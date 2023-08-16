package whatever.sublog.member;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whatever.sublog.global.exception.AutoLoginFailException;
import whatever.sublog.global.exception.DuplicateUidException;
import whatever.sublog.global.exception.LoginFailException;
import whatever.sublog.global.exception.PasswordConfirmNotEqualException;
import whatever.sublog.member.dto.MemberLoginForm;
import whatever.sublog.member.dto.MemberRegisterForm;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberRegisterForm registerForm) {
        validatePasswordEqualPasswordConfirm(registerForm.getPassword(), registerForm.getPasswordConfirm());
        Optional<Member> member = memberRepository.findByUid(registerForm.getUid());
        if (member.isPresent()) {
            throw new DuplicateUidException("존재하는 아이디: " + registerForm.getUid());
        }
        memberRepository.save(registerForm.dtoToEntity());
    }

    private void validatePasswordEqualPasswordConfirm(String password, String passwordConfirm) {
        if (!password.equals(passwordConfirm)) {
            throw new PasswordConfirmNotEqualException("비밀번호와 비밀번호 확인이 다릅니다.");
        }
    }

    @Transactional
    public Member loginMember(MemberLoginForm loginForm) {
        Member member = memberRepository.findByUidAndPassword(loginForm.getUid(), loginForm.getPassword())
                .orElseThrow(() -> new LoginFailException("아이디 또는 패스워드 오류"));
        return member;
    }

    public void findMember(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new AutoLoginFailException("자동 로그인 실패"));
    }
}
