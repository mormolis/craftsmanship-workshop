package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class ShopTest {

    private Shop shop;
    private PaymentHandler mockPaymentHandler;
    private Inventory mockInventory;


    @BeforeEach
    void init(){
        mockPaymentHandler = mock(PaymentHandler.class);
        mockInventory = mock(Inventory.class);
        shop = new Shop(mockInventory, mockPaymentHandler);
    }


    @Test
    void customerCanSearchACDByTitle(){
        given(mockInventory.checkByTitle("Melon Collie and The Infinite Sadness")).willReturn(List.of((new CD("Melon Collie and The Infinite Sadness","The Smashing Pumpkins", 10.00))));

        assertThat(shop.searchByTitle("Melon Collie and The Infinite Sadness")).isEqualTo(List.of(new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins",10.00)));
    }

    @Test
    void customerCanSearchACdByArtist(){

        assertThat(shop.searchByArtist("The Smashing Pumpkins")).isEqualTo(new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins", 10.00));
    }

    @Test
    void customerCanBuyACdThatIsInStock(){
        shop.buy(List.of(new CD("Back in Black", "ACDC", 10.00)));

        then(mockPaymentHandler).should().handle(10.0);
    }
}
