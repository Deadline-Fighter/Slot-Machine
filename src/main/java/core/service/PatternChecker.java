package core.service;

import core.components.AbstractSlot;

import java.util.ArrayList;

public class PatternChecker {

    public static boolean isHorizontallySame(ArrayList<AbstractSlot> leftColumn, ArrayList<AbstractSlot> centerColumn,
                                             ArrayList<AbstractSlot> rightColumn, int row) {
        return leftColumn.get(row).equals(centerColumn.get(row).getName())
                && centerColumn.get(row).getName().equals(rightColumn.get(row).getName());
    }

    public static boolean isDiagonallySameTopLeftBottomRight(ArrayList<AbstractSlot> leftColumn, ArrayList<AbstractSlot> centerColumn,
                                                             ArrayList<AbstractSlot> rightColumn) {
        return leftColumn.get(0).getName().equals(centerColumn.get(1).getName())
                && centerColumn.get(1).getName().equals(rightColumn.get(2).getName());
    }

    public static boolean isDiagonallySameTopRightBottomLeft(ArrayList<AbstractSlot> leftColumn, ArrayList<AbstractSlot> centerColumn,
                                                             ArrayList<AbstractSlot> rightColumn) {
        return leftColumn.get(2).getName().equals(centerColumn.get(1).getName())
                && centerColumn.get(1).getName().equals(rightColumn.get(0).getName());
    }

    public static boolean isSameColour() {
        //TODO: add colour enum or interface for each slotItem
        return false;
    }
}
