package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logic.CombinationGenerator;
import logic.Game;
import objects.Card;
import objects.Deck;
import objects.Hand;
import objects.Player;

public class Controller {
	private Game game;
	private ArrayList<Hand> hands;
	private Deck _deck;
	private ArrayList<Player> players;
	private CombinationGenerator cG;
	
	public Controller(Deck deck, ArrayList<Player> players){
		_deck = deck;
		game = new Game(this);
		this.players = players;
		hands = new ArrayList<Hand>();
		cG = new CombinationGenerator(game, this.players, _deck);
	}
	
	public void checkComb(ArrayList<Card> board, int k) {
		for(Player p : players) {
			p.reset();
		}
		cG.generateCombinations(_deck.getRaminingCards(), board, k);
	}
	
	public void checkOmahaComb(ArrayList<Card> board) {
		for(Player p : players) {
			p.reset();
		}
		cG.generateOmahaComb(_deck.getRaminingCards(), board);
	}


	public String checkMultipleHands(String string) {
		
		return null;
	}
	
//	public String checkMultipleHands(Player player) throws IOException {
//		
//		String bestHand = game.checkHand(Player.getHand(), player);
//	    
//	    
//	    return bestHand;
//	}

		
}
