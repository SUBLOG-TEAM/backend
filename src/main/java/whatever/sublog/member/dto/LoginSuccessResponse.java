package whatever.sublog.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginSuccessResponse {

    String name;

    public LoginSuccessResponse(String name) {
        this.name = name;
    }
}
