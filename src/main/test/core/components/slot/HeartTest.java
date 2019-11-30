package core.components.slot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HeartTest {

    @Test
    public void testGetInstance() {
        assertNotNull(Heart.getHeartInstance());
    }

}
