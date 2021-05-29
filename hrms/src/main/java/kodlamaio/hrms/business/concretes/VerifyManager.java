package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerifyService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.core.utilities.businessEngine.BusinessRun;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class VerifyManager implements VerifyService {

    private final VerificationCodeDao verificationCodeDao;

    @Autowired
    public VerifyManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }


    @Override
    public Result verify(String code) {
        Result run = BusinessRun.run(codeCheck(code));
        if (!run.isSuccess()){
           return run;
        }

        VerificationCode verificationCode=getObject(code);
        verificationCode.setVerified(true);
        verificationCode.setConfirmDate(LocalDate.now());
        this.verificationCodeDao.save(verificationCode);
        return new SuccessResult(Message.successVerify);
    }


    private VerificationCode getObject(String code){
        VerificationCode verificationCode = this.verificationCodeDao.findByCode(code).get();
        return  verificationCode;
    }


    private Result isİtVerified(String code){
        VerificationCode verificationCode = getObject(code);


        if (verificationCode.isVerified()){
            return new ErrorResult(Message.userAuthenticadet);
        }
            return new SuccessResult();
    }


    private Result codeCheck(String code){
        if (this.verificationCodeDao.existsByCode(code)){
            Result run = BusinessRun.run(isİtVerified(code));
            if (run.isSuccess()){
                return new SuccessResult();
            }
               return run;
            }
        return new ErrorResult(Message.codeExist);
    }



}
