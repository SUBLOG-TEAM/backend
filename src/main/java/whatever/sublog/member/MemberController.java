package whatever.sublog.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whatever.sublog.member.dto.MemberRegisterForm;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
@Tag(name = "회원 관련 API", description = "로그인, 회원 가입, 조회, 수정 등 회원 관련 기능을 제공하는 API입니다.")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 가입")
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody @Valid MemberRegisterForm registerForm) {
        memberService.createMember(registerForm);
        return ResponseEntity.ok().build();
    }
}
