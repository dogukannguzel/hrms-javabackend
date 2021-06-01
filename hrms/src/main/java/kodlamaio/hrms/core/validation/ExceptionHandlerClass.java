package kodlamaio.hrms.core.validation;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ErrorResult(ex.getBindingResult().getFieldError().getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }

}

