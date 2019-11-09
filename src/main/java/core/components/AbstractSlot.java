package core.components;

public abstract class AbstractSlot {
    private String name;
    private int odd;

    public AbstractSlot(String name, int odd) {
        this.name = name;
        this.odd = odd;
    }

    public AbstractSlot getInstance() {
        return this;
    }

    public int getOdd() {
        return odd;
    }

    public String getName() {
        return name;
    }

}
