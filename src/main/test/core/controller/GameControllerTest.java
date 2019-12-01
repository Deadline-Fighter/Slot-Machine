package core.controller;

import core.model.Player;
import core.model.SlotMachine;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

//
//@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    @Mock
    private PlayerController playerController = Mockito.mock(PlayerController.class);

    @Mock
    private SlotMachine slotMachine = Mockito.mock(SlotMachine.class);

    @Mock
    private Player player = Mockito.mock(Player.class);

    @Mock
    private Spinner<Integer> bets = Mockito.mock(Spinner.class);

    private Label message;

    private GameController controller;

    @BeforeEach
    public void before() {

//        final URL url = Mockito.mock(URL.class);
//        final ResourceBundle resourceBundle = Mockito.mock(ResourceBundle.class);
//        this.controller.initialize(url, resourceBundle);

        this.controller = new GameController();
        this.controller.setSlotMachine(this.slotMachine);
        this.controller.setPlayerController(this.playerController);
        this.controller.setPlayer(this.player);
        this.controller.setBets(this.bets);

//        this.message = Mockito.spy(new Label());
//        this.controller.setMessage(this.message);
    }


    @Test
    public void testStartWin() {
        final String playerName = "Test";
        final int tokens = 10000, bets = 100, odds = 10;

        Mockito.when(this.player.getName()).thenReturn(playerName);
        Mockito.when(this.player.getTokens()).thenReturn(tokens);
        Mockito.when(this.bets.getValue()).thenReturn(bets);
        Mockito.when(this.slotMachine.spin()).thenReturn(odds);

        this.controller.start();

        assertEquals("You win 1000 tokens", message.getText());
        Mockito.verify(this.playerController, Mockito.times(1)).addMoney(this.player, 1000);
        Mockito.verify(this.playerController, Mockito.times(0)).loseMoney(Mockito.any(Player.class), Mockito.anyInt());
    }

}
