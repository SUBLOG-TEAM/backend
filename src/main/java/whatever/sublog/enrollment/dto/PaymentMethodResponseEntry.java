package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.payment.PaymentMethod;

@Getter
@NoArgsConstructor
public class PaymentMethodResponseEntry {

    @Schema(description = "카드사 ID")
    private Long id;

    @Schema(description = "카드사 이름")
    private String productName;

    public PaymentMethodResponseEntry(PaymentMethod paymentMethod) {
        this.id = paymentMethod.getId();
        this.productName = paymentMethod.getProductName();
    }
}
