package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechonologyDao extends JpaRepository<Technology,Integer> {
}
