package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import observer.IObserver;

public class GameExecution implements Serializable {

	private static final long serialVersionUID = 1L;

	private static GameExecution singleton;

	private Stack<Objective> objStack = new Stack<Objective>();
	private Stack<Card> cardStack = new Stack<Card>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<GameColor> remainingColors = new ArrayList<GameColor>(Arrays.asList(GameColor.Branco,
			GameColor.Preto, GameColor.Azul, GameColor.Amarelo, GameColor.Verde, GameColor.Vermelho));
	private int cardBonus = 4;

	private ArrayList<Territory> territories; // 51

	private ArrayList<Continent> continents; // 6

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
		if (territories != null)
			resetTerritories();
		if (continents != null)
			resetContinents();
		if (cards != null)
			resetCards();
		if (objectives != null)
			resetObjectives();

		territories = Territory.initialize();
		continents = Continent.initialize();
		cards = Card.initialize();
		objectives = Objective.initialize();
	}

	public ArrayList<String> getColorNames() {
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

	public String getPlayerObjective(int i) {
		return players.get(i).getObj().getDescription();
	}

	public String getPlayerColorCode(int i) {
		return players.get(i).getColor().getColorCode();
	}

	public int getPlayerAvailableArmy(int i) {
		return players.get(i).getAvailableArmies();
	}

	public List<Player> getPlayerList() {
		return Collections.unmodifiableList(players);
	}

	// territory methods

	public List<Territory> getTerritoriesList() {
		return Collections.unmodifiableList(territories);
	}

	public void resetTerritories() {
		territories.clear();
	}

	protected Territory getTerritory(String name) {
		for (Territory t : territories) {
			if (t.getName() == name)
				return t;
		}

		return null;
	}

	public Territory getTerritory(int i_turf) {
		if (i_turf > -1 && i_turf < territories.size()) {
			return territories.get(i_turf);
		}

		return null;
	}

	// continent methods

	public List<Continent> getContinentList() {
		return Collections.unmodifiableList(continents);
	}

	public Continent getContinent(int initial) {
		return continents.get(initial);
	}

	public void resetContinents() {
		continents.clear();
	}

	// card methods

	public List<Card> getCardList() {
		return Collections.unmodifiableList(cards);
	}

	public void resetCards() {
		cards.clear();
	}

	// objective methods

	public List<Objective> getObjectiveList() {
		return Collections.unmodifiableList(objectives);
	}

	public Objective getObjective(int i) {
		return objectives.get(i);
	}

	public Objective getObjective(String code) {

		for (Objective o : objectives) {
			if (o.getCode() == code) {
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
					p.draw(cardStack.pop(), true);

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

	public void placeArmy(int player, int army, int territory) {
		Player p = players.get(player);
		Territory t = this.getTerritory(territory);

		if (p == null || t == null) {
			throw new NullPointerException();
		}

		if (army == 0) {
			throw new IllegalArgumentException();
		}

		p.placeArmy(t, army);
	}

	public void distribuiteArmy(int i) {
		Player p = players.get(i);
		int army = 0;

		army += p.getContinentBonus();

		int from_turf = p.getAllTerritories().size() / 2;

		if (from_turf < 3) {
			army += 3;
		} else {
			army += from_turf;
		}

		p.modifyAvailableArmies(army);
	}

	protected boolean executeAttack(Territory src, Territory target, int[] attack, int[] defend) {

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

	public boolean moveTroops(Territory src, Territory target, int troops, boolean conquer) {

		System.out.print(troops);
		
		if (((src.getNewTroops() > 0 && (src.getTroops() - src.getNewTroops() >= troops))
				|| (src.getNewTroops() == 0 && src.getTroops() > troops)) && (src.getColor().equals(target.getColor()))) {
			src.modifyTroops(-troops);
			target.modifyTroops(troops, !conquer);
			return true;
		} else {
			return false;
		}
	}

	public boolean movePlayerTroops(int player, int src, int target, int troops) {

		Player p = players.get(player);

		Territory s = getTerritory(src);
		Territory t = getTerritory(target);

		ArrayList<Territory> territories = new ArrayList<Territory>(Arrays.asList(s, t));

		if (!p.verifyTerritories(territories)) {
			return false;
		}

		return moveTroops(s, t, troops, false);
	}

	/**
	 * 
	 * @param attacker
	 * @param defender
	 * @param src
	 * @param target
	 * @param army     - Number of troops going to the territory conquered
	 * @return
	 */
	private boolean conquer(Player attacker, Player defender, Territory src, Territory target, int army) {

		if (target.getTroops() <= 0) {

			attacker.gainTerritory(target);
			defender.loseTerritory(target);
			moveTroops(src, target, army, true);

			if (defender.getAllTerritories().isEmpty()) {
				attacker.KillPlayer(defender.getColor());
				
				//obtain all enemy cards
				List<Card> cards_transfer = defender.getAllCards();
				attacker.getCards(cards_transfer);
				defender.emptyCards();
				
			}

			attacker.setConquered(true);

			return true;
		} else
			return false;
	}

	public int[] throwDices(int territory, boolean defense) {
		Territory t = getTerritory(territory);
		Random r = new Random();
		int[] dices;

		if (!defense) {
			if (t.getTroops() - 1 > 3)
				dices = r.ints(3, 1, 7).toArray();
			else
				dices = r.ints(t.getTroops() - 1, 1, 7).toArray();
		} else {
			if (t.getTroops() > 3)
				dices = r.ints(3, 1, 7).toArray();
			else
				dices = r.ints(t.getTroops(), 1, 7).toArray();
		}

		return dices;
	}

	public int getDicesAmount(int territory, boolean defense) {
		Territory t = getTerritory(territory);

		if (!defense) {
			if (t.getTroops() - 1 > 3) {
				return 3;
			} else {
				return t.getTroops() - 1;
			}
		} else {
			if (t.getTroops() > 3)
				return 3;
			else
				return t.getTroops();
		}

	}

	public int attack(int src, int target, int[] attackDices, int[] defenseDices) {
		int ret = 0;
		Territory t_src = getTerritory(src);
		Territory t_target = getTerritory(target);
		if (executeAttack(t_src, t_target, attackDices, defenseDices)) {
			ret++;
			if (conquer(getTerritoryOwner(src), getTerritoryOwner(target), t_src, t_target, attackDices.length))
				ret++;
		}
		return ret;
	}

	protected boolean CardTrade(int player, ArrayList<Card> selected) {
		Player p = players.get(player);
		if (p.tradeCards(selected)) {
			// puts cards back on stack
			cardStack.addAll(selected);
			Collections.shuffle(cardStack);

			p.modifyAvailableArmies(cardBonus);
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

	public boolean tradeCards(int player, List<String> cards) {
		ArrayList<Card> l = new ArrayList<Card>();

		for (String s : cards)
			l.add(Card.getCard(getTerritory(s)));
		return CardTrade(player, l);
	}

	protected boolean playerManualDraw(int player, Card c) {

		if ((!cardStack.contains(c) && players.get(player).hasCard(c)))
			return false;

		players.get(player).draw(c,true);

		cardStack.removeElement(c);

		return true;
	}

	public int playerDraw(int i) {
		int ret = players.get(i).draw(cardStack.peek());

		if (ret == 2) {
			cardStack.pop();
		}
		return ret;
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

	public boolean playerHasTerritory(int p, int t) {
		return players.get(p).hasTerritory(getTerritory(t));
	}

	public int getTerritoryCount() {
		return territories.size();
	}

	public String getTerritoryName(int i) {
		return this.getTerritory(i).getName();
	}

	public int getTerritoryIndex(String name) {

		for (int i = 0; i < territories.size(); i++) {
			if (territories.get(i).getName() == name) {
				return i;
			}
		}
		return -1;

	}

	public String getTerritoryColorCode(int i) {
		return this.getTerritory(i).getColor().getColorCode();
	}

	public int getTerritoryArmy(int i) {
		return this.getTerritory(i).getTroops();
	}

	public int[] getTerritoryCenter(int i) {
		int[] center = new int[2];

		Vertex c = getTerritory(i).getCenter();

		center[0] = (int) c.x;
		center[1] = (int) c.y;

		return center;
	}

	public int getTerritoryIndexByClick(Point p) {
		for (int i = 0; i < getTerritoriesList().size(); i++) {
			List<Vertex> polygon = getTerritory(i).getFrontiers();
			if (Vertex.isInsidePolygon(polygon.size(), polygon, p.x, p.y))
				return i;
		}
		return -1;
	}

	private Player getTerritoryOwner(int t) {
		for (Player p : players) {
			if (p.hasTerritory(getTerritory(t)))
				return p;
		}
		return null;
	}

	public boolean isNeighbor(int territory, int neighbour) {
		return getTerritory(territory).isNeighbor(getTerritory(neighbour).getName());
	}

	public boolean playerHasNeighbour(int player, int territory) {
		List<Territory> l = players.get(player).getAllTerritories();

		for (String n : getTerritory(territory).getNeighbors()) {
			Territory t = getTerritory(n);
			if (l.contains(t))
				return true;
		}
		return false;
	}

	/**
	 * If a certain player can attack the territory passed.
	 * 
	 * @param player    - The attacker
	 * @param territory - The territory to be attacked
	 * @return If the player has a neighbor with enough army to the territory chosen
	 *         returns true, else returns false
	 */
	public boolean playerCanAttackTerritory(int player, int territory) {
		List<Territory> l = players.get(player).getAllTerritories();

		for (String n : getTerritory(territory).getNeighbors()) {
			Territory t = getTerritory(n);
			if (l.contains(t) && t.getTroops() > 1)
				return true;
		}

		return false;
	}

	public void addTerritoryObserver(int i, IObserver o) {
		getTerritory(i).addObserver(o);

	}

	public void addPlayerObserver(int i, IObserver o) {
		players.get(i).addObserver(o);
	}

	public void removePlayerObserver(int i, IObserver o) {
		players.get(i).removeObserver(o);
	}

	public boolean checkPlayerObjective(int i) {
		return players.get(i).getObj().ValidateObjective();
	}

	public String getCardImgFilePath(String cardName) {
		Territory t = getTerritory(cardName);

		String s = "src\\images\\war_carta_";

		String continent = t.getContinent().getName();
		
		if (continent.equals("America do Norte")) {
			s += "an_";
		}
		if (continent.equals("America do Sul")) {
			s += "asl_";
		}
		if (continent.equals("Africa")) {
			s += "af_";
		}
		if (continent.equals("Europa")) {
			s += "eu_";
		}
		if (continent.equals("Oceania")) {
			s += "oc_";
		}
		if (continent.equals("Asia")) {
			s += "as_";
		}
		s += t.getName().replaceAll(" ", "").toLowerCase() + ".png";

		return s;
	}

	// Returns a list containing the name of all cards from the Player i
	public List<String> getPlayerCardNameList(int i) {
		ArrayList<String> l = new ArrayList<String>();
		for (Card c : players.get(i).getAllCards()) {
			l.add(c.getTerritory().getName());
		}

		return Collections.unmodifiableList(l);
	}

	public boolean isPlayerTradeObligatory(int i) {
		if (players.get(i).isTradeViable() == 2)
			return true;
		else
			return false;
	}
}
