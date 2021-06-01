package kodlamaio.hrms.core.validation.annotations;



import kodlamaio.hrms.core.validation.EmailValidation;
import kodlamaio.hrms.core.validation.GraduateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GraduateValidation.class})
public @interface ExistByGraduate {

    String message() default "Bu derece zaten eklenmiş ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
