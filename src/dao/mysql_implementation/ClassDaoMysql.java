package dao.mysql_implementation;

import dao.ClassDao;
import domain.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoMysql implements ClassDao {
    private Connection con;

    public ClassDaoMysql(Connection con) {
        this.con = con;
    }

    @Override
    public Class findByName(String name) {
        Class class1 = null;
        try {
            PreparedStatement getClassNameStmnt = con.prepareStatement("SELECT * FROM Class WHERE name = ?");
            getClassNameStmnt.setString(1, name);
            var result = getClassNameStmnt.executeQuery();
            if (result.next()) {
                int classID = result.getInt("classID");
                String name1 = result.getString("name");
                String description = result.getString("description");
                int hp = result.getInt("hp");
                int attack = result.getInt("attack");
                int accuracy = result.getInt("accuracy");
                int evasion = result.getInt("evasion");
                class1 = new Class(classID, name1, description, hp, attack, accuracy, evasion);
            }
        } catch (SQLException e) {
            System.out.println("Esta clase no existe");
        }
        return class1;
    }

    @Override
    public Class findByID(int classID) {
        Class class1 = null;
        try {
            PreparedStatement getClassIDStmnt = con.prepareStatement("SELECT * FROM Class WHERE classID = ?");
            getClassIDStmnt.setInt(1, classID);
            var result = getClassIDStmnt.executeQuery();
            if (result.next()) {
                int classID1 = result.getInt("classID");
                String name = result.getString("name");
                String description = result.getString("description");
                int hp = result.getInt("hp");
                int attack = result.getInt("attack");
                int accuracy = result.getInt("accuracy");
                int evasion = result.getInt("evasion");
                class1 = new Class(classID1, name, description, hp, attack, accuracy, evasion);
            }
        } catch (SQLException e) {
            System.out.println("Esta clase no existe");
        }
        return class1;
    }

    @Override
    public List<Class> findAllClasses() {
        Class class1;
        List<Class> list = new ArrayList();
        try {
            PreparedStatement getAllClassesStmnt = con.prepareStatement("SELECT * FROM Class");
            var result = getAllClassesStmnt.executeQuery();
            while(result.next()){
                int classID1 = result.getInt("classID");
                String name = result.getString("name");
                String description = result.getString("description");
                int hp = result.getInt("hp");
                int attack = result.getInt("attack");
                int accuracy = result.getInt("accuracy");
                int evasion = result.getInt("evasion");
                class1 = new Class(classID1, name, description, hp, attack, accuracy, evasion);
                //if(class1!=null){
                    list.add(class1);
                //}
            }
        } catch (SQLException e){
            System.out.println("Ha habido un error");

        }
        return list;
    }

}
