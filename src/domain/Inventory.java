package domain;

public class Inventory {
    private int inventoryID;
    private Personage personageID;
    private Item itemID;

    public Inventory(int inventoryID, Personage personageID, Item itemID) {
        this.inventoryID = inventoryID;
        this.personageID = personageID;
        this.itemID = itemID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public Personage getPersonajeID() {
        return personageID;
    }

    public Item getItemID() {return itemID;}

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", personageID=" + personageID +
                '}';
    }
}
