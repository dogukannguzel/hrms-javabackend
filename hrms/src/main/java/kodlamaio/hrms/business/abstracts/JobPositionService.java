package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionPostDto;

import java.util.List;

public interface JobPositionService {

    Result add(JobPositionPostDto jobPositionPostDto);
    DataResult<List<JobPosition>> getAll();


}
