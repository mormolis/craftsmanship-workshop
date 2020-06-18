package shop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CDTest {

    @Test
    void cdIsReducingItsPriceWhenInCharts(){
        ChartService mockChartService = mock(ChartService.class);
        given(mockChartService.checkChart("Vs")).willReturn(true);
        CD cdInCharts = new CD("Vs", "Pearl Jam", 10.0, mockChartService);

        assertThat(cdInCharts.getPrice()).isEqualTo(9.0);
    }

    @Test
    void cdDoesNotDiscountWhenNotInCharts(){
        ChartService mockChartService = mock(ChartService.class);
        given(mockChartService.checkChart("Vs")).willReturn(false);
        CD cdInCharts = new CD("Vs", "Pearl Jam", 10.0, mockChartService);

        assertThat(cdInCharts.getPrice()).isEqualTo(10.0);
    }

}