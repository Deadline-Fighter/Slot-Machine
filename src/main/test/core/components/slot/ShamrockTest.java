package core.components.slot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShamrockTest {

    @Test
    public void testGetInstance() {
        assertNotNull(Shamrock.getShamrockInstance());
    }


}
