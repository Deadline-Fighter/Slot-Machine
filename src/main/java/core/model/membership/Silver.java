package core.model.membership;

public class Silver implements Membership{

    private static Membership silver = new Silver();

    private Silver(){

    }

    public static Membership getInstance (){
        return silver;
    }

    @Override
    public double getBonus() {
        return 1;
    }
}
