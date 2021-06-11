package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Graduate;
import kodlamaio.hrms.entities.dtos.GraduateGetDto;

import java.util.List;

public interface GraduateService {

    DataResult<List<GraduateGetDto>> getAll();

    Result add(Graduate graduate);


}
