package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperiencePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.jobExperienceService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobExperiencePostDto jobExperiencePostDto) {

        return ResponseEntity.ok(this.jobExperienceService.add(jobExperiencePostDto));
    }



}
