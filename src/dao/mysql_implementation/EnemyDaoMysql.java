package dao.mysql_implementation;

import dao.EnemyDao;
import domain.Enemy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnemyDaoMysql implements EnemyDao {
    private Connection con;

    public EnemyDaoMysql(Connection con) {
        this.con = con;
    }

    @Override
    public Enemy findByLvl(int level) {
        Enemy enemy = null;
        try {
            PreparedStatement getEnemyLvlStmnt = con.prepareStatement("SELECT * FROM Enemy WHERE lvl = ? ORDER BY rand() LIMIT 1");
            getEnemyLvlStmnt.setInt(1, level);
            var result = getEnemyLvlStmnt.executeQuery();
            if (result.next()) {
                int enemyID = result.getInt("enemyID");
                String name = result.getString("name");
                int lvl = result.getInt("lvl");
                int hp = result.getInt("hp");
                int attack = result.getInt("attack");
                int accuracy = result.getInt("accuracy");
                int evasion = result.getInt("evasion");
                enemy = new Enemy(enemyID, name, lvl, hp, attack, accuracy, evasion);
            }
        } catch (SQLException e) {
            System.out.println("ESTE ENEMIGO NO EXISTE!!!");
        }
        return enemy;
    }
}
