package csci4963u20.project.doudizhu;

import javax.swing.*;

public class ControlMenuBar extends JMenuBar {
    JMenu configMenu = new JMenu("File");
    JMenuItem exitBtn = new JMenuItem("Exit");

    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutBtn = new JMenuItem("About");

    public ControlMenuBar(){
        configMenu.add(exitBtn);
        add(configMenu);

        helpMenu.add(aboutBtn);
        add(helpMenu);

        exitBtn.addActionListener(ev -> {
            int res = JOptionPane.showConfirmDialog(
                    null, "Are you sure to exit?",
                    "Doudizhu",
                    JOptionPane.YES_NO_OPTION);

            if(res==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });

        aboutBtn.addActionListener(ev ->{
            JOptionPane.showMessageDialog(null, "Doudizhu\nDeveloped by Hairong Chen, Qiran Sun, Yichen Li, Zhaolong Lin");
        });

    }

}
