package core.model.slot;

import core.model.AbstractSlot;

public class Watermelon extends AbstractSlot {

    private static AbstractSlot watermelonInstance = new Watermelon(Watermelon.class.getSimpleName(),5,"file:./src/imgs/watermelon.png");

    private Watermelon(String name, int odd, String image) {
        super(name, odd, image);
    }

    public static AbstractSlot getWatermelonInstance() {
        return watermelonInstance;
    }
}
