package whatever.sublog.global.exception;

public class PasswordCheckNotEqualException extends IllegalArgumentException {

    public PasswordCheckNotEqualException(String s) {
        super(s);
    }
}
