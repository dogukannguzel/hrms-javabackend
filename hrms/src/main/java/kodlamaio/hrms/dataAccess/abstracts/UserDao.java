package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserDao<T extends User> extends JpaRepository<T,Integer> {
   Optional<T> findByEmail(String email);
   boolean existsByUuid(String uuid);
   User findByUuid(String uuid);
   T findById(int id);


}
