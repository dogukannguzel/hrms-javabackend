package kodlamaio.hrms.core.mailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailManager  implements MailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(String to,String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("HRMS ACCOUNT VERİFİED");
        message.setText("Sitemize kayıt olduğunuz için teşekkür ederiz Hesanızı onaylamak için alttakı linke tıklayınız\n"+body);
       // javaMailSender.send(message);

    }
}
