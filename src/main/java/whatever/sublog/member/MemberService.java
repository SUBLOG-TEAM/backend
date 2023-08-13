package whatever.sublog.member;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whatever.sublog.global.exception.DuplicateUidException;
import whatever.sublog.member.dto.MemberRegisterForm;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberRegisterForm registerForm) {
        Optional<Member> member = memberRepository.findByUid(registerForm.getUid());
        if (member.isPresent()) {
            throw new DuplicateUidException("존재하는 아이디: " + registerForm.getUid());
        }
        memberRepository.save(registerForm.dtoToEntity());
    }
}
