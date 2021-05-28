package kodlamaio.hrms.business.validationRules.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface AuthValidatorService {

    Result passwordCondirmed(String password1, String password2);


}
