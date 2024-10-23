package objects;

import java.util.ArrayList;

import logic.Rank;

public class Hand {
	private ArrayList<Card> _hand;
	
	public Hand(ArrayList<Card> cards) {
		_hand = cards;
	}
	
	public Hand() {
	}
	
	public static void quickSort(ArrayList<Card> hand, int izq, int der) {

		Card pivote = hand.get(izq);
		int i = izq; 
		int j = der; 
		Card aux;

		while (i < j) { 
			while (hand.get(i).get_num() >= pivote.get_num() && i < j)
				i++; 
			while (hand.get(j).get_num() < pivote.get_num())
				j--; 
			if (i < j) { 
				aux = hand.get(i);
				hand.set(i, hand.get(j));
				hand.set(j, aux);
			}
		}

		hand.set(izq, hand.get(j)); 
		hand.set(j, pivote);

		if (izq < j - 1)
			quickSort(hand, izq, j - 1); 
		if (j + 1 < der)
			quickSort(hand, j + 1, der);
	}

	public ArrayList<Card> getHand() {
		return _hand;
	}
	
	public static final void sortByColour(ArrayList<Card> hand) {
		Card aux;
		
		for(int i = 0; i < hand.size(); i++) {
			for(int j = i + 1; j < hand.size(); j++) {
				if(hand.get(i).getSuit().compareTo(hand.get(j).getSuit()) < 0) {
					aux = hand.get(i);
					hand.set(i, hand.get(j));
					hand.set(j, aux);
				}
			}
		}
		
		for (int i = 0; i < hand.size() - 1; i++) {
			for (int j = i + 1; j < hand.size(); j++) {
				if (hand.get(j).get_num() > hand.get(i).get_num() && hand.get(j).get_suit().equals(hand.get(i).get_suit())) {
					aux = hand.get(i);
					hand.set(i, hand.get(j));
					hand.set(j, aux);
				}
			}
		}
		
	}
	
	public String getCardsToString() {
		String toString = "";
		
		for(Card c : _hand)
			toString += c.get_id();
		
		return toString;
	}

}

