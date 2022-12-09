package dao;

import domain.Inventory;
import domain.Item;

import java.util.List;

public interface InventoryDao {
     Inventory findByInventoryID(int inventoryID);
    List<Item> findByPersonageID(int personageID);
}