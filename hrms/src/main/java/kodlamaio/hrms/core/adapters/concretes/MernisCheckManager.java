package kodlamaio.hrms.core.adapters.concretes;

import kodlamaio.hrms.core.adapters.abstracts.PersonCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisCheckManager implements PersonCheckService {
    @Override
    public boolean checkIfRealPerson(Candidate candidate) {

        // direkt true veriyoruz simulasyon


        return true;
    }
}
