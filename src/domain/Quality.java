package domain;

public class Quality {
    private int qualityID;
    private String name;
    private int bonusHP;
    private int bonusAttack;
    private int bonusPrecision;
    private int bonusEvasion;

    public Quality(int qualityID, String name, int bonusHP, int bonusAttack, int bonusPrecision, int bonusEvasion) {
        this.qualityID = qualityID;
        this.name = name;
        this.bonusHP = bonusHP;
        this.bonusAttack = bonusAttack;
        this.bonusPrecision = bonusPrecision;
        this.bonusEvasion = bonusEvasion;
    }

    public int getQualityID() {
        return qualityID;
    }

    public String getName() {
        return name;
    }

    public int getBonusHP() {
        return bonusHP;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public int getBonusPrecision() {
        return bonusPrecision;
    }

    public int getBonusEvasion() {
        return bonusEvasion;
    }

    @Override
    public String toString() {
        return "Quality{" +
                "qualityID=" + qualityID +
                ", name='" + name + '\'' +
                ", bonusHP=" + bonusHP +
                ", bonusAttack=" + bonusAttack +
                ", bonusPrecision=" + bonusPrecision +
                ", bonusEvasion=" + bonusEvasion +
                '}';
    }
}
