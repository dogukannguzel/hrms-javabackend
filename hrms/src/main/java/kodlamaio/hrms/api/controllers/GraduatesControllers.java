package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/graduates")
public class GraduatesControllers {

    private final GraduateService graduateService;
    @Autowired
    public GraduatesControllers(GraduateService graduateService) {
        this.graduateService = graduateService;
    }


    @GetMapping("/getall")
    public DataResult<List<Graduate>> getAll() {
        return this.graduateService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody @Valid Graduate graduate) {

        return this.graduateService.add(graduate);
    }



}
