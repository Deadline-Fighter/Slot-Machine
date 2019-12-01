package core.controller;

import core.model.Player;
import core.model.membership.Diamond;
import core.model.membership.Gold;
import core.model.membership.Silver;

public class PlayerController {

    private static final int INITIAL_TOKENS = 10000;

    private static PlayerController instance = new PlayerController();

    private PlayerController() {}

    public static PlayerController getInstance(){
        return instance;
    }

    public int addMoney(Player player, int money) {
        int balance = player.getTokens();
        balance = balance + money;
        player.setTokens(balance);

        return balance;
    }

    public int loseMoney(Player player, int money) {
        int balance = player.getTokens();
        player.setTotalSpent(player.getTotalSpent() + money);
        balance -= money;
        player.setTokens(balance);
        this.changeMembership(player);
        return balance;
    }

    public void changeMembership(Player player){
        if (player.getTotalSpent() >=5000 && player.getMembership() != Diamond.getInstance()) {
            player.setMembership(Diamond.getInstance());
        }
        else if (player.getTotalSpent() >= 500 && player.getMembership() == Silver.getInstance()) {
            player.setMembership(Gold.getInstance());
        }
    }

    public int getMoney(Player player){
        return player.getTokens();
    }

}
