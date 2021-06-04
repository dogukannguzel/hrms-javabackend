package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguagePostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    @Mapping(source = "resumeId",target = "resume.id")
    Language dtoToModel(LanguagePostDto languagePostDto);

}
