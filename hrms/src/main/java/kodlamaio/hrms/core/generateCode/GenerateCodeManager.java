package kodlamaio.hrms.core.generateCode;


import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenerateCodeManager implements GenerateCodeService {
    @Override
    public String generateCode() {
        return  UUID.randomUUID().toString();
    }
}
