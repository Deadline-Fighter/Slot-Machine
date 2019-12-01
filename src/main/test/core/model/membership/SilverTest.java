package core.model.membership;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SilverTest {

    private Membership silver;

    @BeforeEach
    public void before() {
        silver = Silver.getInstance();
    }

    @Test
    public void testGetBonus() {
        Assertions.assertEquals(1.0, silver.getBonus());
    }

    @Test
    public void testGetURL() {
        Assertions.assertNotNull(silver.getImageURL());
    }
}
