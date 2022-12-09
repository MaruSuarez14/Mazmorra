package dao;
import domain.Item;

public interface ItemDao {
    Item findItemByID(int itemID);
}
