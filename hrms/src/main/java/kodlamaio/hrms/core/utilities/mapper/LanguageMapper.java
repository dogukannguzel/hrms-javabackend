package kodlamaio.hrms.core.utilities.mapper;


import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageGetDto;
import kodlamaio.hrms.entities.dtos.LanguagePostDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    @Mapping(source = "resumeId",target = "resume.id")
    Language dtoToModel(LanguagePostDto languagePostDto);


    @Named("toGetDto")
    @Mapping(source = "resume.id",target = "resumId")
    LanguageGetDto modelToDto(Language language);

    @IterableMapping(qualifiedByName ="toGetDto" )
    List<LanguageGetDto> modelToDtos(List<Language> languages);

}
