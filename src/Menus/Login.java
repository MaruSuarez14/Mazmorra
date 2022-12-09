package Menus;

import dao.UserDao;
import dao.mysql_implementation.UserDaoMysql;
import domain.Session;

import java.sql.Connection;

public class Login extends Menu {
    protected Connection con;

    public Login(String title, Connection con) {
        super(title);
        this.con = con;
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                String user = Input.readString("Nombre de usuario");
                String password = Input.readString("Contraseña");
                UserDaoMysql userDao = new UserDaoMysql(con);
                if (userDao.loginUser(user, password)) {
                    Session session = new Session(con, userDao.findByUserName(user));
                    Menu menu = new CharacterSelection("Seleccion de personaje", session);
                    menu.start();
                }
            }

            @Override
            public String getOptionName() {
                return "Iniciar sesión";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                String user = Input.readString("Nombre de usuario: ");
                String name = Input.readString("Nombre: ");
                String surname1 = Input.readString("Primer apellido: ");
                String surname2 = Input.readString("Segundo apellido: ");
                String email = Input.readString("Email: ");
                String password = Input.readString("Contraseña: ");
                UserDaoMysql userDao = new UserDaoMysql(con);
                userDao.createUser(user, name, surname1, surname2, email, password);
                sleep(5000);
            }

            @Override
            public String getOptionName() {
                return "Registrarse";
            }
        });
    }

    @Override
    protected void onPreOptions() {


    }
}
