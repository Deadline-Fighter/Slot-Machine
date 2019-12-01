package core.model.slot;

import core.model.AbstractSlot;

public class Seven extends AbstractSlot {

    private static AbstractSlot sevenInstance = new Seven(Seven.class.getSimpleName(),100,"file:./src/imgs/7.png");

    private Seven(String name, int odd, String image) {
        super(name, odd, image);
    }

    public static AbstractSlot getSevenInstance() {
        return sevenInstance;
    }


}
