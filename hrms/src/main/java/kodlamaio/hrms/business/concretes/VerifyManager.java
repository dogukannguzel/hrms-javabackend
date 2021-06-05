package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerifyService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.core.utilities.businessEngine.BusinessRun;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VerifyManager implements VerifyService {

    private final VerificationCodeDao verificationCodeDao;
    private final UserDao userDao;

    @Autowired
    public VerifyManager(VerificationCodeDao verificationCodeDao, UserDao userDao) {
        this.verificationCodeDao = verificationCodeDao;
        this.userDao = userDao;
    }


    @Override
    public Result verify(String uuid,String code) {
        Result run = BusinessRun.run(userCodeExist(uuid),codeCheck(code));
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


    private Result userCodeExist(String uuid){
        if (this.userDao.existsByUuid(uuid)){
            return new SuccessResult();
        }
        return new ErrorResult("Sistemde kayıtlı olan bir kullanıcı değil !");
    }



}
