package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Graduate;
import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GraduateManager implements GraduateService {

    private final GraduateDao graduateDao;
    @Autowired
    public GraduateManager(GraduateDao graduateDao) {
        this.graduateDao = graduateDao;
    }

    @Override
    public DataResult<List<Graduate>> getAll() {
        return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Graduate graduate) {
        this.graduateDao.save(graduate);
       return new SuccessResult("Graduate eklendi");
    }


    }

