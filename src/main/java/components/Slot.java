package components;

public class Slot {
    public Slot(int odd) {
        this.odd = odd;
    }

    public int getOdd() {
        return odd;
    }

    private int odd;

    @Override
    public String toString() {
        return "AbstractSlot{" +
                "odd=" + odd +
                '}';
    }
}
