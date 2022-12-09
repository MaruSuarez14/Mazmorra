
import Menus.Login;
import Menus.Menu;
import dao.InventoryDao;
import dao.ItemDao;
import dao.UserDao;

import java.sql.*;

import dao.mysql_implementation.*;
import domain.Inventory;
import domain.Item;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection con = DBUtil.createConnectionFromProperties("res/connection.properties");
        UserDao usuario = new UserDaoMysql(con);

        Menu menu = new Login( "Login",  con);
        menu.start();

    }
}
