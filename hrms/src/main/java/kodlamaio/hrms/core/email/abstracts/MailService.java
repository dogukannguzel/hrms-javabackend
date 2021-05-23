package kodlamaio.hrms.core.email.abstracts;


import kodlamaio.hrms.entities.abstracts.User;


public interface MailService {

    void sendMail(User user);



}
