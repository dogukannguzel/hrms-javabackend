package kodlamaio.hrms.business.abstracts.auth;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidatesRegisterDto;

public interface CandidateAuthService {

    Result register(CandidatesRegisterDto candidatesRegisterDto);

}
