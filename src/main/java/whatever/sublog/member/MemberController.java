package whatever.sublog.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whatever.sublog.member.dto.LoginSuccessResponse;
import whatever.sublog.member.dto.MemberLoginForm;
import whatever.sublog.member.dto.MemberRegisterForm;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/members")
@CrossOrigin("*")
@RestController
@Tag(name = "회원 관련 API", description = "로그인, 회원 가입, 조회, 수정 등 회원 관련 기능을 제공하는 API입니다.")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 가입")
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid MemberRegisterForm registerForm) {
        memberService.createMember(registerForm);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "수동 로그인")
    @PostMapping("/login")
    public ResponseEntity<LoginSuccessResponse> login(@RequestBody MemberLoginForm loginForm, HttpSession session) {
        Member member = memberService.loginMember(loginForm);
        String sessionKey = UUID.randomUUID().toString();
        session.setAttribute(sessionKey, member.getId());
        return ResponseEntity.ok()
                .header("Authorization", sessionKey)
                .body(new LoginSuccessResponse(member.getName()));
    }

    @Operation(summary = "자동 로그인")
    @PostMapping("/auto-login")
    public ResponseEntity<Void> autoLogin(@RequestHeader("Authorization") String sessionKey, HttpSession session) {
        Long memberId = (Long)session.getAttribute(sessionKey);
        memberService.findMember(memberId);
        return ResponseEntity.ok()
                .header("Authentication", sessionKey)
                .build();
    }
}
