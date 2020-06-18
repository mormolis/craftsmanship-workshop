package shop;


import java.util.List;

public class Shop {

    private Inventory inventory;
    //move this to the buy method
    private PaymentHandler paymentHandler;

    public Shop(Inventory inventory, PaymentHandler paymentHandler) {
        this.inventory = inventory;
        this.paymentHandler = paymentHandler;
    }

    public CD searchByTitle(String title) {
        return inventory.checkByTitle(title);
    }

    public CD searchByArtist(String artist) {
        throw new UnsupportedOperationException();
    }

    public Receipt buy(CD cd) {

        if(!inventory.isTitleAvailable(cd.getTitle())){
            throw new CDNotFoundException(cd.getTitle() + " not found");
        }

        double price = cd.getPrice();

        return paymentHandler.handle(price);
    }
}
