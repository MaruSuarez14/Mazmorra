package domain;

import UI.Colors;

public class Item {
    private int itemID;
    private String name;
    private Quality quality;
    private int hp;
    private int attack;
    private int accuracy;
    private int evasion;

//    private Personaje characterID;


    public Item(int objectID, String name, Quality quality, int hp, int attack, int accuracy, int evasion) {
        this.itemID = objectID;
        this.name = name;
        this.quality = quality;
        this.hp = hp;
        this.attack = attack;
        this.accuracy = accuracy;
        this.evasion = evasion;
    }

    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public Quality getQuality() {
        return quality;
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
        String resultado = rellenarString();
        return resultado;
    }

    private String rellenarString() {
        String resultado = "";
        for (int i = 0; i < 7; i++) {
            if (i == 0 || i == 6) resultado += "                   " + Colors.BLUE_BOLD + "+----------------------------------------+\n" + Colors.RESET;
            if (i == 1) resultado += "                       " + Colors.WHITE_BOLD_BRIGHT + name + "             \n";
            if (i == 2 && hp > 0) resultado += "                           " + Colors.GREEN_BRIGHT + "+" + hp + " vida máxima        " + Colors.BLUE_BOLD + "\n";
            if (i == 3 && attack > 0) resultado += "                           " + Colors.RED_BRIGHT + "+" + attack + " daño              " + Colors.BLUE_BOLD + "\n";
            if (i == 4 && accuracy > 0) resultado += "                           " + Colors.YELLOW_BRIGHT + "+" + accuracy + " precisión         " + Colors.BLUE_BOLD + "\n";
            if (i == 5 && evasion > 0) resultado += "                           " + Colors.RESET_DEFAULT + "+" + evasion + " evasión          " + Colors.BLUE_BOLD + "\n";
        }
        return resultado;
    }
}
