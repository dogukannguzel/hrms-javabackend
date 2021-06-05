package kodlamaio.hrms.business.concretes.auth;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.abstracts.auth.CompanyAuthService;
import kodlamaio.hrms.business.validationRules.abstracts.AuthValidatorService;
import kodlamaio.hrms.core.utilities.businessEngine.BusinessRun;
import kodlamaio.hrms.core.utilities.mapper.CompanyMapper;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyAuthManager implements CompanyAuthService {

    private final AuthValidatorService authValidatorService;
    private final CompanyService companyService;
    private final VerificationCodeService verificationCodeService;

    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyAuthManager(AuthValidatorService authValidatorService, CompanyService companyService, VerificationCodeService verificationCodeService,  CompanyMapper companyMapper) {
        this.authValidatorService = authValidatorService;
        this.companyService = companyService;
        this.verificationCodeService = verificationCodeService;
        this.companyMapper = companyMapper;
    }


    @Override
    public Result register(CompanyRegisterDto companyRegisterDto) {

        Result result = BusinessRun.run(authValidatorService.passwordCondirmed(companyRegisterDto.getPassword(), companyRegisterDto.getConfirmPassword()));

        if (!result.isSuccess()){
            return  result;
        }

        Result employerValidate =companyRegister(companyRegisterDto);
        if (!employerValidate.isSuccess()) {
            return employerValidate;
        }
        return employerValidate;
    }

    private Result companyRegister(CompanyRegisterDto companyRegisterDto){

        DataResult<Company> result = this.save(companyRegisterDto);
       if (!result.isSuccess()){
            return result;
        }
        Result codeService = this.verificationCodeService.saveCode(result.getData());
        if (!codeService.isSuccess()){
            return codeService;
        }
        return  codeService;
    }



    private DataResult<Company> save(CompanyRegisterDto companyRegisterDto){


        Company company = this.companyMapper.dtoToModel(companyRegisterDto);
        company.setUuid(UUID.randomUUID().toString());

        Result result=   this.companyService.add(company);

        if (!result.isSuccess()){
            return new ErrorDataResult<>(null, result.getMessage());
        }
        return new SuccessDataResult<Company>(company,null);

    }



}
