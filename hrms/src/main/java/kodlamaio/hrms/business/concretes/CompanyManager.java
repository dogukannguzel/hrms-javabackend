package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.validationRules.abstracts.CompanyValidatorService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyManager extends UserManager<Company> implements CompanyService {

    private final CompanyValidatorService companyValidatorService;

    @Autowired
    public CompanyManager(UserDao<Company> userDao, CompanyValidatorService companyValidatorService) {
        super(userDao);
        this.companyValidatorService = companyValidatorService;


    }

    @Override
    public Result add(Company company) {
        Result result = this.companyValidatorService.emailCheck(company);
        if (result.isSuccess()){
            return super.add(company);
        }
        return result;
    }
}
