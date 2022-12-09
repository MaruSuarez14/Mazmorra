package dao.mysql_implementation;

import dao.ItemDao;
import dao.QualityDao;
import domain.Item;
import domain.Quality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDaoMySQL implements ItemDao {
    private Connection con;
    public ItemDaoMySQL(Connection con){
        this.con = con;
    }
    @Override
    public Item findItemByID(int itemID) {
        Item item = null;
        Quality qualityID;
        QualityDao quality = new QualityDaoMySQL(con);
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM Item WHERE itemID = ?");
            getUserIDStmnt.setInt(1, itemID);
            var result = getUserIDStmnt.executeQuery();
            if (result.next()) {
                int itemID1 = result.getInt("itemID");
                String name = result.getString("name");
                int hp = result.getInt("hp");
                int attack = result.getInt("attack");
                int accuracy = result.getInt("accuracy");
                int evasion = result.getInt("evasion");
                qualityID = quality.findQualityByID(result.getInt("qualityID"));
                item = new Item(itemID1, name, qualityID, hp, attack, accuracy, evasion);
            }
        } catch (SQLException e) {
            System.out.println("Este objeto no existe");
        }
        return item;
    }
}
