package shop;

import java.util.Objects;

public class CD {
    private String title;
    private String artist;
    private Double price;
    private ChartService chartService;

    public CD(String title, String artist, Double price, ChartService chartService) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.chartService = chartService;
    }

    public String getTitle() {
        return title;
    }

    // would it be good idea to inject chart service here without keeping it in the state
    public Double getPrice() {
        if (chartService.checkChart(title)) {
            return --price;
        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return Objects.equals(title, cd.title) &&
                Objects.equals(artist, cd.artist) &&
                Objects.equals(price, cd.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, price);
    }
}
