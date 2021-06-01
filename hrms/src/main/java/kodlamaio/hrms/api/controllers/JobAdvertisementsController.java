package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementReadDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementRequestDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {
    private final JobAdvertisementService jobAdvertisementService;


    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllByEnableTrue")
    public DataResult<List<JobAdvertisementReadDto>> getAllByEnableTrue() {
        return this.jobAdvertisementService.getAllByEnableTrue();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid JobAdvertisementRequestDto jobAdvertisement) {
        return  this.jobAdvertisementService.add(jobAdvertisement);
    }

    @PutMapping("/setEnable")
    public Result setİsJobEnable(@RequestParam("employerId") int employerId,@RequestParam("id") int id) {
        return this.jobAdvertisementService.setİsJobEnable(employerId,id);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        return this.jobAdvertisementService.getAllSorted();
    }


    @GetMapping("/getAllByEmployerId/{id}")
    public  DataResult<List<JobAdvertisement>> getByEmployerId(@PathVariable  int id) {
        return this.jobAdvertisementService.getByEmployerId(id);
    }

    @GetMapping("/getAllByEnableTrueAndEmployerId/{employerİd}")
    public DataResult<List<JobAdvertisementReadDto>> getAllByEnableTrueAndEmployerId(@PathVariable int employerİd) {
        return this.jobAdvertisementService.getAllByEnableTrueAndEmployerId(employerİd);
    }


}
