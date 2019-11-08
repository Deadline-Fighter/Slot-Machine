package components;

public class Slot {
    private String name;
    private int odd;

    public Slot(String name, int odd) {
        this.name = name;
        this.odd = odd;
    }

    public int getOdd() {
        return odd;
    }

    public String getName() {
        return name;
    }

}
