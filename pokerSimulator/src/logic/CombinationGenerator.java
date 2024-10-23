package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import objects.Card;
import objects.Deck;
import objects.Player;

public class CombinationGenerator {
	private Game game;
	private Controller ctrl;
	private ArrayList<Player> players;
	private Deck deck;
	private int totalComb;

	public CombinationGenerator(Game game, ArrayList<Player> players, Deck deck) {
		this.game = game;
		this.players = players;
		this.deck = deck;
		this.totalComb = 0;
	}

	public void generateCombinations(ArrayList<Card> cards, ArrayList<Card> board, int k) {
		totalComb = 0;
		if (board.size() == 5) {
			ArrayList<Player> winners = game.checkWinner(players, board);
			totalComb++;

			double pts;

			if (winners.size() > 0) {
				pts = 1 / (double) winners.size();
				for (Player p : winners) {
					p.addPoints(pts);
				}
			}

			for (Player p : players) {
				p.setPercentage(totalComb);
			}
		} else {
			generateCombinationsAux(cards, board, k, 0, new ArrayList<Card>());
			for (Player p : players) {
				p.setPercentage(totalComb);
			}
		}
		System.out.println(totalComb);
	}

	private void generateCombinationsAux(ArrayList<Card> cartas, ArrayList<Card> board, int k, int start,
			ArrayList<Card> actComb) {
		if (k == 0) {
			ArrayList<Player> winners = game.checkWinner(players, new ArrayList<>(actComb));
			totalComb++;
			float pts = 1 / (float) winners.size();
			for (Player p : winners) {
				p.addPoints(pts);
			}
			return;
		}

		if (cartas.size() - start < k) {
			return;
		}

		for (Card card : board) {
			if (!actComb.contains(card))
				actComb.add(card);
		}

		// actComb.addAll(board);

		for (int i = start; i < cartas.size(); i++) {
			actComb.add(cartas.get(i));
			generateCombinationsAux(new ArrayList<>(cartas), new ArrayList<>(board), k - 1, i + 1,
					new ArrayList<>(actComb));
			actComb.remove(actComb.size() - 1);
		}
	}

	public void generateOmahaComb(ArrayList<Card> cartas, ArrayList<Card> board) {
		ArrayList<ArrayList<Card>> boardComb = new ArrayList<>();
		ArrayList<ArrayList<Card>> combAux = new ArrayList<>();
		totalComb = 0;

		if (board.isEmpty())
			generateOmahaCombAux(cartas, 3, 0, new ArrayList<Card>(), boardComb, totalComb);
		else {
			generateOmahaCombAux(cartas, 5 - board.size(), 0, new ArrayList<Card>(), combAux, totalComb);
			for(ArrayList<Card> a : combAux) {
				ArrayList<Card> aux = new ArrayList<>(board);
				aux.addAll(a);
				generateOmahaCombAux(aux, 3, 0, new ArrayList<Card>(), boardComb, totalComb);
			}
		}
		Map<Player, Double> winners = new HashMap<>();
			if(board.size() == 5)
				winners = game.checkOmahaWinner(players, boardComb, true);
			else
				winners = game.checkOmahaWinner(players, boardComb, false);

			double pts;

			if (winners.size() > 0) {
				for (Player p : winners.keySet()) {
					p.addPoints(winners.get(p));
				}

			for (Player p : players) {
				p.setPercentage(boardComb.size());
			}

		}
		System.out.println(boardComb.size());

	}

	public static void generateOmahaCombAux(ArrayList<Card> cards, int k, int start, ArrayList<Card> actComb,
			ArrayList<ArrayList<Card>> combinations, int totalComb) {
		if (k == 0) {
			combinations.add(new ArrayList<>(actComb));
			totalComb++;
			return;
		}

		for (int i = start; i < cards.size(); i++) {
			actComb.add(cards.get(i));
			generateOmahaCombAux(cards, k - 1, i + 1, actComb, combinations, totalComb);
			actComb.remove(actComb.size() - 1);
		}

	}

}
