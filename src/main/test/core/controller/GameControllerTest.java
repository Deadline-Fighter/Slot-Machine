package core.controller;

import core.model.Player;
import core.model.SlotMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class GameControllerTest {

    @Mock
    private PlayerController playerController = Mockito.mock(PlayerController.class);

    @Mock
    private SlotMachine slotMachine = Mockito.mock(SlotMachine.class);

    @Mock
    private Player player = Mockito.mock(Player.class);

    private GameController controller;

    @BeforeEach
    public void before() {

        this.controller = Mockito.spy(new GameController());
        this.controller.setSlotMachine(this.slotMachine);
        this.controller.setPlayerController(this.playerController);
        this.controller.setPlayer(this.player);
    }


    @Test
    public void testStartWin() {
        final String playerName = "Test";
        final int tokens = 10000, bets = 100, odds = 10;
        final double bonus = 1;

        Mockito.when(this.player.getName()).thenReturn(playerName);
        Mockito.when(this.player.getTokens()).thenReturn(tokens);
        Mockito.when(this.player.getBonus()).thenReturn(bonus);
        Mockito.when(this.slotMachine.spin()).thenReturn(odds);
        Mockito.doNothing().when(this.controller).setImages(Mockito.any(ArrayList.class));

        int result = this.controller.runMachine(bets);

        Assertions.assertEquals(odds * bets, result);
        Mockito.verify(this.playerController, Mockito.times(1)).addMoney(this.player, odds * bets);
        Mockito.verify(this.playerController, Mockito.times(1)).loseMoney(this.player, bets);
    }


    @Test
    public void testStartLose() {
        final String playerName = "Test";
        final int tokens = 10000, bets = 100, odds = 0;
        final double bonus = 1;

        Mockito.when(this.player.getName()).thenReturn(playerName);
        Mockito.when(this.player.getTokens()).thenReturn(tokens);
        Mockito.when(this.player.getBonus()).thenReturn(bonus);
        Mockito.when(this.slotMachine.spin()).thenReturn(odds);
        Mockito.doNothing().when(this.controller).setImages(Mockito.any(ArrayList.class));

        int result = this.controller.runMachine(bets);

        Assertions.assertEquals(odds * bets, result);
        Mockito.verify(this.playerController, Mockito.times(1)).loseMoney(this.player, bets);
        Mockito.verify(this.playerController, Mockito.times(0)).addMoney(Mockito.any(Player.class), Mockito.anyInt());
    }

}
