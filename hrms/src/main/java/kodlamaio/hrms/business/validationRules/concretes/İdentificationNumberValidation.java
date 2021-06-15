package kodlamaio.hrms.business.validationRules.concretes;

import kodlamaio.hrms.business.validationRules.annotations.ExistByİdentificationNumber;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class İdentificationNumberValidation implements ConstraintValidator<ExistByİdentificationNumber, String> {
    @Autowired
    private CandidateDao candidateDao;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (this.candidateDao.findByIdentificationNumber(s).isPresent()){
            return false;
        }
        return true;
    }
}
