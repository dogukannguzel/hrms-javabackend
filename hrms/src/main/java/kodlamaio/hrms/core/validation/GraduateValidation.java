package kodlamaio.hrms.core.validation;

import kodlamaio.hrms.core.validation.annotations.ExistByEmail;
import kodlamaio.hrms.core.validation.annotations.ExistByGraduate;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GraduateValidation implements ConstraintValidator<ExistByGraduate,String> {
    @Autowired
    GraduateDao graduateDao;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (this.graduateDao.findByGraduateDescription(s).isPresent()){
            return false;
        }


        return true;
    }
}
