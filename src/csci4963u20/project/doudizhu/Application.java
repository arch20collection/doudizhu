package csci4963u20.project.doudizhu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

public class Application {
    public static Properties config;
    public static int mode = -1;
    public static Client client;
    public static Server server;

    public static String playerName;
    public static String serverHost = "localhost";
    public static int serverPort = 8848;
    /**
     * Convert number to corresponding card
     * @param number number of card to be converted
     * @return String of the number's corresponding card
     */
    public static String numToString(int number) {
        switch(number){
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            case 15:
                return "2";
            case 16:
                return "Joker";
            default:
                return "Error";
        }
    }

    /**
     * Main program
     * @param args arguments
     */
    public static void main(String[] args){

        System.out.println("Welcome to Doudizhu!");

        StartPanel sp = new StartPanel();
        sp.addressField.setText("localhost");
        String[] options = {"Host a server", "Connect to server"};

        mode = JOptionPane.showOptionDialog(null, sp, "Please enter information and select mode",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        playerName = (sp.nameField.getText() == null || sp.nameField.getText().equals("")) ?
                "Player "+mode : sp.nameField.getText();
        MainBody mf = new MainBody();
        mf.ctb.ready_button.addActionListener(ev -> {
            mf.ctb.send_button.setEnabled(true);
            mf.ctb.skip_button.setEnabled(true);
            mf.ctb.ready_button.setEnabled(false);
            //mf.ctb.name_label.setText("Welcome"+Application.server.group[0].name);
            Application.client.send("ready", null);
        });
        // server mode
        if(mode == 0) {
            serverHost = "localhost";
            String portInput = sp.portField.getText();

            // if port invalid
            if(portInput == null || portInput.equals("") || serverPort < 0 || serverPort > 65535) {
                JOptionPane.showMessageDialog(null,
                        "Invalid port. Will use 8888 as default",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                //serverPort = 8888;
                //System.exit(1);
            }else{
                serverPort = Functions.convertToInteger(sp.portField.getText());
            }
            server = new Server(serverPort);
            server.start();
        }
        // client mode
        else if (mode == 1){
            //TODO: Add support for two more clients connecting to the server
            serverHost = sp.addressField.getText().length() == 0?"localhost":sp.addressField.getText();
            String portInput = sp.portField.getText();

            if(serverHost == null || serverHost.equals("")) {
                JOptionPane.showMessageDialog(null, "[ERROR] Hostname incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            // if port invalid
            if(portInput == null || portInput.equals("") || serverPort < 0 || serverPort > 65535) {
                JOptionPane.showMessageDialog(null,
                        "Invalid port. Will use 8848 as default",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                //serverPort = 8888;
            }else{
                serverPort = Functions.convertToInteger(sp.portField.getText());
            }

        }// exit if not 0 or 1

        else if(mode == -1) {
            JOptionPane.showMessageDialog(null, "No operation chose. Program will exit.",
                    "Doudizhu", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        System.out.println(playerName);

        mf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        mf.setVisible(true);
        //System.exit(0);
    }

}
