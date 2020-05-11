package model;
import java.util.*;

public class Player {
	private String name;
	private Color color;
	private Objective objective;
	private ArrayList<Card> Cards = new ArrayList<Card>();
	private ArrayList<Territory> Territories = new ArrayList<Territory>();
	
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
	public Player(String n,Color c) {
		name = n;
		color = c;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getObjDescription()
	{
		return objective.description;
	}
	
	public void setObjective(Objective o)
	{
		this.objective = o;
	}
	
	public void receiveCard(Card c)
	{
		Cards.add(c);
	}
	
	public List<Card> getAllCards()
	{
		return Collections.unmodifiableList(Cards);
	}
	
	public void setTerritory(Territory t, int army)
	{
		t.setColor(this.color);
		t.setArmy(army);
	}
}
