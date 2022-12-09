package Menus;

import domain.Session;

import java.sql.Connection;

public class VenderItems extends Menu {
    Session session;
    public VenderItems(String title, Session session) {
        super(title);
        this.session = session;
    }

    @Override
    protected void initActions() {

    }

    @Override
    protected void onPreOptions() {

    }
}
