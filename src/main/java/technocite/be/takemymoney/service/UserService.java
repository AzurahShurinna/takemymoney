package technocite.be.takemymoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technocite.be.takemymoney.api.dto.UserDto;
import technocite.be.takemymoney.model.OweMoney;
import technocite.be.takemymoney.model.User;
import technocite.be.takemymoney.repository.OweDao;
import technocite.be.takemymoney.repository.UserDao;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService implements Function<User, UserDto> {






    @Autowired
    private UserDao userDao;

    public UserDto addUser(UserDto userDto){
       User user = userDao.getByEmail(userDto.getEmail());

       if (user != null){
           System.out.println("this email is already used !");
           return null;
       } else {
           return new UserDto(userDto.getEmail(),userDto.getPassword(),userDto.getFullname(),userDto.isEnabled());
       }



    }



    public UserDto findByEmail(String email){
        User user = userDao.getByEmail(email);
        if ( user != null){
            return apply(user);
        } else {
            throw new RuntimeException("email not found");
        }
    }



    public List<UserDto> findAllUser(){
        return userDao.findAllUser().stream().map(this).collect(Collectors.toList());
    }




    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getEmail(),user.getPassword(),user.getFullname(), user.isEnabled());
    }
}
