package model;
import java.util.*;

class Player {
	private String name;
	private Color color;
	private Objective objective;
	private ArrayList<Card> Cards = new ArrayList<Card>();
	private ArrayList<Territory> Territories = new ArrayList<Territory>();
	private int availableArmies;
	private ArrayList<Color> playersKilled = new ArrayList<Color>(); 
	
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
	
	public ArrayList<Color> getPlayersKilled() {
		return playersKilled;
	}
	
	public void KillPlayer(Color c) {
		playersKilled.add(c);
	}
	
	
	public Objective getObj()
	{
		return objective;
	}
	
	public void setObjective(Objective o)
	{
		this.objective = o;
		o.setPlayer(this);
	}
	
	public List<Card> getAllCards()
	{
		return Collections.unmodifiableList(Cards);
	}
	
	public List<Territory> getAllTerritories()
	{
		return Collections.unmodifiableList(Territories);
	}
	
	public int getAvailableArmies()
	{
		return availableArmies;
	}
	
	public int getContinentBonus(Continent[] allContinents)
	{
		int bonus = 0;
		
		for(Continent c:allContinents)
		{
			boolean validBonus = true;
			Territory []continentTerritories = c.getTerritories();
			for(Territory t:continentTerritories)
			{
				if(!(Territories.contains(t)))
				{
					validBonus = false;
					break;
				}
			}
			if(validBonus)
			{
				bonus += c.getBonusArmy();
			}
		}
	
		return bonus;
	}

	public int isTradeViable()
	{
		//change to enum
		int not_viable = 0;
		int viable = 1;
		int obligatory = 2;
		
		if(Cards.size() >= 5)
		{
			return obligatory;
		}
		if(Cards.size() >= 3)
		{
			return viable;
		}
		
		return not_viable;
		
	}
	
	public void draw(Card c)
	{
		Cards.add(c);
	}
	
	public List<Card> cardToTerritory()
	{
		ArrayList<Card> cardRet = new ArrayList<Card>();
		while(!Cards.isEmpty())
		{
			Card c = Cards.remove(Cards.size()-1);
			manageTerritory(c.getTerritory(),1);
			System.out.println(""+ c.getTerritory().getName() + " eh do jogador " + this.getColor() + "----------------------------");
			cardRet.add(c);
		}
		return cardRet;
	}
	
	public void manageTerritory(Territory t, int army)
	{
		if(t != null)
		{	
			//System.out.println(t.getName());
			t.setColor(this.color);
			t.setTroops(army);
			if(!Territories.contains(t))
				Territories.add(t);
		}
		else
			throw new NullPointerException("Parameter of type Territory cannot be null");
	}
	
	
	public void loseTerritory(Territory t) {
		if(Territories.contains(t)) {
			Territories.remove(t);
		}
			
		
	}
	
	public void gainTerritory(Territory t) {
		if(!Territories.contains(t)) {
			Territories.add(t);
			
			t.setTroops(0);
			t.setColor(this.color);
			
		}
			
	}
	
	
	public void receiveArmies(int army) {
		availableArmies += army;
	}
	
	public void resetPlayer() {
		
		objective = null;
		Cards.clear();
		Territories.clear();
		availableArmies = 0;
		playersKilled.clear(); 
		
	}
	
}
