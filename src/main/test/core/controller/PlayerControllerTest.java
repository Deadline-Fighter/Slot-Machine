package core.controller;

import core.model.Player;
import core.model.membership.Diamond;
import core.model.membership.Gold;
import core.model.membership.Membership;
import core.model.membership.Silver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlayerControllerTest {

    private PlayerController controller;

    @BeforeEach
    public void before() {
        this.controller = PlayerController.getInstance();
    }

    @Test
    public void testAddMoney() {

        final String name = "Stanley";
        final int tokens = 1000;
        final Membership membership = Silver.getInstance();
        final Player player = this.getPlayer(name, tokens);
        final int addValue = 1000;

        int balance = this.controller.addMoney(player, addValue);

        Assertions.assertEquals(this.controller.getMoney(player), balance);
    }

    @Test
    public void testLoseMoney() {

        final String name = "Stanley";
        final int tokens = 1000;
        final Player player = this.getPlayer(name, tokens);
        final int loseValue = 1000;

        int balance = this.controller.loseMoney(player, loseValue);

        Assertions.assertEquals(this.controller.getMoney(player), balance);
    }

    @Test
    public void testChangeMembershipToGold() {

        final String name = "Stanley";
        final int tokens = 1000;
        final Player player = this.getPlayer(name, tokens);

        this.controller.loseMoney(player, 500);

        Assertions.assertEquals(Gold.getInstance(), player.getMembership());
    }


    @Test
    public void testChangeMembershipToDiamond() {

        final String name = "Stanley";
        final int tokens = 1000;
        final Player player = this.getPlayer(name, tokens);

        this.controller.loseMoney(player, 5000);

        Assertions.assertEquals(Diamond.getInstance(), player.getMembership());
    }


    @Test
    public void testChangeMembershipUnchanged() {

        final String name = "Stanley";
        final int tokens = 1000;
        final Player player = this.getPlayer(name, tokens);

        this.controller.loseMoney(player, 499);

        Assertions.assertEquals(Silver.getInstance(), player.getMembership());
    }


    @Test
    public void testChangeMembershipGoldUnchanged() {

        final String name = "Stanley";
        final int tokens = 1000;
        final Player player = this.getPlayer(name, tokens);
        player.setMembership(Gold.getInstance());
        player.setTotalSpent(500);

        this.controller.loseMoney(player, 499);

        Assertions.assertEquals(Gold.getInstance(), player.getMembership());
    }


    @Test
    public void testChangeMembershipDiamondUnchanged() {

        final String name = "Stanley";
        final int tokens = 1000;
        final Player player = this.getPlayer(name, tokens);
        player.setMembership(Diamond.getInstance());
        player.setTotalSpent(5000);

        this.controller.loseMoney(player, 499);

        Assertions.assertEquals(Diamond.getInstance(), player.getMembership());
    }


    private Player getPlayer(String name, int tokens) {

        final Player player = new Player(name, tokens);

        return player;
    }
}
