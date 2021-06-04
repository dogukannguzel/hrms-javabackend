package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.mapper.LanguageMapper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguagePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;
    private final LanguageMapper languageMapper;

    @Autowired
    public LanguageManager(LanguageDao languageDao, LanguageMapper languageMapper) {
        this.languageDao = languageDao;
        this.languageMapper = languageMapper;
    }


    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Data listelendi");
    }

    @Override
    public Result add(LanguagePostDto languagePostDto) {
        Language language=this.languageMapper.dtoToModel(languagePostDto);
        this.languageDao.save(language);
        return new SuccessResult("Dil eklendi");
    }
}