package kodlamaio.hrms.business.validationRules.concretes;

import kodlamaio.hrms.business.validationRules.annotations.ExistByEmail;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<ExistByEmail,String> {

    @Autowired
    UserDao userDao;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (this.userDao.findByEmail(email).isPresent()){
            return false;
        }
        return true;
    }
}
