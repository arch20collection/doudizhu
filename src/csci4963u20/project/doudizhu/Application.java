package csci4963u20.project.doudizhu;
import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args){

        System.out.println("Welcome to Doudizhu!");
        Deck d = new Deck(10);
        d.add(new Card(14, "A"));
        d.add(new Card(15, "2"));
        d.add(new Card(16, "Joker"));
        d.add(new Card(4, "4"));
        d.add(new Card(5, "5"));
        d.add(new Card(11, "J"));
        d.add(new Card(12, "Q"));
        d.add(new Card(13, "K"));
        d.add(new Card(13, "K"));
        d.add(new Card(11, "J"));

        d.sortDeck();
        d.printDeck();
        d.shuffle();
        d.printDeck();

        Deck pair = new Deck(2);
        pair.add(new Card(13, "K"));
        pair.add(new Card(13, "K"));
        System.out.println(pair.isPair());

        Deck trio_single = new Deck(4);
        trio_single.add(new Card(13, "K"));
        trio_single.add(new Card(13, "K"));
        trio_single.add(new Card(13, "K"));
        trio_single.add(new Card(11, "J"));
        System.out.println(trio_single.isTrioSingle());
        
        ArrayList<String> boxes = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        for(int i = 1; i <= 16; i++)
        {
            numbers.add(i+"");
        }
    }
}
