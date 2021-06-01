package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.TechonologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/techonologys")
public class TechonologysController {

    private final TechonologyService techonologyService;
    @Autowired
    public TechonologysController(TechonologyService techonologyService) {
        this.techonologyService = techonologyService;
    }

    @GetMapping("/getall")
    public DataResult<List<Technology>> getAll() {
        return this.techonologyService.getAll() ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Technology technology) {

        return this.techonologyService.add(technology);
    }


}
