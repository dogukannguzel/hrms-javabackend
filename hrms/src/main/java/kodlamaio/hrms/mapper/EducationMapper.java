package kodlamaio.hrms.mapper;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Graduate;
import kodlamaio.hrms.entities.dtos.EducationGetDto;
import kodlamaio.hrms.entities.dtos.EducationPostDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",imports = Graduate.class)
public interface EducationMapper {
    @Mapping(source = "graduateId",target = "graduate.id")
    @Mapping(source = "resumeId",target = "resume.id")
    Education dtoToModel(EducationPostDto educationPostDto);

    @Named("toGetDto")
    @Mapping(source = "graduate.graduateDescription",target = "description")
    EducationGetDto modelToDto(Education education);


    @IterableMapping(qualifiedByName ="toGetDto" )
    List<EducationGetDto> modelToDto(List<Education> educations);



}
