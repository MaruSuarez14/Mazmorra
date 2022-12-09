package dao;
import domain.User;

public interface UserDao {

    User findByUserID(int userID);
    User findByUserName(String username);

    boolean createUser(String userName, String name, String surname1, String surname2, String email, String password);
    boolean loginUser(String userName, String password);

}
