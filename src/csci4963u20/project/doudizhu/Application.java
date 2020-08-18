package csci4963u20.project.doudizhu;
import javax.swing.*;
import java.util.Properties;

public class Application {
    public static Properties config;
    public static int mode = -1;
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
        
         // deal card
        /*Stack<Card> library = new Stack<>();

        for(int i = 0; i < 4; i++) {
            for(int j = 3; j < 16; j++) {
                if(j <= 10)
                    library.push(new Card(j, Integer.toString(j)));
                else
                    library.push(new Card(j, numToString(j)));
            }
        }

        System.out.println("Size of library: "+library.size());
        library.push(new Card(16, "joker"));
        library.push(new Card(16, "joker"));
        Collections.shuffle(library);

        ArrayList<Card> player1 = new ArrayList<>();
        ArrayList<Card> player2 = new ArrayList<>();
        ArrayList<Card> player3 = new ArrayList<>();
        ArrayList<Card> dipai = new ArrayList<>();

        while(library.size() > 3)
        {
            player1.add(library.pop());
            player2.add(library.pop());
            player3.add(library.pop());
        }
        for(int i = 0; i < 3; i++)
        {
            dipai.add(library.pop());
        }
        
        for(int j = 1; j <= 3; j++) {
        	Collections.sort(player1);
        	Collections.sort(player2);
        	Collections.sort(player3);
        	System.out.println("player" + j + ": ");
        	for(int i = 0; i < player1.size(); i++)
            {
        		if(j == 1) {
        			player1.get(i).printCard();
        		} else if(j == 2) {
        			player2.get(i).printCard();
        		} else {
        			player3.get(i).printCard();	
        		}
            }
        }
        
        System.out.println("dipai: ");
        for(int i = 0; i < dipai.size(); i++) {
        	dipai.get(i).printCard();
        }*/

        StartPanel sp = new StartPanel();
        sp.addressField.setText("localhost");
        String[] options = {"Host a server", "Connect to server"};

        mode = JOptionPane.showOptionDialog(null, sp, "Please enter information and select mode",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        playerName = (sp.nameField.getText() == null || sp.nameField.getText().equals("")) ?
                "Player "+mode : sp.nameField.getText();

        System.out.println(playerName);

        MainBody mf = new MainBody();
        mf.setVisible(true);
        //System.exit(0);
    }

}
