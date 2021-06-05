package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.core.generateCode.GenerateCodeService;
import kodlamaio.hrms.core.mailSender.MailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VerificationCodeManager implements VerificationCodeService {

    private final GenerateCodeService generateCodeService;
    private final VerificationCodeDao verificationCodeDao;
    private final MailService mailService;

    @Autowired
    public VerificationCodeManager(GenerateCodeService generateCodeService, VerificationCodeDao verificationCodeDao, MailService mailService) {
        this.generateCodeService = generateCodeService;
        this.verificationCodeDao = verificationCodeDao;
        this.mailService = mailService;
    }

    @Override
    public Result saveCode(User user) {

       String uuıd=this.generateCodeService.generateCode();
       int validity=60*5*1000;
       VerificationCode verificationCode = new VerificationCode(user,uuıd,new Date(System.currentTimeMillis()+validity));
       this.verificationCodeDao.save(verificationCode);
       this.mailService.sendMail("http://localhost:8080/api/auth/confirm/"+user.getUuid()+"/"+uuıd);
       return new SuccessResult(Message.codeToMail);
    }
}
