package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;

public class OpponentStatusPanel extends JPanel {
    public String playerName;
    public JTextField cards_remaining;
    JButton status_button;

    public OpponentStatusPanel(String Name){
        cards_remaining = new JTextField();
        cards_remaining.setEditable(false);
        // *******TEST********
        playerName = Name;
        // *******************
        setBorder(BorderFactory.createTitledBorder(String.format("Player %s", playerName)));
        status_button=new JButton();
        status_button.setBackground(Color.blue);
        status_button.setOpaque(true);
        setLayout(new GridLayout(1, 2));
        add(new JLabel("Cards remaining: "));
        add(status_button);
        cards_remaining.setText("17");
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        cards_remaining.setFont(font1);
        cards_remaining.setHorizontalAlignment(JTextField.CENTER);

        add(cards_remaining);
    }
    public void updaterRemain(String a){
        cards_remaining.setText(a);
    }
    public void status_active(){
        status_button.setBackground(Color.red);
        status_button.setOpaque(true);
    }

    public void status_silent(){
        status_button.setBackground(Color.blue);
        status_button.setOpaque(true);
    }


}
