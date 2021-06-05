package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.EducationGetDto;
import kodlamaio.hrms.entities.dtos.EducationPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.educationService.getAll()) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody EducationPostDto educationPostDto) {

        return ResponseEntity.ok(this.educationService.add(educationPostDto));
    }
    @GetMapping("/findAllByResumeIdOOrderByStartedDate")
    public DataResult<List<EducationGetDto>> findAllByResumeIdOOrderByStartedDate(@RequestParam int resumId) {

        return this.educationService.findAllByResumeIdOOrderByStartedDate(resumId);
    }

}
