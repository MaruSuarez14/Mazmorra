package dao.mysql_implementation;

import dao.QualityDao;
import domain.Quality;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QualityDaoMySQL implements QualityDao {
    private Connection con;
    public QualityDaoMySQL(Connection con){
        this.con = con;
    }
    @Override
    public Quality findQualityByID(int qualityID) {
        Quality quality = null;
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM Quality WHERE qualityID = ?");
            getUserIDStmnt.setInt(1, qualityID);
            var result = getUserIDStmnt.executeQuery();
            if (result.next()) {
                int qualityID1 = result.getInt("qualityID");
                String name = result.getString("name");
                int attack = result.getInt("attack");
                int evasion = result.getInt("evasion");
                int hp = result.getInt("hp");
                int accuracy = result.getInt("accuracy");
                quality = new Quality(qualityID1, name, attack, evasion, hp, accuracy);
            }
        } catch (SQLException e) {
            System.out.println("Esta cualidad no existe");
        }
        return quality;
    }
}
