package whatever.sublog.enrollment;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whatever.sublog.enrollment.dto.EnrollmentEntryResponse;
import whatever.sublog.enrollment.dto.EnrollmentRegisterForm;
import whatever.sublog.enrollment.dto.EnrollmentSearchParam;
import whatever.sublog.enrollment.dto.EnrollmentsResponse;
import whatever.sublog.enrollment.dto.PaymentMethodResponses;

@RequiredArgsConstructor
@RequestMapping("/enrollments")
@CrossOrigin("*")
@RestController
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/register")
    public ResponseEntity<EnrollmentEntryResponse> registerEnrollment(@RequestBody EnrollmentRegisterForm registerForm) {
        registerForm.setMemberId(1L);
        EnrollmentEntryResponse response = enrollmentService.createEnrollment(registerForm);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/services")
    public ResponseEntity<List<String>> getServices() {
        List<String> services = new ArrayList<>();
        services.add("넷플릭스");
        services.add("쿠팡 플레이");
        services.add("멜론");
        return ResponseEntity.ok(services);
    }

    @GetMapping("/payment-method")
    public ResponseEntity<PaymentMethodResponses> getPaymentMethods() {
        PaymentMethodResponses paymentMethods = enrollmentService.getPaymentMethods();
        return ResponseEntity.ok(paymentMethods);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable("enrollmentId") Long id) {
        enrollmentService.deleteEnrollment(1L, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<EnrollmentsResponse> getEnrollments(@RequestParam EnrollmentSearchParam searchParam) {
        EnrollmentsResponse response = enrollmentService.findEnrollmentPage(searchParam);
        return ResponseEntity.ok(response);
    }

}
