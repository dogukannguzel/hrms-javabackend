package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.Optional;


public interface CandidateDao extends UserDao<Candidate> {
    Optional<Candidate> findByIdentificationNumber(String identityNumber);

}
