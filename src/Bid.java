public class Bid {

    private final int face;
    private final int amt;

    public Bid(int faceValue, int amount) {
        face = faceValue;
        amt = amount;


    }

    public int getFaceValue() {
        return face;
    }

    public int getAmount() {
        return amt;

    }


    public String toString() {

        return amt + " " + face + "s";

    }
}