package core.components.slot;

import core.components.AbstractSlot;

public class Watermelon extends AbstractSlot {

    private static AbstractSlot watermelonInstance = new Watermelon(Watermelon.class.getSimpleName(),5);

    private Watermelon(String name, int odd) {
        super(name, odd);
    }

    public static AbstractSlot getWatermelonInstance() {
        return watermelonInstance;
    }
}
