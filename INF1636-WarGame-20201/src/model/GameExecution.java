package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import observer.IObserver;

public class GameExecution {

	private static GameExecution singleton;

	private Stack<Objective> objStack = new Stack<Objective>();
	private Stack<Card> cardStack = new Stack<Card>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<GameColor> remainingColors = new ArrayList<GameColor>(Arrays.asList(GameColor.Branco,
			GameColor.Preto, GameColor.Azul, GameColor.Amarelo, GameColor.Verde, GameColor.Vermelho));
	private int cardBonus = 4;
	
	
	private ArrayList<Territory> territories; //51
	
	private ArrayList<Continent> continents; //6
	
	private ArrayList<Card> cards;
	
	private ArrayList<Objective> objectives;

	private GameExecution() {
	}

	public static GameExecution getGameExecution() {
		if (singleton == null)
			singleton = new GameExecution();
		return singleton;
	}
	
	public static void setGameExecution(GameExecution gE) {
		singleton = gE;
	}

	public void initializeGameComponents() {
		if(territories != null)
			resetTerritories();
		if(continents != null)
			resetContinents();
		if(cards != null)
			resetCards();
		if(objectives != null)
			resetObjectives();
		
		territories = Territory.initialize();
		continents = Continent.initialize();
		cards = Card.initialize();
		objectives = Objective.initialize();
	}

	public ArrayList<String> getColorNames()
	{
		return GameColor.getColorNames();
	}
	
	public Player getPlayer(int i) {
		return players.get(i);
	}

	public Player getPlayer(GameColor c) {
		for (Player p : players) {
			if (p.getColor() == c)
				return p;
		}
		return null;
	}

	public int getPlayerCount() {
		return players.size();
	}

	public String getPlayerName(int i) {
		return players.get(i).getName();
	}

	public String getPlayerObjective(int i)
	{
		return players.get(i).getObj().getDescription();
	}
	
	public String getPlayerColorCode(int i)
	{
		return players.get(i).getColor().getColorCode();
	}

	public int getPlayerAvailableArmy(int i)
	{
		return players.get(i).getAvailableArmies();
	}
	
	public List<Player> getPlayerList() {
		return Collections.unmodifiableList(players);
	}
	
	//territory methods
	
	public List<Territory> getTerritoriesList()
	{
		return Collections.unmodifiableList(territories);
	}
	
	public void resetTerritories() {
			territories.clear();
	}
	
	public Territory getTerritory(String name)
	{
		for(Territory t : territories)
		{
			if(t.getName() == name)
				return t;
		}
		
		return null;
	}
	
	public Territory getTerritory(int i_turf)
	{
		if(i_turf > -1 && i_turf < territories.size()){
			return territories.get(i_turf);
		}
		
		return null;
	}
	
	//continent methods
	
	public List<Continent> getContinentList()
	{
		return Collections.unmodifiableList(continents);
	}
	
	public Continent getContinent(int initial) {
		return continents.get(initial);
	}
	
	public void resetContinents() {
		continents.clear();
	}
	
	//card methods
	
	public List<Card> getCardList()
	{
		return Collections.unmodifiableList(cards);
	}
	
	public void resetCards() {
		cards.clear();
	}
	
	//objective methods
	
	public List<Objective> getObjectiveList()
	{
		return Collections.unmodifiableList(objectives);
	}
	
	public Objective getObjective(int i) {
		return objectives.get(i);
	}
	
	
	
	public Objective getObjective(String code) {
		
		for(Objective o: objectives) {
			if(o.getCode() == code) {
				return o;
			}
		}
		return null;
	}
	
	public void resetObjectives() {
		objectives.clear();
	}

	// Return if the argument numberOfPlayers is valid
	public boolean createPlayerList(int numberOfPlayers) {
		if (numberOfPlayers < 3 || numberOfPlayers > 6) {
			return false;
		} else {
			resetPlayers();
			players = new ArrayList<Player>(Arrays.asList(new Player[numberOfPlayers]));
			return true;
		}
	}
	
	

	// Return if the player was added
	public boolean addPlayers(String[] names, String[] colors) {
		Player[] pArray = new Player[players.size()];
		GameColor[] cArray = new GameColor[players.size()];

		for (int i = 0; i < players.size(); i++) {
			if (names[i] == null || colors[i] == null) {
				return false;
			}
			try {
				cArray[i] = GameColor.valueOf(colors[i]);
			} catch (IllegalArgumentException e) {
				return false;
			}
			if (!remainingColors.remove(cArray[i])) {
				remainingColors.addAll(Arrays.asList(cArray));
				return false;
			}
			pArray[i] = new Player(names[i], cArray[i]);
		}

		int cont = 0;
		for (Player p : pArray) {
			players.set(cont, p);
			cont++;
		}
		
		Collections.shuffle(players);

		return true;
	}

	public void firstDraw() {

		// Draw cards and objectives
		// Creating stacks to draw cards and objectives
		objStack.addAll(objectives);

		Collections.shuffle(objStack);
		
		cardStack.addAll(cards);

		// Remove jokers
		cardStack.removeAll(Card.getJokers());

		Collections.shuffle(cardStack);

		boolean isCardStackEmpty = false;

		while (!isCardStackEmpty) {
			for (Player p : players) {
				if (!isCardStackEmpty) {
					p.draw(cardStack.pop());

					isCardStackEmpty = cardStack.isEmpty();
				} else
					break;
			}
		}

		// Add jokers
		cardStack.addAll(Card.getJokers());

		for (Player p : players) {
			Objective o = objStack.pop();

			p.setObjective(o);
			o.setPlayer(p);

			// Place 1 army on each territory and retrieve the cards
			cardStack.addAll(p.cardToTerritory());
		}

		// Shuffle players order
		Collections.shuffle(players);
	}

	public void placeArmy(int player, int army, String territory) {
		Player p = players.get(player);
		Territory t = this.getTerritory(territory);

		if (p == null || t == null) {
			throw new NullPointerException();
		}

		if (army == 0) {
			throw new IllegalArgumentException();
		}

		p.manageTerritory(t, army);
	}

	public void distribuiteArmy(int i) {
		Player p = players.get(i);
		int army = 0;

		army += p.getContinentBonus();
		
		int from_turf = p.getAllTerritories().size() / 2;
		
		if(from_turf < 3) {
		army += 3;
		}
		else {
			army += from_turf;
		}

		p.receiveArmies(army);
	}

	public boolean executeAttack(Territory src, Territory target, int[] attack, int[] defend) {

		if (!GameValidation.validateAttack(src.getColor(), src, target, attack.length)) {
			return false;
		}

		// sort arrays in reverse
		Arrays.sort(attack);
		Arrays.sort(defend);

		for (int i = 0; i < attack.length / 2; i++) {
			int temp = attack[i];
			attack[i] = attack[attack.length - 1 - i];
			attack[attack.length - 1 - i] = temp;
		}

		for (int i = 0; i < defend.length / 2; i++) {
			int temp = defend[i];
			defend[i] = defend[defend.length - 1 - i];
			defend[defend.length - 1 - i] = temp;
		}

		// generate array of results
		int[] results = new int[2];

		for (int i = defend.length - 1; i > -1; i--) {
			if (defend[i] >= attack[i]) // defense victory increase
				results[0]++;

			else // attack victory increase
				results[1]++;
		}

		// modify troops after conflict
		target.modifyTroops(-results[1]);
		src.modifyTroops(-results[0]);

		return true;
	}

	public boolean moveTroops(Territory src, Territory target, int mov) {

		if ((src.getTroops() > mov) && (src.getColor().equals(target.getColor()))) {

			src.modifyTroops(-mov);
			target.modifyTroops(mov);

			return true;
		} else {
			return false;
		}

	}

	public boolean movePlayerTroops(int player, Territory src, Territory target, int mov) {

		Player p = players.get(player);

		ArrayList<Territory> territories = new ArrayList<Territory>(Arrays.asList(src, target));

		if (!p.verifyTerritories(territories)) {
			return false;
		}

		moveTroops(src, target, mov);

		return true;
	}

	private void conquer(Player attacker, Player defender, Territory src, Territory target, int[] attack,
			int[] defend) {

		executeAttack(src, target, attack, defend);

		if (target.getTroops() <= 0) {

			attacker.gainTerritory(target);
			defender.loseTerritory(target);
			moveTroops(src, target, attack.length);

			if (defender.getAllTerritories().isEmpty()) {
				attacker.KillPlayer(defender.getColor());
			}

		}

	}

	public void attack(int attacker, int defender, String src, String target, int[] attackDice, int[] defenseDice) {
		conquer(players.get(attacker), players.get(defender), this.getTerritory(src),
				this.getTerritory(target), attackDice, defenseDice);
	}

	public boolean CardTrade(int player, ArrayList<Card> selected) {
		Player p = players.get(player);
		if (p.tradeCards(selected)) {
			// puts cards back on stack
			cardStack.addAll(selected);
			Collections.shuffle(cardStack);

			p.receiveArmies(cardBonus);
			if (cardBonus < 12) {
				cardBonus += 2;
			} else if (cardBonus == 12) {
				cardBonus += 3;
			} else {
				cardBonus += 5;
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean playerManualDraw(int player, Card c) {

		if ((!cardStack.contains(c) && players.get(player).hasCard(c)))
			return false;

		players.get(player).draw(c);

		cardStack.removeElement(c);

		return true;
	}

	public void resetPlayers() {
		players.clear();
		remainingColors.clear();

		remainingColors.add(GameColor.Branco);
		remainingColors.add(GameColor.Preto);
		remainingColors.add(GameColor.Azul);
		remainingColors.add(GameColor.Amarelo);
		remainingColors.add(GameColor.Verde);
		remainingColors.add(GameColor.Vermelho);

	}

	public int getTerritoryCount()
	{
		return territories.size();
	}
	
	public String getTerritoryName(int i) {
		return this.getTerritory(i).getName();
	}

	public String getTerritoryColorCode(int i) {
		return this.getTerritory(i).getColor().getColorCode();
	}

	public int getTerritoryArmy(int i) {
		return this.getTerritory(i).getTroops();
	}
	
	public int[] getTerritoryCenter(int i)
	{
		int[] center = new int[2];
		
		Vertex c = this.getTerritory(i).getCenter();
		
		center[0] = (int)c.x;
		center[1] = (int)c.y;
		
		return center;
	}
	
	public void addTerritoryObserver(int i, IObserver o)
	{
		this.getTerritory(i).addObserver(o);
	}
	
}
