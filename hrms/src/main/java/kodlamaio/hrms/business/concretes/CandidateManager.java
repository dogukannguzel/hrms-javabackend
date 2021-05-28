package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.validationRules.abstracts.CandidatesValidatorService;
import kodlamaio.hrms.core.adapters.abstracts.UserRealCheckService;
import kodlamaio.hrms.core.generateCode.GenerateCodeService;
import kodlamaio.hrms.core.utilities.businessEngine.BusinessRun;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

    private final CandidatesValidatorService candidatesValidatorService;
    private final CandidateDao candidateDao;
    private final UserRealCheckService personCheckService;
    private final GenerateCodeService generateCodeService;


    public CandidateManager(UserDao<Candidate> userDao, CandidateDao candidateDao, CandidatesValidatorService candidatesValidatorService, UserRealCheckService personCheckService, GenerateCodeService generateCodeService) {
        super(userDao);
        this.candidatesValidatorService = candidatesValidatorService;
        this.candidateDao=candidateDao;
        this.personCheckService = personCheckService;
        this.generateCodeService = generateCodeService;

    }

    @Override
    public Result add(Candidate candidate) {
        Result result = BusinessRun.run(identityNumberExist(candidate.getIdentificationNumber()),
                checkİfRealPerson(candidate));
        if (!result.isSuccess()) {
            return result;
        }
        return super.add(candidate);
    }


    private  Result identityNumberExist(String identityNumber){
        if (this.candidateDao.findByIdentificationNumber(identityNumber).isPresent()){
            System.out.println("tc kontrol");
            return new ErrorResult(Message.identityNumberExist);
        }
        return new SuccessResult();
    }

    private Result checkİfRealPerson(Candidate candidate)  {

        boolean result = false;
        try {
            result = this.personCheckService.checkIfRealPerson(candidate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result?new SuccessResult():new ErrorResult(Message.notRealPerson);
    }



}
