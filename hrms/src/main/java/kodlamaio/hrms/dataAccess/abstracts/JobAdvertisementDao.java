package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> getAllByEnableTrue();

    JobAdvertisement findAllByEmployerIdAndId(int employerId,int id);

    List<JobAdvertisement> getAllByApplicationDeadlineLessThanEqual(Date date);


}
