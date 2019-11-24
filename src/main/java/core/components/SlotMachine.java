package core.components;

import javafx.scene.image.Image;
import core.components.slot.*;
import core.service.PatternChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SlotMachine implements Spinnable{

    private static final int ROWS = 3;

    private static final int MAX_STEPS_TO_FORWARD = 7;

    private ArrayList<AbstractSlot> leftSlots = new ArrayList<AbstractSlot>(
            Arrays.asList(
                    Bar.getBarInstance(),
                    Cherry.getCherryInstance(),
                    Diamond.getDiamondInstance(),
                    Heart.getHeartInstance(),
                    Seven.getSevenInstance(),
                    Shamrock.getShamrockInstance(),
                    Watermelon.getWatermelonInstance()
            )
    );

    private ArrayList<AbstractSlot> centerSlots = new ArrayList<AbstractSlot>(
            Arrays.asList(
                    Shamrock.getShamrockInstance(),
                    Cherry.getCherryInstance(),
                    Bar.getBarInstance(),
                    Diamond.getDiamondInstance(),
                    Watermelon.getWatermelonInstance(),
                    Seven.getSevenInstance(),
                    Heart.getHeartInstance()
            )
    );

    private ArrayList<AbstractSlot> rightSlots = new ArrayList<AbstractSlot>(
            Arrays.asList(
                    Watermelon.getWatermelonInstance(),
                    Seven.getSevenInstance(),
                    Cherry.getCherryInstance(),
                    Diamond.getDiamondInstance(),
                    Heart.getHeartInstance(),
                    Bar.getBarInstance(),
                    Shamrock.getShamrockInstance()
            )
    );

    public ArrayList<AbstractSlot> getLeftColumn() {
        return leftColumn;
    }

    public ArrayList<AbstractSlot> getCenterColumn() {
        return centerColumn;
    }

    public ArrayList<AbstractSlot> getRightColumn() {
        return rightColumn;
    }

    private ArrayList<AbstractSlot> leftColumn;

    private ArrayList<AbstractSlot> centerColumn;

    private ArrayList<AbstractSlot> rightColumn;

    private static SlotMachine slotMachineInstance = new SlotMachine();

    private SlotMachine() {
        leftColumn = new ArrayList<AbstractSlot>();
        centerColumn = new ArrayList<AbstractSlot>();
        rightColumn = new ArrayList<AbstractSlot>();
        randomizeColumns();
    }

    public static SlotMachine getInstance() {
        return slotMachineInstance;
    }

    public int spin(){

        //spin three col and return max odds
        randomizeColumns();
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
        leftColumn = spinColumn(leftSlots,leftColumn,getStepsToForward());
        centerColumn = spinColumn(centerSlots,centerColumn,getStepsToForward());
        rightColumn = spinColumn(rightSlots,rightColumn,getStepsToForward());
    }

    public int calMaxOdds(int maxOdds, int odds) {
        if(odds > maxOdds)
            maxOdds = odds;
        return maxOdds;
    }

    private ArrayList<AbstractSlot> spinColumn(ArrayList<AbstractSlot>slots, ArrayList<AbstractSlot> col, int stepsForward) {

        ArrayList<AbstractSlot> newColumn = new ArrayList<AbstractSlot>();
        int startIndex;
        if(col.size() == 0)
            startIndex = 0;
        else
            startIndex =  slots.indexOf(col.get(0));
        for(int i = 0; i < ROWS;i++){
            newColumn.add(slots.get((startIndex+stepsForward+i)%slots.size()));
        }
        return newColumn;
    }

    private int getStepsToForward(){
        Random random = new Random();
        int stepsToForward = random.nextInt(MAX_STEPS_TO_FORWARD);
        return stepsToForward;
    }

    public void printSlots(){
        for(int i = 0; i< ROWS;i++){
            System.out.printf("%-15s|%-15s|%-15s\n",leftColumn.get(i).getName(),centerColumn.get(i).getName(),rightColumn.get(i).getName());
        }
    }

    public ArrayList<Image> getImages(){
        ArrayList<Image> images = new ArrayList<>();
        for(int i=0;i<ROWS;i++){
            images.add(leftColumn.get(i).getImage());
            images.add(centerColumn.get(i).getImage());
            images.add(rightColumn.get(i).getImage());
        }

        return images;
    }

}
