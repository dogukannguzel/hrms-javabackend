package kodlamaio.hrms.core.mailSender;

import org.springframework.stereotype.Component;

@Component
public class MailManager  implements MailService{

    @Override
    public void sendMail(String message) {
        System.out.println(message);

    }
}
