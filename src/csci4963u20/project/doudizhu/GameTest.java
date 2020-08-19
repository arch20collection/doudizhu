package csci4963u20.project.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GameTest {
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

    public static void main(String[] args){
        System.out.println("Welcome to Doudizhu!");

        // deal card
        Stack<Card> library = new Stack<>();

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
        }
    }
}
