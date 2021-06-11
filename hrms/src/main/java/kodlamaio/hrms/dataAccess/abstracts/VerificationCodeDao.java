package kodlamaio.hrms.dataAccess.abstracts;



import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {
    Optional<VerificationCode> findByCode(String code);
    boolean existsByCode(String code);
    boolean existsByUserUuid(String uuid);




}
