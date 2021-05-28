package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManager<T extends User> implements UserService<T> {


    private final UserDao<T> userDao;

    @Autowired
    public UserManager(UserDao<T> userDao) {
        this.userDao = userDao;

    }


    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<List<T>>(this.userDao.findAll(), Message.userListed);
    }

    @Override
    public Result add(T t)  {

        Result result = emailExist(t.getEmail());
        if (result.isSuccess()){
            this.userDao.save(t);
            return new SuccessResult(Message.userAddes);

        }
        return result;
    }

    private Result emailExist(String email){
        if (userDao.findByEmail(email).isPresent()){
            return new ErrorResult(Message.mailExist);
        }
        return new SuccessResult();

    }

}
