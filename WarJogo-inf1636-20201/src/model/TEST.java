package model;
import java.util.*;

public class TEST {
	
	
	public static void testValidateCardTrade()
	{
		System.out.println("-------------TEST CARD TRADE--------------");
		
		
		
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
	
	public static void testCreatePlayerList()
	{
		System.out.println("----------------TEST CREATE PLAYER LIST----------------");
		
		System.out.println("With 2 players: " + GameExecution.createPlayerList(2));
		System.out.println("With 3 players: " + GameExecution.createPlayerList(3));
		System.out.println("With 6 players: " + GameExecution.createPlayerList(6));
		System.out.println("With 7 players: " + GameExecution.createPlayerList(7));
		
		GameExecution.resetPlayers();
	}
	
	public static void testAddPlayers()
	{
		System.out.println("----------------TEST ADD PLAYERS----------------");
		
		System.out.println("3 players: ");
		
		//public static boolean addPlayers(String[] names, String[] colors)
		
		System.out.println("\ncorrectly adds 3 players: expects true");
		GameExecution.createPlayerList(3);
		
		String[] jogadores1 = {"Hashirama","Tobirama","Hiruzen"};
		
		String[] cores1 = {"Azul","Vermelho","Preto"};
		
		boolean result = GameExecution.addPlayers(jogadores1,cores1);
		
		System.out.println(result);
		
		for(int i= 0;i < 3; i++) {
			System.out.println(GameExecution.getPlayer(i).getName());
		}
		
		GameExecution.resetPlayers();
		
		System.out.println("\nincorrectly adds 2 players: expects false");
		GameExecution.createPlayerList(2);
		
		String[] jogadores2 = {"Hashirama","Tobirama"};
		
		String[] cores2 = {"Azul","Vermelho"};
		
		System.out.println(GameExecution.addPlayers(jogadores2,cores2));
		
		GameExecution.resetPlayers();
		
		System.out.println("\nincorrectly adds 3 players with repeated color: expects false");
		GameExecution.createPlayerList(3);
		
		String[] jogadores3 = {"Hashirama","Madara","Tobirama"};
		
		String[] cores3 = {"Azul","Azul","Vermelho"};
		
		System.out.println(GameExecution.addPlayers(jogadores3,cores3));
		
		GameExecution.resetPlayers();
		
		System.out.println("\nincorrectly adds 3 players with non-existent color: expects false");
		GameExecution.createPlayerList(3);
		
		String[] jogadores4 = {"Hashirama","Madara","Tobirama"};
		
		String[] cores4 = {"Azul","Laranja","Vermelho"};
		
		System.out.println(GameExecution.addPlayers(jogadores4,cores4));
		
		GameExecution.resetPlayers();
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
	    
	    Territory Venezuela = new Territory("Venezuela", venezuela_n);
		Territory Peru = new Territory("Peru", peru_n);
		
		//public Player(String n,GameColor c) {
		
		Player p1 = new Player("Eduardo",GameColor.Vermelho);
		Player p2 = new Player("Gabriel",GameColor.Azul);
		
		p1.manageTerritory(Venezuela, 5);
		p2.manageTerritory(Peru, 3);
		
		System.out.println("BEFORE ATTACK: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = GameExecution.executeAttack(Venezuela , Peru, atk , def );
		
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
	    Territory Venezuela = new Territory("Venezuela", venezuela_n);
		Territory Peru = new Territory("Peru", peru_n);
		
		Player p1 = new Player("Eduardo",GameColor.Vermelho);
		Player p2 = new Player("Gabriel",GameColor.Azul);
		
		p1.manageTerritory(Venezuela, 1);
		p2.manageTerritory(Peru, 5);
		
		boolean result;
		
		System.out.println("\nincorrectly move troops of different colors");
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = GameExecution.moveTroops(Venezuela,Peru,1);
		
		System.out.println(result);
		
		System.out.println("AFTER MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		System.out.println("\nincorrectly move stationary troops ");
		
		Venezuela.setColor(Peru.getColor());
		
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = GameExecution.moveTroops(Venezuela,Peru,1);
		
		System.out.println(result);
		
		System.out.println("AFTER MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		System.out.println("\ncorrectly move 2 troops ");
		
		Venezuela.setTroops(3);
		
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = GameExecution.moveTroops(Venezuela,Peru,2);
		
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
	    
		Territory Venezuela = new Territory("Venezuela", venezuela_n);
		Territory Peru = new Territory("Peru", peru_n);
		Territory Argentina = new Territory("Argentina", argentina_n);
		Territory Brasil = new Territory("Brasil", brasil_n);
		
		
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
		GameExecution.resetAll();
		GameExecution.createPlayerList(3);
		Territory.initialize();
		Continent.initialize();
		
		String[] jogadores = {"Mario","Luigi","Peach"};
		
		String[] cores = {"Azul","Vermelho","Preto"};
		
		GameExecution.addPlayers(jogadores,cores);
		
		Objective objs[] = new Objective[3];
		//DestroyArmyObjective(String description, Player target,Player player)
		objs[0] = new DestroyArmyObjective("Destruir totalmente os ex�rcitos do jogador " + GameExecution.getPlayer(0).getColor().name(),GameExecution.getPlayer(0),null);
		objs[1] = new DestroyArmyObjective("Destruir totalmente os ex�rcitos do jogador " + GameExecution.getPlayer(1).getColor().name(),GameExecution.getPlayer(1),null);
		objs[2] = new DestroyArmyObjective("Destruir totalmente os ex�rcitos do jogador " + GameExecution.getPlayer(2).getColor().name(),GameExecution.getPlayer(2),null);
		
		GameExecution.getPlayer(0).setObjective(objs[1]);
		GameExecution.getPlayer(1).setObjective(objs[2]);
		GameExecution.getPlayer(2).setObjective(objs[0]);
		
		
		//add territories to all players
	    
	    System.out.println("\ncorrectly eliminate target player. expects [T,F,F]");
	    
	    GameExecution.getPlayer(0).manageTerritory(Territory.getTerritory("Argentina"),4);
	    GameExecution.getPlayer(1).manageTerritory(Territory.getTerritory("Brasil"),3);
	    GameExecution.getPlayer(2).manageTerritory(Territory.getTerritory("Peru"),3);
		
		//destroyArmyObjective holding player will win attack against his target
		
		int [] max_value = {6,6,6};
		
		int [] min_value = {1,1,1};
		
		// attack (int attacker, int defender, String src, String target, int[] attackDice, int[] defenseDice)
		GameExecution.attack(0,1,"Argentina","Brasil", max_value , min_value);
		
		for(int i=0;i<3;i++) {
			System.out.println("Objective complete: " + GameExecution.getPlayer(i).getObj().ValidateObjective());
		}
		
		//red will win by having 24 territories
		GameExecution.resetAll();
		GameExecution.createPlayerList(3);
		Territory.initialize();
		Continent.initialize();
		GameExecution.addPlayers(jogadores,cores);
		
		
		System.out.println("\ncorrectly conquer 24 territories after target player is defeated by someone else. expects [T,F,F]");
		
		//lots of stub territories to give red a lot of territories
		int i_turf = 0;
		
		while(i_turf < 30) {
			if(i_turf < 9 || i_turf > 11) {
				GameExecution.getPlayer(0).manageTerritory(Territory.getTerritory(i_turf),1);
			}
			i_turf++;
		}
	    
	    GameExecution.getPlayer(0).manageTerritory(Territory.getTerritory("Argentina"),4);
	    GameExecution.getPlayer(1).manageTerritory(Territory.getTerritory("Brasil"),3);
	    GameExecution.getPlayer(2).manageTerritory(Territory.getTerritory("Peru"),4);
		
	    GameExecution.getPlayer(0).setObjective(objs[1]);
	    GameExecution.getPlayer(1).setObjective(objs[2]);
	    GameExecution.getPlayer(2).setObjective(objs[0]);
		
	    
		GameExecution.attack(2,1,"Peru","Brasil", max_value , min_value);
		
		
		for(int i=0;i<3;i++) {
			System.out.println("Objective complete: " + GameExecution.getPlayer(i).getObj().ValidateObjective());
		}
		
		
	}
	
	private static void  testConquerTerritoryObjective() {
		
		System.out.println("-------------TEST CONQUER TERRITORY OBJECTIVE--------------");
		
		System.out.println("Both P1 and P2 have enough territories, expects [T,T,F]");
		
		//setting the stage
		
		GameExecution.resetAll();
		GameExecution.createPlayerList(3);
		Territory.initialize();
		Continent.initialize();
		
		String[] jogadores = {"Mario","Luigi","Peach"};
		
		String[] cores = {"Azul","Vermelho","Preto"};
		
		GameExecution.addPlayers(jogadores,cores);
		
		List<Territory> territories = Territory.getTerritoriesList();
		
		Objective objs[] = new Objective[3];
		//ConquerTerritoryObjective(String description, int numberOfTerritories, int armyPerTerritory,Player player)
		
		objs[0] = new ConquerTerritoryObjective("Conquistar 18 territ�rios e ocupar cada um deles com pelo menos 2 ex�rcitos", 18, 2, null);
		objs[1] = new ConquerTerritoryObjective("Conquistar 24 territ�rios", 24, 1,null);
		objs[2] = new ConquerTerritoryObjective("Conquistar 24 territ�rios", 24, 1,null);
		
		GameExecution.getPlayer(0).setObjective(objs[0]);
		GameExecution.getPlayer(1).setObjective(objs[1]);
		GameExecution.getPlayer(2).setObjective(objs[2]);
		
		
		//player 1 will have his objective conquered
		for(int i=0;i<18;i++) {
			GameExecution.getPlayer(0).manageTerritory(territories.get(i),2);
		}
		
		
		//player 2 will have his objective conquered
		for(int i=18;i<42;i++) {
			GameExecution.getPlayer(1).manageTerritory(territories.get(i),1);
		}
		
		//player 3 will not have territories
		
		for(int i=0;i<3;i++) {
			System.out.println("Objective complete: " + GameExecution.getPlayer(i).getObj().ValidateObjective());
		}
	
		GameExecution.resetAll();
		
		
	}

	private static void  testConquerContinentObjective() {
		
		System.out.println("-------------TEST CONQUER CONTINENT OBJECTIVE--------------");
		
		GameExecution.resetAll();
		GameExecution.createPlayerList(3);
		Territory.initialize();
		Continent.initialize();
		
		String[] jogadores = {"Mario","Luigi","Peach"};
		
		String[] cores = {"Azul","Vermelho","Preto"};
		
		GameExecution.addPlayers(jogadores,cores);
		
		Objective.initialize();
		
		
		System.out.println("P1 conquers NA,SA,EU, expects true");
		
		GameExecution.getPlayer(0).setObjective(Objective.getObjective(8));
		GameExecution.getPlayer(0).getObj().getDescription();
		
		
		for(int i = 0; i < 2; i++) { //NA and SA
			GameExecution.getPlayer(0).manageContinent(continents.get(i),1);	
		}
		
		//EU
		GameExecution.getPlayer(0).manageContinent(continents.get(3),1);
		
		System.out.println("Objective complete: " + GameExecution.getPlayer(0).getObj().ValidateObjective());
		
		
		//looses NA (extra continent)
		GameExecution.getPlayer(0).loseContinent(continents.get(0));
		
		System.out.println("P1 conquers SA,EU, but not NA, expects false");
		
		System.out.println("Objective complete: " + GameExecution.getPlayer(0).getObj().ValidateObjective());
		
		System.out.println("P1 conquers SA,EU, and NA again, expects true");
		
		
		// looses NA (extra continent)
		GameExecution.getPlayer(0).manageContinent(continents.get(0),1);
		
		System.out.println("Objective complete: " + GameExecution.getPlayer(0).getObj().ValidateObjective());
		
		GameExecution.getPlayer(0).resetPlayer();
		
		System.out.println("P2 conquers NA,OC, expects true");
		
		GameExecution.getPlayer(2).setObjective(objectives.get(10));
		
		//NA
		GameExecution.getPlayer(2).manageContinent(continents.get(0),1);
		
		
		//OC
		GameExecution.getPlayer(2).manageContinent(continents.get(5),1);
		
		
		System.out.println("Objective complete: " + GameExecution.getPlayer(2).getObj().ValidateObjective());
		
		System.out.println("P2 conquers NA, but not OC, expects false");
		
		//looses OC
		GameExecution.getPlayer(0).loseContinent(continents.get(5));
		
		System.out.println("Objective complete: " + GameExecution.getPlayer(2).getObj().ValidateObjective());
		
		
	}
	
	public static void testMethods()
	{
		GameExecution.initializeGameComponents();
		
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
		
		GameExecution.firstDraw();
		
		System.out.println("------------PLAYER ORDER-------------------");
		System.out.println();
		for(Player p:GameExecution.getPlayerList())
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

		for(Player p:GameExecution.getPlayerList())
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


