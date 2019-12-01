package core.model.slot;

import core.model.AbstractSlot;

public class Bar extends AbstractSlot {

    private static AbstractSlot barInstance =new Bar(Bar.class.getSimpleName(),1,"file:./src/imgs/bar.png");

    private Bar(String name, int odd, String image) {
        super(name, odd, image);
    }

    public static AbstractSlot getBarInstance() {
        return barInstance;
    }


}
