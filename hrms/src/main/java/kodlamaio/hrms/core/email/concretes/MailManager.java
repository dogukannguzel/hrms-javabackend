package kodlamaio.hrms.core.email.concretes;

import kodlamaio.hrms.core.email.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MailManager implements MailService {
    @Override
    public void sendMail(Candidate candidate) {

        String message = "Sayın " + candidate.getFirstName() + " E-posta adresinize doğrulama linki gönderilmiştir onaylayıp sisteme giriş yapabilirsiniz";

        System.out.println(message);

    }
}
