package kodlamaio.hrms.business.validationRules.concretes;

import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.validationRules.abstracts.EmployerValidatorService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import org.assertj.core.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class EmployerValidator  implements EmployerValidatorService {


    @Override
    public Result emailCheck(Employer employer) {

        String email=employer.getEmail();
        String webAddres = employer.getWebAddress();

        String domain = webAddres.split("www.")[1];


        if (domain.equals(email.split("@")[1])){
           return new SuccessResult();
        }
        return new ErrorResult(Message.employersMailWrong);
    }
}
