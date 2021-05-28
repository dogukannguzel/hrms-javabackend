package kodlamaio.hrms.business.concretes.auth;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.abstracts.auth.CandidateAuthService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.validationRules.abstracts.AuthValidatorService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidatesRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateAuthManager implements CandidateAuthService {

    private final CandidateService candidateService;
    private final AuthValidatorService authValidatorService;
    private final VerificationCodeService verificationCodeService;

    @Autowired
    public CandidateAuthManager(CandidateService candidateService, AuthValidatorService authValidatorService, VerificationCodeService verificationCodeService) {
        this.candidateService = candidateService;
        this.authValidatorService = authValidatorService;
        this.verificationCodeService = verificationCodeService;
    }


    @Override
    public Result register(CandidatesRegisterDto candidatesRegisterDto) {

        Result validate = this.authValidatorService.passwordCondirmed(candidatesRegisterDto.getPassword(),candidatesRegisterDto.getConfirmPassword());
        if (!validate.isSuccess()){
            return validate;
        }

        DataResult<Candidate> candidateRegister = candidateRegister(candidatesRegisterDto);

        if (!candidateRegister.isSuccess()){
            return candidateRegister;
        }

      Result codeService = this.verificationCodeService.saveCode(candidateRegister.getData());
        if (!codeService.isSuccess()){
            return codeService;
        }
        return new SuccessResult(codeService.getMessage());
    }


    private DataResult<Candidate> candidateRegister(CandidatesRegisterDto candidatesRegisterDto){
        Candidate candidate = new Candidate(candidatesRegisterDto.getEmail(),candidatesRegisterDto.getPassword(),candidatesRegisterDto.getFirstName(),candidatesRegisterDto.getLastName(),candidatesRegisterDto.getIdentityNumber(),candidatesRegisterDto.getBirthDate());
        Result result =this.candidateService.add(candidate);
        if (!result.isSuccess()){
            return new ErrorDataResult<>(null,result.getMessage());
        }
        return new SuccessDataResult<Candidate>(candidate, Message.userAddes);
    }

}
