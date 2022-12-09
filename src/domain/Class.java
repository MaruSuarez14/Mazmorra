package domain;

public class Class {
    private int classID;
    private String name;
    private String description;
    private int hp;
    private int attack;
    private int accuracy;
    private int evasion;

    public Class(int classID, String name, String description, int hp, int attack, int accuracy, int evasion) {
        this.classID = classID;
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.attack = attack;
        this.accuracy = accuracy;
        this.evasion = evasion;
    }

    public Class(Class classID) {
    }

    public int getClassID() {
        return classID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getEvasion() {
        return evasion;
    }

    @Override
    public String toString() {
        return "Class " +
                "classID = " + classID +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", hp = " + hp +
                ", attack = " + attack +
                ", accuracy = " + accuracy +
                ", evasion = " + evasion;
    }
}
