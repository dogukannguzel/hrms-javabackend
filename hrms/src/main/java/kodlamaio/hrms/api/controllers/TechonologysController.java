package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.TechonologyService;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechonologyPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.techonologyService.getAll()) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TechonologyPostDto techonologyPostDto) {

        return ResponseEntity.ok(this.techonologyService.add(techonologyPostDto));
    }


}
