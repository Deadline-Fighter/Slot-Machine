package core.controller;

import core.components.SlotMachine;

public class GameController {

    private static GameController gameController = new GameController();

    public static GameController getInstance() {
        return gameController;
    }

    private GameController() {}

    public void start() {

        final SlotMachine slotMachine = SlotMachine.getInstance();

        slotMachine.randomizeColumns();


    }
}
