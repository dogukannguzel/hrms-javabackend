package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {

    private final EducationService educationService;
    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    public DataResult<List<Education>> getAll() {
        return this.educationService.getAll() ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody  Education education) {

        return this.educationService.add(education);
    }
}
