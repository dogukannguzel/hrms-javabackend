package kodlamaio.hrms.core.validation.annotations;


import kodlamaio.hrms.core.validation.EmailValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailValidation.class})
public @interface ExistByEmail {

    String message() default "Bu email adresi ile kayıt yapılmış ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
