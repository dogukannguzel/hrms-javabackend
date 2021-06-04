package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperiencePostDto;

import java.util.List;

public interface JobExperienceService {

    DataResult<List<JobExperience>> getAll();

    Result add(JobExperiencePostDto jobExperiencePostDto);


}
