package dao.mysql_implementation;

import dao.InventoryDao;
import dao.ItemDao;
import dao.PersonageDao;
import dao.UserDao;
import domain.*;
import domain.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDaoMySQL implements InventoryDao {
    private Connection con;
    public InventoryDaoMySQL (Connection con) {
        this.con = con;
    }

    @Override
    public Inventory findByInventoryID(int inventoryID) {
        Inventory inventory = null;
        Personage personage;
        PersonageDao personageDao = new PersonageDaoMysql(con);
        Item item;
        ItemDao itemDao = new ItemDaoMySQL(con);
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM Inventory WHERE inventoryID = ?");
            getUserIDStmnt.setInt(1, inventoryID);
            var result = getUserIDStmnt.executeQuery();
            while (result.next()) {
                int inventoryID1 = result.getInt("inventoryID");
                personage = personageDao.findByID(result.getInt("personageID"));
                item = itemDao.findItemByID(result.getInt("itemID"));
                inventory = new Inventory(inventoryID1, personage, item);
            }
        } catch (SQLException e) {
            System.out.println("Este inventario no existe");
        }
        return inventory;
    }

    @Override
    public List<Item> findByPersonageID(int personageID) {
        Inventory inventory = null;
        List<Item> list = new ArrayList<>();
        Item item;
        ItemDao itemDao = new ItemDaoMySQL(con);
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT itemID FROM Inventory WHERE personageID = ?");
            getUserIDStmnt.setInt(1, personageID);
            var result = getUserIDStmnt.executeQuery();
            while (result.next()) {
                item = itemDao.findItemByID(result.getInt("itemID"));
                list.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Este inventario no existe");
        }
        return list;
    }

}
