package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.mapper.JobExperienceMapper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceGetDto;
import kodlamaio.hrms.entities.dtos.JobExperiencePostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private final JobExperienceDao jobExperienceDao;
    private final JobExperienceMapper jobExperienceMapper;
    public JobExperienceManager(JobExperienceDao jobExperienceDao, JobExperienceMapper jobExperienceMapper) {
        this.jobExperienceDao = jobExperienceDao;
        this.jobExperienceMapper = jobExperienceMapper;
    }


    @Override
    public DataResult<List<JobExperienceGetDto>> getAll() {
        List<JobExperience> jobExperienceList = this.jobExperienceDao.findAll();
        return new SuccessDataResult<List<JobExperienceGetDto>>(this.jobExperienceMapper.modelToDtos(jobExperienceList),"Data listelendi");
    }

    @Override
    public Result add(JobExperiencePostDto jobExperiencePostDto) {
        JobExperience jobExperience=this.jobExperienceMapper.dtoToModel(jobExperiencePostDto);
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("İş tecrübesi eklendi");
    }
}
