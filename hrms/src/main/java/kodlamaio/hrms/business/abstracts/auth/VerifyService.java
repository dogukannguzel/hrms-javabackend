package kodlamaio.hrms.business.abstracts.auth;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerifyService {
    Result verify(String code);


}
