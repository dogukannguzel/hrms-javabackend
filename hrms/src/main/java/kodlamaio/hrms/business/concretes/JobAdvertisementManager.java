package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementReadDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementDao jobAdvertisementDao;
    private final ModelMapper modelMapper;


    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.modelMapper = modelMapper;

    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementReadDto>> getAllByEnableTrue() {
        List<JobAdvertisement> jobAdvertisements = this.jobAdvertisementDao.getAllByEnableTrue();

        return   new SuccessDataResult<List<JobAdvertisementReadDto>>(jobAdvertisementToDto(jobAdvertisements),Message.jobAdvertisementListed);
    }

    @Override
    public Result add(JobAdvertisementRequestDto jobAdvertisementRequestDto) {
        JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementRequestDto,JobAdvertisement.class);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Message.jobAdvertisementAdded);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createdDate");
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),Message.jobAdvertisementListed);



    }

    @Override
    public Result setİsJobEnable(int employerId,int id) {
        JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.findAllByCompanyIdAndId(employerId,id);
        jobAdvertisement.setEnable(false);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Message.setJobAdvertisement);
    }

    @Override
    public  DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyId(id),Message.jobAdvertisementListed);
    }

    @Override
    public DataResult<List<JobAdvertisementReadDto>> getAllByEnableTrueAndEmployerId(int employerİd) {
        List<JobAdvertisement> jobAdvertisements=jobAdvertisementDao.getAllByEnableTrueAndCompanyId(employerİd);

        return new SuccessDataResult<List<JobAdvertisementReadDto>>(jobAdvertisementToDto(jobAdvertisements),Message.jobAdvertisementListed);
    }


    private List<JobAdvertisementReadDto> jobAdvertisementToDto(List<JobAdvertisement> jobAdvertisements){
        return jobAdvertisements.stream()
                .map(jobAdvertisement->modelMapper.map(jobAdvertisement,JobAdvertisementReadDto.class))
                .collect(Collectors.toList());
    }

}
