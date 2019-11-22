package core.controller;

import core.components.Player;

public class PlayerController {
    private static final int INITIAL_TOKENS = 100;
    private Player player;

    public PlayerController(String name){
    }

    public Player createPlayer(String name){
        player = new Player(name, INITIAL_TOKENS);
        return player;
    }

    public int addMoney(int money) {
        int balance = this.player.getTokens();
        balance += money;
        this.player.setTokens(balance);

        return balance;
    }

    public int loseMoney(int money) {
        int balance = this.player.getTokens();
        balance -= money;
        this.player.setTokens(balance);

        return balance;
    }

    public boolean isBankrupt(){
        return this.player.getTokens() <= 0;
    }

    public int getMoney(){
        return this.player.getTokens();
    }

}
