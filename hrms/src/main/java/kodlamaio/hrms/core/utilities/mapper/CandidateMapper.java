package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidatesRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate dtoToModel(CandidatesRegisterDto candidatesRegisterDto);
}
