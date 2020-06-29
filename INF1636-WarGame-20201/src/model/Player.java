package model;
import java.io.Serializable;
import java.util.*;

import observer.Observable;

class Player extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private GameColor color;
	private Objective objective;
	private ArrayList<Card> Cards = new ArrayList<Card>();
	private ArrayList<Territory> Territories = new ArrayList<Territory>();
	private int availableArmies = 0;
	private ArrayList<GameColor> playersKilled = new ArrayList<GameColor>(); 
	
	public Player(String n,GameColor c) {
		name = n;
		color = c;
	}
	
	public List<Card> cardToTerritory()
	{
		ArrayList<Card> cardRet = new ArrayList<Card>();
		while(!Cards.isEmpty())
		{
			Card c = Cards.remove(Cards.size()-1);
			manageTerritory(c.getTerritory(),1);
			cardRet.add(c);
		}
		return cardRet;
	}
	
	public void draw(Card c)
	{
		Cards.add(c);
	}
	
	public void gainTerritory(Territory t) {
		if(!Territories.contains(t)) {
			Territories.add(t);
			
			t.setTroops(0);
			t.setColor(this.color);
			
		}
			
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
	
	public Card getCard(Territory t) {
		for(Card c:Cards) {
			if (c.getTerritory().equals(t)) {
				return c;
			}
		}
		return null;
	}
	
	public GameColor getColor() {
		return color;
	}
	
	public int getContinentBonus()
	{
		int bonus = 0;
		
		for(Continent c:GameExecution.getGameExecution().getContinentList())
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
	
	public String getName() {
		return name;
	}
	
	public Objective getObj()
	{
		return objective;
	}

	public ArrayList<GameColor> getPlayersKilled() {
		return playersKilled;
	}
	
	public boolean hasCard(Card c) {
		return Cards.contains(c);
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
	
	public void KillPlayer(GameColor c) {
		playersKilled.add(c);
	}
	
	public void loseContinent(Continent c) {
		
		Territory [] territories = c.getTerritories();
		
		for(int i = 0;i < territories.length;i++){
			if(!Territories.contains(territories[i])) {
				return;
			}	
		}
		
		for(int i = 0;i < territories.length;i++){
			Territories.remove(territories[i]);
		}	
		
	}
	
	public void loseTerritory(Territory t) {
		if(Territories.contains(t)) {
			Territories.remove(t);
		}
			
		
	}
	
	public void manageContinent(Continent c, int army) {
		
		Territory [] territories = c.getTerritories();
		
		for(int i=0;i<territories.length;i++) {
			this.manageTerritory(territories[i], army);
		}
		
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
	
	public void modifyAvailableArmies(int army) {
		availableArmies += army;
		
		notifyObservers();
	}
	
	public void placeArmy(Territory t, int army)
	{
		if(Territories.contains(t) && availableArmies >= army)
		{
			t.modifyTroops(army);
			modifyAvailableArmies(-army);
		}
	}
	
	public void resetPlayer() {
		
		objective = null;
		Cards.clear();
		Territories.clear();
		availableArmies = 0;
		playersKilled.clear(); 
		
	}
	
	public void resetPlayerCards() {
		Cards.clear();
	}
	
	
	public void setObjective(Objective o)
	{
		this.objective = o;
		o.setPlayer(this);
	}
	
	public boolean tradeCards(ArrayList<Card> trading) {
		
		for(Card c:trading) {
			if (!Cards.contains(c)) {
				return false;
			}
		}
		
		if(!GameValidation.validateCardTrade(trading))
			return false;
		
		for(Card c:trading) {
			Cards.remove(c);
			if(Territories.contains(c.getTerritory())){
				availableArmies += 2;
			}
		}
		return true;
	}
	
	public boolean verifyTerritories(ArrayList<Territory> selection) {
		if(Territories.containsAll(selection)) {
			return true;
		}
		return false;
		
	}
	
	public boolean hasTerritory(Territory t)
	{
		return Territories.contains(t);
	}

	@Override
	public Object get(int i) {
		switch(i)
		{
		case 0:
			return availableArmies;
		}
		return null;
	}
	
}
