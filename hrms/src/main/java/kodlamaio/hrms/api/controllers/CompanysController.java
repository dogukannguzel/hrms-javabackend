package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companys")
@CrossOrigin
public class CompanysController {

    private CompanyService companyService;


    @Autowired
    public CompanysController(CompanyService companyService) {
        this.companyService = companyService;

    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok( this.companyService.getAll());
    }

    @GetMapping("/getAllById")
    public ResponseEntity<?> getAllById(@RequestParam("id") int id){

        return ResponseEntity.ok( this.companyService.findAllById(id));
    }


}
