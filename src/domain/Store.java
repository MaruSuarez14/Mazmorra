package domain;

public class Store {
    private int storeID;
    private Personage personageID;
    private Item itemID;
    private int price;

    public Store(int storeID, Personage personageID, Item itemID, int price) {
        this.storeID = storeID;
        this.personageID = personageID;
        this.itemID = itemID;
        this.price = price;
    }

    public int getStoreID() {
        return storeID;
    }

    public Personage getPersonageID() {
        return personageID;
    }

    public Item getItemID() {
        return itemID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeID=" + storeID +
                ", personageID=" + personageID.getName() +
                ", itemID=" + itemID +
                ", price=" + price +
                '}';
    }
}
