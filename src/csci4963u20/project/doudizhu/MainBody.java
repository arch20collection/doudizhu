package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;

public class MainBody extends JFrame {
    public OpponentStatusBar osb;
    public CardPanel current_deck_panel;
    public CardPanel own_deck_panel;
    public ControlToolBar ctb;
    public MainBody(){
        osb = new OpponentStatusBar();
        current_deck_panel = new CardPanel("Current deck", new Deck());

        own_deck_panel = new CardPanel("Own deck", new Deck());
        ctb = new ControlToolBar();

        setLayout(new GridLayout(4, 1));
        setSize(800, 600);
        add(osb);
        add(current_deck_panel);
        add(own_deck_panel);
        add(ctb);

        Deck d = new Deck();
        d.add(new Card(13, "K"));
        d.add(new Card(8, "8"));
        d.add(new Card(8, "8"));
        d.add(new Card(3, "3"));
        d.add(new Card(4, "4"));
        d.add(new Card(5, "5"));
        d.sortDeck();

        Deck d2 = new Deck();
        d2.add(new Card(5, "5"));
        d2.add(new Card(12, "Q"));
        d2.add(new Card(8, "8"));
        d2.add(new Card(8, "8"));
        d2.add(new Card(13, "K"));
        d2.sortDeck();

        current_deck_panel.updateDeck(d);
        own_deck_panel.updateDeck(d);
        own_deck_panel.updateDeck(d2);

        setVisible(true);

    }
}
