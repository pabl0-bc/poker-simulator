package logic;

import java.util.*;

import objects.Card;
import objects.Hand;
import objects.Player;

public class HandComparator implements Comparator<Player> {

	@Override
	public int compare(Player player1, Player player2) {

		
		Card firstCard1 = player1.getHand().get(0);
		Card firstCard2 = player2.getHand().get(0);
		Card lastCard1 = player1.getHand().get(player1.getHand().size() - 1);
		Card lastCard2 = player2.getHand().get(player2.getHand().size() - 1);


		switch (player1.getRank()) {
		
			// STRAIGHT FLUSH
			case 0: { // todo bien, REVISADO
	
				if (firstCard1.get_num() == firstCard2.get_num() || player1.getHand().equals(player2.getHand()))
					return 0;
	
				else if (firstCard2.get_num() > firstCard1.get_num()) {
					return 1;
				}
	
				break;
			}
	
			// POKER/QUADS
			case 1: { // todo bien, REVISADO
	
				// el quads está en la mesa
				if (firstCard1.get_num() == firstCard2.get_num()) {
					if (lastCard1.get_num() == lastCard2.get_num())
						return 0; // tanto el cuarteto como el kicker son iguales, empate
	
					else if (lastCard1.get_num() < lastCard2.get_num())
						return 1; // el jugador 2 tiene un kicker mayor
	
				} else if (firstCard1.get_num() < firstCard2.get_num())
					return 1; // el jugador 2 tiene quads con mayor valor
	
				break;
			}
	
			// FULL
			case 2: { // todo bien. REVISADO
	
				if (firstCard1.get_num() == firstCard2.get_num()) {// tienen el trio en comun
					if (lastCard1.get_num() == lastCard2.get_num())
						return 0; // tienen el mismo full
	
					else if (lastCard1.get_num() < lastCard2.get_num())
						return 1; // el jugador 2 tiene una pareja mayor
				}
	
				else if (firstCard1.get_num() < firstCard2.get_num())
					return 1; // el jugador 2 tiene un trio mayor
	
				break;
			}
	
			// FLUSH
			case 3: { // todo bien REVISADO
	
				if (player1.getHand().equals(player2.getHand()))
					return 0;// el flush estaba en la mesa
	
				else if (firstCard2.get_num() > firstCard1.get_num())
					return 1; // gana el jugador
	
				else if (firstCard2.get_num() == firstCard1.get_num()) { // cada jugador tiene un mix entre mesa y cartas
																			// propias
					int i = 1;
	
					while (i < player1.getHand().size()) {
						if (player2.getHand().get(i).get_num() > player1.getHand().get(i).get_num())
							return 1; // el jugador 2 gana
	
						++i;
					}
				}
	
				break;
			}
	
			// STRAIGHT
			case 4: { // todo bien. REVISADO
	
				if (firstCard1.get_num() == firstCard2.get_num())
					return 0;
	
				else if (firstCard2.get_num() > firstCard1.get_num()) {
					return 1;
				}
	
				break;
			}
	
			// TRIO/THREEOFAKIND
			case 5: { // todo bien. REVISADO
	
				if (firstCard1.get_num() == firstCard2.get_num()) {
					for (int i = 3; i < player1.getHand().size(); ++i) {
						if (player2.getHand().get(i).get_num() > player1.getHand().get(i).get_num())
							return 1; // gana el jugador 2
						
						else if(player2.getHand().get(i).get_num() < player1.getHand().get(i).get_num())
							return -1; // gana el jugador 1
	
					}
					
					return 0; // si salgo del for, es que sus manos son iguales en numero por lo que empatan
					
				}
	
				else if (firstCard2.get_num() > firstCard1.get_num())
					return 1;
	
				break;
			}
	
			// TWO PAIR
			case 6: {
				// todo bien. REVISADO
				if (firstCard2.get_num() == firstCard1.get_num() && // tienen las mismas parejas
						player2.getHand().get(2).get_num() == player1.getHand().get(2).get_num()) {
	
					// miro la carta que me sobra
					if (lastCard2.get_num() > lastCard1.get_num())
						return 1;
	
					else if (lastCard2.get_num() == lastCard1.get_num())
						return 0;
				}
				// miro primera pareja
				else if (firstCard2.get_num() > firstCard1.get_num())
					return 1;
				// si son iguales miro la segunda pareja
				else if (firstCard2.get_num() == firstCard2.get_num()
						&& player2.getHand().get(2).get_num() > player1.getHand().get(2).get_num())
					return 1;
	
				break;
			}
	
			// PAIR
			case 7: {
	
				if (firstCard1.get_num() == firstCard2.get_num()) {
	
					for (int i = 2; i < player1.getHand().size(); i++) {
						if (player2.getHand().get(i).get_num() > player1.getHand().get(i).get_num())
							return 1; // gana el jugador 2
	
						else if (player2.getHand().get(i).get_num() < player1.getHand().get(i).get_num())
							return -1; // gana el jugador 1
					}
	
					return 0; // si salgo del for, es que sus manos son iguales en numero por lo que empatan
				}
	
				if (firstCard2.get_num() > firstCard1.get_num())
					return 1;
	
				if (firstCard2.get_num() < firstCard1.get_num())
					return -1;
				break;
			}
	
			// NO MADE HAND
			case 8: {
				
				if (firstCard2.get_num() > firstCard1.get_num())
					return 1;
	
				else if(firstCard2.get_num() == firstCard1.get_num()){
					for (int i = 0; i < player1.getHand().size(); ++i) {
						if (player2.getHand().get(i).get_num() > player1.getHand().get(i).get_num())
							return 1; // gana el jugador 2
						
						else if(player2.getHand().get(i).get_num() < player1.getHand().get(i).get_num())
							return -1; // gana el jugador 1
	
					}
					
					return 0; // si salgo del for, es que sus manos son iguales en numero por lo que empatan
				}
	
			}
	
		}
		
		return -1;
	}
}