package csci4963u20.project.doudizhu;

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
    }
}
