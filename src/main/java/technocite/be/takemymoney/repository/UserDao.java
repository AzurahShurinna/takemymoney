package technocite.be.takemymoney.repository;

import technocite.be.takemymoney.model.User;

import java.util.List;

public interface UserDao {



    List<User> findAllUser();

    User addUser(User user);

    User getByEmail(String email);

}
