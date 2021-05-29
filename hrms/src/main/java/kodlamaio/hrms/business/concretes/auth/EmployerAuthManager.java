package kodlamaio.hrms.business.concretes.auth;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.abstracts.auth.EmployerAuthService;
import kodlamaio.hrms.business.validationRules.abstracts.AuthValidatorService;
import kodlamaio.hrms.core.utilities.businessEngine.BusinessRun;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager implements EmployerAuthService {

    private final AuthValidatorService authValidatorService;
    private final EmployerService employerService;
    private final VerificationCodeService verificationCodeService;
    private final ModelMapper modelMapper;
    @Autowired
    public EmployerAuthManager(AuthValidatorService authValidatorService, EmployerService employerService, VerificationCodeService verificationCodeService, ModelMapper modelMapper) {
        this.authValidatorService = authValidatorService;
        this.employerService = employerService;
        this.verificationCodeService = verificationCodeService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Result register(EmployerRegisterDto employerRegisterDto) {

        Result result = BusinessRun.run(authValidatorService.passwordCondirmed(employerRegisterDto.getPassword(),employerRegisterDto.getConfirmPassword()));

        if (!result.isSuccess()){
            return  result;
        }

        Result employerValidate =employerRegister(employerRegisterDto);
        if (!employerValidate.isSuccess()) {
            return employerValidate;
        }
        return employerValidate;
    }

    private Result employerRegister(EmployerRegisterDto employerRegisterDto){

        DataResult<Company> result = this.candidateRegister(employerRegisterDto);
       if (!result.isSuccess()){
            return result;
        }
        Result codeService = this.verificationCodeService.saveCode(result.getData());
        if (!codeService.isSuccess()){
            return codeService;
        }
        return  codeService;
    }



    private DataResult<Company> candidateRegister(EmployerRegisterDto employerRegisterDto){

       // Employer employer = new Employer(employerRegisterDto.getEmail(),employerRegisterDto.getPassword(),employerRegisterDto.getCompanyName(),employerRegisterDto.getWebAddress(),employerRegisterDto.getPhoneNumber());

        Company company = modelMapper.map(employerRegisterDto, Company.class);

        Result result=   this.employerService.add(company);

        if (!result.isSuccess()){
            return new ErrorDataResult<>(null, result.getMessage());
        }
        return new SuccessDataResult<Company>(company,null);

    }



}
