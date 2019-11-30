package core.controller;

import core.components.Player;
import core.components.SlotMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    @Mock
    private PlayerController playerController;

    @Mock
    private SlotMachine slotMachine;

    @Mock
    private Player player;

    private GameController controller;

    @BeforeEach
    public void before() {

        this.controller = new GameController();
        this.controller.setSlotMachine(this.slotMachine);
        this.controller.setPlayerController(this.playerController);
        this.player = Mockito.mock(Player.class);
        this.controller.setPlayer(this.player);
    }

    @Test
    public void testStart() {

    }

}
