package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementReadDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementRequestDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisementReadDto>> getAllByEnableTrue();

    Result add(JobAdvertisementRequestDto jobAdvertisement);

   DataResult<List<JobAdvertisement>> getAllSorted();

    Result setİsJobEnable(int employerId,int id);

    DataResult<List<JobAdvertisement>> getByEmployerId(int id);

    DataResult<List<JobAdvertisementReadDto>> getAllByEnableTrueAndEmployerId(int employerİd);

}
