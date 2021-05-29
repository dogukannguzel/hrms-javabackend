package kodlamaio.hrms.business.validationRules.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;


public interface EmployerValidatorService {
    Result emailCheck(Company employer);
}
