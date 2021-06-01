package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumDao;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResumeManager implements ResumeService {

    private final ResumDao resumDao;
    @Autowired
    public ResumeManager(ResumDao resumDao) {
        this.resumDao = resumDao;
    }


    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Resume resume) {
        this.resumDao.save(resume);
        return new SuccessResult("Kayıt yapıldı");
    }
}
