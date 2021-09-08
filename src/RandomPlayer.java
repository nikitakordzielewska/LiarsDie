
import java.util.ArrayList;
import java.util.Random;

public class RandomPlayer extends Player {

    Random random = new Random();


    public Bid makeBid(ArrayList<Integer> player1Roll) {
        int randomFaceValue = random.nextInt(6) + 1;
        int randomAmount = random.nextInt(11);

        return new Bid(randomFaceValue, randomAmount);

    }

    public boolean ifCallLiar(Bid player1Bid, ArrayList<Integer> player2Roll) {
        int choice = random.nextInt(2);
        if (choice == 1) {
            return true;
        } else {
            return false;
        }

    }


    public Bid raiseBid(Bid bid, ArrayList<Integer> player2Roll) {
        int faceValue = bid.getFaceValue();
        int newAmount = bid.getAmount() + 1;
        return new Bid(faceValue, newAmount);


    }
}
