package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechonologyPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TechonologyMapper {
    @Mapping(source = "resumeId",target = "resume.id")
    Technology dtoToModel(TechonologyPostDto techonologyPostDto);

}
