package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao=employerDao;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Veriler başarıyla getirildi");
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Veri başarıyla eklendi");
    }
}
