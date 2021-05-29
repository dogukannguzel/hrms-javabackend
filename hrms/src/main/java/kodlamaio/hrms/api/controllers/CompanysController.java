package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employers")
public class CompanysController {

    private CompanyService companyService;

    @Autowired
    public CompanysController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getall")
    public DataResult<List<Company>> getAll(){
        return this.companyService.getAll();
    }



}
