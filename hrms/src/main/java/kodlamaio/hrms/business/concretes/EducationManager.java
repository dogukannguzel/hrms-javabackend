package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.mapper.EducationMapper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationGetDto;
import kodlamaio.hrms.entities.dtos.EducationPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;
    private final EducationMapper educationMapper;

    @Autowired
    public EducationManager(EducationDao educationDao, EducationMapper educationMapper) {
        this.educationDao = educationDao;
        this.educationMapper = educationMapper;
    }

    @Override
    public DataResult<EducationGetDto> findAllByResumeId(int resumId) {
        Education education = this.educationDao.findAllByResumeId(resumId);

        return new SuccessDataResult<EducationGetDto>(this.educationMapper.modelToDto(education));
    }

    @Override
    public DataResult<List<EducationGetDto>> getAll() {
        List<Education> educationGetDtoList = this.educationDao.findAll();
        return new SuccessDataResult<List<EducationGetDto>>(this.educationMapper.modelToDto(educationGetDtoList));}

    @Override
    public Result add(EducationPostDto educationPostDto) {
        Education education=this.educationMapper.dtoToModel(educationPostDto);

        this.educationDao.save(education);
        return new SuccessResult("Eğitim eklendi");
    }

    @Override
    public DataResult<List<EducationGetDto>> findAllByResumeIdOOrderByStartedDate(int resumId) {
        List<Education> educationList = this.educationDao.findAllByResumeIdOrderByStartedDate(resumId);
        return new SuccessDataResult<List<EducationGetDto>>(this.educationMapper.modelToDto(educationList));
    }
}
