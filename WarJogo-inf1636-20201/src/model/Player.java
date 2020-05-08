package model;
import java.util.ArrayList;

public class Player {
	private String name;
	private Color color;
	private Objective objective;
	private ArrayList<Card> Cards;
	private ArrayList<Territory> Territories;
	
	
	
	public Player(String n,Color c,Objective o) {
		
		name = n;
		color = c;
		objective = o;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	
	
}
