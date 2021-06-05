package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.mapper.JobPositionMapper;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionGetDto;
import kodlamaio.hrms.entities.dtos.JobPositionPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;
    private final JobPositionMapper jobPositionMapper;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao, JobPositionMapper jobPositionMapper) {
        this.jobPositionDao = jobPositionDao;

        this.jobPositionMapper = jobPositionMapper;
    }


    @Override
    public Result add(JobPositionPostDto jobPositionPostDto) {
        JobPosition jobPosition = this.jobPositionMapper.dtoToModel(jobPositionPostDto);
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Message.positionAdded);
}

    @Override
    public DataResult<List<JobPositionGetDto>> getAll() {
        List<JobPosition> jobPositionList = this.jobPositionDao.findAll();

        return new SuccessDataResult<List<JobPositionGetDto>>(this.jobPositionMapper.modelToDtos(jobPositionList), Message.positionListed);
    }


    private Result positionExist(String position){
        if (this.jobPositionDao.findByPosition(position).isPresent()){
            return new ErrorResult(Message.positionExist);
        }
        return new SuccessResult();
    }




}
