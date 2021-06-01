package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
}
