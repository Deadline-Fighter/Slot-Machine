package core.service;

import core.model.AbstractSlot;

import java.util.List;

public class PatternChecker {

    public static boolean isHorizontallySame(List<AbstractSlot> leftColumn, List<AbstractSlot> centerColumn,
                                             List<AbstractSlot> rightColumn, int row) {
        return leftColumn.get(row).getName().equals(centerColumn.get(row).getName())
                && centerColumn.get(row).getName().equals(rightColumn.get(row).getName());
    }

    public static boolean isDiagonallySameTopLeftBottomRight(List<AbstractSlot> leftColumn, List<AbstractSlot> centerColumn,
                                                             List<AbstractSlot> rightColumn) {
        return leftColumn.get(0).getName().equals(centerColumn.get(1).getName())
                && centerColumn.get(1).getName().equals(rightColumn.get(2).getName());
    }

    public static boolean isDiagonallySameTopRightBottomLeft(List<AbstractSlot> leftColumn, List<AbstractSlot> centerColumn,
                                                             List<AbstractSlot> rightColumn) {
        return leftColumn.get(2).getName().equals(centerColumn.get(1).getName())
                && centerColumn.get(1).getName().equals(rightColumn.get(0).getName());
    }

//    public static boolean isSameColour() {
//        //TODO: add colour enum or interface for each slotItem
//        return false;
//    }
}
