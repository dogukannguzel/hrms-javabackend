package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface PersonCheckService {

    boolean checkIfRealPerson(Candidate candidate);


}
