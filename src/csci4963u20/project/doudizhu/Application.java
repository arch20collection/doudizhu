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
        
        // deal card
        Stack<Card> library = new Stack<>();
        ArrayList<Card> boxes = new ArrayList<>();
        
        public String numToString(int number)
        {
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
            }
        }
//         ArrayList<String> numbers = new ArrayList<>();
//         ArrayList<String> names = new ArrayList<>();
//         for(int i = 3; i <= 16; i++) // 3, 4, ..., 10, J, Q, K, A, 2, Joker
//         {
//             numbers.add(i+"");
//         }
//         numbers.add(16+"");
//         for(int i = 3; i <= 10; i++)
//         {
//             names.add(i+"");
//         }
//         names.add("J");
//         names.add("Q");
//         names.add("K");
//         names.add("A");
//         names.add("2");
//         names.add("joker");
//         names.add("joker");

//         for(int i = 0; i < 4; i++)
//         {
//             for(int j = 0; j <= 12; j++)
//             {
//                 boxes.add(names[i] + numbers[i]);
//             }
//         }
//         boxes.add(names[13] + numbers[13]);
//         boxes.add(names[14] + numbers[14]);
        for(int i = 0; i < 4; i++)
        {
            for(int j = 3; j < 16; j++)
            {
                if(j <= 10)
                    library.push(new Card(j, Integer.ToString(j)))
                else
                    library.push(new Card(j, numToString(j)));
            }
        }
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
    }
}
