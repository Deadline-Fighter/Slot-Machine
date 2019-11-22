package core.components.slot;

import core.components.AbstractSlot;

public class Diamond extends AbstractSlot {

    private static AbstractSlot diamondInstance = new Diamond(Diamond.class.getSimpleName(),50);

    private Diamond(String name, int odd) {
        super(name, odd);
    }

    public static AbstractSlot getDiamondInstance() {
        return diamondInstance;
    }

}
