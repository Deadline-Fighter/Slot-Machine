package core.components.slot;

import core.components.AbstractSlot;

public class Seven extends AbstractSlot {

    private static AbstractSlot sevenInstance = new Seven(Seven.class.getName(),100);

    private Seven(String name, int odd) {
        super(name, odd);
    }

    public static AbstractSlot getSevenInstance() {
        return sevenInstance;
    }


}
