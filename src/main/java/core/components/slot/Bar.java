package core.components.slot;

import core.components.AbstractSlot;

public class Bar extends AbstractSlot {

    private static AbstractSlot barInstance =new Bar(Bar.class.getSimpleName(),1);

    private Bar(String name, int odd) {
        super(name, odd);
    }

    public static AbstractSlot getBarInstance() {
        return barInstance;
    }
}
