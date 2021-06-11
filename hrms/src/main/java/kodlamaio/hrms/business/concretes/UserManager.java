package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.constrains.Message;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager<T extends User> implements UserService<T> {


    private final UserDao<T> userDao;

    @Autowired
    public UserManager( UserDao<T> userDao) {

        this.userDao = userDao;

    }


    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<List<T>>(this.userDao.findAll());
    }

    @Override
    public DataResult<List<T>> findAllById(int id) {
        return new SuccessDataResult<List<T>>(this.userDao.findById(id)) ;
    }

    @Override
    public Result add(T t)  {
        this.userDao.save(t);
        return new SuccessResult(Message.userAddes);
    }



}
