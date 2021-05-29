package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validationRules.abstracts.EmployerValidatorService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager extends UserManager<Company> implements EmployerService {

    private final EmployerValidatorService employerValidatorService;

    @Autowired
    public EmployerManager(UserDao<Company> userDao, EmployerValidatorService employerValidatorService ) {
        super(userDao);
        this.employerValidatorService=employerValidatorService;


    }

    @Override
    public Result add(Company company) {
        Result result = this.employerValidatorService.emailCheck(company);
        if (result.isSuccess()){
            return super.add(company);
        }
        return result;
    }
}
