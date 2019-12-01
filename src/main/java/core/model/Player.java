package core.model;

import core.model.membership.Membership;
import core.model.membership.Silver;

public class Player {

    private String name;

    private int tokens;

    private int totalSpent;

    private Membership membership;

    public Player (String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
        this.totalSpent = 0;
        this.membership = Silver.getInstance();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public double getBonus() {
        return membership.getBonus();
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Membership getMembership() {
        return membership;
    }
}
