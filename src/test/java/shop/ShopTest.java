package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class ShopTest {

    private Shop shop;
    private PaymentHandler mockPaymentHandler;
    private Inventory mockInventory;
    private ChartService mockChartService;


    @BeforeEach
    void init() {
        mockPaymentHandler = mock(PaymentHandler.class);
        mockChartService = mock(ChartService.class);
        mockInventory = mock(Inventory.class);
        shop = new Shop(mockInventory, mockPaymentHandler);
    }


    @Test
    void customerCanSearchACDByTitle() {
        given(mockInventory.checkByTitle("Melon Collie and The Infinite Sadness")).
                willReturn(new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins", 10.00, mockChartService));

        assertThat(shop.searchByTitle("Melon Collie and The Infinite Sadness"))
                .isEqualTo(new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins", 10.00, mockChartService));
    }

    @Disabled
    @Test
    void customerCanSearchACdByArtist() {

        assertThat(shop.searchByArtist("The Smashing Pumpkins")).isEqualTo(new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins", 10.00, mockChartService));
    }

    @Test
    void customerCanBuyACdThatIsInStock() {
        CD cd = new CD("Back in Black", "ACDC", 10.00, mockChartService);
        given(mockInventory.isTitleAvailable("Back in Black")).willReturn(true);

        shop.buy(cd);

        then(mockInventory).should().isTitleAvailable("Back in Black");
        then(mockPaymentHandler).should().handle(10.0);
    }

    @Test
    void customerCannotBuyCdIfNotInStock(){

        given(mockInventory.isTitleAvailable("Yellow Submarine")).willReturn(false);

        assertThatThrownBy(()-> shop.buy(new CD("Yellow Submarine", "The Beatles", 1000.00, mockChartService)))
                .hasMessage("Yellow Submarine not found")
                .isInstanceOf(CDNotFoundException.class);
    }

    @Test
    void receiptIndicatesTotalAfterPurchase(){
        Receipt mockReceipt = mock(Receipt.class);
        CD cd = new CD("Back in Black", "ACDC", 10.00, mockChartService);
        given(mockInventory.isTitleAvailable("Back in Black")).willReturn(true);
        given(mockPaymentHandler.handle(10.00)).willReturn(mockReceipt);

        final Receipt receipt = shop.buy(cd);

        assertThat(receipt).isEqualTo(mockReceipt);
    }

}
