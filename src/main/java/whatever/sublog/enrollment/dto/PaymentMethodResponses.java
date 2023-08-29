package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentMethodResponses {

    @Schema(description = "카드사 리스트")
    private List<PaymentMethodResponseEntry> entries;

    public PaymentMethodResponses(List<PaymentMethodResponseEntry> entries) {
        this.entries = entries;
    }
}
