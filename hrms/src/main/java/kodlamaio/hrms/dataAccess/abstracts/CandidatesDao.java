package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesDao extends JpaRepository<Candidate,Integer> {
}
