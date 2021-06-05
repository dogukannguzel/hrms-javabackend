package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.auth.CandidateAuthService;
import kodlamaio.hrms.business.abstracts.auth.CompanyAuthService;
import kodlamaio.hrms.business.abstracts.VerifyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidatesRegisterDto;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final VerifyService verifyService;
    private final CandidateAuthService candidateAuthService;
    private final CompanyAuthService companyAuthService;
    @Autowired
    public AuthController(VerifyService verifyService, CandidateAuthService candidateAuthService, CompanyAuthService companyAuthService) {
        this.verifyService = verifyService;
        this.candidateAuthService = candidateAuthService;
        this.companyAuthService = companyAuthService;
    }

    @PostMapping("/register/candidate")
    public ResponseEntity<?> registerCandidates(@RequestBody @Valid CandidatesRegisterDto candidatesRegisterDto){
        return ResponseEntity.ok(this.candidateAuthService.register(candidatesRegisterDto));
    }

    @PostMapping("/register/employer")
    public ResponseEntity<?> registerCandidates(@RequestBody @Valid CompanyRegisterDto companyRegisterDto){
        return ResponseEntity.ok(this.companyAuthService.register(companyRegisterDto));
    }

    @GetMapping("/confirm/{uuid}/{code}")
    public ResponseEntity<?> confirm(@PathVariable("uuid") String uuid , @PathVariable("code") String verificationCode){

        return ResponseEntity.ok(this.verifyService.verify(uuid,verificationCode));

    }

}
