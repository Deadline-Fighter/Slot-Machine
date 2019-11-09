package core.components;

import java.util.ArrayList;

public class SlotMachine {
//    private ArrayList<AbstractSlot> slots;

    private AbstractSlot[] slots;

    private static SlotMachine slotMachineInstance = new SlotMachine();

    private SlotMachine() {
        this.slots = new AbstractSlot[3];
    }

    public static SlotMachine getInstance() {
        return slotMachineInstance;
    }

    public int spin(int tokens){

        //TODO: random slots, then set left, center, right slots
        return 0;
    }

    public boolean isSamePattern() {
        return this.slots[0].getName().equals(this.slots[1].getName())
                && this.slots[0].getName().equals(this.slots[2].getName());
    }

    public boolean isSameColour() {
        //TODO: add colour enum or interface for each slotItem
        return false;
    }


}
