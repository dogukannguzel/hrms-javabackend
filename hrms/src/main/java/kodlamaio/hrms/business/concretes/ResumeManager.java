package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.ımageService.ImageService;
import kodlamaio.hrms.dataAccess.abstracts.ResumDao;
import kodlamaio.hrms.entities.concretes.Resume;
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
    @Autowired
    public ResumeManager(ImageService imageService, ResumDao resumDao) {
        this.imageService = imageService;
        this.resumDao = resumDao;
    }


    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Resume resume)  {

        this.resumDao.save(resume);
        return new SuccessResult("Kayıt yapıldı");
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
