package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserRealCheckService {

    boolean checkIfRealPerson(Candidate user);


}
