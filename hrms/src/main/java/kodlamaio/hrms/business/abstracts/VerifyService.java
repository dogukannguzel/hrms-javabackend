package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerifyService {
    Result verify(String uuid,String code);
}
