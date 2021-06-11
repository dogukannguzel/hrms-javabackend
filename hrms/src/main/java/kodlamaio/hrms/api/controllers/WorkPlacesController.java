package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/workplaces")
@CrossOrigin
public class WorkPlacesController {

    private final WorkPlaceService workPlaceService;

    @Autowired
    public WorkPlacesController(WorkPlaceService workPlaceService) {
        this.workPlaceService = workPlaceService;
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.workPlaceService.getAll());
    }
}
