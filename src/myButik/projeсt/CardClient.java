package myButik.projeсt;

import java.util.HashMap;
import java.util.Map;

public class CardClient {

    private static CardClient instance = null;
    private int card = 7000;
    protected Map<Integer, Double> buyerRating = new HashMap<Integer, Double>();

    private CardClient() {

    }

    public static CardClient get() {
        if (instance == null) instance = new CardClient();
        return instance;
    }

    public int getCard() {
        buyerRating.put(card, 0.0);
        return card++;
    }

}
