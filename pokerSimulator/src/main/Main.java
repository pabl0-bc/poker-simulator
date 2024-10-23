package main;

import java.util.ArrayList;

import controller.Controller;
import objects.Deck;
import view.MainWindow;
import objects.Player;

public class Main {
	
	private static Deck deck;
	private static ArrayList<Player> players;
	
	public static void main(String[] args) {
		deck = new Deck();
		
		players = new ArrayList<>();
		for(int i = 0; i < 6; i++) {
			players.add(new Player(i));
		}
		Controller ctrl = new Controller(deck, players);
		MainWindow mW = new MainWindow(deck, players, ctrl);

		
	}
}
