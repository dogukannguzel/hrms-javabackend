package kodlamaio.hrms.core.generateCode;


import org.springframework.stereotype.Component;


import java.util.UUID;

@Component
public class GenerateCodeManager implements GenerateCodeService {
    @Override
    public String generateCode() {
        return  UUID.randomUUID().toString();
    }
}
