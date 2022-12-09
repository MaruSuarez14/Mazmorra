package Menus;

import dao.StoreDao;
import dao.mysql_implementation.StoreDaoMySQL;
import domain.Session;
import domain.Store;

import java.sql.Connection;
import java.util.List;

public class ComprarItems extends Menu{
    Session session;

    public ComprarItems(String title, Session session) {
        super(title);
        this.session = session;
    }

    @Override
    protected void initActions() {

    }

    @Override
    protected void onPreOptions() {
        StoreDao storeDao = new StoreDaoMySQL(session.getCon());
        List<Store> store = storeDao.findAllStore();
        for (Store s : store) {
            System.out.println(s);
        }
    }
}
