package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.abstracts.CandidateService;
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


    private final CandidateDao candidateDao;
    private final UserRealCheckService personCheckService;
    private final GenerateCodeService generateCodeService;


    public CandidateManager(UserDao<Candidate> userDao, CandidateDao candidateDao ,UserRealCheckService personCheckService, GenerateCodeService generateCodeService) {
        super(userDao);

        this.candidateDao=candidateDao;
        this.personCheckService = personCheckService;
        this.generateCodeService = generateCodeService;

    }

    @Override
    public Result add(Candidate candidate) {
        return super.add(candidate);
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
