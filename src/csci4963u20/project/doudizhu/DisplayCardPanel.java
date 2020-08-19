package csci4963u20.project.doudizhu;

import java.util.Iterator;

public class DisplayCardPanel extends CardPanel {

	public DisplayCardPanel(String name, Deck d) {
		super(name, d);
	}

	@Override
	public void fillCardPanel(Deck d) {
		removeAll();
        Iterator<Card> it = d.cardIterator();
        while(it.hasNext()){
            CardView temp = new DisplayCardView(it.next());
            deck.add(temp);
            temp.updateAppearance();
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
		return CombinationType.Invalid;
	}

	@Override
	public Deck getCombination() {
		return null;
	}

}
