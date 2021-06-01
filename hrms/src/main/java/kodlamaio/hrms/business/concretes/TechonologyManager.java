package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.TechonologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechonologyDao;
import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechonologyManager implements TechonologyService {

    private final TechonologyDao techonologyDao;
    @Autowired
    public TechonologyManager( TechonologyDao techonologyDao) {
        this.techonologyDao = techonologyDao;
    }


    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<List<Technology>>(this.techonologyDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Technology technology) {

        this.techonologyDao.save(technology);

        return new SuccessResult("Teknoloji eklendi");
    }
}
