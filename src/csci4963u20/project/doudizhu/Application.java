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
        
        // (发牌) deal card
        ArrayList<String> boxes = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        for(int i = 3; i <= 16; i++)
        {
            numbers.add(i+"");
        }
        numbers.add(16+"");
        for(int i = 3; i <= 10; i++)
        {
            names.add(i+"");
        }
        names.add("J");
        names.add("Q");
        names.add("K");
        names.add("A");
        names.add("2");
        names.add("joker");
        names.add("joker");
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j <= 12; j++)
            {
                boxes.add(names[i] + numbers[i]);
            }
        }
        boxes.add(names[13] + numbers[13]);
        boxes.add(names[14] + numbers[14]);
        Collections.shuffle(boxes);
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        
        for(int i = 0; i < boxes.size(); i++)
        {
            if(i > 50)
            {
                dipai.add(boxes.get(i));
            }
            else
            {
                if (i % 3 == 0)
                {
                    player1.add(boxes.get(i));
                }
                else if(i % 3 == 1)
                {
                    player2.add(boxes.get(i));
                }
                else
                {
                    player3.add(boxes.get(i));
                }
            }
        }
    }
}
