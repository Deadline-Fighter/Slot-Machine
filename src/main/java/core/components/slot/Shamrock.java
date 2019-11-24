package core.components.slot;

import core.components.AbstractSlot;

public class Shamrock extends AbstractSlot {

    private static AbstractSlot shamrockInstance = new Shamrock(Shamrock.class.getSimpleName(),25,"file:./src/imgs/shamrock.png");

    private Shamrock(String name, int odd, String image) {
        super(name, odd, image);
    }

    public static AbstractSlot getShamrockInstance() {
        return shamrockInstance;
    }
}
