package csci4963u20.project.doudizhu;

import java.util.*;
public class Deck {
    private ArrayList<Card> cards;
    private int card_count;

    /**
     * Default empty constructor.
     */
    public Deck(){
        cards = new ArrayList<>();
        card_count = 0;
    }

    /**
     * Constructor from deck size.
     * @param size deck size
     */
    public Deck(int size){
        card_count = size;
        cards = new ArrayList<>(card_count);
    }

    /**
     * Add a Card to this Deck.
     * @param c Card to be added
     * @return boolean if Card is added successfully
     */
    public boolean add(Card c){
        boolean ret = cards.add(c);
        if(ret){ card_count++; }
        return ret;
    }


    /**
     * Shuffle the deck.
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Sort the deck.
     */
    public void sortDeck(){
        Collections.sort(cards);
    }

    /**
     * Print the deck.
     */
    public void printDeck(){
        for(Card c:cards){
            System.out.println(c.getName());
        }
    }
}
