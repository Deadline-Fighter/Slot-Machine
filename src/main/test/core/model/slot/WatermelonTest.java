package core.model.slot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WatermelonTest {

    @Test
    public void testGetInstance() {
        assertNotNull(Watermelon.getWatermelonInstance());
    }

}
