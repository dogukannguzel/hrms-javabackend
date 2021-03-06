package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementPostDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementTableDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisementGetDto>> getAll();

    DataResult<JobAdvertisementGetDto> findAllById(int id);

    DataResult<List<JobAdvertisementTableDto>> getByJobAdversitementCompanyIdTableDto(int id);

    Result add(JobAdvertisementPostDto jobAdvertisementPostDto);

    DataResult<List<JobAdvertisement>> getAllSorted();

    Result setİsJobEnable(int id);

    DataResult<List<JobAdvertisementGetDto>> getByCompanyId(int id);

    DataResult<List<JobAdvertisementGetDto>> getAllByEnableTrueAndEmployerId(int employerİd);

    DataResult<List<JobAdvertisementGetDto>> getByJobAdversitementTrueDto();

    DataResult<List<JobAdvertisementGetDto>> getByJobAdversitementDto();

    DataResult<List<JobAdvertisementTableDto>> getByJobAdversitementTableDto();

    DataResult<List<JobAdvertisementTableDto>> getByJobAdversitementEnableFalse();


    Result deleteById(int id);

}
