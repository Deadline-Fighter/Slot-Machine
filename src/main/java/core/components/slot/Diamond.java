package core.components.slot;

import core.components.AbstractSlot;

public class Diamond extends AbstractSlot {

    private static AbstractSlot diamondInstance = new Diamond(Diamond.class.getSimpleName(),50,"file:./src/imgs/diamond.png");

    private Diamond(String name, int odd, String image) {
        super(name, odd, image);
    }

    public static AbstractSlot getDiamondInstance() {
        return diamondInstance;
    }

}
