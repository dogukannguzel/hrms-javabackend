package hrms.business.concretes;

import hrms.business.abstracts.JobPositionService;
import hrms.dataAccess.abstracts.JobPositionDao;
import hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobDao){
        this.jobDao=jobDao;
     }

    @Override
    public List<JobPosition> getAll() {
        return this.jobDao.findAll();
    }
}
