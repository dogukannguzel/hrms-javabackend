package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.entities.dtos.JobAdvertisementPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {
    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobAdvertisementService.getAll());
    }

    @GetMapping("/getAllByEnableTrue")
    public ResponseEntity<?> getAllByEnableTrue() {
        return ResponseEntity.ok(this.jobAdvertisementService.getByJobAdversitementTrueDto());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid JobAdvertisementPostDto jobAdvertisement) {
        return  ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
    }

    @PutMapping("/setEnable")
    public ResponseEntity<?> setİsJobEnable(@RequestParam("employerId") int employerId,@RequestParam("id") int id) {
        return ResponseEntity.ok(this.jobAdvertisementService.setİsJobEnable(employerId,id));
    }

    @GetMapping("/getAllSorted")
    public  ResponseEntity<?> getAllSorted() {
        return ResponseEntity.ok(this.jobAdvertisementService.getAllSorted());
    }


    @GetMapping("/getAllByEmployerId/{id}")
    public  ResponseEntity<?> getByEmployerId(@PathVariable  int id) {
        return ResponseEntity.ok(this.jobAdvertisementService.getByEmployerId(id));
    }

    @GetMapping("/getAllByEnableTrueAndEmployerId/{employerİd}")
    public  ResponseEntity<?> getAllByEnableTrueAndEmployerId(@PathVariable int employerİd) {
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByEnableTrueAndEmployerId(employerİd));
    }

    @GetMapping("/getByJobAdversitementDto")
    public  ResponseEntity<?> getByJobAdversitementDto() {
        return ResponseEntity.ok(this.jobAdvertisementService.getByJobAdversitementDto());
    }


    @GetMapping("/getByJobAdversitementTrueDto")
    public ResponseEntity<?>  getByJobAdversitementTrueDto() {
        return ResponseEntity.ok(this.jobAdvertisementService.getByJobAdversitementTrueDto());
    }

    @GetMapping("/getByJobAdversitementTableDto")
    public ResponseEntity<?> getByJobAdversitementTableDto() {
        return ResponseEntity.ok(this.jobAdvertisementService.getByJobAdversitementTableDto());
    }

}
