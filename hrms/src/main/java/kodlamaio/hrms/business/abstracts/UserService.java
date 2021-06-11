package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;

import java.util.List;

public interface UserService<T extends User> {
    DataResult<List<T>> getAll();
    DataResult<List<T>> findAllById(int id);
    Result add(T t) ;
}
