package core.model.membership;

public class Gold implements Membership{
    private static Membership gold = new Gold();

    private Gold(){

    }

    public static Membership getInstance (){
        return gold;
    }

    @Override
    public double getBonus() {
        return 1.1;
    }
}
