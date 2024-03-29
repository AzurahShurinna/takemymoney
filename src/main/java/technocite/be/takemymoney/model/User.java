package technocite.be.takemymoney.model;


import java.util.Objects;

public class User {

    private String email;
    private String password;
    private String fullname;
    private boolean enabled;



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
