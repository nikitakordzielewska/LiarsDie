import java.util.ArrayList;


public class SmartPlayer extends Player {


    public Bid makeBid(ArrayList<Integer> smartDie) {
//For smart computer I decided to make safe initial bid. I want to make the first bid small and true and see how other player responds
        //If other player challenges it's a win and if they raise the bid, the computer will decide what to do.
        //If computer doesn't have any twos or threes, it will bid 1 2's, because there is a high probability there will be
        //at least one 2.
        int count2s = 0;
        int count3s = 0;

        for (Object o : smartDie) {
            if (o.equals(2)) {
                count2s++;
                if (count2s > 1) {
                    return new Bid(2, count2s);
                }
            }
            if (o.equals(3)) {
                count3s++;
                if (count3s > 1) {
                    return new Bid(3, count3s);
                }
            }
        }
        return new Bid(2, 1);

    }


    public boolean ifCallLiar(Bid otherPlayersBid, ArrayList<Integer> smartDie) {
        int bidFaceValue = otherPlayersBid.getFaceValue();
        int bidAmount = otherPlayersBid.getAmount();

        //here smart player checks how many of the bid value they have, if the bid is about 3 or more bigger than
        //the amount the computer has, it calls liar, because the possibility of other players having 3 more isn't very big.
        // Otherwise, smart player raises the bid.
        //
        int countValueAmount = 0;
        for (Integer integer : smartDie) {
            if (integer.equals(bidFaceValue)) {
                countValueAmount++;
            }
        }
        return bidAmount - 3 >= countValueAmount;


    }

    public Bid raiseBid(Bid bid, ArrayList<Integer> smartDie) {

        // if the smart player has more of the bid face value, then they raise to the amount they have.
        // if the smart palyer has fewer and if the bid favefalue wasn't 6, then they raise the faceValue by one and bid
        // the amount they have(unless they don't have any.
        //if either the bid amount is equal to the amount the smart player has or the bid faceValue was 6, then
        //the smart player raises the amount by 1.
        int bidFaceValue = bid.getFaceValue();
        int bidAmount = bid.getAmount();

        int countValueAmount = 0;
        for (Integer integer : smartDie) {
            if (integer.equals(bidFaceValue)) {
                countValueAmount++;
            }
        }

        if (countValueAmount > bidAmount) {
            return new Bid(bidFaceValue, countValueAmount);
        }
        if (countValueAmount < bidAmount && bidFaceValue != 6) {
            for (Integer integer : smartDie) {
                if (integer.equals(bidFaceValue + 1)) {
                    countValueAmount++;
                    if (countValueAmount > 0) {

                        return new Bid(bidFaceValue + 1, countValueAmount);
                    }

                }
            }
        }
        return new Bid(bidFaceValue, bidAmount + 1);


    }
}






