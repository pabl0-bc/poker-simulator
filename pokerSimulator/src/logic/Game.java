package logic;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import controller.Controller;
import objects.Card;
import objects.Deck;
import objects.Hand;
import objects.Pair;
import objects.Player;

public class Game {

	private Controller _ctrl;
	private Deck _deck;
	private int cont = 0;
	public static Map<String, String> dictionary;
	private Map<Player, ArrayList<ArrayList<Card>>> combinations;
	// private ArrayList<Player> players;

	public Game(Controller ctrl) {
		_ctrl = ctrl;
		dictionary = new HashMap<>();
		combinations = new HashMap<>();
		// _deck = deck;
		// this.players = players;
	}

	public Map<Player, Double> checkOmahaWinner(ArrayList<Player> players, ArrayList<ArrayList<Card>> tableCards,
			boolean river) {
		Map<Player, Double> winners = new HashMap<>();
		combinations = new HashMap<>();

		for (int i = 0; i < players.size(); i++) {
			winners.put(players.get(i), 0.0);
		}

		HandComparator hC = new HandComparator();

		for (Player p : players) {
			ArrayList<ArrayList<Card>> playersComb = new ArrayList<>();
			CombinationGenerator.generateOmahaCombAux(p.getCards(), 2, 0, new ArrayList<Card>(), playersComb, 0);
			combinations.put(p, playersComb);
		}
		ArrayList<ArrayList<Card>> resul = new ArrayList<>();
		ArrayList<Pair> bestHands = new ArrayList<>();

		if (!river) {
			for (ArrayList<Card> boardComb : tableCards) {
				ArrayList<Player> bestH = new ArrayList<>();

				for (Player p : combinations.keySet()) {
					ArrayList<Pair> playerBestHand = new ArrayList<>();

					for (ArrayList<Card> playerCards : combinations.get(p)) {
						ArrayList<Card> aux = new ArrayList<>(boardComb);
						aux.addAll(playerCards);
						Pair result = checkHand(aux, p);

						if (playerBestHand.isEmpty()) {
							playerBestHand.add(result);
						} else {
							if (playerBestHand.get(0).getFirst() == result.getFirst()) {
								Player p1 = new Player(p.getIndex());
								p1.createHand(playerBestHand.get(0).getSecond());
								p1.setRank(playerBestHand.get(0).getFirst());
								Player p2 = new Player(p.getIndex());
								p2.createHand(result.getSecond());
								p2.setRank(result.getFirst());
								
								int r = hC.compare(p1, p2);
								
								if(r == 1) {
									playerBestHand.clear();
									playerBestHand.add(result);
								}
								
							}
							else if (playerBestHand.get(0).getFirst() > result.getFirst()) {
								playerBestHand.clear();
								playerBestHand.add(result);
							}
						}
					}

//					if (playerBestHand.size() > 1) {
//
//						for (int i = 0; i < playerBestHand.size() - 1; i++) {
//							if (playerBestHand.get(i).getFirst() < playerBestHand.get(i + 1).getFirst()) {
//								playerBestHand.remove(playerBestHand.get(i + 1));
//								i--;
//							}
//						}
//
//						for (int i = 0; i < playerBestHand.size() - 1; i++) {
//
//							Player p1 = new Player(p.getIndex());
//							p1.createHand(playerBestHand.get(i).getSecond());
//							p1.setRank(playerBestHand.get(i).getFirst());
//							Player p2 = new Player(p.getIndex());
//							p2.createHand(playerBestHand.get(i + 1).getSecond());
//							p2.setRank(playerBestHand.get(i + 1).getFirst());
//
//							int res = hC.compare(p1, p2);
//
//							if (res == 1) {
//								playerBestHand.remove(i);
//								i--;
//							}
//							// los dos tienen una mano igual y pueden o ganar o que otro les gane a los dos
//							else if (res == 0) {
//								playerBestHand.remove(i + 1);
//							} else if (res == -1) {
//								playerBestHand.remove(i + 1);
//							}
//						}
//					}
					p.setRank(playerBestHand.get(0).getFirst());
					p.createHand(playerBestHand.get(0).getSecond());
					bestH.add(playerBestHand.get(0).getPlayer());
				}
				mergeSort(bestH);

				if (bestH.size() > 1) {
					if (bestH.get(0).getRank() < bestH.get(1).getRank()) {
						winners.put(bestH.get(0), winners.get(bestH.get(0)) + 1);
					} else {
						for (int i = 0; i < bestH.size() - 1; i++) {
							int res = -2;

							res = hC.compare(bestH.get(i), bestH.get(i + 1));

							if (res == 1) {
								bestH.remove(i);
								i--;
							} else if (res == 0) {
								bestH.remove(i + 1);
							} else if (res == -1) {
								bestH.remove(i + 1);
							}
						}
						double pts = 1 / (double) bestH.size();
						for (Player p2 : bestH) {
							winners.put(p2, winners.get(p2) + pts);
						}
					}
				} else {
					if (bestH.size() == 1) {
						winners.put(bestH.get(0), winners.get(bestH.get(0)) + 1);
					}
				}

			}
		} else {
			ArrayList<Player> allBestHands = new ArrayList<>();
			for (Player p : combinations.keySet()) {
				ArrayList<Pair> bestHand = new ArrayList<>();

				for (ArrayList<Card> playerComb : combinations.get(p)) {

					for (ArrayList<Card> boardComb : tableCards) {

						ArrayList<Card> actComb = new ArrayList<>(playerComb);
						actComb.addAll(boardComb);

						Pair res = checkHand(actComb, p);

						if (bestHand.isEmpty()) {
							bestHand.add(res);
						} else {
							if (bestHand.get(0).getFirst() == res.getFirst()) {
								Player p1 = new Player(p.getIndex());
								p1.setRank(res.getFirst());
								p1.createHand(res.getSecond());
								Player p2 = new Player(p.getIndex());
								p2.createHand(bestHand.get(0).getSecond());
								p2.setRank(bestHand.get(0).getFirst());
								int a = hC.compare(p1, p2);

								if (a == -1) {
									bestHand.clear();
									bestHand.add(res);
								}

							} else if (bestHand.get(0).getFirst() > res.getFirst()) {
								bestHand.clear();
								bestHand.add(res);
							}
						}
					}
				}
				p.createHand(bestHand.get(0).getSecond());
				p.setRank(bestHand.get(0).getFirst());
				allBestHands.add(p);
			}

			mergeSort(allBestHands);

			for (int i = 0; i < allBestHands.size() - 1; i++) {
				if (allBestHands.get(i).getRank() < allBestHands.get(i + 1).getRank()) {
					allBestHands.remove(allBestHands.get(i + 1));
					i--;
				}
			}

			if (!allBestHands.isEmpty()) {
				if (allBestHands.size() == 1) {
					winners.put(allBestHands.get(0), 10.0);
				} else {

					if (allBestHands.get(0).getRank() < allBestHands.get(1).getRank()) {
						winners.put(allBestHands.get(0), 10.0);
					} else {
						if (allBestHands.size() > 1) {
							for (int i = 0; i < allBestHands.size() - 1; i++) {
								if (allBestHands.get(i).getRank() == allBestHands.get(i + 1).getRank()) {
									int res = -2;

									res = hC.compare(allBestHands.get(i), allBestHands.get(i + 1));

									if (res == 1) {
										allBestHands.remove(i);
										i--;
									}
									// los dos tienen una mano igual y pueden o ganar o que otro les gane a los dos
									else if (res == 0) {
										allBestHands.remove(i + 1);
									} else if (res == -1) {
										allBestHands.remove(i + 1);
									}
								} else {
									allBestHands.remove(i + 1);
								}
							}
							if (allBestHands.size() > 1) {
								int res = -2;

								res = hC.compare(allBestHands.get(0), allBestHands.get(1));

								if (res == 1) {
									allBestHands.remove(0);
								}
								// los dos tienen una mano igual y pueden o ganar o que otro les gane a los dos
								else if (res == 0) {
									allBestHands.remove(1);
								} else if (res == -1) {
									allBestHands.remove(1);
								}
							}
						}
						double pts = 10 / (double) allBestHands.size();

						for (Player p : allBestHands) {
							winners.put(p, pts);
						}
					}
				}
			}
		}

		return winners;

	}

	public ArrayList<Player> checkWinner(ArrayList<Player> players, ArrayList<Card> tableCards) {
		ArrayList<Player> winners = new ArrayList<Player>();

		if (!players.isEmpty()) {
			int numPlayers = players.size();
			int[] playerWins = new int[numPlayers];

			// ArrayList<Card> remainingCards = new ArrayList<>(_deck);

			ArrayList<Player> bestHands = new ArrayList<Player>();

			for (int i = 0; i < numPlayers; i++) { // para cada jugador, creo una mano con sus cartas y las de la mesa

				ArrayList<Card> currentHand = new ArrayList<Card>(players.get(i).getCards());
				currentHand.addAll(tableCards);

				// miro cual es su winning hand
				Pair bestHand = checkHand(currentHand, players.get(i));

				// guard el rank en el jugador
				players.get(i).setRank(bestHand.getFirst());

				// me guardo su mano en su clase por si hay dos indices ganadores, poder
				// comparar
				try {
					players.get(i).createHand(bestHand.getSecond());

				} catch (Exception e) {
					// TODO: handle exception
					e.getMessage();
				}
				// hago un array de jugadores auxiliar
				bestHands.add(players.get(i));

			}

			mergeSort(bestHands); // ordeno de menor a mayor mi array de jugadores en base a su rank

			int counter = 1;
			Player p = bestHands.get(0);
			int i = 1;

			// solo hay un ganador
			if (p.getRank() != bestHands.get(1).getRank()) {
				winners.add(p);
				return winners;
			}

			else {
				// entra en el while si hay mas de un posible ganador y sale instant cuando ya
				// no tienen el rank igual
				while (i < bestHands.size() && bestHands.get(i).getRank() == p.getRank()) {
					counter++;
					i++;
				}
				// Compara manos
				HandComparator hC = new HandComparator();
				Player winner = bestHands.get(0);
				ArrayList<Integer> indexes = new ArrayList<>();

				for (int j = 1; j < counter; j++) {
					int result = hC.compare(winner, bestHands.get(j));
					// el segundo tiene una mano mejor pero aun no sabemos si ha ganado
					if (result == 1) {
						winner = bestHands.get(j);
						indexes.clear();
					}
					// los dos tienen una mano igual y pueden o ganar o que otro les gane a los dos
					else if (result == 0) {
						indexes.add(j);
					}

				}

				winners.add(winner);
				if (!indexes.isEmpty())
					for (int k : indexes)
						winners.add(bestHands.get(k));

			}
		}

		return winners;
	}

	public static void mergeSort(ArrayList<Player> lista) {
		if (lista.size() <= 1) {
			return; // La lista ya está ordenada si tiene 0 o 1 elemento
		}

		// Dividir la lista en mitades izquierda y derecha
		int medio = lista.size() / 2;
		ArrayList<Player> izquierda = new ArrayList<>(lista.subList(0, medio));
		ArrayList<Player> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

		// Llamadas recursivas para ordenar las dos mitades
		mergeSort(izquierda);
		mergeSort(derecha);

		// Combinar las dos mitades ordenadas
		merge(izquierda, derecha, lista);
	}

	private static void merge(ArrayList<Player> izquierda, ArrayList<Player> derecha, ArrayList<Player> resultado) {
		int i = 0; // Índice para la lista izquierda
		int j = 0; // Índice para la lista derecha
		int k = 0; // Índice para la lista resultado

		// Combinar las listas izquierda y derecha en la lista resultado
		while (i < izquierda.size() && j < derecha.size()) {
			if (izquierda.get(i).getRank() <= derecha.get(j).getRank()) {
				resultado.set(k, izquierda.get(i));
				i++;
			} else {
				resultado.set(k, derecha.get(j));
				j++;
			}
			k++;
		}

		// Copiar los elementos restantes de la lista izquierda
		while (i < izquierda.size()) {
			resultado.set(k, izquierda.get(i));
			i++;
			k++;
		}

		// Copiar los elementos restantes de la lista derecha
		while (j < derecha.size()) {
			resultado.set(k, derecha.get(j));
			j++;
			k++;
		}
	}

	private void buildDiccionary() {
		dictionary.put("h", "Hearts");
		dictionary.put("d", "Diamonds");
		dictionary.put("s", "Spades");
		dictionary.put("c", "Clubs");
	}

	public ArrayList<Card> checkPair(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();
		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).get_num() == hand.get(i + 1).get_num()) {
				ret.add(hand.get(i));
				ret.add(hand.get(i + 1));
				return ret;
			}
		}
		return ret;
	}

	public ArrayList<Card> checkTwoPair(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();
		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).get_num() == hand.get(i + 1).get_num()) {
				ret.add(hand.get(i));
				ret.add(hand.get(i + 1));
				++i;
				if (ret.size() == 4)
					return ret;
			}
		}

		if (ret.size() == 4)
			return ret.size() == 4 ? ret : new ArrayList<>();

		else
			ret.clear();

		return ret.size() == 4 ? ret : new ArrayList<>();
	}

	public ArrayList<Card> checkThreeOfaKind(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();
		int cont = 1;
		for (int i = 0; i < hand.size() - 1; i++) {
			if (cont == 3) {
				if (hand.get(i - 1).get_num() == hand.get(i).get_num()) {
					ret.add(hand.get(i));
					return ret.size() == 3 ? ret : new ArrayList<>();
				} else {// nunca va a entrar aqui, pero por si acaso lo dejamos
					ret.clear();
					ret.add(hand.get(i));
					cont = 1;
				}
			}

			if (hand.get(i).get_num() == hand.get(i + 1).get_num()) {
				ret.add(hand.get(i));
				cont++;
			} else {
				ret.clear();
				cont = 1;
			}
		}

		if (ret.size() != 0 && ret.get(0).get_num() == hand.get(hand.size() - 1).get_num()
				&& !ret.contains(hand.get(hand.size() - 1))) {
			ret.add(hand.get(hand.size() - 1));
		}

		if (ret.size() != 3) {
			ret.clear();
		}
		return ret.size() == 3 ? ret : new ArrayList<>();
	}

	public ArrayList<Card> checkStraight(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();

		ret.add(hand.get(0));
		for (int i = 1; i < hand.size(); ++i) {
			if (ret.size() == 5) {
				return ret.size() == 5 ? ret : new ArrayList<>();
			}
			if (ret.get(ret.size() - 1).get_num() - 1 == hand.get(i).get_num()) {
				ret.add(hand.get(i));
			} else if (ret.get(ret.size() - 1).get_num() != hand.get(i).get_num()) {
				ret.clear();
				ret.add(hand.get(i));
			}
		}

		if (ret.size() == 5)
			return ret.size() == 5 ? ret : new ArrayList<>();

		if (ret.size() == 4 && (hand.get(0).get_num() == 14 && ret.get(ret.size() - 1).get_num() == 2)) {
			ret.add(hand.get(0));
			return ret;
		}

		if (ret.size() < 5)
			ret.clear();

		return ret.size() == 5 ? ret : new ArrayList<>();
	}

	public ArrayList<Card> checkFlush(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();
		ArrayList<Card> h = new ArrayList<>(hand);

		Hand.sortByColour(h);

		int counter = 1;
		for (int i = 0; i < h.size() - 1; i++) {

			if (h.get(i).getSuit().equals(h.get(i + 1).getSuit())) {
				ret.add(h.get(i));
				counter++;
			} else {
				ret.clear();
				counter = 1;
			}

			if (counter == 5) {
				ret.add(h.get(i + 1));
				return ret.size() == 5 ? ret : new ArrayList<>();
			}
		}

		ret.clear();

		return ret.size() == 5 ? ret : new ArrayList<>();
	}

	public ArrayList<Card> checkFull(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();
		ArrayList<Card> three = new ArrayList<>(checkThreeOfaKind(hand));
		ArrayList<Card> two = new ArrayList<>();
		ArrayList<Card> aux = new ArrayList<>(hand);

		if (three.size() == 3) {
			aux.removeAll(three);
			two = checkPair(aux);
			if (two.size() == 2) {
				ret.addAll(three);
				ret.addAll(two);
				return ret;
			}
		}

		return ret.size() == 5 ? ret : new ArrayList<>();
	}

	public ArrayList<Card> checkPoker(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();
		int cont = 1;
		for (int i = 0; i < hand.size() - 1; i++) {
			if (cont == 4) {
				ret.add(hand.get(i));
				return ret.size() == 4 ? ret : new ArrayList<>();
			}
			if (hand.get(i).get_num() == hand.get(i + 1).get_num()) {
				ret.add(hand.get(i));
				cont++;
			} else {
				ret.clear();
				cont = 1;
			}
		}
		// se sale en la ultima vuelta, tiene que mirar el ultimo numero
		if (cont == 4) {
			ret.add(hand.get(hand.size() - 1));
			return ret.size() == 4 ? ret : new ArrayList<>();
		}

		ret.clear();
		return ret.size() == 4 ? ret : new ArrayList<>();
	}

	public ArrayList<Card> checkStraightFlush(List<Card> hand) {
		ArrayList<Card> ret = new ArrayList<>();

		ret.add(hand.get(0));
		for (int i = 1; i < hand.size(); ++i) {
			if (ret.get(ret.size() - 1).get_num() - 1 == hand.get(i).get_num()
					&& ret.get(ret.size() - 1).get_suit().equals(hand.get(i).get_suit())) {
				ret.add(hand.get(i));
			} else if (ret.get(ret.size() - 1).get_num() != hand.get(i).get_num()) {
				ret.clear();
				ret.add(hand.get(i));
			}
		}

		if (ret.size() == 4 && ((hand.get(0).get_num() == 14 && ret.get(ret.size() - 1).get_num() == 2))) {

			int j = 0;
			while (j < hand.size() - 1 && hand.get(j).get_num() == 14) {
				if (hand.get(j).get_suit().equals(ret.get(0).get_suit())) {
					ret.add(hand.get(j));
					return ret.size() == 5 ? ret : new ArrayList<>();
				}
				j++;
			}
		}
		if (ret.size() < 5)
			ret.clear();

		return ret.size() == 5 ? ret : new ArrayList<>();
	}

	public Pair checkHand(ArrayList<Card> hand, Player p) {

		ArrayList<Card> a = new ArrayList<>();
		ArrayList<Card> a2 = new ArrayList<>();
		String aux = "";

		Hand.quickSort(hand, 0, hand.size() - 1);

		a = checkStraightFlush(hand);
		if (!a.isEmpty()) {
			return new Pair(0, a, p);
		}

		a = checkPoker(hand);
		if (!a.isEmpty() && aux.equals("")) {
			addBestCards(a, hand);
			return new Pair(1, a, p);
		}

		a = checkFull(hand);
		if (!a.isEmpty() && aux.equals("")) {
			return new Pair(2, a, p);
		}

		a = checkFlush(hand);
		if (!a.isEmpty() && aux.equals("")) {
			return new Pair(3, a, p);
		}

		a = checkStraight(hand);
		if (!a.isEmpty() && aux.equals("")) {
			return new Pair(4, a, p);
		}

		a = checkThreeOfaKind(hand);
		if (!a.isEmpty() && aux.equals("")) {
			addBestCards(a, hand);
			return new Pair(5, a, p);
		}

		a = checkTwoPair(hand);
		if (!a.isEmpty() && aux.equals("")) {
			addBestCards(a, hand);
			return new Pair(6, a, p);
		}
		
		a = checkPair(hand);
		if (!a.isEmpty() && aux.equals("")) {
			addBestCards(a, hand);
			return new Pair(7, a, p);
		}

		for (int i = 0; i < 5; ++i)
			a.add(hand.get(i));

		return new Pair(8, a, p);
	}

	private void addBestCards(ArrayList<Card> ret, ArrayList<Card> hand) {
		ArrayList<Card> aux = new ArrayList<>();

		for (Card card : hand) {
			if (!ret.contains(card)) {
				aux.add(card);
			}
		}
		// Hand h = new Hand(aux);
		if (aux.size() > 1)
			Hand.quickSort(aux, 0, aux.size() - 1);

		if (ret.size() == 4) {
			ret.add(aux.get(0));
		} else if (ret.size() == 3) {
			ret.add(aux.get(0));
			ret.add(aux.get(1));
		} else if (ret.size() == 2) {
			ret.add(aux.get(0));
			ret.add(aux.get(1));
			ret.add(aux.get(2));
		}

	}

}