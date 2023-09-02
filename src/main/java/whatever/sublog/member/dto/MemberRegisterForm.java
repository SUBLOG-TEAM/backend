package whatever.sublog.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.member.Member;

@Getter
@NoArgsConstructor
public class MemberRegisterForm {

    @Schema(description = "사용자의 고유 ID. 영문, 숫자 포함 20자 이내로 작성.")
//    @Pattern(regexp = "^[a-zA-Z0-9]{1,20}$", message = "uid는 영문, 숫자 포함 20자 이내여야 합니다.")
    private String uid;

    @Schema(description = "사용자의 별명. 영문, 한글 포함 20자 이내로 작성.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{1,20}$", message = "name 영문, 한글 숫자 포함 20자 이내여야 합니다.")
    private String name;

    @Schema(description = "사용자의 비밀번호. 영문, 숫자, 특수문자를 포함해 20자리 이내로 작성.")
    // @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{1,20}$", message = "password는 영문, 숫자, 특수문자를 포함해 20자리 이내여야 합니다.")
    private String password;

    private String passwordConfirm;

    @Builder
    public MemberRegisterForm(String uid, String name, String password, String passwordConfirm) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public Member dtoToEntity() {
        return new Member(uid, name, password);
    }
}
