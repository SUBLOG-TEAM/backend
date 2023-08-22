package whatever.sublog.enrollment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.payment.PaymentMethod;

@Getter
@NoArgsConstructor
public class PaymentMethodResponseEntry {

    private Long id;

    private String productName;

    public PaymentMethodResponseEntry(PaymentMethod paymentMethod) {
        this.id = paymentMethod.getId();
        this.productName = paymentMethod.getProductName();
    }
}
