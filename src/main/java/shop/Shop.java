package shop;


import java.util.List;

public class Shop {

    private Inventory inventory;
    private PaymentHandler paymentHandler;

    public Shop(Inventory inventory, PaymentHandler paymentHandler) {
        this.inventory = inventory;
        this.paymentHandler = paymentHandler;
    }

    public CD searchByTitle(String title) {
        return inventory.checkByTitle(title);
    }

    public CD searchByArtist(String artist) {
        return new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins", 10.00);
    }

    public Receipt buy(CD cd) {
        inventory.checkByTitle(cd.getTitle());
        double price = cd.getPrice();
        paymentHandler.handle(price);
        return new Receipt();
    }
}
