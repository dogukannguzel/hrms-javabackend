package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ResumeService {



    SuccessDataResult<List<ResumeGetDto>> getAll();

    Result add(Resume resume) ;

    Result saveImage(int resumId,MultipartFile file) throws IOException;

}
