package kodlamaio.hrms.mapper;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionGetDto;
import kodlamaio.hrms.entities.dtos.JobPositionPostDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobPositionMapper {
    JobPosition dtoToModel(JobPositionPostDto jobPositionPostDto);
    List<JobPositionGetDto> modelToDtos(List<JobPosition> jobPositions);
}
