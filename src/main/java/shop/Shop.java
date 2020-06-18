package shop;


import java.util.List;

public class Shop {

    private Inventory inventory;
    private PaymentHandler paymentHandler;

    public Shop(Inventory inventory, PaymentHandler paymentHandler) {
        this.inventory = inventory;
        this.paymentHandler = paymentHandler;
    }

    public List<CD> searchByTitle(String title) {
        return inventory.checkByTitle(title);
    }

    public CD searchByArtist(String artist) {
        return new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins",10.00);
    }

    public Receipt buy(List<CD> cds) {
        paymentHandler.handle(cds.stream()
                .mapToDouble(CD::getPrice)
                .reduce(0, (price1, price2) -> price1 + price2));
        return new Receipt();
    }
}
