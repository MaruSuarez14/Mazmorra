package Menus;

import dao.StoreDao;
import dao.mysql_implementation.StoreDaoMySQL;
import domain.Item;
import domain.Session;
import domain.Store;

import java.sql.Connection;
import java.util.List;

public class StoreMenu extends Menu{
    protected Session session;
    public StoreMenu(String title, Session session) {
        super(title);
        this.session = session;
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                Menu menu = new ComprarItems("Comprar items", session);
                menu.start();
            }

            @Override
            public String getOptionName() {
                return "Comprar";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                Menu menu = new VenderItems("Vender items", session);
                menu.start();
            }

            @Override
            public String getOptionName() {
                return "Poner en venta";
            }
        });

    }

    @Override
    protected void onPreOptions() {
        System.out.println("Tienes " + session.getPersonage().getGold() + " monedas de oro");

    }
}
