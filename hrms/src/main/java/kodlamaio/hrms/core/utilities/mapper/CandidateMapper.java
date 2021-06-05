package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidatesRegisterDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate dtoToModel(CandidatesRegisterDto candidatesRegisterDto);
}
