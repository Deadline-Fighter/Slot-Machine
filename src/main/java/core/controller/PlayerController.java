package core.controller;

import core.components.Player;

public class PlayerController {
    private static final int INITIAL_TOKENS = 100;

    private static PlayerController instance;

    private PlayerController(){
        if (instance == null)
            instance = new PlayerController();
    }

    public static PlayerController getInstance(){
        return instance;
    }

    public int addMoney(Player player, int money) {
        int balance = player.getTokens();
        balance += money;
        player.setTokens(balance);

        return balance;
    }

    public int loseMoney(Player player, int money) {
        int balance = player.getTokens();
        balance -= money;
        player.setTokens(balance);

        return balance;
    }

    public boolean isBankrupt(Player player){
        return player.getTokens() <= 0;
    }

    public int getMoney(Player player){
        return player.getTokens();
    }

}
