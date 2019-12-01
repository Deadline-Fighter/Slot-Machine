package core.model.membership;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiamondTest {

    private Membership diamond;

    @BeforeEach
    public void before() {
        diamond = Diamond.getInstance();
    }

    @Test
    public void testGetBonus() {
        Assertions.assertEquals(1.3, diamond.getBonus());
    }

    @Test
    public void testGetURL() {
        Assertions.assertNotNull(diamond.getImageURL());
    }
}
