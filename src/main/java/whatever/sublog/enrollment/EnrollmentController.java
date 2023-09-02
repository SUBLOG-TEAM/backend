package whatever.sublog.enrollment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whatever.sublog.enrollment.dto.EnrollmentEntryResponse;
import whatever.sublog.enrollment.dto.EnrollmentRegisterForm;
import whatever.sublog.enrollment.dto.EnrollmentSearchParam;
import whatever.sublog.enrollment.dto.EnrollmentsResponse;
import whatever.sublog.enrollment.dto.PaymentMethodResponses;

@RequiredArgsConstructor
@RequestMapping("/enrollments")
@CrossOrigin("*")
@RestController
@Tag(name = "구독 관련 API", description = "구독 CRUD 관련 기능을 제공하는 API입니다.")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Operation(summary = "구독 서비스 등록")
    @PostMapping("/register")
    public ResponseEntity<EnrollmentEntryResponse> registerEnrollment(@RequestAttribute("memberId") Long memberId, @RequestBody EnrollmentRegisterForm registerForm) {
        EnrollmentEntryResponse response = enrollmentService.createEnrollment(memberId, registerForm);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "등록할 구독 서비스 목록 보기")
    @GetMapping("/services")
    public ResponseEntity<List<String>> getServices() {
        List<String> services = new ArrayList<>();
        services.add("넷플릭스");
        services.add("쿠팡 플레이");
        services.add("멜론");
        return ResponseEntity.ok(services);
    }

    @Operation(summary = "결제 카드사 보기")
    @GetMapping("/payment-method")
    public ResponseEntity<PaymentMethodResponses> getPaymentMethods() {
        PaymentMethodResponses paymentMethods = enrollmentService.getPaymentMethods();
        return ResponseEntity.ok(paymentMethods);
    }

    @Operation(summary = "구독 서비스 삭제")
    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> deleteEnrollment(@RequestAttribute("memberId") Long memberId, @PathVariable("enrollmentId") Long enrollmentId) {
        enrollmentService.deleteEnrollment(memberId, enrollmentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<EnrollmentsResponse> getEnrollments(@RequestAttribute("memberId") Long memberId, @ModelAttribute EnrollmentSearchParam searchParam) {
        if (searchParam.getPage() == null) {
            searchParam.setPage(1);
        }
        if (searchParam.getSize() == null) {
            searchParam.setSize(2);
        }
        EnrollmentsResponse response = enrollmentService.findEnrollmentPage(memberId, searchParam);
        return ResponseEntity.ok(response);
    }

}
