package csci4963u20.project.doudizhu;
import java.util.*;

public class Deck {
    private ArrayList<Card> cards;
    private int card_count;

    /**
     * Default empty constructor.
     */
    public Deck(){
        cards = new ArrayList<>();
        card_count = 0;
    }

    /**
     * Constructor from deck size.
     * @param size deck size
     */
    public Deck(int size){
        card_count = size;
        cards = new ArrayList<>(card_count);
    }
    
    /**
     * Constructor from deck size.
     * @param size deck size
     */
    public Deck(List<Card> input_cards){
        card_count = input_cards.size();
        cards = new ArrayList<>(card_count);
        for(Card c : input_cards) {
        	cards.add(new Card(c.getValue(), c.getName()));
        }
    }

    /**
     * Add a Card to this Deck.
     * @param c Card to be added
     * @return boolean if Card is added successfully
     */
    public boolean add(Card c){
        boolean ret = cards.add(c);
        if(ret){ card_count++; }
        return ret;
    }
    
    /**
     * Return the size of the deck
     * @return the size of deck
     */
    public int size() {
    	return cards.size();
    }


    /**
     * Shuffle the deck.
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Sort the deck.
     */
    public void sortDeck(){
        Collections.sort(cards, Collections.reverseOrder());
    }

    /**
     * Check if deck is trio and single (sandaiyi).
     * @return boolean if deck is trio and single
     */
    public boolean isTrioSingle(){
        if(cards.size()!=4){
            return false;
        }
        Set<Card> pool=new TreeSet<Card>();
        for(int i = 0; i < 4; i++){
            pool.add(cards.get(i));
        }
        if(pool.size() == 2){
            return true;
        }
        return false;
    }

    /**
     * Check if deck is trio and pair (san'dai'er).
     * @return boolean if deck is trio and pair
     */
    public boolean isTrioPair(){
        if(cards.size() != 5){
            return false;
        }
        Set<Card> pool=new TreeSet<Card>();
        for(int i = 0; i < 5; i++){
            pool.add(cards.get(i));
        }
        if(pool.size() == 2){
            return true;
        }
        return false;
    }


    /**
     * Check if deck is bomb (zhadan).
     * @return boolean if boolean is bomb
     */
    public boolean isBomb(){
        if(cards.size()!=4) return false;
        Card one=cards.get(0);
        Card two=cards.get(1);
        Card three=cards.get(2);
        Card four=cards.get(3);

        return ( one.equals(two) && one.equals(three) &&one.equals(four) );
    }

    /**
     * Check if deck is pair (duizi).
     * @return boolean if deck is pair
     */
    public boolean isPair(){
        if(cards.size()!=2) return false;
        Card one=cards.get(0);
        Card two=cards.get(1);
        return one.equals(two);
    }

    /**
     * Check if deck is joker bomb (wangzha).
     * @return boolean if deck is joker bomb
     */
    public boolean isJokerBomb(){
        boolean ret = isPair();
        return ret && cards.get(0).getValue() == 16;
    }

    /**
     * Check if deck is sequence (shunzi).
     * @return boolean if deck is sequence
     */
    public boolean isSequence(){
        for(int i=0;i<cards.size();i++){
            Card temp=cards.get(i);
            if(i!=0){
                Card previous=cards.get(i-1);
                if(previous.getValue()!=temp.getValue()-1) return false;
            }
        }
        return true;
    }
    /**
     * Print the deck.
     */
    public void printDeck(){
        for(Card c:cards){
            System.out.println(c.getName());
        }
    }
    
    /**
     * Get an iterator of cards
     * @return the iterator of cards
     */
    public Iterator<Card> getIterator() {
    	return cards.iterator();
    }

    /**
     * Dispense cards
     * @param pattern pattern of the current round (当前这一轮的牌型)
     */
    public Deck chooseCards(String pattern, ArrayList<Integer> chosen){
        Deck ret = new Deck();
        // choose cards according to pattern and chosen array
        if(chosen.size() != 0){

        }
        // return a deck
        return ret;
    }
    
    /**
     * Split a full deck in to 3 deck, 1 has 20 cards, others each have 17 cards
     * @return an array of Deck
     */
    public Deck[] deal() {
    	Deck[] splitDeck = new Deck[3];
    	splitDeck[0] = new Deck(this.cards.subList(0, 20));
    	splitDeck[0].printDeck();
    	System.out.println();
    	splitDeck[1] = new Deck(this.cards.subList(20, 37));
    	splitDeck[1].printDeck();
    	System.out.println();
    	splitDeck[2] = new Deck(this.cards.subList(37, 54));
    	splitDeck[2].printDeck();
    	System.out.println();
    	return splitDeck;
    }
    
    
    
    /**
     * Get a full deck of card(54 cards)
     * @return the full deck
     */
    public static Deck generateFullDeck() {
    	String[] card_name = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "Joker"};
    	Deck fullDeck = new Deck(54);
    	for(int i = 0; i < 14; i++) {
    		for(int j = 0; j < 4; j++) {
    			fullDeck.add(new Card(i+3, card_name[i]));
    			System.out.println("Card added " + (i+3) + card_name[i]);
    			if(fullDeck.size() == 54) {
    				break;
    			}
    		}
    	}
    	return fullDeck;
    }
    
    public static void main(String[] arg) {
    	Deck full = Deck.generateFullDeck();
    	Deck[] split = full.deal();
    }

    public Iterator<Card> cardIterator(){
        return cards.iterator();
    }

}
