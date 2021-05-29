package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementReadDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> getAllByEnableTrue();

    JobAdvertisement findAllByCompanyIdAndId(int employerId,int id);

    List<JobAdvertisement> getAllByApplicationDeadlineLessThanEqual(Date date);

    List<JobAdvertisement> getByCompanyId(int id);

    List<JobAdvertisement> getAllByEnableTrueAndCompanyId(int employerİd);



}
