package whatever.sublog.enrollment.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.enrollment.Enrollment;

@Getter
@NoArgsConstructor
public class EnrollmentRegisterForm {

    private Long memberId;

    private String name;

    private Integer pay;

    private LocalDateTime payAt;

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
