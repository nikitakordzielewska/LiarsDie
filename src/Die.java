import java.util.Random;

public class Die {

    public Die() {

    }

    Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;


    }


}
