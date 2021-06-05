package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobAdversitementMapper {
    @Mapping(source = "cityId",target = "city.id")
    @Mapping(source = "companyId",target = "company.id")
    @Mapping(source = "jobPositionId",target = "jobPosition.id")
    JobAdvertisement dtoToModel(JobAdvertisementPostDto jobAdvertisementPostDto);

}
