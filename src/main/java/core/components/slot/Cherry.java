package core.components.slot;

import core.components.AbstractSlot;

public class Cherry extends AbstractSlot {

    private static AbstractSlot cherry = new Cherry(Cherry.class.getName(),5);

    private  Cherry(String name, int odd) {
        super(name, odd);
    }

}
