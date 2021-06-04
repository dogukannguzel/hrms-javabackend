package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.ımageService.ImageService;
import kodlamaio.hrms.dataAccess.abstracts.ResumDao;
import kodlamaio.hrms.entities.concretes.Resume;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ResumeManager implements ResumeService {
    private final ImageService imageService;
    private final ResumDao resumDao;
    private final ModelMapper modelMapper;

    @Autowired
    public ResumeManager(ImageService imageService, ResumDao resumDao, ModelMapper modelMapper) {
        this.imageService = imageService;
        this.resumDao = resumDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Resume resume)  {
        if (resume.getLanguages() != null) {
            resume.getLanguages().forEach(lang -> lang.setResume(resume));
        }

        if (resume.getEducations()!=null){
            resume.getEducations().forEach(edu->edu.setResume(resume));
        }
        if (resume.getJobExperiences()!=null){
            resume.getJobExperiences().forEach(exp->exp.setResume(resume));
        }
        if (resume.getTechnologies()!=null){
            resume.getTechnologies().forEach(tec->tec.setResume(resume));
        }


        this.resumDao.save(resume);
        return new SuccessResult(Message.resumeAdded);
    }

    @Override
    public Result saveImage(int resumId, MultipartFile file) throws IOException {

        Resume resume=this.resumDao.getOne(resumId);

        Map<String, String> uploader = (Map<String, String>) imageService.save(file).getData();
        String imageUrl= uploader.get("url");

        resume.setPhoto(imageUrl);
        this.resumDao.save(resume);

        return new SuccessResult("Resim ekleme başarılı");
    }


}
