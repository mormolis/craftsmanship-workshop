package shop;

import java.util.Objects;

public class CD {
    private String title;

    public CD(String title, String artist) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CD)) return false;
        CD cd = (CD) o;
        return Objects.equals(title, cd.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
