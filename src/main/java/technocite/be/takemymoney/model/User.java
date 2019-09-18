package technocite.be.takemymoney.model;


import java.util.List;

public class User {

    private String email;
    private String password;
    private String fullname;
    private boolean enabled;
    private List<User> pplIborrow;
    private List<User> pplBorrowMe;


    public User(String email, String password, String fullname, boolean enabled) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
