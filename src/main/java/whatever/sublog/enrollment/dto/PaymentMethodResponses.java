package whatever.sublog.enrollment.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentMethodResponses {

    private List<PaymentMethodResponseEntry> entries;

    public PaymentMethodResponses(List<PaymentMethodResponseEntry> entries) {
        this.entries = entries;
    }
}
