package core.controller;

import core.components.Player;
import core.components.SlotMachine;

import java.util.Arrays;
import java.util.Scanner;

public class GameController {

    private static GameController gameControllerInstance = new GameController();

    private PlayerController playerController;

    public static GameController getInstance() {
        return gameControllerInstance;
    }

    private GameController() {
//        if (gameControllerInstance == null)
//            gameControllerInstance = new GameController();
        playerController = PlayerController.getInstance();
    }

    public void start() {
        System.out.println("Hello World");

        final SlotMachine slotMachine = SlotMachine.getInstance();
        final Player player = new Player("Stanley", 10000000);
        final Scanner input = new Scanner(System.in);
        try {
            while (!this.playerController.isBankrupt(player)) {
                System.out.printf("Player %s now have %d tokens\n",player.getName(),player.getTokens());
                System.out.print("Please enter your bets: ");
                int bet = input.nextInt();
                this.playerController.loseMoney(player, bet);

                slotMachine.randomizeColumns();
                int odds = slotMachine.spin();
                slotMachine.printSlots();
                if (odds > 0) {
                    System.out.println("Win");
                    playerController.addMoney(player, bet * odds);
                } else {
                    System.out.println("lose");
                }

            }

        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }



    }

    public boolean isBankrupt(Player player) {
        return player.getTokens() <= 0;
    }
}