package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceDao;
import kodlamaio.hrms.entities.concretes.WorkPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkPlaceManager implements WorkPlaceService {

    private final WorkPlaceDao workPlaceDao;
    @Autowired
    public WorkPlaceManager(WorkPlaceDao workPlaceDao) {
        this.workPlaceDao = workPlaceDao;
    }


    @Override
    public DataResult<List<WorkPlace>> getAll() {
        return new SuccessDataResult<List<WorkPlace>>(this.workPlaceDao.findAll());
    }
}
