package core.service;

import core.components.AbstractSlot;
import core.components.slot.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatternCheckerTest {

    private PatternChecker checker;


    /**
     * Test {@link PatternChecker#isHorizontallySame(List, List, List, int)}
     * Same in second row
     */
    @Test
    public void testIsHorizontallySameSecondRow() {

        final List<AbstractSlot> left = new ArrayList<>();
        left.add(Bar.getBarInstance());
        left.add(CherryTest.getCherryInstance());
        left.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(Seven.getSevenInstance());
        center.add(CherryTest.getCherryInstance());
        center.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> right = new ArrayList<>();
        right.add(Bar.getBarInstance());
        right.add(CherryTest.getCherryInstance());
        right.add(Watermelon.getWatermelonInstance());

        assertTrue(PatternChecker.isHorizontallySame(left, center, right, 1));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 0));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 2));
    }


    /**
     * Test {@link PatternChecker#isHorizontallySame(List, List, List, int)}
     * Same in first row
     */
    @Test
    public void testIsHorizontallySameFirstRow() {
        final List<AbstractSlot> left = new ArrayList<>();
        left.add(CherryTest.getCherryInstance());
        left.add(Bar.getBarInstance());
        left.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(CherryTest.getCherryInstance());
        center.add(Seven.getSevenInstance());
        center.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> right = new ArrayList<>();
        right.add(CherryTest.getCherryInstance());
        right.add(Bar.getBarInstance());
        right.add(Watermelon.getWatermelonInstance());

        assertTrue(PatternChecker.isHorizontallySame(left, center, right, 0));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 1));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 2));
    }


    /**
     * Test {@link PatternChecker#isHorizontallySame(List, List, List, int)}
     * Same in third row
     */
    @Test
    public void testIsHorizontallySameThirdRow() {
        final List<AbstractSlot> left = new ArrayList<>();
        left.add(Bar.getBarInstance());
        left.add(Diamond.getDiamondInstance());
        left.add(CherryTest.getCherryInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(Seven.getSevenInstance());
        center.add(Diamond.getDiamondInstance());
        center.add(CherryTest.getCherryInstance());

        final List<AbstractSlot> right = new ArrayList<>();
        right.add(Bar.getBarInstance());
        right.add(Watermelon.getWatermelonInstance());
        right.add(CherryTest.getCherryInstance());

        assertTrue(PatternChecker.isHorizontallySame(left, center, right, 2));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 0));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 1));
    }


    /**
     * Test {@link PatternChecker#isHorizontallySame(List, List, List, int)}
     * No match
     */
    @Test
    public void testIsHorizontallySameNoMatch() {
        final List<AbstractSlot> left = new ArrayList<>();
        left.add(Bar.getBarInstance());
        left.add(Diamond.getDiamondInstance());
        left.add(CherryTest.getCherryInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(Diamond.getDiamondInstance());
        center.add(CherryTest.getCherryInstance());
        center.add(Seven.getSevenInstance());

        final List<AbstractSlot> right = new ArrayList<>();
        right.add(Bar.getBarInstance());
        right.add(Watermelon.getWatermelonInstance());
        right.add(CherryTest.getCherryInstance());

        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 0));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 1));
        assertFalse(PatternChecker.isHorizontallySame(left, center, right, 2));
    }


    @Test
    public void testIsDiagonallySameTopLeftBottomRight() {
        final List<AbstractSlot> left = new ArrayList<>();
        left.add(CherryTest.getCherryInstance());
        left.add(Bar.getBarInstance());
        left.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(Diamond.getDiamondInstance());
        center.add(CherryTest.getCherryInstance());
        center.add(Seven.getSevenInstance());

        final List<AbstractSlot> right = new ArrayList<>();
        right.add(Bar.getBarInstance());
        right.add(Watermelon.getWatermelonInstance());
        right.add(CherryTest.getCherryInstance());

        assertTrue(PatternChecker.isDiagonallySameTopLeftBottomRight(left, center, right));
    }


    @Test
    public void testIsDiagonallySameTopLeftBottomRightNoMatch() {
        final List<AbstractSlot> left = new ArrayList<>();
        left.add(CherryTest.getCherryInstance());
        left.add(Bar.getBarInstance());
        left.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(Diamond.getDiamondInstance());
        center.add(CherryTest.getCherryInstance());
        center.add(Seven.getSevenInstance());

        final List<AbstractSlot> right = new ArrayList<>();
        right.add(Bar.getBarInstance());
        right.add(CherryTest.getCherryInstance());
        right.add(Watermelon.getWatermelonInstance());

        assertFalse(PatternChecker.isDiagonallySameTopLeftBottomRight(left, center, right));
    }


    @Test
    public void testIsDiagonallySameTopRightBottomLeft() {
        final List<AbstractSlot> right = new ArrayList<>();
        right.add(CherryTest.getCherryInstance());
        right.add(Bar.getBarInstance());
        right.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(Diamond.getDiamondInstance());
        center.add(CherryTest.getCherryInstance());
        center.add(Seven.getSevenInstance());

        final List<AbstractSlot> left = new ArrayList<>();
        left.add(Bar.getBarInstance());
        left.add(Watermelon.getWatermelonInstance());
        left.add(CherryTest.getCherryInstance());

        assertTrue(PatternChecker.isDiagonallySameTopRightBottomLeft(left, center, right));
    }


    @Test
    public void testIsDiagonallySameTopRightBottomLeftNoMatch() {
        final List<AbstractSlot> right = new ArrayList<>();
        right.add(CherryTest.getCherryInstance());
        right.add(Bar.getBarInstance());
        right.add(Diamond.getDiamondInstance());

        final List<AbstractSlot> center = new ArrayList<>();
        center.add(Diamond.getDiamondInstance());
        center.add(Seven.getSevenInstance());
        center.add(CherryTest.getCherryInstance());

        final List<AbstractSlot> left = new ArrayList<>();
        left.add(Bar.getBarInstance());
        left.add(Watermelon.getWatermelonInstance());
        left.add(CherryTest.getCherryInstance());

        assertFalse(PatternChecker.isDiagonallySameTopRightBottomLeft(left, center, right));
    }
}
