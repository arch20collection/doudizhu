package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;

public class OpponentStatusBar extends JPanel {
    public OpponentStatusPanel osp1;
    public OpponentStatusPanel osp2;

    public OpponentStatusBar(){
        osp1 = new OpponentStatusPanel("lyc");
        osp1.statusActivate();
        osp2 = new OpponentStatusPanel("wyh");
        setLayout(new GridLayout(1, 2));
        add(osp1);
        add(osp2);
    }
}