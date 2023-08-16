package whatever.sublog.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginForm {

    private String uid;

    private String password;

    @Builder
    public MemberLoginForm(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }
}
