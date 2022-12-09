package Menus;

import domain.Session;

public class MainMenu extends Menu{
    protected Session session;
    public MainMenu(String title, Session session) {
        super(title);
        this.session = session;

    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                Menu menu = new Dungeon("Mazmorra", session);
                menu.start();
            }

            @Override
            public String getOptionName() {
                return "Mazmorra";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                Menu menu = new StoreMenu("Tienda", session);
                menu.start();
            }

            @Override
            public String getOptionName() {
                return "Tienda";
            }
        });
        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                Menu menu = new InventoryMenu("Inventario", session);
                menu.start();
            }

            @Override
            public String getOptionName() {
                return "Inventario";
            }
        });

    }

    @Override
    protected void onPreOptions() {

    }
}
