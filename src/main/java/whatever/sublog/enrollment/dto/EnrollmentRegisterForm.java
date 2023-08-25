package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.enrollment.Enrollment;

@Getter
@NoArgsConstructor
public class EnrollmentRegisterForm {

    @Schema(description = "구독 서비스명")
    private String name;

    @Schema(description = "구독 가격. 0 이상인 정수가 아니면 예외")
    private Integer pay;

    @Schema(description = "결제 날짜")
    private Integer payAt;

    @Schema(description = "구독 결제 카드사 ID")
    private Long paymentMethodId;

    public EnrollmentRegisterForm(String name, Integer pay, Integer payAt, Long paymentMethodId) {
        this.name = name;
        this.pay = pay;
        this.payAt = payAt;
        this.paymentMethodId = paymentMethodId;
    }

    public Enrollment dtoToEntity(Long memberId) {
        return Enrollment.builder()
            .memberId(memberId)
            .paymentMethodId(this.paymentMethodId)
            .name(this.name)
            .pay(this.pay)
            .payAt(this.payAt)
            .build();
    }
}
