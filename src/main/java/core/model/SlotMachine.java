package core.model;

import javafx.scene.image.Image;
import core.model.slot.*;
import core.service.PatternChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SlotMachine implements Spinnable{

    private static final int ROWS = 3;

    private static final int MAX_STEPS_TO_FORWARD = 7;

    private List<AbstractSlot> leftSlots = new ArrayList<AbstractSlot>(
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

    private List<AbstractSlot> centerSlots = new ArrayList<AbstractSlot>(
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

    private List<AbstractSlot> rightSlots = new ArrayList<AbstractSlot>(
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

    public List<AbstractSlot> getLeftColumn() {
        return leftColumn;
    }

    public List<AbstractSlot> getCenterColumn() {
        return centerColumn;
    }

    public List<AbstractSlot> getRightColumn() {
        return rightColumn;
    }

    private List<AbstractSlot> leftColumn;

    private List<AbstractSlot> centerColumn;

    private List<AbstractSlot> rightColumn;

    public void setLeftColumn(List<AbstractSlot> leftColumn) {
        this.leftColumn = leftColumn;
    }

    public void setCenterColumn(List<AbstractSlot> centerColumn) {
        this.centerColumn = centerColumn;
    }

    public void setRightColumn(List<AbstractSlot> rightColumn) {
        this.rightColumn = rightColumn;
    }

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

    List<AbstractSlot> spinColumn(List<AbstractSlot>slots, List<AbstractSlot> col, int stepsForward) {

        List<AbstractSlot> newColumn = new ArrayList<AbstractSlot>();
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

    public ArrayList<Image> getImages(){
        ArrayList<Image> images = new ArrayList<>();
        for(int i=0;i<ROWS;i++){
            images.add(leftColumn.get(i).getImage());
            images.add(centerColumn.get(i).getImage());
            images.add(rightColumn.get(i).getImage());
        }

        return images;
    }

    public List<AbstractSlot> getLeftSlots() {
        return leftSlots;
    }

    public List<AbstractSlot> getCenterSlots() {
        return centerSlots;
    }

    public List<AbstractSlot> getRightSlots() {
        return rightSlots;
    }
}
