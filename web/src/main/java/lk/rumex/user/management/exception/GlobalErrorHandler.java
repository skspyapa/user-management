package lk.rumex.user.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({
    UserNotFoundException.class
  })
  public Map<String, String> handleNotFoundException(Exception ex) {
    return Collections.singletonMap("error", ex.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({

  })
  public Map<String, String> handleBadRequestException(Exception ex) {
    return Collections.singletonMap("error", ex.getMessage());
  }

}
