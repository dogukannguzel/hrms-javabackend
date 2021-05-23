package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {

    DataResult<List<Candidate>> getAll();

    Result add(Candidate candidate);
}
