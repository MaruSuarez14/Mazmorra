package Menus;

import domain.Session;

public class Dungeon extends Menu{
    protected Session session;
    public Dungeon(String title, Session session) {
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
