package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.core.utilities.mapper.JobAdversitementMapper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementPostDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementTableDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementDao jobAdvertisementDao;
    private final JobAdversitementMapper jobAdversitementMapper;


    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, JobAdversitementMapper jobAdversitementMapper) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.jobAdversitementMapper = jobAdversitementMapper;


    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
    }



    @Override
    public Result add(JobAdvertisementPostDto jobAdvertisementPostDto) {
        JobAdvertisement jobAdvertisement = this.jobAdversitementMapper.dtoToModel(jobAdvertisementPostDto);
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
    public DataResult<List<JobAdvertisementGetDto>> getAllByEnableTrueAndEmployerId(int employerİd) {


        return new SuccessDataResult<List<JobAdvertisementGetDto>>(this.jobAdvertisementDao.getByJobAdversitementTrueAndCompanyIdDto(employerİd),Message.jobAdvertisementListed) ;
    }
    @Override
    public DataResult<List<JobAdvertisementGetDto>> getByJobAdversitementTrueDto() {
        return   new SuccessDataResult<List<JobAdvertisementGetDto>>(this.jobAdvertisementDao.getByJobAdversitementTrueDto(),Message.jobAdvertisementListed);
    }

    @Override
    public  DataResult<List<JobAdvertisementGetDto>> getByJobAdversitementDto() {
        return new SuccessDataResult<List<JobAdvertisementGetDto>>(this.jobAdvertisementDao.getByJobAdversitementDto(),Message.jobAdvertisementListed);
    }

    @Override
    public DataResult<List<JobAdvertisementTableDto>> getByJobAdversitementTableDto() {
        return new SuccessDataResult<List<JobAdvertisementTableDto>>(this.jobAdvertisementDao.getByJobAdversitementTableDto(),Message.jobAdvertisementListed);
    }


}
