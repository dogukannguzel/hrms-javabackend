package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobposition")
@CrossOrigin
public class JobPositionsController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobPositionService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid JobPositionPostDto jobPositionPostDto){
        return ResponseEntity.ok(this.jobPositionService.add(jobPositionPostDto));
    }


}
