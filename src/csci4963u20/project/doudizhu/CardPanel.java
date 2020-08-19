package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public abstract class CardPanel extends JPanel {
    protected int card_count;
    protected ArrayList<CardView> deck;

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

    public abstract void fillCardPanel(Deck d);

    public void updateDeck(Deck new_d){
        removeAll();
        card_count = 0;
        deck = new ArrayList<>();
        fillCardPanel(new_d);
    }
    public void upadatecardviewlist(ArrayList<CardView> a){
        deck=a;
    }
    
    public abstract CombinationType checkCombination();
    
    public abstract Deck getCombination();

}
