package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<JobAdvertisement>> getAllByEnableTrue() {
        return this.jobAdvertisementService.getAllByEnableTrue();
    }

    @PostMapping("/add")
    public Result add(@RequestBody  JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementService.add(jobAdvertisement);
        System.out.println(jobAdvertisement.getEmployer().getCompanyName());
        return new SuccessResult("İş pozisyonu eklendi");
    }

    @PutMapping("/setEnable")
    public Result setİsJobEnable(@RequestParam("employerId") int employerId,@RequestParam("id") int id) {
        return this.jobAdvertisementService.setİsJobEnable(employerId,id);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        return this.jobAdvertisementService.getAllSorted();
    }
}
