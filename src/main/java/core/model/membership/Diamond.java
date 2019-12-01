package core.model.membership;

public class Diamond implements Membership{
    private static Membership diamond = new Diamond();

    private Diamond(){

    }

    public static Membership getInstance (){
        return diamond;
    }

    @Override
    public double getBonus() {
        return 1.3;
    }
}
