package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RequestMapping("/api/resumes/")
@RestController
public class ResumesController {

    private final  ResumeService resumeService;


    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Resume>> getAll() {
        return this.resumeService.getAll();
    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody Resume resume) {

        return this.resumeService.add(resume);
    }

    @PutMapping("/saveImage")
    public Result saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) throws IOException {
        return this.resumeService.saveImage(resumeId, file);

    }

}
