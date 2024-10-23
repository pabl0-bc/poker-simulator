package objects;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	private ArrayList<Card> deck;
	String[] suits = {"h", "d", "c", "s"};
	private String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
	
	public Deck() {
		deck = new ArrayList<>();
		initDeck();
	}
	
	
	public void initDeck() {
		deck.clear();
		for(String s : suits) {
			for(String r: ranks) {
				deck.add(new Card(r, s, r + s));

			}
		}
	}
	
	public void removeCard(Card card) {
		deck.remove(card);
	}
	
	public void addCard(Card card) {
		deck.add(card);
	}
	
	public boolean containsCard(Card card) {
		return deck.contains(card);
	}

	public int size() {
		return deck.size();
	}
	public ArrayList<Card> getRaminingCards() {
		return deck;
	}
}
