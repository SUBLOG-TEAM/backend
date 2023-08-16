package whatever.sublog.global.exception;

public class PasswordConfirmNotEqualException extends IllegalArgumentException {

    public PasswordConfirmNotEqualException(String s) {
        super(s);
    }
}
