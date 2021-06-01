package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private final JobExperienceDao jobExperienceDao;

    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }


    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("İş tecrübesi eklendi");
    }
}
