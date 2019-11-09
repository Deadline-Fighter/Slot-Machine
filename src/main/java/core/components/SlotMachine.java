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

    private ArrayList<AbstractSlot> leftColumn;

    private ArrayList<AbstractSlot> centerColumn;

    private ArrayList<AbstractSlot> rightColumn;

    private static SlotMachine slotMachineInstance = new SlotMachine();

    private SlotMachine() {
        leftColumn = new ArrayList<AbstractSlot>();
        centerColumn = new ArrayList<AbstractSlot>();
        rightColumn = new ArrayList<AbstractSlot>();
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

    public boolean isHorizontallySame(int row) {
        return this.leftColumn.get(row).equals(this.centerColumn.get(row).getName())
                && this.centerColumn.get(row).getName().equals(this.rightColumn.get(row).getName());
    }

    public boolean isDiagonallySameTopLeftBottomRight() {
        return this.leftColumn.get(0).getName().equals(this.centerColumn.get(1).getName())
                && this.centerColumn.get(1).getName().equals(this.rightColumn.get(2).getName());
    }

    public boolean isDiagonallySameTopRightBottomLeft() {
        return this.leftColumn.get(2).getName().equals(this.centerColumn.get(1).getName())
                && this.centerColumn.get(1).getName().equals(this.rightColumn.get(0).getName());
    }

    public boolean isSameColour() {
        //TODO: add colour enum or interface for each slotItem
        return false;
    }


}
