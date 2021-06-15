package kodlamaio.hrms.business.validationRules.concretes;

import kodlamaio.hrms.business.validationRules.annotations.ExistsByPosition;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class JobPositionValidation implements ConstraintValidator<ExistsByPosition,String> {
    @Autowired
    JobPositionDao jobPositionDao;

    @Override
    public boolean isValid(String position, ConstraintValidatorContext context) {
        if(jobPositionDao.findByPosition(position).isPresent()){
            return false;
        }

        return true;
    }
}
