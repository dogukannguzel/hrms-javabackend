package hrms.api.controllers;

import hrms.business.abstracts.JobPositionService;
import hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<JobPosition> getAll(){

    return this.jobService.getAll();
    }




}
