package dao;

import domain.Enemy;

public interface EnemyDao {

    Enemy findByLvl(int level);
}
