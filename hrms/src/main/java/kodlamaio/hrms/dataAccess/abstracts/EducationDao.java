package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education,Integer> {
    List<Education> findAllByResumeIdOrderByStartedDate(int resumId);
}
