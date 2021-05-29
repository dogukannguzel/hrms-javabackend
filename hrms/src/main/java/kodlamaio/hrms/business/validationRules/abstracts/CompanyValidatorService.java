package kodlamaio.hrms.business.validationRules.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;


public interface CompanyValidatorService {
    Result emailCheck(Company employer);
}
