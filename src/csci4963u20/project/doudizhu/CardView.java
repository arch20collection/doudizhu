package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardView extends JButton {
    public Card c;
    public boolean chosen;

    public CardView(Card new_card){
        c = new_card;
        chosen = false;
        setText(c.getName());
        setSize(10,10);
        updateAppearance();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isChosen()) {
                    System.out.println("set unchosen");
                    setUnchosen();
                } else {
                    System.out.println("set chosen");
                    setChosen();
                }
                repaint();
            }
        });
    }

    public void setChosen(){
        chosen = true;
        updateAppearance();
    }

    public void setUnchosen(){
        chosen = false;
        updateAppearance();
    }

    public boolean isChosen(){
        return chosen == true;
    }

    public void updateAppearance(){
        if(chosen){
            setBackground(Color.GRAY);
        }else{
            setBackground(Color.WHITE);
        }
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        setFont(font1);
        setHorizontalAlignment(JButton.CENTER);
        repaint();
    }
}
