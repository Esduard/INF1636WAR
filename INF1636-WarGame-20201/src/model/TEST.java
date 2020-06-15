package model;
import java.util.*;

public class TEST {
	
	private static GameExecution gE = GameExecution.getGameExecution();
	
	public static void testValidateCardTrade()
	{
		System.out.println("-------------TEST VALIDATE CARD TRADE--------------");
		
		
		
		Card []cards = new Card[8];
		
		ArrayList<Card> test_subject = new ArrayList<Card>();
		
		cards[0]  = new Card(Shape.Triangle	, null);
		cards[1]  = new Card(Shape.Circle	, null);
		cards[2]  = new Card(Shape.Square	, null);
		cards[3]  = new Card(Shape.Circle	, null);
		cards[4]  = new Card(Shape.Triangle	, null);
		cards[5]  = new Card(Shape.Triangle	, null);
		cards[6]  = new Card(Shape.Joker	, null);
		cards[7]  = new Card(Shape.Joker	, null);
		
		//GameValidation {
		
		//public static boolean validateCardTrade(ArrayList<Card> selected)
		
		System.out.println("\ncorrectly use 3 cards of same shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[4]);
		test_subject.add(cards[5]);
		System.out.print("Expects true -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		
		System.out.println("\ncorrectly use 3 cards of different shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		System.out.print("Expects true -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("\nincorrectly use 4 cards for trade");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		test_subject.add(cards[3]);
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("\nincorrectly use 0 cards for trade");
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("\nincorrectly use 2 cards of same shape and other of different-nonjoker shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[5]);
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("\nincorrectly use 2 cards of different shape and other of repeated-nonjoker shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[3]);
		test_subject.add(cards[4]);
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("\nincorrectly use first card with different shape of second and second card with equal shape of third");
		test_subject.add(cards[1]);
		test_subject.add(cards[4]);
		test_subject.add(cards[5]);
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("\ncorrectly deal 2 equal cards with 1 joker");
		test_subject.add(cards[1]);
		test_subject.add(cards[3]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		
		System.out.println("\ncorrectly deal 2 diferent cards with  1 joker");
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("\ncorrectly deal trade with 2 jokers and 1 extra card");
		test_subject.add(cards[1]);
		test_subject.add(cards[7]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(GameValidation.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
	}
	
	public static void testCardTrade() {
		
		System.out.println("----------------TEST CARD TRADE ----------------");
		
		gE.createPlayerList(3);
		
		String names[] = {"Eduardo", "Gabriel", "Ivan"};
		
		String colors[] = {"Vermelho", "Azul", "Preto"};
		
		boolean result = gE.addPlayers(names, colors);
		
		gE.initializeGameComponents();
		
		System.out.println("game created: " + result);
		
		Player p = gE.getPlayer(0);
		
		System.out.println("Correctly trades 3 cards that he owns, gets 4 bonus troops");
		
			System.out.println("BEFORE TRADE");
			
			//acquires cards
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("Alasca")));
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("Calgary")));
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("California")));
			
			ArrayList<Card> selected = new ArrayList<Card>();
			
			//get territory for function
			selected.add(p.getCard(Territory.getTerritory("Alasca")));
			selected.add(p.getCard(Territory.getTerritory("Calgary")));
			selected.add(p.getCard(Territory.getTerritory("California")));
			
			ArrayList<Card> cards = new ArrayList<Card>();
			
			cards.addAll(p.getAllCards());
			
			System.out.print("cards: ");
			for(Card c: cards)
				System.out.print(c.getTerritory().getName() + " ");
			
			System.out.println("availableTroops: " + p.getAvailableArmies());
			
			gE.CardTrade(0,selected);
			
			
			System.out.println("AFTER TRADE");
			
			cards.clear();
			cards.addAll(p.getAllCards());
			
			System.out.print("cards: ");
			for(Card c: cards)
				System.out.print(c.getTerritory().getName() + " ");
			
			System.out.println("availableTroops: " + p.getAvailableArmies());
			
			p.resetPlayerCards();
		
		System.out.println("Incorrectly trades 3 cards that he doesn't own");
		
			System.out.println("BEFORE TRADE");
			
			//acquires cards
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("Calgary")));
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("California")));
			
			cards.clear();
			cards.addAll(p.getAllCards());

			System.out.print("cards: ");
			for(Card c: cards)
				System.out.print(c.getTerritory().getName() + " ");
			
			System.out.println("available Troops: " + p.getAvailableArmies());
			
			gE.CardTrade(0,selected);
			
			
			System.out.println("AFTER TRADE");
			
			cards.clear();
			cards.addAll(p.getAllCards());
			
			System.out.print("cards: ");
			for(Card c: cards)
				System.out.print(c.getTerritory().getName() + " ");
			
			System.out.println("available Troops: " + p.getAvailableArmies());
			
			p.resetPlayerCards();
		
		System.out.println("Correctly trades 3 cards that he owns the turfs");
		
			System.out.println("BEFORE TRADE");
			
			//acquires cards
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("Alasca")));
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("Calgary")));
			gE.playerManualDraw(0,Card.getCard(Territory.getTerritory("California")));
			
			
			
			//get territory of cards
			p.manageTerritory(Territory.getTerritory("Alasca"), 1);
			p.manageTerritory(Territory.getTerritory("Calgary"), 1);
			p.manageTerritory(Territory.getTerritory("California"), 1);
			
			cards.clear();
			cards.addAll(p.getAllCards());
			
			System.out.print("cards: ");
			for(Card c: cards)
				System.out.print(c.getTerritory().getName() + " ");
			
			System.out.println("available Troops: " + p.getAvailableArmies());
			
			gE.CardTrade(0,selected);
			
			System.out.println("AFTER TRADE");
			
			cards.clear();
			cards.addAll(p.getAllCards());
			
			System.out.print("cards: ");
			for(Card c: cards)
				System.out.print(c.getTerritory().getName() + " ");
			
			System.out.println("available Troops: " + p.getAvailableArmies());
			
			p.resetPlayerCards();
		
	}
	
	public static void testCreatePlayerList()
	{
		System.out.println("----------------TEST CREATE PLAYER LIST----------------");
		
		System.out.println("With 2 players: " + gE.createPlayerList(2));
		System.out.println("With 3 players: " + gE.createPlayerList(3));
		System.out.println("With 6 players: " + gE.createPlayerList(6));
		System.out.println("With 7 players: " + gE.createPlayerList(7));
	}
	
	public static void testAddPlayers()
	{
		System.out.println("----------------TEST ADD PLAYERS----------------");
		
		System.out.println("3 players: ");
		
		//public static boolean addPlayers(String[] names, String[] colors)
		
		System.out.println("\ncorrectly adds 3 players: expects true");
		gE.createPlayerList(3);
		
		String[] jogadores1 = {"Hashirama","Tobirama","Hiruzen"};
		
		String[] cores1 = {"Azul","Vermelho","Preto"};
		
		boolean result = gE.addPlayers(jogadores1,cores1);
		
		System.out.println("game created: " + result);
		
		for(int i= 0;i < 3; i++) {
			System.out.println(gE.getPlayer(i).getName());
		}
		
		System.out.println("\nincorrectly adds 2 players: expects false");
		gE.createPlayerList(2);
		
		String[] jogadores2 = {"Hashirama","Tobirama"};
		
		String[] cores2 = {"Azul","Vermelho"};
		
		System.out.println("game created: " + gE.addPlayers(jogadores2,cores2));
		
		System.out.println("\nincorrectly adds 3 players with repeated color: expects false");
		gE.createPlayerList(3);
		
		String[] jogadores3 = {"Hashirama","Madara","Tobirama"};
		
		String[] cores3 = {"Azul","Azul","Vermelho"};
		
		System.out.println("game created: " + gE.addPlayers(jogadores3,cores3));
		
		System.out.println("\nincorrectly adds 3 players with non-existent color: expects false");
		gE.createPlayerList(3);
		
		String[] jogadores4 = {"Hashirama","Madara","Tobirama"};
		
		String[] cores4 = {"Azul","Laranja","Vermelho"};
		
		System.out.println("game created: " + gE.addPlayers(jogadores4,cores4));
	}
	
	public static void testAttackResult()
	{
		//further testing is not required since validateAttack works
		
		System.out.println("----------------TEST EXECUTE ATTACK----------------");
		
		int [] atk = {6,6,6};
		int [] def = {1,1,1};
		
		boolean result;
		
		System.out.println("ATK : " + Arrays.toString(atk));
		System.out.println("DEF : " + Arrays.toString(def));
		
		ArrayList<String> venezuela_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Peru","Brasil"));
	    
	    ArrayList<String> peru_n = new ArrayList<String>(
	    	      Arrays.asList("Argentina","Venezuela","Brasil"));
	    
	    Territory Venezuela = new Territory("Venezuela", venezuela_n, null, null);
		Territory Peru = new Territory("Peru", peru_n, null, null);
		
		//public Player(String n,GameColor c) {
		
		Player p1 = new Player("Eduardo",GameColor.Vermelho);
		Player p2 = new Player("Gabriel",GameColor.Azul);
		
		p1.manageTerritory(Venezuela, 5);
		p2.manageTerritory(Peru, 3);
		
		System.out.println("BEFORE ATTACK: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = gE.executeAttack(Venezuela , Peru, atk , def );
		
		System.out.println(result);
		
		System.out.println("AFTER ATTACK: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		
	}
	
	public static void testMoveTroops(){
		
		System.out.println("----------------TEST MOVE TROOPS----------------");
		
		ArrayList<String> venezuela_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Peru","Brasil"));
	    
	    ArrayList<String> peru_n = new ArrayList<String>(
	    	      Arrays.asList("Argentina","Venezuela","Brasil"));
	    Territory Venezuela = new Territory("Venezuela", venezuela_n, null, null);
		Territory Peru = new Territory("Peru", peru_n, null, null);
		
		Player p1 = new Player("Eduardo",GameColor.Vermelho);
		Player p2 = new Player("Gabriel",GameColor.Azul);
		
		p1.manageTerritory(Venezuela, 1);
		p2.manageTerritory(Peru, 5);
		
		boolean result;
		
		System.out.println("\nincorrectly move troops of different colors");
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = gE.moveTroops(Venezuela,Peru,1);
		
		System.out.println(result);
		
		System.out.println("AFTER MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		System.out.println("\nincorrectly move stationary troops ");
		
		Venezuela.setColor(Peru.getColor());
		
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = gE.moveTroops(Venezuela,Peru,1);
		
		System.out.println(result);
		
		System.out.println("AFTER MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		System.out.println("\ncorrectly move 2 troops ");
		
		Venezuela.setTroops(3);
		
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = gE.moveTroops(Venezuela,Peru,2);
		
		System.out.println(result);
		
		System.out.println("AFTER MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		
	}
	
	public static void testValidateAttack()
	{
		System.out.println("-------------TEST VALIDATE ATTACK--------------");
		//public Territory(String n, Color c, ArrayList<String> neighbors );
	    ArrayList<String> venezuela_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Peru","Brasil"));
	    
	    ArrayList<String> peru_n = new ArrayList<String>(
	    	      Arrays.asList("Argentina","Venezuela","Brasil"));
	    
	    ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Venezuela","Peru","Argentina"));
	    
	    ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Peru","Brasil"));
		
	    
	    Player p1 = new Player("Eduardo",GameColor.Vermelho);
		Player p2 = new Player("Gabriel",GameColor.Azul);
	    
		Territory Venezuela = new Territory("Venezuela", venezuela_n, null, null);
		Territory Peru = new Territory("Peru", peru_n, null, null);
		Territory Argentina = new Territory("Argentina", argentina_n, null, null);
		Territory Brasil = new Territory("Brasil", brasil_n, null, null);
		
		
		p1.manageTerritory(Venezuela, 1);
		p2.manageTerritory(Peru, 5);
		p2.manageTerritory(Argentina, 2);
		p2.manageTerritory(Brasil, 1);
		
		//public static boolean validateAttack(Color c,Territory src,Territory target,int n_Troops_Attacking)
		
		
		System.out.println("can't attack with enemy troops");
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateAttack(GameColor.Azul,Venezuela,Peru,1));
		
		System.out.println("can't attack yourself");
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateAttack(GameColor.Azul,Brasil,Peru,1));
		
		System.out.println("can't do attack with no troops on standby in source");
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateAttack(GameColor.Azul,Brasil,Venezuela,1));
	
		System.out.println("can't attack with 0 troops");
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateAttack(GameColor.Azul,Peru,Venezuela,0));
		System.out.println("can't attack with more than 3 troops");
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateAttack(GameColor.Azul,Peru,Venezuela,4));
		
		System.out.println("verify if target is src's neighbor");
		System.out.print("Expects false -> ");
		System.out.println(GameValidation.validateAttack(GameColor.Azul,Argentina,Venezuela,1));
		
		System.out.println("valid attack");
		System.out.print("Expects true -> ");
		System.out.println(GameValidation.validateAttack(GameColor.Azul,Peru,Venezuela,1));
	}
	
	public static void testObjectiveValidation (){
		
		testDestroyArmyObjective();
		testConquerTerritoryObjective();
		testConquerContinentObjective();
		
	}
	
	private static void  testDestroyArmyObjective() {
		
		System.out.println("-------------TEST DESTROY ARMY OBJECTIVE--------------");
		
		//setting the stage
		gE.createPlayerList(3);
		
		
		String[] jogadores = {"Mario","Luigi","Peach"};
		
		String[] cores = {"Azul","Vermelho","Preto"};
		
		gE.addPlayers(jogadores,cores);
		
		gE.initializeGameComponents();
		
		Objective objs[] = new Objective[3];
		//DestroyArmyObjective(String description, Player target,Player player)
		objs[0] = new DestroyArmyObjective("DA" + gE.getPlayer(0).getColor(),"Destruir totalmente os exércitos do jogador " + gE.getPlayer(0).getColor().name(),gE.getPlayer(0),null);
		objs[1] = new DestroyArmyObjective("DA" + gE.getPlayer(1).getColor(),"Destruir totalmente os exércitos do jogador " + gE.getPlayer(1).getColor().name(),gE.getPlayer(1),null);
		objs[2] = new DestroyArmyObjective("DA" + gE.getPlayer(2).getColor(),"Destruir totalmente os exércitos do jogador " + gE.getPlayer(2).getColor().name(),gE.getPlayer(2),null);
		
		gE.getPlayer(0).setObjective(objs[1]);
		gE.getPlayer(1).setObjective(objs[2]);
		gE.getPlayer(2).setObjective(objs[0]);
		
		
		//add territories to all players
	    
	    System.out.println("\ncorrectly eliminate target player. expects [T,F,F]");
	    
	    gE.getPlayer(0).manageTerritory(Territory.getTerritory("Argentina"),4);
	    gE.getPlayer(1).manageTerritory(Territory.getTerritory("Brasil"),3);
	    gE.getPlayer(2).manageTerritory(Territory.getTerritory("Peru"),3);
		
		//destroyArmyObjective holding player will win attack against his target
		
		int [] max_value = {6,6,6};
		
		int [] min_value = {1,1,1};
		
		// attack (int attacker, int defender, String src, String target, int[] attackDice, int[] defenseDice)
		gE.attack(0,1,"Argentina","Brasil", max_value , min_value);
		
		for(int i=0;i<3;i++) {
			System.out.println("Objective complete: " + gE.getPlayer(i).getObj().ValidateObjective());
		}
		
		//red will win by having 24 territories
		gE.createPlayerList(3);
		Territory.initialize();
		Continent.initialize();
		gE.addPlayers(jogadores,cores);
		
		
		System.out.println("\ncorrectly conquer 24 territories after target player is defeated by someone else. expects [T,F,F]");
		
		//lots of stub territories to give red a lot of territories
		int i_turf = 0;
		
		while(i_turf < 30) {
			if(i_turf < 9 || i_turf > 11) {
				gE.getPlayer(0).manageTerritory(Territory.getTerritory(i_turf),1);
			}
			i_turf++;
		}
	    
	    gE.getPlayer(0).manageTerritory(Territory.getTerritory("Argentina"),4);
	    gE.getPlayer(1).manageTerritory(Territory.getTerritory("Brasil"),3);
	    gE.getPlayer(2).manageTerritory(Territory.getTerritory("Peru"),4);
		
	    gE.getPlayer(0).setObjective(objs[1]);
	    gE.getPlayer(1).setObjective(objs[2]);
	    gE.getPlayer(2).setObjective(objs[0]);
		
	    
		gE.attack(2,1,"Peru","Brasil", max_value , min_value);
		
		
		for(int i=0;i<3;i++) {
			System.out.println("Objective complete: " + gE.getPlayer(i).getObj().ValidateObjective());
		}
		
		
	}
	
	private static void  testConquerTerritoryObjective() {
		
		System.out.println("-------------TEST CONQUER TERRITORY OBJECTIVE--------------");
		
		System.out.println("Both P1 and P2 have enough territories, expects [T,T,F]");
		
		//setting the stage
		
		gE.createPlayerList(3);
		Territory.initialize();
		Continent.initialize();
		
		String[] jogadores = {"Mario","Luigi","Peach"};
		
		String[] cores = {"Azul","Vermelho","Preto"};
		
		gE.addPlayers(jogadores,cores);
		
		List<Territory> territories = Territory.getTerritoriesList();
		
		Objective objs[] = new Objective[3];
		//ConquerTerritoryObjective(String description, int numberOfTerritories, int armyPerTerritory,Player player)
		
		objs[0] = new ConquerTerritoryObjective("CT182","Conquistar 18 territórios e ocupar cada um deles com pelo menos 2 exércitos", 18, 2, null);
		objs[1] = new ConquerTerritoryObjective("CT241","Conquistar 24 territórios", 24, 1,null);
		objs[2] = new ConquerTerritoryObjective("CT241","Conquistar 24 territórios", 24, 1,null);
		
		gE.getPlayer(0).setObjective(objs[0]);
		gE.getPlayer(1).setObjective(objs[1]);
		gE.getPlayer(2).setObjective(objs[2]);
		
		
		//player 1 will have his objective conquered
		for(int i=0;i<18;i++) {
			gE.getPlayer(0).manageTerritory(territories.get(i),2);
		}
		
		
		//player 2 will have his objective conquered
		for(int i=18;i<42;i++) {
			gE.getPlayer(1).manageTerritory(territories.get(i),1);
		}
		
		//player 3 will not have territories
		
		for(int i=0;i<3;i++) {
			System.out.println("Objective complete: " + gE.getPlayer(i).getObj().ValidateObjective());
		}	
		
	}

	private static void  testConquerContinentObjective() {
		
		System.out.println("-------------TEST CONQUER CONTINENT OBJECTIVE--------------");
		
		gE.createPlayerList(3);
		Territory.initialize();
		Continent.initialize();
		
		//Index for each continent on Continents List
		int NA = 0;
		int SA = 1;
	    int AF = 2;
	    int EU = 3;
		int AS = 4;
	    int OC = 5;
		
		String[] jogadores = {"Mario","Luigi","Peach"};
		
		String[] cores = {"Azul","Vermelho","Preto"};
		
		gE.addPlayers(jogadores,cores);
		
		Objective.initialize();
		
		
		System.out.println("P1 conquers NA,SA,EU, expects true");
		
		gE.getPlayer(0).setObjective(Objective.getObjective("CCEUSA1"));
		gE.getPlayer(0).getObj().getDescription();
		
		
		//NA, SA and EU
		gE.getPlayer(0).manageContinent(Continent.getContinent(NA),1);
		gE.getPlayer(0).manageContinent(Continent.getContinent(SA),1);
		gE.getPlayer(0).manageContinent(Continent.getContinent(EU),1);
		
		
		System.out.println("Objective complete: " + gE.getPlayer(0).getObj().ValidateObjective());
		
		
		//looses NA (extra continent)
		gE.getPlayer(0).loseContinent(Continent.getContinent(NA));
		
		System.out.println("P1 conquers SA,EU, but not NA, expects false");
		
		System.out.println("Objective complete: " + gE.getPlayer(0).getObj().ValidateObjective());
		
		System.out.println("P1 conquers SA,EU, and AS, expects true");
		
		
		// looses NA (extra continent)
		gE.getPlayer(0).manageContinent(Continent.getContinent(AS),1);
		
		System.out.println("Objective complete: " + gE.getPlayer(0).getObj().ValidateObjective());
		
		gE.getPlayer(0).resetPlayer();
		
		System.out.println("P2 conquers NA,OC, expects true");
		
		gE.getPlayer(2).setObjective(Objective.getObjective("CCNAOC0"));
		
		//NA
		gE.getPlayer(2).manageContinent(Continent.getContinent(NA),1);
		
		
		//OC
		gE.getPlayer(2).manageContinent(Continent.getContinent(OC),1);
		
		
		System.out.println("Objective complete: " + gE.getPlayer(2).getObj().ValidateObjective());
		
		System.out.println("P2 conquers NA, but not OC, expects false");
		
		//looses OC
		gE.getPlayer(2).loseContinent(Continent.getContinent(OC));
		
		System.out.println("Objective complete: " + gE.getPlayer(2).getObj().ValidateObjective());
		
		
	}
	
	public static void testMethods()
	{
		gE.initializeGameComponents();
		
		//Instances log
		
		System.out.println("------------------CARDS---------------------");
		System.out.println();
		for(Card c:Card.getCardList())
		{
			if(c.getTerritory() != null)
				System.out.println(c.getShape().name() +", "+ c.getTerritory().getName());
			else
				System.out.println(c.getShape().name());
			System.out.println();
		}
		
		System.out.println("---------------TERRITORIES-----------");
		System.out.println();
		for(Territory t:Territory.getTerritoriesList())
		{
			System.out.println("Name:" );
			System.out.println(t.getName());
			
			System.out.println("\tNeighbours:" );
			for(String n:t.getNeighbors())
			{
				System.out.println("\t" + n);
			}
			System.out.println();
		}
		
		System.out.println("--------------CONTINENTS-----------------");
		System.out.println();
		for(Continent c:Continent.getContinentList())
		{
			System.out.println("Name:" );
			System.out.println(c.getName());
			
			System.out.println("\tTerritories:" );
			for(Territory t:c.getTerritories())
			{
				System.out.println("\t" + t.getName());
			}
			System.out.println();
		}
		
		gE.firstDraw();
		
		System.out.println("------------PLAYER ORDER-------------------");
		System.out.println();
		for(Player p:gE.getPlayerList())
		{
			System.out.println(p.getName());
		}
		System.out.print("\n");
		
		System.out.println("------------ALL OBJECTIVES-------------------");
		System.out.println();
		for(Objective o:Objective.getObjectiveList())
		{
			System.out.println(o.getDescription());
			System.out.println();
		}

		for(Player p:gE.getPlayerList())
		{
			System.out.println("------------------"+ p.getName() + "-" + p.getColor() + "----------------------------");
			System.out.println("\tObjetivo: ");
			System.out.println("\t\t"+p.getObj().getDescription());
			
			System.out.println("\tCartas: ");
			for(Card c:p.getAllCards())
			{
				System.out.println("\t\t"+c.getShape()+", "+c.getTerritory().getName());
			}
			
			System.out.println("\tTerritorios: ");
			for(Territory t:p.getAllTerritories()) 
			{
				System.out.println("\t\t"+t.getName());
			}
		}
	}

	
	}


