package objects;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private int first;
    private ArrayList<Card> second ;
    private Player _player;

    public Pair(int first, ArrayList<Card> a, Player player) {
        this.first = first;
        _player = player;
        second = new ArrayList<Card>();
        this.second = a;
    }

    public int getFirst() {
        return first;
    }

    public ArrayList<Card> getSecond() {
        return second;
    }
    
    public Player getPlayer() {
    	return _player;
    }
    
//    public void setFirst(int value) {
//    	first = value;
//    }
//    
//    public void setSecond(ArrayList<Card> cards) {
//    	of
//    }
}
