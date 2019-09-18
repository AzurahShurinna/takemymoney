package technocite.be.takemymoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technocite.be.takemymoney.model.OweMoney;
import technocite.be.takemymoney.model.User;
import technocite.be.takemymoney.repository.OweDao;
import technocite.be.takemymoney.repository.UserDao;

import java.util.List;
import java.util.function.Function;

@Service
public class UserOweService  {




    @Autowired
    private OweDao oweDao;

    @Autowired
    private UserDao userDao;

    public User addUser(User user){
       return userDao.addUser(user);
    }

    public OweMoney addowe(OweMoney oweMoney){
        return oweDao.addDette(oweMoney);
    }

    public User findByEmail(String email){
        User user = userDao.getByEmail(email);
        if ( user != null){
            return user;
        } else {
            throw new RuntimeException("email not found");
        }
    }

    public List<OweMoney> findAllOwe(){
        return oweDao.ff();
    }

    public List<User> findAllUser(){
        return userDao.findAllUser();
    }

    public Boolean remoteOwe(OweMoney oweMoney){
        return oweDao.removeDette(oweMoney);
    }




}
