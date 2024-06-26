package Bug;

public class User {
    Long id;
    String Role;
    String UserName;
    String Password;
    String FirstName;
    String LastName;
    String email;
    Integer dateOfBirth;

    public User(String role, String userName, String password, String firstName, String lastName, String email, Integer dateOfBirth) {
        Role = role;
        UserName = userName;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    public long getId() {
        return id;
    }
    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", Role='" + Role + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
