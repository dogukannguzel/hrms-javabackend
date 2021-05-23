package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.abstracts.PersonCheckService;
import kodlamaio.hrms.core.email.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidatesDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateManager implements CandidateService {

    private CandidatesDao candidatesDao;
    private PersonCheckService personCheckService;
    private MailService mailService;


    @Autowired
    public CandidateManager(CandidatesDao candidatesDao,PersonCheckService personCheckService,MailService mailService) {
        this.candidatesDao = candidatesDao;
        this.personCheckService=personCheckService;
        this.mailService=mailService;
    }



    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidatesDao.findAll(),"Veriler başarıyla getirildi");
    }

    @Override
    public Result add(Candidate candidate) {

        if (personCheckService.checkIfRealPerson(candidate)){
            this.mailService.sendMail(candidate);
            this.candidatesDao.save(candidate);

            return new SuccessResult("Veri başarıyla eklendi");
        }
            return new ErrorResult("Bir hata oluştu");
    }
}
