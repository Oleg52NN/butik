package myButik.projeсt;

public class Buyer {
    private int numberCard;

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard() {
        CardClient number = CardClient.get();
        numberCard = number.getCard();
    }
}
