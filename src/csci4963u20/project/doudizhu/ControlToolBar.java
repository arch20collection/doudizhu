package csci4963u20.project.doudizhu;

import javax.swing.*;

public class ControlToolBar extends JToolBar {

    public JButton send_button = new JButton("Send");
    public JButton skip_button = new JButton("Skip");
    public JButton ready_button = new JButton("Ready");

    /**
     * Default constructor
     */
    public ControlToolBar(){
        setFloatable(false);
        add(Box.createHorizontalGlue());
        add(ready_button);
        add(send_button);
        send_button.setEnabled(false);
        add(skip_button);
        skip_button.setEnabled(false);
    }
}
