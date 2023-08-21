package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.enrollment.Enrollment;

@Getter
@NoArgsConstructor
public class EnrollmentRegisterForm {

    @Schema(description = "사용자 ID")
    private Long memberId;

    @Schema(description = "구독 서비스명. 10자 이내로 작성")
    private String name;

    @Schema(description = "구독 가격. 0 이상인 정수가 아니면 예외")
    private Integer pay;

    @Schema(description = "결제 날짜")
    private LocalDateTime payAt;

    @Schema(description = "구독 결제 카드사 ID")
    private Long paymentMethodId;

    public EnrollmentRegisterForm(String name, Integer pay, LocalDateTime payAt, Long paymentMethodId) {
        this.name = name;
        this.pay = pay;
        this.payAt = payAt;
        this.paymentMethodId = paymentMethodId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Enrollment dtoToEntity() {
        return Enrollment.builder()
            .memberId(this.memberId)
            .paymentMethodId(this.paymentMethodId)
            .name(name)
            .pay(this.pay)
            .payAt(this.payAt)
            .build();
    }
}
