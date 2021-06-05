package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechonologyGetDto;
import kodlamaio.hrms.entities.dtos.TechonologyPostDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechonologyMapper {
    @Mapping(source = "resumeId",target = "resume.id")
    Technology dtoToModel(TechonologyPostDto techonologyPostDto);

    @Named("toGetDto")
    @Mapping(source = "resume.id",target = "resumeId")
    TechonologyGetDto modelToDto(Technology technology);

    @IterableMapping(qualifiedByName = "toGetDto")
    List<TechonologyGetDto> modelToDtos(List<Technology> technology);
}
