package whatever.sublog.member.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.member.Member;

@Getter
@NoArgsConstructor
public class MemberRegisterForm {

    @Pattern(regexp = "^[a-zA-Z0-9]{1,15}$", message = "uid는 영문, 숫자 포함 15자 이내여야 합니다.")
    private String uid;

    @Pattern(regexp = "^[a-zA-Z가-힣]{1,10}$", message = "nickname은 영문, 한글 포함 10자 이내여야 합니다.")
    private String nickname;

    // @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,15}$", message = "password는 영문, 숫자, 특수문자를 포함해 8자리 이상 15자리 이내여야 합니다.")
    private String password;

    @Builder
    public MemberRegisterForm(String uid, String nickname, String password) {
        this.uid = uid;
        this.nickname = nickname;
        this.password = password;
    }

    public Member dtoToEntity() {
        return new Member(uid, nickname, password);
    }
}
