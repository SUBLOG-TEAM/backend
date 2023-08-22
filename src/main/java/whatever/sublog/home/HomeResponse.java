package whatever.sublog.home;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.enrollment.dto.EnrollmentEntryResponse;

import java.math.BigInteger;
import java.util.List;

@Getter
@NoArgsConstructor
public class HomeResponse {

    @Schema(description = "사용자의 이름")
    private String name;

    @Schema(description = "사용자가 이번 달 결제할 금액")
    private BigInteger totalPayment;

    @Schema(description = "현재 결제가 가장 가까운 구독 서비스 3개")
    private List<EnrollmentEntryResponse> entries;


    public HomeResponse(String name, BigInteger totalPayment, List<EnrollmentEntryResponse> entries) {
        this.name = name;
        this.totalPayment = totalPayment;
        this.entries = entries;
    }
}
