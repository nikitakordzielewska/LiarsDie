import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {


    Scanner sc = new Scanner(System.in);


    public Bid makeBid(ArrayList<Integer> playerRoll) {

        System.out.print("Your roll is: ");
        revealDice(playerRoll);

        System.out.println("Enter face value: ");
        int humanFaceValue = sc.nextInt();
        System.out.println("Enter amount: ");
        int humanAmount = sc.nextInt();
        return new Bid(humanFaceValue, humanAmount);
    }


    public boolean ifCallLiar(Bid player1Bid, ArrayList<Integer> playerRoll) {
        System.out.print("Your roll is: ");
        revealDice(playerRoll);
        System.out.println("\nIf you want to call a liar enter 1 and if you want to raise the bid enter 0");
        int choice = sc.nextInt();

        if (choice == 1) {
            return true;
        } else {
            return false;
        }

    }


    public Bid raiseBid(Bid bid, ArrayList<Integer> player2Roll) {
        System.out.println("Enter new face value: ");
        int newFaceValue = sc.nextInt();
        System.out.println("Enter new amount: ");
        int newAmount = sc.nextInt();
        return new Bid(newFaceValue, newAmount);
    }


    public void revealDice(ArrayList<Integer> die1) {

        for (Integer integer : die1) {
            System.out.print(integer + ", ");

        }
    }
}
