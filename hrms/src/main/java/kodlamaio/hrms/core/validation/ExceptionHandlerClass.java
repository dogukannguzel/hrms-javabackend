package kodlamaio.hrms.core.validation;

import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDataResult<Object>> handleValidationExceptions(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();

        exceptions.getBindingResult().getFieldErrors()
                .forEach(fieldError -> validationErrors
                        .put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(new ErrorDataResult<>(validationErrors, "Validation Errors"));
    }


}

