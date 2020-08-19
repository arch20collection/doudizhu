package csci4963u20.project.doudizhu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InteractiveCardView extends CardView {

	public InteractiveCardView(Card new_card) {
		super(new_card);
		
		addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	//System.out.println(new_card.getName());
                if (isChosen()) {
                    //System.out.println("set unchosen");
                    setUnchosen();
                } else {
                    //System.out.println("set chosen");
                    setChosen();
                }
                repaint();
            }
        });
	}

}
