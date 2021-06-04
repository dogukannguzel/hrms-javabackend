package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationPostDto;


import java.util.List;

public interface EducationService {

    DataResult<List<Education>> getAll();

    Result add(EducationPostDto educationPostDto);

}
