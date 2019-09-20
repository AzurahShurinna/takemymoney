package technocite.be.takemymoney.repository;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Repository;
import technocite.be.takemymoney.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Repository
public class UserDaoImpl implements  UserDao {

    private ArrayList<User> users = newArrayList();

    @Override
    public User addUser(User user) {
        if(getByEmail(user.getEmail()) == null){
            users.add(user);
        } else {
            users.remove(user);
            users.add(user);
        }
        return getByEmail(user.getEmail());
    }

    @Override
    public User getByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);

    }

    @Override
    public List<User> findAllUser() {
        return users;
    }

    @PostConstruct
    private void onPostConstruct(){
        try {
            users.add(new User("abcd@gmail.com", "1234","MamyTraillette", true));
            users.add(new User("abdc1234@gmail.com", "1234","JeanCaisse", true));
            users.add(new User("1234@gmail.com", "1234","JeanFeDTonnes", true));
            users.add(new User("IvanDuShit@gmail.com", "1234","IvanDuShit", true));

        } catch (ParseException e) {
            e.printStackTrace();

        }
    }
}
