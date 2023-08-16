package whatever.sublog.member;

import java.util.List;
import org.junit.jupiter.api.Test;
import whatever.sublog.common.UnitTest;
import whatever.sublog.global.exception.DuplicateUidException;
import whatever.sublog.global.exception.PasswordConfirmNotEqualException;
import whatever.sublog.member.dto.MemberRegisterForm;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static whatever.sublog.fixture.MemberFixture.회원_만들기;
import static whatever.sublog.fixture.RegisterFixture.폼_객체_만들기;

class MemberServiceTest extends UnitTest {

    @Test
    public void 중복된_아이디_허용X() {
        // Given
        Member member1 = 회원_만들기("test1", "testName", "password123!");
        memberRepository.save(member1);
        MemberRegisterForm form = 폼_객체_만들기("test1", "testName", "password123!", "password123!");

        // When & Then
        assertThrows(DuplicateUidException.class, () -> {
            memberService.createMember(form);
        });
    }

    @Test
    public void 비밀번호와_비밀번호_확인이_다르면_가입_불가() {
        // Given
        MemberRegisterForm form = 폼_객체_만들기("test1", "testName", "password123!", "password123@");

        // When & Then
        assertThrows(PasswordConfirmNotEqualException.class, () -> {
            memberService.createMember(form);
        });
    }

    @Test
    public void 비밀번호와_비밀번호_확인이_같으면_가입() {
        // Given
        MemberRegisterForm form = 폼_객체_만들기("test1", "testName", "password123!", "password123!");
        memberService.createMember(form);

        // When
        List<Member> members = memberRepository.findAll();

        // Then
        assertThat(members.size()).isEqualTo(1);
    }
}
