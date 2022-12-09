package dao.mysql_implementation;

import dao.ItemDao;
import dao.PersonageDao;
import dao.StoreDao;
import domain.Inventory;
import domain.Item;
import domain.Personage;
import domain.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDaoMySQL implements StoreDao {
    private Connection con;
    public StoreDaoMySQL (Connection con) {
        this.con = con;
    }
    @Override
    public List<Store> findAllStore() {
        List<Store> list = new ArrayList<>();
        Item item;
        Store store;
        ItemDao itemDao = new ItemDaoMySQL(con);
        Personage personage;
        PersonageDao personageDao = new PersonageDaoMysql(con);
        try {
            PreparedStatement getUserIDStmnt = con.prepareStatement("SELECT * FROM Store");
            var result = getUserIDStmnt.executeQuery();
            while (result.next()) {
                int storeID = result.getInt("storeID");
                personage = personageDao.findByID(result.getInt("personageID"));
                item = itemDao.findItemByID(result.getInt("itemID"));
                int price = result.getInt("price");
                store = new Store(storeID, personage, item, price);
                list.add(store);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
