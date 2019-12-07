package core.model;

import core.model.slot.Bar;
import core.model.slot.Cherry;
import core.model.slot.Diamond;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SlotMachineTest {

    private SlotMachine slotMachine;

    private List<AbstractSlot> leftColumn;
    private List<AbstractSlot> centreColumn;
    private List<AbstractSlot> rightColumn;

    @BeforeEach
    public void before() {
        slotMachine = Mockito.spy(SlotMachine.getInstance());
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

        this.mockColumns();

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        Mockito.when(leftColumn.get(0)).thenReturn(diamond);
        Mockito.when(centreColumn.get(0)).thenReturn(diamond);
        Mockito.when(rightColumn.get(0)).thenReturn(diamond);

        Mockito.when(leftColumn.get(1)).thenReturn(cherry);
        Mockito.when(centreColumn.get(1)).thenReturn(cherry);
        Mockito.when(rightColumn.get(1)).thenReturn(cherry);

        Mockito.when(leftColumn.get(2)).thenReturn(bar);
        Mockito.when(centreColumn.get(2)).thenReturn(bar);
        Mockito.when(rightColumn.get(2)).thenReturn(bar);

        Mockito.doNothing().when(this.slotMachine).randomizeColumns();

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }


    @Test
    public void testSpinHorizontallySameSecondRowOdd() {

        this.mockColumns();

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        Mockito.when(leftColumn.get(1)).thenReturn(diamond);
        Mockito.when(centreColumn.get(1)).thenReturn(diamond);
        Mockito.when(rightColumn.get(1)).thenReturn(diamond);

        Mockito.when(leftColumn.get(0)).thenReturn(cherry);
        Mockito.when(centreColumn.get(0)).thenReturn(cherry);
        Mockito.when(rightColumn.get(0)).thenReturn(cherry);

        Mockito.when(leftColumn.get(2)).thenReturn(bar);
        Mockito.when(centreColumn.get(2)).thenReturn(bar);
        Mockito.when(rightColumn.get(2)).thenReturn(bar);

        Mockito.doNothing().when(this.slotMachine).randomizeColumns();

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }


    @Test
    public void testSpinHorizontallySameThirdRowOdd() {

        this.mockColumns();

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        Mockito.when(leftColumn.get(2)).thenReturn(diamond);
        Mockito.when(centreColumn.get(2)).thenReturn(diamond);
        Mockito.when(rightColumn.get(2)).thenReturn(diamond);

        Mockito.when(leftColumn.get(0)).thenReturn(cherry);
        Mockito.when(centreColumn.get(0)).thenReturn(cherry);
        Mockito.when(rightColumn.get(0)).thenReturn(cherry);

        Mockito.when(leftColumn.get(1)).thenReturn(bar);
        Mockito.when(centreColumn.get(1)).thenReturn(bar);
        Mockito.when(rightColumn.get(1)).thenReturn(bar);

        Mockito.doNothing().when(this.slotMachine).randomizeColumns();

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }

    @Test
    public void testSpinTopLeftToBottomRight() {

        this.mockColumns();

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        Mockito.when(leftColumn.get(2)).thenReturn(cherry);
        Mockito.when(centreColumn.get(2)).thenReturn(bar);
        Mockito.when(rightColumn.get(2)).thenReturn(diamond);

        Mockito.when(leftColumn.get(0)).thenReturn(diamond);
        Mockito.when(centreColumn.get(0)).thenReturn(cherry);
        Mockito.when(rightColumn.get(0)).thenReturn(cherry);

        Mockito.when(leftColumn.get(1)).thenReturn(bar);
        Mockito.when(centreColumn.get(1)).thenReturn(diamond);
        Mockito.when(rightColumn.get(1)).thenReturn(bar);

        Mockito.doNothing().when(this.slotMachine).randomizeColumns();

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }

    @Test
    public void testSpinTopRightToBottomLeft() {

        this.mockColumns();

        final AbstractSlot bar = Bar.getBarInstance();
        final AbstractSlot cherry = Cherry.getCherryInstance();
        final AbstractSlot diamond = Diamond.getDiamondInstance();

        Mockito.when(leftColumn.get(2)).thenReturn(diamond);
        Mockito.when(centreColumn.get(2)).thenReturn(bar);
        Mockito.when(rightColumn.get(2)).thenReturn(cherry);

        Mockito.when(leftColumn.get(0)).thenReturn(bar);
        Mockito.when(centreColumn.get(0)).thenReturn(cherry);
        Mockito.when(rightColumn.get(0)).thenReturn(diamond);

        Mockito.when(leftColumn.get(1)).thenReturn(bar);
        Mockito.when(centreColumn.get(1)).thenReturn(diamond);
        Mockito.when(rightColumn.get(1)).thenReturn(bar);

        Mockito.doNothing().when(this.slotMachine).randomizeColumns();

        int maxOdds = this.slotMachine.spin();

        Assertions.assertEquals(diamond.getOdd(), maxOdds);
    }

    @Test
    public void testGetImages() {

        this.mockColumns();

        final AbstractSlot slot = Mockito.mock(AbstractSlot.class);
        final Image image = Mockito.mock(Image.class);

        Mockito.when(this.leftColumn.get(Mockito.anyInt())).thenReturn(slot);
        Mockito.when(this.centreColumn.get(Mockito.anyInt())).thenReturn(slot);
        Mockito.when(this.rightColumn.get(Mockito.anyInt())).thenReturn(slot);

        Mockito.when(slot.getImage()).thenReturn(image);

        Assertions.assertNotNull(this.slotMachine.getImages());
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

    private void mockColumns() {
        leftColumn = Mockito.mock(List.class);
        centreColumn = Mockito.mock(List.class);
        rightColumn = Mockito.mock(List.class);

        this.slotMachine.setLeftColumn(leftColumn);
        this.slotMachine.setCenterColumn(centreColumn);
        this.slotMachine.setRightColumn(rightColumn);
    }
}
