package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;

public class OpponentStatusPanel extends JPanel {
    public String playerName;
    public JTextField cards_remaining;

    public OpponentStatusPanel(){
        cards_remaining = new JTextField();
        // *******TEST********
        playerName = "TEST";
        // *******************
        setBorder(BorderFactory.createTitledBorder(String.format("Player %s", playerName)));

        setLayout(new GridLayout(1, 2));
        add(new JLabel("Cards remaining: "));
        cards_remaining.setText("17");
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        cards_remaining.setFont(font1);
        cards_remaining.setHorizontalAlignment(JTextField.CENTER);


        add(cards_remaining);
    }

}
