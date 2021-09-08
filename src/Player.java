import java.util.ArrayList;


// I'm using inheritance because methods rollDice and revealDice will be exactly the same for three types of players.
//The rest of the methods will differ depending on the type of player
public class Player {

    public ArrayList<Integer> rollDice(Die die) {
        ArrayList<Integer> dice = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            dice.add(die.roll());
        }
        return dice;
    }


    public void revealDice(ArrayList<Integer> die1) {
        for (Integer integer : die1) {
            System.out.print(integer + ", ");
        }
    }

    public Bid makeBid(ArrayList<Integer> player1Roll) {
        return null;
    }

    public boolean ifCallLiar(Bid player1Bid, ArrayList<Integer> player2Roll) {

        return false;
    }

    public Bid raiseBid(Bid bid, ArrayList<Integer> player2Roll) {

        return null;
    }


}
