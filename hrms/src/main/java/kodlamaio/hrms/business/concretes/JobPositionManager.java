package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.validationRules.abstracts.JobPositionValidatorService;
import kodlamaio.hrms.core.utilities.businessEngine.BusinessRun;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;
    private final JobPositionValidatorService jobPositionValidatorService;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao, JobPositionValidatorService jobPositionValidatorService) {
        this.jobPositionDao = jobPositionDao;
        this.jobPositionValidatorService = jobPositionValidatorService;
    }


    @Override
    public Result add(JobPosition jobPosition) {

        Result positionValidate = this.jobPositionValidatorService.positionNullCheck(jobPosition.getPosition());

        if (positionValidate.isSuccess()){
            Result positionCheck = BusinessRun.run(positionExist(jobPosition.getPosition()));
            if (positionCheck.isSuccess()){
                this.jobPositionDao.save(jobPosition);
                return new SuccessResult(Message.positionAdded);
            }
           return positionCheck;

        }

        return  positionValidate;

    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Message.positionListed);
    }


    private Result positionExist(String position){
        if (this.jobPositionDao.findByPosition(position).isPresent()){
            return new ErrorResult(Message.positionExist);
        }
        return new SuccessResult();
    }




}
