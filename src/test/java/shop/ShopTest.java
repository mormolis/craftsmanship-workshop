package shop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ShopTest {


    @Test
    void customerCanSearchACDByTitle(){
        Inventory mockInventory = mock(Inventory.class);
        Shop shop = new Shop(mockInventory);
        given(mockInventory.checkByTitle("Melon Collie and The Infinite Sadness")).willReturn(List.of((new CD("Melon Collie and The Infinite Sadness","The Smashing Pumpkins"))));

        assertThat(shop.searchByTitle("Melon Collie and The Infinite Sadness")).isEqualTo(List.of(new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins")));
    }

    @Test
    void customerCanSearchACdByArtist(){
        Inventory mockInventory = mock(Inventory.class);

        Shop shop = new Shop(mockInventory);

        assertThat(shop.searchByArtist("The Smashing Pumpkins")).isEqualTo(new CD("Melon Collie and The Infinite Sadness", "The Smashing Pumpkins"));
    }
}
