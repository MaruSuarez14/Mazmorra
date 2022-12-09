package domain;

public class Enemy {
    private int enemyID;
    private String name;
    private int level;
    private int maxHP;
    private int attack;
    private int evasion;
    private int precision;

    public Enemy(int enemyID, String name, int level, int maxHP, int attack, int evasion, int precision) {
        this.enemyID = enemyID;
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.attack = attack;
        this.evasion = evasion;
        this.precision = precision;
    }

    public int getEnemyID() {
        return enemyID;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAttack() {
        return attack;
    }

    public int getEvasion() {
        return evasion;
    }

    public int getPrecision() {
        return precision;
    }

    @Override
    public String toString() {
        return "Enemy " +
                "enemyID = " + enemyID +
                ", name = '" + name + '\'' +
                ", level = " + level +
                ", maxHP = " + maxHP +
                ", attack = " + attack +
                ", evasion = " + evasion +
                ", precision = " + precision;
    }
}
