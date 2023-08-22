package whatever.sublog.home;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/home")
@CrossOrigin("*")
@RestController
@Tag(name = "홈 API", description = "메인 화면을 보여줍니다.")
public class HomeController {

    private final HomeService homeService;
    private final int SIZE = 3;

    @GetMapping
    public ResponseEntity<HomeResponse> home(@RequestAttribute(value = "memberId", required = false) Long memberId) {
        if (memberId == null) {
            return ResponseEntity.ok(new HomeResponse());
        }
        HomeResponse response = homeService.getMainInfo(memberId, SIZE);
        return ResponseEntity.ok(response);
    }

}
