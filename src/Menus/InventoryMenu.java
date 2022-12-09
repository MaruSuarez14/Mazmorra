package Menus;

import dao.InventoryDao;
import dao.mysql_implementation.InventoryDaoMySQL;
import domain.Item;
import domain.Session;

import java.util.List;

public class InventoryMenu extends Menu {
    protected Session session;

    public InventoryMenu(String title, Session session) {
        super(title);
        this.session = session;
    }

    @Override
    protected void initActions() {

    }
    @Override
    protected void onPreOptions() {
        InventoryDao inventoryDao = new InventoryDaoMySQL(session.getCon());
        List<Item> items = inventoryDao.findByPersonageID(session.getPersonage().getCharacterID());
        for (Item i : items) {
            System.out.println(i);
        }

    }
}
