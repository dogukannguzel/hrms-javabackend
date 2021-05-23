package kodlamaio.hrms.core.email.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface MailService {

    void sendMail(User user
    );



}
