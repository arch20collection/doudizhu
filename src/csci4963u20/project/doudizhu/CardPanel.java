package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CardPanel extends JPanel {
    public int card_count;
    private ArrayList<CardView> deck;

    public CardPanel(String name, Deck d){
        deck = new ArrayList<>();
        setName(name);
        fillCardPanel(d);
        setLayout(new GridLayout(1, card_count));
        setBorder(BorderFactory.createTitledBorder(name));

        for(int i=0; i<card_count; ++i){
            add(deck.get(i));
        }
    }

    public void fillCardPanel(Deck d){
        removeAll();
        Iterator<Card> it = d.cardIterator();
        while(it.hasNext()){
            CardView temp = new CardView(it.next());
            deck.add(temp);
            card_count++;
        }
        for(int i=0; i<card_count; ++i){
            add(deck.get(i));
        }

        repaint();
    }

    public void updateDeck(Deck new_d){
        removeAll();
        card_count = 0;
        deck = new ArrayList<>();
        fillCardPanel(new_d);
    }

}
