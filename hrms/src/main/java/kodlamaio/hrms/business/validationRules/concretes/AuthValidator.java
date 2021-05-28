package kodlamaio.hrms.business.validationRules.concretes;

import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.validationRules.abstracts.AuthValidatorService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator implements AuthValidatorService {
    @Override
    public Result passwordCondirmed(String password1, String password2) {
        if (password1.equals(password2)){
            return new SuccessResult();
        }
        return new ErrorResult(Message.notPassword);
    }
}
