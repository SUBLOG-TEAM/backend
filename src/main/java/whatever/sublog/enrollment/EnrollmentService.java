package whatever.sublog.enrollment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whatever.sublog.enrollment.dto.EnrollmentEntryResponse;
import whatever.sublog.enrollment.dto.EnrollmentRegisterForm;
import whatever.sublog.enrollment.dto.EnrollmentSearchParam;
import whatever.sublog.enrollment.dto.EnrollmentsResponse;
import whatever.sublog.enrollment.dto.PaymentMethodResponses;
import whatever.sublog.global.exception.PayRangeException;
import whatever.sublog.member.MemberService;
import whatever.sublog.payment.PaymentMethod;
import whatever.sublog.payment.PaymentMethodService;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final MemberService memberService;
    private final PaymentMethodService paymentMethodService;

    @Transactional
    public EnrollmentEntryResponse createEnrollment(Long memberId, EnrollmentRegisterForm registerForm) {
        if (registerForm.getPay() < 0) {
            throw new PayRangeException("가격이 올바르지 않습니다. : " + registerForm.getPay());
        }
        memberService.findMember(memberId);
        Enrollment enrollment = enrollmentRepository.save(registerForm.dtoToEntity(memberId));
        PaymentMethod paymentMethod = paymentMethodService.findPaymentMethodOrElseThrow(registerForm.getPaymentMethodId());
        return new EnrollmentEntryResponse(enrollment, paymentMethod.getProductName());
    }

    public PaymentMethodResponses getPaymentMethods() {
        return paymentMethodService.findAllPaymentMethods();
    }

    @Transactional
    public void deleteEnrollment(Long memberId, Long enrollmentId) {
        memberService.findMember(memberId);
        enrollmentRepository.deleteById(enrollmentId);
    }

    public EnrollmentsResponse findEnrollmentPage(EnrollmentSearchParam param) {
        // 페이지 offset, limit 설정
        Pageable pageable = PageRequest.of(param.getPage() - 1, param.getSize());
        // 페이징 형태로 가져옴
        Page<EnrollmentEntryResponse> enrollmentsPage = enrollmentRepository.findEnrollmentPagination(pageable);

        EnrollmentsResponse response = new EnrollmentsResponse();
        response.setEntries(enrollmentsPage.getContent());
        // 이전 Cursor 설정
        if (enrollmentsPage.hasPrevious()) {
            response.setPrevCursor((param.getPage() - 1) * param.getSize());
        } else {
            response.setPrevCursor(null);
        }
        // 다음 Cursor 설정
        if (enrollmentsPage.hasNext()) {
            response.setNextCursor((param.getPage()) * param.getSize() + 1);
        } else {
            response.setNextCursor(null);
        }
        return response;
    }

}
