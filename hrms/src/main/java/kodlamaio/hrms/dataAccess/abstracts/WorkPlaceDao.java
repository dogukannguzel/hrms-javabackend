package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPlaceDao extends JpaRepository<WorkPlace,Integer> {
}
