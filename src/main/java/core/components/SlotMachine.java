package core.components;

import core.components.slot.*;
import core.service.PatternChecker;

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

    public int spin(){

        //spin three col and reutrn max odds

        int maxOdds = 0;

        for(int i = 0; i<ROWS; i++){
            if(PatternChecker.isHorizontallySame(leftColumn,centerColumn,rightColumn,i)){
                maxOdds = calMaxOdds(maxOdds, leftColumn.get(i).getOdd());
            }
        }

        if (PatternChecker.isDiagonallySameTopLeftBottomRight(leftColumn,centerColumn,rightColumn))
            maxOdds = calMaxOdds(maxOdds,leftColumn.get(0).getOdd());
        if(PatternChecker.isDiagonallySameTopRightBottomLeft(leftColumn,centerColumn,rightColumn))
            maxOdds = calMaxOdds(maxOdds,rightColumn.get(0).getOdd());

        return maxOdds;
    }

    public void randomizeColumns() {
        spinColumn(leftColumn,leftSlots);
        spinColumn(centerColumn,centerSlots);
        spinColumn(rightColumn,rightSlots);
    }

    private int calMaxOdds(int maxOdds, int odds) {
        if(odds > maxOdds)
            maxOdds = odds;
        return maxOdds;
    }

    private void spinColumn(ArrayList<AbstractSlot> col, AbstractSlot[] slot) {

        col.clear();
        Random random = new Random();
        int startIndex = random.nextInt(slot.length);

        for (int i = 0;i<ROWS;i++){
            col.add(slot[(startIndex+i)%(slot.length)]);
        }
    }


}
