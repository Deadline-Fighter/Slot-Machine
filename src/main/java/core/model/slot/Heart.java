package core.model.slot;

import core.model.AbstractSlot;

public class Heart extends AbstractSlot {

    private static AbstractSlot heartInstance = new Heart(Heart.class.getSimpleName(),10,"file:./src/imgs/heart.png");

    private Heart(String name, int odd, String image) {
        super(name, odd, image);
    }

    public static AbstractSlot getHeartInstance() {
        return heartInstance;
    }
}
