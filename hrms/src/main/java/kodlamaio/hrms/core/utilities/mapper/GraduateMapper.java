package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Graduate;
import kodlamaio.hrms.entities.dtos.GraduateGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GraduateMapper {

    @Named("modelToDto")
    GraduateGetDto modelToDto(Graduate graduate);

    List<GraduateGetDto> modelToDtos(List<Graduate> graduates);

}
