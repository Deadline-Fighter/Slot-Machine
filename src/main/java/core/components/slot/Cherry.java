package core.components.slot;

import core.components.AbstractSlot;

public class Cherry extends AbstractSlot {

    private static AbstractSlot cherryInstance = new Cherry(Cherry.class.getSimpleName(),2);

    private Cherry(String name, int odd) {
        super(name, odd);
    }

    public static AbstractSlot getCherryInstance() {
        return cherryInstance;
    }
}
