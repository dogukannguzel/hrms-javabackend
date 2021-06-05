package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.*;
import kodlamaio.hrms.entities.dtos.*;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResumeMapper {
    @Named("educationToDto")
    @Mapping(source = "graduate.graduateDescription",target = "description")
    EducationGetDto eduGetDto(Education education);

    @IterableMapping(qualifiedByName = "educationToDto")
    @Named("educationToDtos")
    List<EducationGetDto> eduGetDtos (List<Education> educations);


    @Named("jobExpGetDto")
    @Mapping(source = "resume.id",target = "resumId")
    JobExperienceGetDto jobExpToDto(JobExperience jobExperience);

    @IterableMapping(qualifiedByName ="jobExpGetDto" )
    @Named("jobExpGetDtos")
    List<JobExperienceGetDto> jobExpToDtos(List<JobExperience> jobExperiences);

    @Named("langGetDto")
    @Mapping(source = "resume.id",target = "resumId")
    LanguageGetDto langToDto(Language language);

    @IterableMapping(qualifiedByName ="langGetDto" )
    @Named("langGetDtos")
    List<LanguageGetDto> langToDtos(List<Language> languages);

    @Named("tecGetDto")
    @Mapping(source = "resume.id",target = "resumeId")
    @Mapping(source = "technology.techonologydescription",target = "techonologydescription")
    TechonologyGetDto tecToDto(Technology technology);

    @IterableMapping(qualifiedByName = "tecGetDto")
    @Named("tecToDtos")
    List<TechonologyGetDto> tecToDtos(List<Technology> technology);



    @Mapping(target = "educations", source = "educations", qualifiedByName = "educationToDtos")
    @Mapping(target = "jobExperiences", source = "jobExperiences", qualifiedByName = "jobExpGetDtos")
    @Mapping(target = "languages", source = "languages", qualifiedByName = "langGetDtos")
    @Mapping(target = "technologies", source = "technologies", qualifiedByName = "tecToDtos")
    @Mapping(target = "candidateId", source = "candidate.id")
    @Named("toGetDto")
    ResumeGetDto map(Resume resume);

    @IterableMapping(qualifiedByName = "toGetDto")
    List<ResumeGetDto> map(List<Resume> candidateCVS);



}
