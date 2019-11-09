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




}
