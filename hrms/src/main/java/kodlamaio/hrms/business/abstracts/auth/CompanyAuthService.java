package kodlamaio.hrms.business.abstracts.auth;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;

public interface CompanyAuthService {
    Result register(CompanyRegisterDto companyRegisterDto);
}
