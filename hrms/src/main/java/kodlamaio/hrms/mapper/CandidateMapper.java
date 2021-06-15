package kodlamaio.hrms.mapper;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateGetDto;
import kodlamaio.hrms.entities.dtos.CandidatesRegisterDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate dtoToModel(CandidatesRegisterDto candidatesRegisterDto);

    CandidateGetDto modelToDto(Candidate candidate);

    List<CandidateGetDto> modelToDtos(List<Candidate> candidates);
}
