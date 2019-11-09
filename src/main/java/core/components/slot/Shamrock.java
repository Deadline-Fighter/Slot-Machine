package core.components.slot;

import core.components.AbstractSlot;

public class Shamrock extends AbstractSlot {
    private AbstractSlot shamrockInstance = new Shamrock(Shamrock.class.getName(),25);
    private Shamrock(String name, int odd) {
        super(name, odd);
    }
}
