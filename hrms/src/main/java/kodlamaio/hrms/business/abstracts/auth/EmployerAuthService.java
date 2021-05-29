package kodlamaio.hrms.business.abstracts.auth;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;

public interface EmployerAuthService {
    Result register(CompanyRegisterDto companyRegisterDto);
}
