package objects;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Player {
	private double points;
	private boolean fold;
	private double percentage;
	private ArrayList<Card> cards;
	private Hand winningHand;
	private int index;
	private int rank;
	private Hand cardsInHand;
	private DecimalFormat format = new DecimalFormat("#.###");


	public Player(int index) {
		this.index = index;
		points = 0;
		fold = false;
		percentage = 0.0;
		cards = new ArrayList<>();
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int r) {
		this.rank = r;
	}

	public int getIndex() {
		return index;
	}

	public boolean getFold() {
		return fold;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public double getPoints() {
		return points;
	}

	public void setPercentage(double totalComb) {
		this.percentage = (points / totalComb) * 100;
	}

	public void addPoints(double point) {
		points += point;
	}

	public void reset() {
		this.points = 0;
		this.percentage = 0.0;
		this.rank = -1;
		winningHand = new Hand();
	}
	
	public void reset2() {
		this.points = 0;
		this.percentage = 0.0;
		cards = new ArrayList<>();
		fold = false;
		winningHand = new Hand();
		index = -1;
		rank = -1;
		cardsInHand = new Hand();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void createHand(ArrayList<Card> cards) {
		this.winningHand = new Hand(cards);
		ArrayList<Card> aux = new ArrayList<>();
		if (!winningHand.getHand().contains(cards.get(0)))
			aux.add(cards.get(0));

		if (!winningHand.getHand().contains(cards.get(1)))
			aux.add(cards.get(1));

		Hand h = new Hand(aux);
		cardsInHand = new Hand(cards);
		if (!aux.isEmpty() && aux.size() > 1)
			Hand.quickSort(h.getHand(), 0, h.getHand().size() - 1);
		cardsInHand = h;
	}

	public ArrayList<Card> getHand() {
		return winningHand.getHand();
	}

	public String getCardsToString() {
		String toString = "";

		for (Card c : cards)
			toString += c.get_id();

		return toString;
	}

	public int getNumOfCards() {
		return cards.size();
	}

	public String getPercent() {
		return format.format(percentage);
	}

	public void removeCard(Card c) {
		cards.remove(c);
	}

	public Card getBestCard() {
		if (cards.get(0).get_num() > cards.get(1).get_num())
			return cards.get(0);
		else
			return cards.get(1);
	}

	public Hand cardsInHand() {
		return cardsInHand;
	}
}