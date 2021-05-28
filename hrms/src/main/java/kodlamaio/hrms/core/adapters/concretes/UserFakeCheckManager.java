package kodlamaio.hrms.core.adapters.concretes;

import kodlamaio.hrms.core.adapters.abstracts.UserRealCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;

public class UserFakeCheckManager implements UserRealCheckService {
    @Override
    public boolean checkIfRealPerson(Candidate user)  {
        //fake
        return true;
    }
}
