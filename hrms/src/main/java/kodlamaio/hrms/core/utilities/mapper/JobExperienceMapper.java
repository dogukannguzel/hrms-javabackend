package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.dtos.JobExperiencePostDto;
import org.mapstruct.Mapper;
import kodlamaio.hrms.entities.concretes.JobExperience;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobExperienceMapper {
    @Mapping(source = "resumeId",target = "resume.id")
    @Mapping(source = "jobPositionId",target = "jobPosition.id")
    JobExperience dtoToModel(JobExperiencePostDto jobExperiencePostDto);

}
