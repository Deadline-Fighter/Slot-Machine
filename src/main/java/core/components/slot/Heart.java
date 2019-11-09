package core.components.slot;

import core.components.AbstractSlot;

public class Heart extends AbstractSlot {
    private AbstractSlot heartInstance = new Heart(Heart.class.getName(),10);
    private Heart(String name, int odd) {
        super(name, odd);
    }
}
