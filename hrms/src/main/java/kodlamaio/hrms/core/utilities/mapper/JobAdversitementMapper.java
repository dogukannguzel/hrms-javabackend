package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGetDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobAdversitementMapper {
    @Mapping(source = "cityId",target = "city.id")
    @Mapping(source = "companyId",target = "company.id")
    @Mapping(source = "jobPositionId",target = "jobPosition.id")
    @Mapping(source = "workPlaceId",target = "workPlace.id")
    @Mapping(source = "workTypeId",target = "workType.id")
    JobAdvertisement dtoToModel(JobAdvertisementPostDto jobAdvertisementPostDto);


    @Mapping(source = "city.name",target = "cityName")
    @Mapping(source = "company.companyName",target = "companyName")
    @Mapping(source = "jobPosition.position",target = "jobPosition")
    @Mapping(source = "workPlace.type",target ="workPlaceType" )
    @Mapping(source = "workType.type",target = "workType")
    JobAdvertisementGetDto modelToDto(JobAdvertisement jobAdvertisement);



}
