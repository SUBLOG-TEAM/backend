package whatever.sublog.payment;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whatever.sublog.enrollment.dto.PaymentMethodResponseEntry;
import whatever.sublog.enrollment.dto.PaymentMethodResponses;
import whatever.sublog.global.exception.PaymentMethodNotFoundException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod findPaymentMethodOrElseThrow(Long paymentId) {
        return paymentMethodRepository.findById(paymentId)
            .orElseThrow(() -> new PaymentMethodNotFoundException("유효하지 않는 카드사입니다. : " + paymentId));
    }

    public PaymentMethodResponses findAllPaymentMethods() {
        List<PaymentMethodResponseEntry> entries = paymentMethodRepository.findAll()
            .stream()
            .map(PaymentMethodResponseEntry::new)
            .collect(Collectors.toList());
        return new PaymentMethodResponses(entries);
    }

}
