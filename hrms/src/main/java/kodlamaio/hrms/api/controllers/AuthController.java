package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.auth.CandidateAuthService;
import kodlamaio.hrms.business.abstracts.auth.EmployerAuthService;
import kodlamaio.hrms.business.abstracts.VerifyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidatesRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final VerifyService verifyService;
    private final CandidateAuthService candidateAuthService;
    private final EmployerAuthService employerAuthService;
    @Autowired
    public AuthController(VerifyService verifyService, CandidateAuthService candidateAuthService, EmployerAuthService employerAuthService) {
        this.verifyService = verifyService;
        this.candidateAuthService = candidateAuthService;
        this.employerAuthService = employerAuthService;
    }

    @PostMapping("/register/candidate")
    public Result registerCandidates(@RequestBody @Valid CandidatesRegisterDto candidatesRegisterDto){
        return this.candidateAuthService.register(candidatesRegisterDto);
    }

    @PostMapping("/register/employer")
    public Result registerCandidates(@RequestBody @Valid EmployerRegisterDto employerRegisterDto){
        return this.employerAuthService.register(employerRegisterDto);
    }

    @GetMapping("/verify/{code}")
    public Result verify(@PathVariable  String code){
        return this.verifyService.verify(code);
    }

}
