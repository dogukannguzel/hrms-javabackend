package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GraduateDao extends JpaRepository<Graduate,Integer> {

    Optional<Graduate> findByGraduateDescription(String description);
}
