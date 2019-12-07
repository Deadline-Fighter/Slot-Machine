package core.model;

import core.model.membership.Gold;
import core.model.membership.Membership;
import core.model.membership.Silver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testGettersSetters() {

        final String name = "Init";
        final int tokens = 1000;

        final Player player = new Player(name, tokens);
        Assertions.assertEquals(name, player.getName());
        Assertions.assertEquals(tokens, player.getTokens());
        Assertions.assertEquals(0, player.getTotalSpent());
        Assertions.assertEquals(Silver.getInstance(), player.getMembership());

        final String newName = "Stan";
        final int newTokens = 2000, totalSpent = 1000;
        final Membership membership = Gold.getInstance();

        player.setName(newName);
        player.setTokens(newTokens);
        player.setTotalSpent(totalSpent);
        player.setMembership(membership);

        Assertions.assertEquals(newName, player.getName());
        Assertions.assertEquals(newTokens, player.getTokens());
        Assertions.assertEquals(totalSpent, player.getTotalSpent());
        Assertions.assertEquals(Gold.getInstance(), player.getMembership());
    }

}
