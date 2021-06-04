package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    @Mapping(source = "graduateId",target = "graduate.id")
    @Mapping(source = "resumeId",target = "resume.id")
    Education dtoToModel(EducationPostDto educationPostDto);

}
