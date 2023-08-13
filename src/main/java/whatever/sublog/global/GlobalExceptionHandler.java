package whatever.sublog.global;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import whatever.sublog.global.exception.DuplicateUidException;
import whatever.sublog.global.exception.InvalidInputFormatException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private ErrorMessage buildErrorMessage(Exception exception, HttpServletRequest request) {
        log.error(exception.getMessage());
        return ErrorMessage.builder()
            .title(exception.getClass().getSimpleName())
            .detail(exception.getMessage())
            .instance(request.getRequestURI())
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        InvalidInputFormatException.class
    })
    public ResponseEntity<ErrorMessage> handleBadRequest(Exception e, HttpServletRequest request) {
        return new ResponseEntity<>(buildErrorMessage(e, request),
            HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            DuplicateUidException.class
    })
    public ResponseEntity<ErrorMessage> handleConflict(Exception e, HttpServletRequest request) {
        return new ResponseEntity<>(buildErrorMessage(e, request),
                HttpStatus.CONFLICT);
    }
}
