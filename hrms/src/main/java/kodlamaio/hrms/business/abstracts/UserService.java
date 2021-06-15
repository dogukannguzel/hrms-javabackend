package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;
import org.springframework.http.ResponseEntity;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService<T extends User> {
    DataResult<List<T>> getAll();
   DataResult<T> findAllById(int id);
    Result add(T t) ;
}
