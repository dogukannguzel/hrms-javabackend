package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;

    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Eğitim eklendi");
    }
}
