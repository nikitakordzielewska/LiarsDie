
import java.util.ArrayList;
import java.util.Scanner;

public class LiarsDie {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Player1: ");

        System.out.println("1.Random Computer");
        System.out.println("2.Smart Computer");
        System.out.println("3.Human");

        int player1Choice = sc.nextInt();

        if (player1Choice == 3) {
            System.out.println("Choose Player2: ");
            System.out.println("1.Random Computer");
            System.out.println("2.Smart Computer");
        } else {
            System.out.println("Choose Player2: ");
            System.out.println("1.Random Computer");
            System.out.println("2.Smart Computer");
            System.out.println("3.Human");
        }

        int player2Choice = sc.nextInt();


        RandomPlayer random1 = new RandomPlayer();
        RandomPlayer random2 = new RandomPlayer();
        SmartPlayer smart1 = new SmartPlayer();
        SmartPlayer smart2 = new SmartPlayer();
        HumanPlayer human1 = new HumanPlayer();



        if (player1Choice == 1) {
            if (player2Choice == 1) {
                gamePlay(random1, random2);
            }
            if (player2Choice == 2) {
                gamePlay(random1, smart2);
            }
            if (player2Choice == 3) {
                gamePlay(random1, human1);
            }
        }
        if (player1Choice == 2) {
            if (player2Choice == 1) {
                gamePlay(smart1, random2);
            }
            if (player2Choice == 2) {
                gamePlay(smart1, smart2);
            }
            if (player2Choice == 3) {
                gamePlay(smart1, human1);
            }
        }
        if (player1Choice == 3) {
            if (player2Choice == 1) {
                gamePlay(human1, random2);
            }
            if (player2Choice == 2) {
                gamePlay(human1, smart2);
            }
        }


    }

    //*gameplay* insert player types

    public static void gamePlay(Player player1, Player player2) {
        //creats new dies and rolls
        Die die1 = new Die();
        Die die2 = new Die();

        ArrayList<Integer> player1Roll = player1.rollDice(die1);
        ArrayList<Integer> player2Roll = player1.rollDice(die2);

        //first bid
        Bid player1Bid = player1.makeBid(player1Roll);
        System.out.println("Player 1 bid " + player1Bid);


        //asks if player 2 wants to call a liar
        while (!player2.ifCallLiar(player1Bid, player2Roll)) {

            //if pllayer 2 doesn't call a liar they must raise the bid
            Bid player2Bid = player2.raiseBid(player1Bid, player2Roll);
            System.out.println("Player 2 raised the bid: " + player2Bid);

            //then player 1 decides if they want to call a liar
            if (player1.ifCallLiar(player1Bid, player1Roll)) {
                System.out.println("Player 1 calls a liar!");
                System.out.println("Player 2 bid: " + player2Bid);

                player1.revealDice(player1Roll);
                player2.revealDice(player2Roll);

                //checks the bid for the rolls
                int bidFaceValue = player2Bid.getFaceValue();
                int checkAmount = 0;
                for (Integer integer : player1Roll) {
                    if (integer.equals(bidFaceValue)) {
                        checkAmount++;
                    }
                }
                for (Integer integer : player2Roll) {
                    if (integer.equals(bidFaceValue)) {
                        checkAmount++;
                    }
                }

                if (checkAmount >= player2Bid.getAmount()) {
                    System.out.println("Player 2 WINS!");
                } else {
                    System.out.println("Player1 WINS!");
                }
                return;
            }
            //player 2 doesn't call a liar and player 1 raises the bid
            player1Bid = player1.raiseBid(player2Bid, player2Roll);
            System.out.println("Player 1 raised the bid: " + player1Bid);

        }
        System.out.println("Player 2 calls a liar!");
        System.out.println("Player 1 bid: " + player1Bid);
        player1.revealDice(player1Roll);
        player2.revealDice(player2Roll);

        int bidFaceValue = player1Bid.getFaceValue();
        int checkAmount = 0;

        for (Integer integer : player1Roll) {
            if (integer.equals(bidFaceValue)) {
                checkAmount++;
            }
        }
        for (Integer integer : player2Roll) {
            if (integer.equals(bidFaceValue)) {
                checkAmount++;
            }
        }

        if (checkAmount >= player1Bid.getAmount()) {
            System.out.println("Player1 WINS!");
        } else {
            System.out.println("Player2 WINS!");
        }


    }

}