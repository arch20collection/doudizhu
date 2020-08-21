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

		ctb.skip_button.addActionListener(ev -> {
			Application.client.send("skip", null);
		});

		ctb.send_button.addActionListener(arg0 -> {
			Deck lastDeck = new Deck();
			if(Application.client.latestDeck != null){
				lastDeck = Application.client.latestDeck;
				System.out.println("=======last deck is========");
				lastDeck.printDeck();
				System.out.println("===========================");
			}

			CombinationType result = own_deck_panel.checkCombination();
			System.out.println("Combination Type: " + result);
			Deck combi = own_deck_panel.getCombination();
			/*if(result != CombinationType.Invalid) {
				// check if result is same to lastdeck
				if(result == lastDeck.checkValid()){
					current_deck_panel.updateDeck(combi);
				}
			}*/

			// removing cards in own_deck if valid
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
			System.out.println(own_deck_panel.card_count);

			// check the card count after updating the decks
			if(own_deck_panel.card_count == 0){
				Functions.showInfoMsg("You win!");
			}else{
				System.out.println(Application.client == null);
				current_deck_panel.updateDeck(combi);
				Application.client.send("sendDeck", combi);
			}

		});

		// ********** TESTING ONLY. REMOVE THIS PART WHEN FINISHED. *************
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
		own_deck_panel.updateDeck(d2);

		// ***********************************************************************

		//System.out.println(Application.server==null);

		Player player_client=new Player(Application.playerName);
		Application.client = new Client(player_client, this);
		Application.client.start();

		setVisible(true);

	}
}
