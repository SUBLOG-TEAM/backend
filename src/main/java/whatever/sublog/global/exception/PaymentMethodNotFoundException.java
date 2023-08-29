package whatever.sublog.global.exception;

public class PaymentMethodNotFoundException extends RuntimeException {

    public PaymentMethodNotFoundException(String s) {
        super(s);
    }
}
