package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GameExecution {
	
	private static Stack<Objective> objStack = new Stack<Objective>();
	private static Stack<Card> cardStack = new Stack<Card>();
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<GameColor> chosenColors = new ArrayList<GameColor>();
	
	public static void initializeGameComponents()
	{
		Territory.initialize();
		Continent.initialize();
		Card.initialize();
		Objective.initialize();
	}
	
	public static Player getPlayer(int i)
	{
		return players.get(i);
	}
	 
	public static Player getPlayer(GameColor c)
	{
		for(Player p : players)
		{
			if(p.getColor() == c)
				return p;
		} 
		return null;
	 }
	
	 public static int getPlayerCount()
	 {
	    return players.size();
	 }
	 
	 public static List<Player> getPlayerList() {
		 return Collections.unmodifiableList(players);
	 }
	 
	
	//Return if the argument numberOfPlayers is valid
  	public static boolean createPlayerList(int numberOfPlayers)
  	{
  		if(numberOfPlayers < 3 || numberOfPlayers > 6)
  		{
  			return false;
  		}
  		else
  		{
  			players = new ArrayList<Player>(Arrays.asList(new Player[numberOfPlayers]));
  			
  			//System.out.println(" 'createPlayerList' player list size: " + players.size());
  			
  			return true;
  		}
  	}
  	
  	//Return if the player was added
  	public static boolean addPlayers(String[] names, String[] colors)
  	{
  		Player[] pArray = new Player[players.size()];
  		GameColor[] cArray = new GameColor[players.size()];
  		
  		for(int i = 0; i < players.size(); i ++)
  		{
  			if(names[i] == null || colors[i] == null)
  			{
  				return false;
  			}
  			try {
  			cArray[i] = GameColor.valueOf(colors[i]);
  			}
  			catch(IllegalArgumentException e) {
  				return false;
  			}
  			if(!remainingColors.remove(cArray[i]))
  			{
  				chosenColors.clear();
  				return false;
  			}
  			
  			System.out.println(cArray[i].name());
  			
  			chosenColors.add(cArray[i]);
  			
  			pArray[i] = new Player(names[i], cArray[i]);
  			//System.out.println("insert : " + pArray[i].getName() + "/" + pArray[i].getColor());
  		}
  		
  		int cont = 0;
  		for(Player p : pArray)
  		{
  			//System.out.println(" 'addPlayers loop' player list size: " + players.size());
  			players.set(cont, p);
  			//System.out.println("insert players: " + p.getName() + "/" + p.getColor());
  			cont++;
  		}
  		//System.out.println(" 'addPlayers' player list size: " + players.size());
  		/*for(int i= 0;i < players.size(); i++) {
			System.out.println("player gameexec list : " + players.get(i).getName());
		}*/
  		
  		return true;
  	}
  	
  	public static void firstDraw() {
  		
  		List<Objective> objectives = Objective.getObjectiveList();
  	//Draw cards and objectives
  		//Creating stacks to draw cards and objectives
  		objStack.addAll(objectives);
  		
  		Collections.shuffle(objStack);
  		
  		List<Card> cards = Card.getCardList();
  		cardStack.addAll(cards);
  		
  		//Remove jokers
  		cardStack.remove(43); 
  		cardStack.remove(42);
  		
  		Collections.shuffle(cardStack);
  		
  		boolean isCardStackEmpty = false;
  		
  		while(!isCardStackEmpty)
  		{
  			for(Player p:players)
  			{
  				if(!isCardStackEmpty)
  				{
  					p.draw(cardStack.pop());
  					
  					isCardStackEmpty = cardStack.isEmpty();
  				}
  				else
  					break;
  			}
  		}
  		
  		//Add jokers
  		cardStack.add(cards.get(42));
  		cardStack.add(cards.get(43));
  		
  		for(Player p:players)
  		{
  			Objective o = objStack.pop();
  		
  			p.setObjective(o);
  			o.setPlayer(p); 
  			
  			//Place 1 army on each territory and retrieve the cards
  			cardStack.addAll(p.cardToTerritory());
  		}
  		
  	//Shuffle players order
  		Collections.shuffle(players);
  	}
    	
	public static void placeArmy(Player p, int army, Territory t)
	{
		if(p == null ||t == null)
		{
			throw new NullPointerException();
		}
		
		if(army == 0)
		{
			throw new IllegalArgumentException();
		}
		
		p.manageTerritory(t, army);
	}
	
	public static void distribuiteArmy()
	{
		for(Player p:players)
		{
			int army = 0;
			
			army += p.getContinentBonus();
			army += p.getAllTerritories().size()/2;
			
			p.receiveArmies(army);
		}
	}

	public static boolean executeAttack(Territory src , Territory target, int [] attack,int [] defend) {
		
		if(!GameValidation.validateAttack(src.getColor(), src, target, attack.length)) {
			return false;
		}
			
		//sort arrays in reverse
		Arrays.sort(attack);
		Arrays.sort(defend);
		
		for(int i = 0; i < attack.length / 2; i++) {
			int temp = attack[i];
			attack[i] = attack[attack.length - 1 - i];
			attack[attack.length- 1 - i] = temp;
		}
		
		for(int i = 0; i < defend.length / 2; i++) {
			int temp = defend[i];
			defend[i] = defend[defend.length - 1 - i];
			defend[defend.length- 1 - i] = temp;
		}
		
		
		
		//generate array of results
		int[] results = new int[2];
		
		for(int i=defend.length - 1;i > -1;i--)
		{
			if(defend[i] >= attack[i]) //defense victory increase
				results[0]++;
			
			else					   //attack victory increase
				results[1]++;
		}
		
		//modify troops after conflict
		target.modifyTroops(-results[1]);
		src.modifyTroops(-results[0]);
		
		return true;
	}
	
	public static boolean moveTroops(Territory src , Territory target, int mov) {
		
		
		if((src.getTroops() > mov) && (src.getColor().equals(target.getColor())) ) {
			
			
			src.modifyTroops(-mov);
			target.modifyTroops(mov);
			
			return true;
		}
		else {
			return false;
		}
		
	}
	
	static void conquer (Player attacker, Player defender, Territory src , Territory target, int [] attack,int [] defend) {
		
		executeAttack(src,target,attack,defend);
		
		//System.out.println("target troops: " + target.getTroops());
		
		if(target.getTroops() <= 0) {
			
			
			attacker.gainTerritory(target);
			defender.loseTerritory(target);
			moveTroops(src ,target, attack.length);
			
			if(defender.getAllTerritories().isEmpty()) {
				attacker.KillPlayer(defender.getColor());
			}
			
		}
		
	}

	public static void attack (int attacker, int defender, String src, String target, int[] attackDice, int[] defenseDice)
	{
		conquer(players.get(attacker), players.get(defender), Territory.getTerritory(src), Territory.getTerritory(target), attackDice, defenseDice);
	}
	
	public static void resetPlayers() {
		players.clear();
		remainingColors.clear();
		
		remainingColors.add(GameColor.Branco);
		remainingColors.add(GameColor.Preto);
		remainingColors.add(GameColor.Azul);
		remainingColors.add(GameColor.Amarelo);
		remainingColors.add(GameColor.Verde);
		remainingColors.add(GameColor.Vermelho);

	}
	
	public static void resetAll() {
		resetPlayers();
		Territory.resetTerritories();
	}
	
}
