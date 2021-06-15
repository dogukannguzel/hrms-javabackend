package kodlamaio.hrms.mapper;


import kodlamaio.hrms.entities.dtos.JobExperienceGetDto;
import kodlamaio.hrms.entities.dtos.JobExperiencePostDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import kodlamaio.hrms.entities.concretes.JobExperience;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobExperienceMapper {
    @Mapping(source = "resumeId",target = "resume.id")
    JobExperience dtoToModel(JobExperiencePostDto jobExperiencePostDto);

    @Named("toGetDto")
    @Mapping(source = "resume.id",target = "resumId")
    JobExperienceGetDto modelToDto(JobExperience jobExperience);

    @IterableMapping(qualifiedByName ="toGetDto" )
    List<JobExperienceGetDto> modelToDtos(List<JobExperience> jobExperiences);

}
