package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkPlace;

import java.util.List;

public interface WorkPlaceService {


    DataResult<List<WorkPlace>> getAll();


}
