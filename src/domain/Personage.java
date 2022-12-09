package domain;

import UI.Colors;

public class Personage {
    private int characterID;
    private String name;
    private int level;
    private int gold;
    private int pointsEXP;
    private int pointsHP;
    private Class classID;
    private int flat;
    private User userID;


    public Personage(int characterID, String name, int level, int gold, int pointsEXP, int pointsHP, int flat, Class classID, User userID) {
        this.characterID = characterID;
        this.name = name;
        this.level = level;
        this.gold = gold;
        this.pointsEXP = pointsEXP;
        this.pointsHP = pointsHP;
        this.flat = flat;
        this.classID = classID;
        this.userID = userID;
    }

    public int getCharacterID() {
        return characterID;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public int getPointsEXP() {
        return pointsEXP;
    }

    public int getPointsHP() {
        return pointsHP;
    }

    public Class getClassID() {
        return classID;
    }

    public int getAttackMax() {
        return classID.getAttack() + (getLevel() * 5);
    }

    public int getEvasionMax() {
        return classID.getEvasion() + (getLevel() * 5);
    }

    public int getAcuraccyMax() {
        return classID.getAccuracy() + (getLevel() * 5);
    }

    public int getExpNecesaria() {
        return (int) (Math.pow(level, 2) + 30 * level - 30);
    }

    public int getMaxHP() {
        return classID.getHp() + (level * 5);
    }

    @Override
    public String toString() {
        return "                   " + Colors.RED_BOLD + "+----------------------------------------+\n" +
                "                       " + Colors.WHITE_UNDERLINED + name + Colors.RESET + " " + Colors.RED_BOLD + classID.getName() + Colors.RESET + " de nivel " + Colors.YELLOW_BOLD + level + Colors.RED_BOLD + "              \n" + Colors.RED_BOLD +
                "                       " + Colors.YELLOW_BOLD + gold + " monedas de oro                  " + Colors.RED_BOLD + "\n" +
                "                       " + Colors.BLUE_BOLD + pointsEXP + Colors.RESET + "/" + Colors.BLUE_BOLD + getExpNecesaria() + " XP                           " + Colors.RED_BOLD + "\n" +
                "                                                            \n" +
                "                       " + Colors.RESET + "Salud (" + pointsHP + "/" + getMaxHP() + ")                        " + Colors.RED_BOLD + "\n" +
                "                       " + Colors.RESET + "Daño:       " + getAttackMax() + "                       " + Colors.RED_BOLD + "\n" +
                "                       " + Colors.RESET + "Precisión:  " + getAcuraccyMax() + "                       " + Colors.RED_BOLD + "\n" +
                "                       " + Colors.RESET + "Evasión:    " + getEvasionMax() + "                       " + Colors.RED_BOLD + "\n" +
                "                   " + Colors.RED_BOLD + "+----------------------------------------+" + Colors.RESET;
    }



}
