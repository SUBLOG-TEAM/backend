package whatever.sublog.member;

import org.junit.jupiter.api.Test;
import whatever.sublog.common.UnitTest;
import whatever.sublog.global.exception.DuplicateUidException;
import whatever.sublog.member.dto.MemberRegisterForm;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static whatever.sublog.fixture.MemberFixture.*;
import static whatever.sublog.fixture.RegisterFixture.폼_만들기;

class MemberServiceTest extends UnitTest {

    @Test
    public void 중복된_아이디_허용X(){
        // Given
        Member member1 = 회원_만들기("test1", "testName", "password123!");
        memberRepository.save(member1);
        MemberRegisterForm form = 폼_만들기("test1", "testName", "password123!");

        // When & Then
        assertThrows(DuplicateUidException.class, () -> {
            memberService.createMember(form);
        });
    }
}
