package whatever.sublog.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whatever.sublog.enrollment.EnrollmentRepository;
import whatever.sublog.enrollment.dto.EnrollmentEntryResponse;
import whatever.sublog.member.Member;
import whatever.sublog.member.MemberService;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class HomeService {

    private final EnrollmentRepository enrollmentRepository;
    private final MemberService memberService;

    public HomeResponse getMainInfo(Long memberId, int size) {
        Member member = memberService.findMember(memberId);
        List<EnrollmentEntryResponse> enrollmentsPage = enrollmentRepository.findMainInfoPagination(memberId);

        BigInteger totalPayment = enrollmentsPage.stream()
                .map(EnrollmentEntryResponse::getPay)
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);

        List<EnrollmentEntryResponse> entries = enrollmentsPage.stream()
                .limit(size)
                .collect(Collectors.toList());

        return new HomeResponse(member.getName(), totalPayment, entries);
    }
}
