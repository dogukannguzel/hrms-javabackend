package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/worktypes")
@CrossOrigin
public class WorkTypesController {

    private final WorkTypeService workTypeService;

    @Autowired
    public WorkTypesController(WorkTypeService workTypeService) {
        this.workTypeService = workTypeService;

    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.workTypeService.getAll());
    }

}
