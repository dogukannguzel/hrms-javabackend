package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/resumes/")
@RestController
@CrossOrigin
public class ResumesController {

    private final  ResumeService resumeService;


    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.resumeService.getAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody Resume resume) {

        return ResponseEntity.ok(this.resumeService.add(resume));
    }

    @PutMapping("/saveImage")
    public ResponseEntity<?>saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) throws IOException {
        return ResponseEntity.ok(this.resumeService.saveImage(resumeId, file));

    }

    @GetMapping("/getAllByCandidateId/{candidateId}")
    public ResponseEntity<?>  getAllByCandidateId(@PathVariable int candidateId) {

        return ResponseEntity.ok(this.resumeService.getAllByCandidateId(candidateId));
    }



}
