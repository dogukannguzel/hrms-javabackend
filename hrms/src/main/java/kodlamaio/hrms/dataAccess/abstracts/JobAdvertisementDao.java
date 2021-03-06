package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementTableDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {


    List<JobAdvertisement> getAllByApplicationDeadlineLessThanEqual(Date date);

    List<JobAdvertisement> getByCompanyId(int id);

    JobAdvertisement findById(int id);


    @Query("SELECT NEW kodlamaio.hrms.entities.dtos.JobAdvertisementTableDto(p.id,p.company.companyName,p.jobPosition.position,p.openPosition,p.createdDate,p.applicationDeadline) from Company  c inner join c.jobAdvertisements p where c.id=:id")
    List<JobAdvertisementTableDto> getByJobAdversitementCompanyIdTableDto(int id);

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto(p.id,p.jobDescription,p.maxSalary,p.maxSalary,p.openPosition,p.applicationDeadline,p.city.name,p.company.companyName,p.jobPosition.position,p.workPlace.type,p.workType.type,p.createdDate) from Company c INNER JOIN c.jobAdvertisements p")
    List<JobAdvertisementGetDto> getByJobAdversitementDto();

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto(p.id,p.jobDescription,p.maxSalary,p.maxSalary,p.openPosition,p.applicationDeadline,p.city.name,p.company.companyName,p.jobPosition.position,p.workPlace.type,p.workType.type,p.createdDate)  from Company c  INNER JOIN c.jobAdvertisements p where p.enable=true")
    List<JobAdvertisementGetDto> getByJobAdversitementTrueDto();

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto(p.id,p.jobDescription,p.maxSalary,p.maxSalary,p.openPosition,p.applicationDeadline,p.city.name,p.company.companyName,p.jobPosition.position,p.workPlace.type,p.workType.type,p.createdDate)  from Company c  INNER JOIN c.jobAdvertisements p where p.enable=true and p.company.id=:company??d")
    List<JobAdvertisementGetDto> getByJobAdversitementTrueAndCompanyIdDto(int company??d);

    @Query("SELECT NEW kodlamaio.hrms.entities.dtos.JobAdvertisementTableDto(p.id,p.company.companyName,p.jobPosition.position,p.openPosition,p.createdDate,p.applicationDeadline) from Company  c inner join c.jobAdvertisements p where p.enable=true")
    List<JobAdvertisementTableDto> getByJobAdversitementTableDto();


    @Query("SELECT NEW kodlamaio.hrms.entities.dtos.JobAdvertisementTableDto(p.id,p.company.companyName,p.jobPosition.position,p.openPosition,p.createdDate,p.applicationDeadline) from Company  c inner join c.jobAdvertisements p where p.enable=false ")
    List<JobAdvertisementTableDto> getByJobAdversitementEnableFalse();







}
