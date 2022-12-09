package dao.mysql_implementation;

import dao.UserDao;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoMysql implements UserDao {
    private Connection con;

    public UserDaoMysql(Connection con) {
        this.con = con;
    }

    @Override
    public User findByUserID(int userID) {
        User user = null;
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM User WHERE userID = ?");
            getUserIDStmnt.setInt(1, userID);
            var result = getUserIDStmnt.executeQuery();
            if (result.next()) {
                int userID1 = result.getInt("userID");
                String username = result.getString("username");
                String name = result.getString("name");
                String surname1 = result.getString("surname1");
                String surname2 = result.getString("surname2");
                String email = result.getString("email");
                String password = result.getString("pass");
                user = new User(userID1, username, name, surname1, surname2, email, password);
            }
        } catch (SQLException e) {
            System.out.println("Este usuario no existe");
        }
        return user;
    }

    @Override
    public User findByUserName(String username) {
        User user = null;
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM User WHERE username = ?");
            getUserIDStmnt.setString(1, username);
            var result = getUserIDStmnt.executeQuery();
            if (result.next()) {
                int userID = result.getInt("userID");
                String username1 = result.getString("username");
                String name = result.getString("name");
                String surname1 = result.getString("surname1");
                String surname2 = result.getString("surname2");
                String email = result.getString("email");
                String password = result.getString("pass");
                user = new User(userID, username1, name, surname1, surname2, email, password);
            }
        } catch (SQLException e) {
            System.out.println("Este usuario no existe");
        }
        return user;
    }

    @Override
    public boolean createUser(String userName, String name, String surname1, String surname2, String email, String password) {
        try {
            PreparedStatement insertUser = con.prepareStatement("INSERT INTO User (username, name, surname1, surname2, email, pass) VALUES (?, ?, ?, ?, ?, ?)");
            insertUser.setString(1, userName);
            insertUser.setString(2, name);
            insertUser.setString(3, surname1);
            insertUser.setString(4, surname2);
            insertUser.setString(5, email);
            insertUser.setString(6, password);
            int result = insertUser.executeUpdate();
            if (result > 0) {
                System.out.println("Usuario creado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Este usuario ya está creado");
            return false;
        }
        return true;
    }

    @Override
    public boolean loginUser(String userName, String pass) {
        try {
            PreparedStatement findUser = con.prepareStatement("SELECT * FROM User where username = ? AND pass = ?");
            findUser.setString(1, userName);
            findUser.setString(2, pass);
            ResultSet result = findUser.executeQuery();
            if (result.next()) {
                System.out.println("Usuario encontrado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Usuario no encontrado");
            System.out.println(e);
        }
        return false;
    }
}
