package dao.mysql_implementation;

import dao.ClassDao;
import dao.InventoryDao;
import dao.PersonageDao;
import dao.UserDao;
import domain.Class;
import domain.Inventory;
import domain.Personage;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonageDaoMysql implements PersonageDao {
    private Connection con;

    public PersonageDaoMysql(Connection con) {
        this.con = con;
    }

    @Override
    public Personage findByID(int personageID) {
        Personage personage = null;
        Class classID;
        ClassDao clase1 = new ClassDaoMysql(con);
        User userID;
        UserDao user1 = new UserDaoMysql(con);
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM Personage WHERE personageID = ?");
            getUserIDStmnt.setInt(1, personageID);
            var result = getUserIDStmnt.executeQuery();
            if (result.next()) {
                int id = result.getInt("personageID");
                String name = result.getString("name");
                int lvl = result.getInt("lvl");
                int gold = result.getInt("gold");
                int experience = result.getInt("experience");
                int hp_actual = result.getInt("hp_actual");
                int flat = result.getInt("flat");
                classID = clase1.findByID(result.getInt("classID"));
                userID = user1.findByUserID(result.getInt("userID"));
                personage = new Personage(id, name, lvl, gold, experience, hp_actual, flat, classID, userID);
            }
        } catch (SQLException e) {
            System.out.println("ESTE USUARIO NO EXISTE!!! PRUEBA OTRA ID!!");
        }
        return personage;
    }

    @Override
    public Personage findByName(String name) {
        Personage personage = null;
        Class classID;
        User userID;
        ClassDao clase1 = new ClassDaoMysql(con);
        UserDao user1 = new UserDaoMysql(con);
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM Personage WHERE name = ?");
            getUserIDStmnt.setString(1, name);
            var result = getUserIDStmnt.executeQuery();
            if (result.next()) {
                int id = result.getInt("personageID");
                String name1 = result.getString("name");
                int lvl = result.getInt("lvl");
                int gold = result.getInt("gold");
                int experience = result.getInt("experience");
                int hp_actual = result.getInt("hp_actual");
                int flat = result.getInt("flat");
                classID = clase1.findByID(result.getInt("classID"));
                userID = user1.findByUserID(result.getInt("userID"));
                personage = new Personage(id, name1, lvl, gold, experience, hp_actual, flat, classID, userID);
            }
        } catch (SQLException e) {
            System.out.println("ESTE PERSONAJE NO EXISTE!!! PRUEBA OTRO NOMBRE!!");
        }
        return personage;
    }

    @Override
    public List<Personage> findByUserID(int userID) {
        List<Personage> list = new ArrayList<>();
        Personage personage = null;
        Class classID;
        User user;
        ClassDao clase1 = new ClassDaoMysql(con);
        UserDao user1 = new UserDaoMysql(con);
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM Personage WHERE userID = ?");
            getUserIDStmnt.setInt(1, userID);
            var result = getUserIDStmnt.executeQuery();
            while (result.next()) {
                int id = result.getInt("personageID");
                String name = result.getString("name");
                int lvl = result.getInt("lvl");
                int gold = result.getInt("gold");
                int experience = result.getInt("experience");
                int hp_actual = result.getInt("hp_actual");
                int flat = result.getInt("flat");
                classID = clase1.findByID(result.getInt("classID"));
                user = user1.findByUserID(result.getInt("userID"));
                personage = new Personage(id, name, lvl, gold, experience, hp_actual, flat, classID, user);
                list.add(personage);
            }
        } catch (SQLException e) {
            System.out.println("Este personaje no existe");
        }
        return list;
    }

    @Override
    public boolean createPersonage(int classID, String characterName, int userID) {
        try {
            PreparedStatement getPersonageStmnt = con.prepareStatement("INSERT INTO Personage (name, classID, userID) VALUES (?, ?, ?)");
            getPersonageStmnt.setString(1, characterName);
            getPersonageStmnt.setInt(2, classID);
            getPersonageStmnt.setInt(3, userID);
            int result = getPersonageStmnt.executeUpdate();
            if (result > 0) {
                System.out.println("Personaje creado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Este personaje ya está creado");
            return false;
        }
        return true;
    }

    @Override
    public boolean removePersonage(int characterID) {
        try {
            PreparedStatement getPersonageStmnt = con.prepareStatement("DELETE FROM Personage WHERE personageID = ?");
            getPersonageStmnt.setInt(1, characterID);
            int result = getPersonageStmnt.executeUpdate();
            if (result > 0) {
                System.out.println("Personaje eliminado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Este personaje no existe");
            return false;
        }
        return true;
    }
}
