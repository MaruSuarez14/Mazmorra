package Menus;

import dao.ClassDao;
import dao.InventoryDao;
import dao.PersonageDao;
import dao.mysql_implementation.ClassDaoMysql;
import dao.mysql_implementation.InventoryDaoMySQL;
import dao.mysql_implementation.PersonageDaoMysql;
import domain.Class;
import domain.Personage;
import domain.Session;

import java.sql.Connection;
import java.util.List;

public class CharacterSelection extends Menu {
    protected Session session;

    public CharacterSelection(String title, Session session) {
        super(title);
        this.session = session;
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                PersonageDao personageDao = new PersonageDaoMysql(session.getCon());
                List<Personage> personageList = personageDao.findByUserID(session.getUser().getUserID());
                int count = 1;
                for (Personage p : personageList) {
                    System.out.println(count + ")" + p);
                    count++;
                }
                int selection = Input.readInt("Elige el número de personaje");
                Personage personage = personageList.get(selection-1);
                if(personageDao.findByID(personage.getCharacterID()) != null){
                    Session session1  = new Session(session.getCon(), session.getUser(), personage);
                    Menu menu = new MainMenu("Menú principal", session1);
                    menu.start();
                }
            }

            @Override
            public String getOptionName() {
                return "Selección de personaje";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                ClassDao classDao = new ClassDaoMysql(session.getCon());
                List<Class> list = classDao.findAllClasses();
                int count = 1;
                for (Class e : list) {
                    System.out.println(count + ")" + e);
                    count++;
                }
                int classSelection = Input.readInt("Elige un número");
                String characterName = Input.readString("Nombre del personaje");
                PersonageDao personageDao = new PersonageDaoMysql(session.getCon());
                personageDao.createPersonage(classSelection, characterName, session.getUser().getUserID());
                sleep(2000);

            }
            @Override
            public String getOptionName() {
                return "Crear un personaje nuevo";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                PersonageDao personageDao = new PersonageDaoMysql(session.getCon());
                List<Personage> personageList = personageDao.findByUserID(session.getUser().getUserID());
                int count = 1;
                for (Personage p : personageList) {
                    System.out.println(count + ")" + p);
                    count++;
                }
                int selection = Input.readInt("Elige un número");
                int characterID = personageList.get(selection-1).getCharacterID();
                personageDao.removePersonage(characterID);
            }

            @Override
            public String getOptionName() {
                return "Eliminar un personaje";
            }
        });
    }

    @Override
    protected void onPreOptions() {

    }
}
