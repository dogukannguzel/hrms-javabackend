package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionPostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobPositionMapper {

    JobPosition dtoToModel(JobPositionPostDto jobPositionPostDto);
}
