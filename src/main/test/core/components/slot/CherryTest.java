package core.components.slot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CherryTest {

    @Test
    public void testGetInstance() {
        assertNotNull(Cherry.getCherryInstance());
    }

}
