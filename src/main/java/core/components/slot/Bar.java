package core.components.slot;

import core.components.AbstractSlot;

public class Bar extends AbstractSlot {

    private static AbstractSlot bar =new Bar(Bar.class.getName(),1);

    private Bar(String name, int odd) {
        super(name, odd);
    }


}
