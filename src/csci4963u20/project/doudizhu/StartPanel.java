package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    JTextField addressField;
    JTextField portField;
    JTextField nameField;

    public StartPanel(){
        addressField = new JTextField(10);
        portField = new JTextField(10);
        nameField = new JTextField(10);

        //JPanel myPanel = new JPanel();
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Address:"));
        add(addressField);
        //add(Box.createHorizontalStrut(15)); // a spacer
        add(new JLabel("Port:"));
        add(portField);
        //add(Box.createHorizontalStrut(15)); // a spacer
        add(new JLabel("Name:"));
        add(nameField);
    }
}