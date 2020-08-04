package csci4963u20.project.doudizhu;

import java.util.*;
public class Deck {
    private ArrayList<Card> cards;
    private int card_count;

    public Deck(){
        cards = new ArrayList<>();
        card_count = 0;
    }

    public Deck(int size){
        card_count = size;
        cards = new ArrayList<>(card_count);
    }
}
