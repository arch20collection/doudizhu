package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CardPanel extends JPanel {
    public int card_count;
    public ArrayList<CardView> deck_list;
    public Deck deck;

    /**
     * Default constructor from name and deck
     * @param name name of CardPanel shown in window
     * @param d deck of CardPanel
     */
    public CardPanel(String name, Deck d){
        deck_list = new ArrayList<>();
        setName(name);
        fillCardPanel(d);
        setLayout(new GridLayout(1, card_count));
        setBorder(BorderFactory.createTitledBorder(name));

        for(int i=0; i<card_count; ++i){
            add(deck_list.get(i));
        }
    }

    /**
     * Fill CardPanel with a Deck
     * @param d new deck to fill CardPanel
     */
    public void fillCardPanel(Deck d){
        removeAll();
        deck_list = new ArrayList<>();
        deck = d;
        Iterator<Card> it = d.cardIterator();
        while(it.hasNext()){
            CardView temp = new CardView(it.next());
            deck_list.add(temp);
            card_count++;
        }
        for(int i=0; i<card_count; ++i){
            add(deck_list.get(i));
        }

        repaint();
    }

    /**
     * Update the deck with a new deck
     * @param new_d new deck to update
     */
    public void updateDeck(Deck new_d){
        removeAll();
        deck = new Deck();
        card_count = 0;
        deck_list = new ArrayList<>();
        fillCardPanel(new_d);
    }

    /**
     * Disable all buttons (when using in current deck window)
     */
    public void disableButtons(){
        for(CardView cv: deck_list){
            cv.setEnabled(false);
        }
    }

}
