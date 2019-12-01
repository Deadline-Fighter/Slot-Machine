package core.model.slot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BarTest {

    @Test
    public void testGetInstance() {
        assertNotNull(Bar.getBarInstance());
    }

}
