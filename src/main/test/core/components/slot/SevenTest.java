package core.components.slot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SevenTest {

    @Test
    public void testGetInstance() {
        assertNotNull(Seven.getSevenInstance());
    }

}
