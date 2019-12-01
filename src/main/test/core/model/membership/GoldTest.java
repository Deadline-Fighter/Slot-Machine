package core.model.membership;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoldTest {

    private Membership gold;

    @BeforeEach
    public void before() {
        gold = Gold.getInstance();
    }

    @Test
    public void testGetBonus() {
        Assertions.assertEquals(1.1, gold.getBonus());
    }

    @Test
    public void testGetURL() {
        Assertions.assertNotNull(gold.getImageURL());
    }
}
