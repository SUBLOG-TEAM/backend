package whatever.sublog.global.exception;

public class LoginFailException extends IllegalArgumentException {

    public LoginFailException(String s) {
        super(s);
    }
}
