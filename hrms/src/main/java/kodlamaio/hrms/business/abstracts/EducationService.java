package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationGetDto;
import kodlamaio.hrms.entities.dtos.EducationPostDto;


import java.util.List;

public interface EducationService {

    DataResult<EducationGetDto> findAllByResumeId(int resumId);

    DataResult<List<EducationGetDto>> getAll();

    Result add(EducationPostDto educationPostDto);

    DataResult<List<EducationGetDto>> findAllByResumeIdOOrderByStartedDate(int resumId);
}
