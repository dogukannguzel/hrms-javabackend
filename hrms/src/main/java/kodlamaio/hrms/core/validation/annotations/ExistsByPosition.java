package kodlamaio.hrms.core.validation.annotations;

import kodlamaio.hrms.core.validation.JobPositionValidation;
import kodlamaio.hrms.core.validation.İdentificationNumberValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {JobPositionValidation.class})
public @interface ExistsByPosition {
    String message() default "Bu pozisyon zaten eklenmiş ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
