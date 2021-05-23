package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobDao){
        this.jobDao=jobDao;
     }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobDao.findAll(),"Data Başarıyla getirildi");
    }

    @Override
    public Result add(JobPosition jobPosition) {

        this.jobDao.save(jobPosition);

        return new SuccessResult("Veri ekleme işlemi başarılı");
    }
}
