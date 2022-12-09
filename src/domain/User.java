package domain;

public class User {

    private int userID;
    private String username;
    private String name;
    private String surname1;
    private String surname2;
    private String email;
    private String password;
    private final Encrypter encrypter = new Encrypter();

    public User(int userID, String username, String name, String surname1, String surname2, String email, String password) {
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.email = email;
        this.password = encrypter.SHA256(password);;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User " +
                "userID = " + userID +
                ", username = '" + username + '\'' +
                ", name = '" + name + '\'' +
                ", surname1 = '" + surname1 + '\'' +
                ", surname2 = '" + surname2 + '\'' +
                ", email = '" + email + '\'' +
                ", password = '" + password + '\'';
    }
}
