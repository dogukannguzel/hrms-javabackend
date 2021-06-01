package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumDao extends JpaRepository<Resume,Integer> {
}
