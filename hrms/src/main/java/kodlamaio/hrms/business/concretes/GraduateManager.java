package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.mapper.GraduateMapper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrms.entities.concretes.Graduate;
import kodlamaio.hrms.entities.dtos.GraduateGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GraduateManager implements GraduateService {
    private final GraduateMapper graduateMapper;
    private final GraduateDao graduateDao;
    @Autowired
    public GraduateManager(GraduateMapper graduateMapper, GraduateDao graduateDao) {
        this.graduateMapper = graduateMapper;
        this.graduateDao = graduateDao;
    }

    @Override
    public DataResult<List<GraduateGetDto>> getAll() {
        List<Graduate> graduateList = this.graduateDao.findAll();
        return new SuccessDataResult<List<GraduateGetDto>>(this.graduateMapper.modelToDtos(graduateList),"Data listelendi");
    }

    @Override
    public Result add(Graduate graduate) {
        this.graduateDao.save(graduate);
       return new SuccessResult("Graduate eklendi");
    }


    }

