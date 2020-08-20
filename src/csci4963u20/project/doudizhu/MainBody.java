package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

public class MainBody extends JFrame {
	public OpponentStatusBar osb;
	public CardPanel current_deck_panel;
	public CardPanel own_deck_panel;
	public ControlToolBar ctb;
	public ControlMenuBar cmb;

	public MainBody() {
		setTitle("Doudizhu");
		osb = new OpponentStatusBar();
		current_deck_panel = new DisplayCardPanel("Current deck", new Deck());

		own_deck_panel = new InteractiveCardPanel("Own deck", new Deck());
		ctb = new ControlToolBar();
		cmb = new ControlMenuBar();

		setLayout(new GridLayout(4, 1));
		setSize(1600, 900);
		add(osb);
		add(current_deck_panel);
		add(own_deck_panel);
		add(ctb);
		setJMenuBar(cmb);

		ctb.send_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				CombinationType result = own_deck_panel.checkCombination();
				System.out.println("Combination Type: " + result);
				if(result != CombinationType.Invalid) {
					current_deck_panel.updateDeck(own_deck_panel.getCombination());
				}

				ArrayList<CardView> current_deck=own_deck_panel.deck;
				if(result != CombinationType.Invalid) {
					current_deck.removeIf(CardView::isChosen);
				}
				own_deck_panel.deck = current_deck;
				own_deck_panel.upadatecardviewlist(current_deck);
				Deck update_deck = new Deck();
				for(CardView a:own_deck_panel.deck){
					update_deck.add(a.c);
				}
				own_deck_panel.updateDeck(update_deck);

			}
		});

		Deck d = new Deck();
		d.add(new Card(8, "8"));
		d.add(new Card(8, "8"));
		d.sortDeck();

		Deck d2 = new Deck();
		d2.add(new Card(3, "3"));
		d2.add(new Card(3, "3"));
		d2.add(new Card(3, "3"));
		d2.add(new Card(3, "3"));
		d2.add(new Card(4, "4"));
		d2.add(new Card(11, "J"));
		d2.add(new Card(4, "4"));
		d2.add(new Card(4, "4"));
		d2.add(new Card(4, "4"));
		d2.add(new Card(5, "5"));
		d2.add(new Card(12, "Q"));
		d2.add(new Card(8, "8"));
		d2.add(new Card(8, "8"));
		d2.add(new Card(13, "K"));
		d2.sortDeck();

		current_deck_panel.updateDeck(d);
		// own_deck_panel.updateDeck(d);
		own_deck_panel.updateDeck(d2);

		setVisible(true);

	}
}
