package shop;


import java.util.List;

public class Shop {

    private Inventory inventory;

    public Shop(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<CD> searchByTitle(String title) {
        return inventory.checkByTitle(title);
    }

    public CD searchByArtist(String artist) {
        return new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins");
    }
}
