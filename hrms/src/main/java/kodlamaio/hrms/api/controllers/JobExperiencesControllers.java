package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesControllers {
    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesControllers(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }



    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience) {

        return this.jobExperienceService.add(jobExperience);
    }



}
