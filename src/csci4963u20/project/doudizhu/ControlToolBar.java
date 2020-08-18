package csci4963u20.project.doudizhu;

import javax.swing.*;

public class ControlToolBar extends JToolBar {

    public JButton send_button = new JButton("Send");
    public JButton skip_button = new JButton("Skip");

    /**
     * Default constructor
     */
    public ControlToolBar(){
        setFloatable(false);
        add(Box.createHorizontalGlue());
        add(send_button);
        add(skip_button);

    }
}
