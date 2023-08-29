package whatever.sublog.enrollment;

import static whatever.sublog.enrollment.ThumbnailList.*;

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
        Enrollment enrollment = registerForm.dtoToEntity(memberId);
        setEnrollmentLogo(enrollment);
        enrollmentRepository.save(enrollment);
        PaymentMethod paymentMethod = paymentMethodService.findPaymentMethodOrElseThrow(registerForm.getPaymentMethodId());
        return new EnrollmentEntryResponse(enrollment, paymentMethod.getProductName());
    }

    private void setEnrollmentLogo(Enrollment enrollment) {
        if (enrollment.getName().equals("쿠팡 플레이")) {
            enrollment.setThumbnail(CUPANG_PLAY);
        } else if (enrollment.getName().equals("넷플릭스")) {
            enrollment.setThumbnail(NETFLIX);
        } else if (enrollment.getName().equals("멜론")) {
            enrollment.setThumbnail(MELON);
        } else if (enrollment.getName().equals("청소 연구소")) {
            enrollment.setThumbnail(CLEAN_LAB);
        } else if (enrollment.getName().equals("유튜브 프리미엄")) {
            enrollment.setThumbnail(YOUTUBE_PREMIUM);
        } else if (enrollment.getName().equals("왓챠")) {
            enrollment.setThumbnail(WATCHA);
        } else if (enrollment.getName().equals("퍼블리")) {
            enrollment.setThumbnail(PUBLI);
        } else if (enrollment.getName().equals("웨이브")) {
            enrollment.setThumbnail(WAVVE);
        } else if (enrollment.getName().equals("밀리의 서재")) {
            enrollment.setThumbnail(MILLI_LIBRARY);
        } else if (enrollment.getName().equals("디즈니 플러스")) {
            enrollment.setThumbnail(DISNEY_PLUS);
        } else {
            enrollment.setThumbnail(NONE);
        }
    }

    public PaymentMethodResponses getPaymentMethods() {
        return paymentMethodService.findAllPaymentMethods();
    }

    @Transactional
    public void deleteEnrollment(Long memberId, Long enrollmentId) {
        memberService.findMember(memberId);
        enrollmentRepository.deleteById(enrollmentId);
    }

    public EnrollmentsResponse findEnrollmentPage(Long memberId, EnrollmentSearchParam param) {
        // 페이지 offset, limit 설정
        Pageable pageable = PageRequest.of(param.getPage() - 1, param.getSize());
        // 페이징 형태로 가져옴
        Page<EnrollmentEntryResponse> enrollmentsPage = enrollmentRepository.findEnrollmentPagination(memberId, pageable);

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
