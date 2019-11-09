package core;

public class GameController {

    private static GameController gameController = new GameController();

    public static GameController getInstance() {
        return gameController;
    }

    private GameController() {

    }
}
