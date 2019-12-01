package core.model.slot;

import core.model.AbstractSlot;

public class Cherry extends AbstractSlot {

    private static AbstractSlot cherryInstance = new Cherry(Cherry.class.getSimpleName(),2,"file:./src/imgs/cherry.png");

    private Cherry(String name, int odd, String image) {
        super(name, odd, image);
    }

    public static AbstractSlot getCherryInstance() {
        return cherryInstance;
    }
}
