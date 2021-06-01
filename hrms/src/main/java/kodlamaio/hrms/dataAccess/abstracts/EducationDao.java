package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Integer> {
}
