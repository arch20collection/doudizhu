package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;

public class OpponentStatusBar extends JPanel {
    public OpponentStatusPanel osp1;
    public OpponentStatusPanel osp2;

    public OpponentStatusBar(){
        osp1 = new OpponentStatusPanel();
        osp2 = new OpponentStatusPanel();
        setLayout(new GridLayout(1, 2));
        add(osp1);
        add(osp2);
    }
}
