package core.components;

import core.components.slot.*;

import java.util.ArrayList;
import java.util.Random;

public class SlotMachine {
    private static final int ROWS = 3;
    private AbstractSlot[] leftSlots = {
            Bar.getBarInstance(),
            Cherry.getCherryInstance(),
            Diamond.getDiamondInstance(),
            Heart.getHeartInstance(),
            Seven.getSevenInstance(),
            Shamrock.getShamrockInstance(),
            Watermelon.getWatermelonInstance(),
    };

    private AbstractSlot[] centerSlots = {
            Shamrock.getShamrockInstance(),
            Cherry.getCherryInstance(),
            Bar.getBarInstance(),
            Diamond.getDiamondInstance(),
            Watermelon.getWatermelonInstance(),
            Seven.getSevenInstance(),
            Heart.getHeartInstance(),

    };

    private AbstractSlot[] rightSlots = {

            Watermelon.getWatermelonInstance(),
            Seven.getSevenInstance(),
            Cherry.getCherryInstance(),
            Diamond.getDiamondInstance(),
            Heart.getHeartInstance(),
            Bar.getBarInstance(),
            Shamrock.getShamrockInstance(),
    };

    private ArrayList<AbstractSlot> leftColumns;
    private ArrayList<AbstractSlot> centerColumns;
    private ArrayList<AbstractSlot> rightColumns;

    private static SlotMachine slotMachineInstance = new SlotMachine();

    private SlotMachine() {
        leftColumns = new ArrayList<AbstractSlot>();
        centerColumns = new ArrayList<AbstractSlot>();
        rightColumns = new ArrayList<AbstractSlot>();
    }

    public static SlotMachine getInstance() {
        return slotMachineInstance;
    }

    public void spinColumn(ArrayList<AbstractSlot> col,AbstractSlot[] slot) {

        col.clear();
        Random random = new Random();
        int startIndex = random.nextInt(slot.length);

        for (int i = 0;i<ROWS;i++){
            col.add(slot[(startIndex+i)%(slot.length)]);
        }
    }

    public boolean isSamePattern() {
        return false;
    }

    public boolean isSameColour() {
        //TODO: add colour enum or interface for each slotItem
        return false;
    }


}
