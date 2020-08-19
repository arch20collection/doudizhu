package csci4963u20.project.doudizhu;

import java.io.*;
import java.util.*;

public class Deck implements Serializable {
	private ArrayList<Card> cards;
	private int card_count;

	/**
	 * Default empty constructor.
	 */
	public Deck() {
		cards = new ArrayList<>();
		card_count = 0;
	}

	/**
	 * Constructor from deck size.
	 * 
	 * @param size deck size
	 */
	public Deck(int size) {
		card_count = size;
		cards = new ArrayList<>(card_count);
	}

	/**
	 * Constructor from deck size.
	 * 
	 * @param input_cards a list of cards
	 */
	public Deck(List<Card> input_cards) {
		card_count = input_cards.size();
		cards = new ArrayList<>(card_count);
		for (Card c : input_cards) {
			cards.add(new Card(c.getValue(), c.getName()));
		}
	}

	/**
	 * Add a Card to this Deck.
	 * 
	 * @param c Card to be added
	 * @return boolean if Card is added successfully
	 */
	public boolean add(Card c) {
		boolean ret = cards.add(c);
		if (ret) {
			card_count++;
		}
		return ret;
	}

	/**
	 * Return the size of the deck
	 * 
	 * @return the size of deck
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * Shuffle the deck.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Sort the deck.
	 */
	public void sortDeck() {
		Collections.sort(cards);
	}

	public boolean isSingle() {
		return cards.size() == 1;
	}
	
	/**
	 * Check if deck is trio and single (sandaiyi).
	 * 
	 * @return boolean if deck is trio and single
	 */
	public boolean isTrioSingle() {
		if (cards.size() != 4) {
			return false;
		}
		Set<Card> pool = new TreeSet<Card>();
		for (int i = 0; i < 4; i++) {
			pool.add(cards.get(i));
		}
		if (pool.size() == 2) {
			return true;
		}
		return false;
	}

	/**
	 * Check if deck is trio and pair (san'dai'er).
	 * 
	 * @return boolean if deck is trio and pair
	 */
	public boolean isTrioPair() {
		if (cards.size() != 5) {
			return false;
		}

		Set<Card> pool = new TreeSet<Card>();
		for (int i = 0; i < 5; i++) {
			pool.add(cards.get(i));
		}
		if (pool.size() == 2) {
			Deck tempDeck = new Deck(this.cards);
			if (tempDeck.cards.get(0).compareTo(tempDeck.cards.get(1)) == -1
					|| tempDeck.cards.get(3).compareTo(tempDeck.cards.get(4)) == -1) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Check if deck is bomb (zhadan).
	 * 
	 * @return boolean if boolean is bomb
	 */
	public boolean isBomb() {
		if (cards.size() != 4)
			return false;
		Card one = cards.get(0);
		Card two = cards.get(1);
		Card three = cards.get(2);
		Card four = cards.get(3);

		return (one.equals(two) && one.equals(three) && one.equals(four));
	}

	/**
	 * Check if deck is pair (duizi).
	 * 
	 * @return boolean if deck is pair
	 */
	public boolean isPair() {
		if (cards.size() != 2)
			return false;
		Card one = cards.get(0);
		Card two = cards.get(1);
		return one.equals(two);
	}

	/**
	 * Check if deck is joker bomb (wangzha).
	 * 
	 * @return boolean if deck is joker bomb
	 */
	public boolean isJokerBomb() {
		boolean ret = isPair();
		return ret && cards.get(0).getValue() == 16;
	}

	/**
	 * Check if deck is sequence (shunzi).
	 * 
	 * @return boolean if deck is sequence
	 */
	public boolean isSequence() {
		if (cards.size() < 3) {
			return false;
		}
		for (int i = 0; i < cards.size(); i++) {
			Card temp = cards.get(i);
			if (i != 0) {
				Card previous = cards.get(i - 1);
				if (previous.getValue() != temp.getValue() - 1)
					return false;
			}
		}
		return true;
	}

	/**
	 * Print the deck.
	 */
	public void printDeck() {
		for (Card c : cards) {
			System.out.print(c.getName());
			System.out.print(" ");
		}
		System.out.println();
	}

	/**
	 * Get an iterator of cards
	 * 
	 * @return the iterator of cards
	 */
	public Iterator<Card> getIterator() {
		return cards.iterator();
	}

	public CombinationType checkValid() {
		if (isBomb()) {
			return CombinationType.Bomb;
		}
		if (isJokerBomb()) {
			return CombinationType.JokerBomb;
		}
		if (isPair()) {
			return CombinationType.Pair;
		}
		if (isSequence()) {
			return CombinationType.Sequence;
		}
		if (isTrioPair()) {
			return CombinationType.TiroPair;
		}
		if (isTrioSingle()) {
			return CombinationType.TrioSingle;
		}
		if (isSingle()) {
			return CombinationType.Single;
		}
		return CombinationType.Invalid;
	}

	/**
	 * Choose cards to send
	 * 
	 * @param pattern pattern of the current round
	 * @param chosen  cards chosen by user
	 * @return Deck of cards chosen by user according to pattern
	 */
	public Deck chooseCards(String pattern, ArrayList<Card> chosen) {
		Deck ret = new Deck();
		// choose cards according to pattern and chosen array

		// return a deck
		return ret;
	}

	/**
	 * Split a full deck in to 3 deck, 1 has 20 cards, others each have 17 cards
	 * 
	 * @return an array of Deck
	 */
	public Deck[] dealFullDeck(int lord) {
		shuffle();
		Deck[] splitDeck = new Deck[3];
		splitDeck[lord] = new Deck(this.cards.subList(0, 20));
		splitDeck[lord].sortDeck();
		splitDeck[lord].printDeck();
		System.out.println();
		int p1, p2;
		if (lord == 0) {
			p1 = 1;
			p2 = 2;
		} else if (lord == 1) {
			p1 = 0;
			p2 = 2;
		} else {
			p1 = 0;
			p2 = 1;
		}
		splitDeck[p1] = new Deck(this.cards.subList(20, 37));
		splitDeck[p1].sortDeck();
		splitDeck[p1].printDeck();
		System.out.println();
		splitDeck[p2] = new Deck(this.cards.subList(37, 54));
		splitDeck[p2].sortDeck();
		splitDeck[p2].printDeck();
		System.out.println();
		return splitDeck;
	}

	/**
	 * Get a full deck of card(54 cards)
	 * 
	 * @return the full deck
	 */
	public static Deck generateFullDeck() {
		String[] card_name = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "Joker" };
		Deck fullDeck = new Deck(54);
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				fullDeck.add(new Card(i + 3, card_name[i]));
//    			System.out.println("Card added " + (i+3) + card_name[i]);
				if (fullDeck.size() == 54) {
					break;
				}
			}
		}
		return fullDeck;
	}

	/**
	 * Get an iterator of the deck
	 * 
	 * @return iterator of the deck
	 */
	public Iterator<Card> cardIterator() {
		return cards.iterator();
	}

	public static void main(String[] arg) {
		Deck full = Deck.generateFullDeck();
		Deck[] split = full.dealFullDeck(0);
	}

}
