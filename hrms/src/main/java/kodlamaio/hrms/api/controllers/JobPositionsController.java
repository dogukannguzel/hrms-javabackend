package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionsController {

    private JobPositionService jobService;

    @Autowired
    public JobPositionsController(JobPositionService jobService){
        this.jobService=jobService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){

        return this.jobService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){

        return this.jobService.add(jobPosition);
    }


}
