package csci4963u20.project.doudizhu;

import java.util.Iterator;

public class InteractiveCardPanel extends CardPanel {

	public InteractiveCardPanel(String name, Deck d) {
		super(name, d);
	}

	@Override
	public void fillCardPanel(Deck d) {
		removeAll();
        Iterator<Card> it = d.cardIterator();
        while(it.hasNext()){
            CardView temp = new InteractiveCardView(it.next());
            deck.add(temp);
            card_count++;
        }
        for(int i=0; i<card_count; ++i){
            add(deck.get(i));
        }
        revalidate();
        repaint();
	}

	@Override
	public CombinationType checkCombination() {
		Deck combination = new Deck();
		for(CardView cv : deck) {
			if(cv.isChosen()) {
				combination.add(cv.c);
			}
		}
		//combination.printDeck();
		return combination.checkValid();
	}
	
	@Override
	public Deck getCombination() {
		Deck combination = new Deck();
		for(CardView cv : deck) {
			if(cv.isChosen()) {
				combination.add(cv.c);
			}
		}
		return combination;
	}
}
