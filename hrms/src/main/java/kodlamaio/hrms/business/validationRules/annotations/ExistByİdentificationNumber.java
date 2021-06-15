package kodlamaio.hrms.business.validationRules.annotations;

import kodlamaio.hrms.business.validationRules.concretes.İdentificationNumberValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {İdentificationNumberValidation.class})
public @interface ExistByİdentificationNumber {

    String message() default "Bu tc kimlik numarası ile sisteme zaten kayıt yapılmış";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
