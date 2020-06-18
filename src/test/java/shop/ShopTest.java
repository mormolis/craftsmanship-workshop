package shop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {


    @Test
    void customerCanSearchACDByTitle(){

        Shop shop = new Shop();

        assertThat(shop.searchByTitle("Melon Collie and The Infinite Sadness")).isEqualTo(new CD("Melon Collie and The Infinite Sadness"));
    }

}
