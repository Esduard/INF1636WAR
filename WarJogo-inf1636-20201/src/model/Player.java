package model;
import java.util.ArrayList;
import java.util.Scanner; 

public class Player {
	private String name;
	private Color color;
	private Objective objective;
	private ArrayList<Card> Cards;
	private ArrayList<Territory> Territories;
	
	public static ArrayList<Player> players;
	
	//waiting for view
	/*
	public static boolean generatePlayers(int n_players) {
	int index;
	Scanner scan = new Scanner(System.in);
		
		for(index=0;index<n_players;index++)
		{
			//catch name from swing later
			String name = "name " + Integer.toString(index + 1);
		
		}
		
		
		return true;
	}
	*/
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
