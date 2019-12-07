package core.model;

import core.model.slot.Bar;
import core.model.slot.Cherry;
import core.model.slot.Diamond;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SlotMachineIT {

    private SlotMachine slotMachine;

    private List<AbstractSlot> leftColumn;
    private List<AbstractSlot> centreColumn;
    private List<AbstractSlot> rightColumn;

    @BeforeEach
    public void before() {
        slotMachine = Mockito.spy(SlotMachine.getInstance());
        SlotMachine.setMaxStepsToForward(1);
    }

    @Test
    public void testGetInstance() {
        Assertions.assertNotNull(SlotMachine.getInstance());
    }

    @Test
    public void testGetters() {
        Assertions.assertNotNull(slotMachine.getLeftColumn());
        Assertions.assertNotNull(slotMachine.getCenterColumn());
        Assertions.assertNotNull(slotMachine.getRightColumn());
        Assertions.assertNotNull(slotMachine.getLeftSlots());
        Assertions.assertNotNull(slotMachine.getCenterSlots());
        Assertions.assertNotNull(slotMachine.getRightSlots());
    }

    @Test
    public void testSpinHorizontallySameFirstRowOdd() {

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        leftColumn = new ArrayList<>();
        centreColumn = new ArrayList<>();
        rightColumn = new ArrayList<>();

        leftColumn.add(diamond);
        centreColumn.add(diamond);
        rightColumn.add(diamond);

        leftColumn.add(cherry);
        centreColumn.add(cherry);
        rightColumn.add(cherry);

        leftColumn.add(bar);
        centreColumn.add(bar);
        rightColumn.add(bar);

        this.setColumns(leftColumn, centreColumn, rightColumn);
        this.setSlots(leftColumn, centreColumn, rightColumn);
        SlotMachine.setMaxStepsToForward(1);

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }


    @Test
    public void testSpinHorizontallySameSecondRowOdd() {

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        leftColumn = new ArrayList<>();
        centreColumn = new ArrayList<>();
        rightColumn = new ArrayList<>();

        leftColumn.add(cherry);
        centreColumn.add(cherry);
        rightColumn.add(cherry);

        leftColumn.add(diamond);
        centreColumn.add(diamond);
        rightColumn.add(diamond);

        leftColumn.add(bar);
        centreColumn.add(bar);
        rightColumn.add(bar);

        this.setColumns(leftColumn, centreColumn, rightColumn);
        this.setSlots(leftColumn, centreColumn, rightColumn);
        SlotMachine.setMaxStepsToForward(1);

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }


    @Test
    public void testSpinHorizontallySameThirdRowOdd() {

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        leftColumn = new ArrayList<>();
        centreColumn = new ArrayList<>();
        rightColumn = new ArrayList<>();

        leftColumn.add(cherry);
        centreColumn.add(cherry);
        rightColumn.add(cherry);

        leftColumn.add(bar);
        centreColumn.add(bar);
        rightColumn.add(bar);

        leftColumn.add(diamond);
        centreColumn.add(diamond);
        rightColumn.add(diamond);

        this.setColumns(leftColumn, centreColumn, rightColumn);
        this.setSlots(leftColumn, centreColumn, rightColumn);
        SlotMachine.setMaxStepsToForward(1);

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }

    @Test
    public void testSpinTopLeftToBottomRight() {

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        leftColumn = new ArrayList<>();
        centreColumn = new ArrayList<>();
        rightColumn = new ArrayList<>();

        leftColumn.add(diamond);
        centreColumn.add(cherry);
        rightColumn.add(cherry);

        leftColumn.add(bar);
        centreColumn.add(diamond);
        rightColumn.add(bar);

        leftColumn.add(cherry);
        centreColumn.add(bar);
        rightColumn.add(diamond);

        this.setColumns(leftColumn, centreColumn, rightColumn);
        this.setSlots(leftColumn, centreColumn, rightColumn);
        SlotMachine.setMaxStepsToForward(1);

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }

    @Test
    public void testSpinTopRightToBottomLeft() {

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        leftColumn = new ArrayList<>();
        centreColumn = new ArrayList<>();
        rightColumn = new ArrayList<>();

        leftColumn.add(bar);
        leftColumn.add(cherry);
        leftColumn.add(diamond);

        centreColumn.add(cherry);
        centreColumn.add(diamond);
        centreColumn.add(bar);

        rightColumn.add(diamond);
        rightColumn.add(bar);
        rightColumn.add(cherry);

        this.setColumns(leftColumn, centreColumn, rightColumn);
        this.setSlots(leftColumn, centreColumn, rightColumn);
        SlotMachine.setMaxStepsToForward(1);

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }

    @Test
    public void testSpinColumnWhenInit() {

        List<AbstractSlot> slots = this.slotMachine.getCenterSlots();
        List<AbstractSlot> columns = new ArrayList<>();

        Assertions.assertNotNull(this.slotMachine.spinColumn(slots, columns, 2));
    }

    @Test
    public void testSpinColumn() {

        List<AbstractSlot> slots = this.slotMachine.getCenterSlots();
        List<AbstractSlot> columns = new ArrayList<>();

        columns.add(Bar.getBarInstance());
        columns.add(Cherry.getCherryInstance());
        columns.add(Diamond.getDiamondInstance());

        Assertions.assertNotNull(this.slotMachine.spinColumn(slots, columns, 2));
    }

    private void setColumns(List<AbstractSlot> left, List<AbstractSlot> centre, List<AbstractSlot> right) {

        this.slotMachine.setLeftColumn(left);
        this.slotMachine.setCenterColumn(centre);
        this.slotMachine.setRightColumn(right);
    }

    private void setSlots(List<AbstractSlot> left, List<AbstractSlot> centre, List<AbstractSlot> right) {
        this.slotMachine.setLeftSlots(left);
        this.slotMachine.setCenterSlots(centre);
        this.slotMachine.setRightSlots(right);
    }
}
