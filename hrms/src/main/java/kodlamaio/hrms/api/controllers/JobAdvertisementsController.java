package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementPostDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementTableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
@CrossOrigin()
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
    public ResponseEntity<?> setİsJobEnable(@RequestParam("id") int id) {
        return ResponseEntity.ok(this.jobAdvertisementService.setİsJobEnable(id));
    }

    @GetMapping("/getAllSorted")
    public  ResponseEntity<?> getAllSorted() {
        return ResponseEntity.ok(this.jobAdvertisementService.getAllSorted());
    }


    @GetMapping("/getAllByEmployerId/{id}")
    public  ResponseEntity<?> getByEmployerId(@PathVariable  int id) {
        return ResponseEntity.ok(this.jobAdvertisementService.getByCompanyId(id));
    }

    @GetMapping("/getAllByEnableTrueAndEmployerId/{employerİd}")
    public  ResponseEntity<?> getAllByEnableTrueAndEmployerId(@PathVariable int companyİd) {
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByEnableTrueAndEmployerId(companyİd));
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

    @GetMapping("getByJobAdversitementCompanyIdTableDto")
    public ResponseEntity<?> getByJobAdversitementCompanyIdTableDto(@RequestParam  int id) {
        return ResponseEntity.ok(this.jobAdvertisementService.getByJobAdversitementCompanyIdTableDto(id));
    }

    @GetMapping("/findAllById")
    public ResponseEntity<?> findAllById(@RequestParam() int id) {

        return ResponseEntity.ok(this.jobAdvertisementService.findAllById(id));
    }

    @GetMapping("/getByJobAdversitementEnableFalse")
    public ResponseEntity<?> getByJobAdversitementEnableFalse() {

        return ResponseEntity.ok(this.jobAdvertisementService.getByJobAdversitementEnableFalse());

    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam int id){
        return ResponseEntity.ok(this.jobAdvertisementService.deleteById(id));
    }


}
