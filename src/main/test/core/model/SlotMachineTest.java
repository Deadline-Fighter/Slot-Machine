package core.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SlotMachineTest {

    private SlotMachine slotMachine;

    @BeforeEach
    public void before() {
        slotMachine = SlotMachine.getInstance();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(SlotMachine.getInstance());
    }

    @Test
    public void testGetters() {
        assertNotNull(slotMachine.getLeftColumn());
        assertNotNull(slotMachine.getCenterColumn());
        assertNotNull(slotMachine.getRightColumn());
    }

}
