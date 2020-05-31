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
		
		
		
		System.out.println("correctly use 3 cards of same shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[4]);
		test_subject.add(cards[5]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		
		System.out.println("correctly use 3 cards of different shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 4 cards for trade");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		test_subject.add(cards[3]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 0 cards for trade");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 2 cards of same shape and other of different-nonjoker shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[5]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 2 cards of different shape and other of repeated-nonjoker shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[3]);
		test_subject.add(cards[4]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use first card with different shape of second and second card with equal shape of third");
		test_subject.add(cards[1]);
		test_subject.add(cards[4]);
		test_subject.add(cards[5]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("correctly deal 2 equal cards with 1 joker");
		test_subject.add(cards[1]);
		test_subject.add(cards[3]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		
		System.out.println("correctly deal 2 diferent cards with  1 joker");
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("correctly deal trade with 2 jokers and 1 extra card");
		test_subject.add(cards[1]);
		test_subject.add(cards[7]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
	}
	
	public static void testCreatePlayerList()
	{
		System.out.println("----------------TEST CREATE PLAYER LIST----------------");
		
		System.out.println("With 2 players: " + Model.createPlayerList(2));
		System.out.println("With 3 players: " + Model.createPlayerList(3));
		System.out.println("With 6 players: " + Model.createPlayerList(6));
		System.out.println("With 7 players: " + Model.createPlayerList(7));
	}
	
	public static void testAddPlayer()
	{
		System.out.println("----------------TEST ADD PLAYER----------------");
		
		Model.createPlayerList(3);
		System.out.println("3 players: ");
		
		System.out.println("Adding null: " + Model.addPlayer(null));
		System.out.println("Adding first player: " + Model.addPlayer(new Player("Hashirama", Color.Azul)));
		System.out.println("Adding second player: " + Model.addPlayer(new Player("Tobirama", Color.Vermelho)));
		System.out.println("Adding third player and repeating color: " + Model.addPlayer(new Player("Madara", Color.Vermelho)));
		System.out.println("Adding third player: " + Model.addPlayer(new Player("Hiruzen", Color.Preto)));
		System.out.println("Adding forth player: " + Model.addPlayer(new Player("Minato", Color.Branco)));
		System.out.println("Adding fifth player: " + Model.addPlayer(new Player("Tsunade", Color.Amarelo)));
		System.out.println("Adding sixth player: " + Model.addPlayer(new Player("Kakashi", Color.Verde)));
		System.out.println("Adding seventh player: " + Model.addPlayer(new Player("Naruto", Color.Branco)));
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
	    
	    Territory Venezuela = new Territory("Venezuela",Color.Vermelho, venezuela_n);
		Territory Peru = new Territory("Peru",Color.Azul, peru_n);
		
		Venezuela.setTroops(5);
		Peru.setTroops(3);
		
		System.out.println("BEFORE ATTACK: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = Model.executeAttack(Venezuela , Peru, atk , def );
		
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
	    
	    Territory Venezuela = new Territory("Venezuela",Color.Azul, venezuela_n);
		Territory Peru = new Territory("Peru",Color.Vermelho, peru_n);
		
		boolean result;
		
		Venezuela.setTroops(1);
		Peru.setTroops(5);
		
		
		System.out.println("Incorrectly move troops of different colors");
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = Model.moveTroops(Venezuela,Peru,1);
		
		System.out.println(result);
		
		System.out.println("AFTER MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		System.out.println("Incorrectly move stationary troops ");
		
		Venezuela.setColor(Peru.getColor());
		
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = Model.moveTroops(Venezuela,Peru,1);
		
		System.out.println(result);
		
		System.out.println("AFTER MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());
		
		System.out.println("Correctly move 2 troops ");
		
		Venezuela.setTroops(3);
		
		System.out.println("BEFORE MOVE: ");
		
		System.out.println(Venezuela.getName() + "-" + Venezuela.getColor() + " : " + Venezuela.getTroops());
		System.out.println(Peru.getName() + "-" + Peru.getColor() + " : " + Peru.getTroops());

		result = Model.moveTroops(Venezuela,Peru,2);
		
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
		
		Territory Venezuela = new Territory("Venezuela",Color.Vermelho, venezuela_n);
		Territory Peru = new Territory("Peru",Color.Azul, peru_n);
		Territory Argentina = new Territory("Argentina",Color.Azul, argentina_n);
		Territory Brasil = new Territory("Brasil",Color.Azul, brasil_n);
		
		Venezuela.setTroops(1);
		Peru.setTroops(5);
		Argentina.setTroops(2);
		Brasil.setTroops(1);
		
		//public static boolean validateAttack(Color c,Territory src,Territory target,int n_Troops_Attacking)
		
		
		System.out.println("can't attack with enemy troops");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Venezuela,Peru,1));
		
		System.out.println("can't attack yourself");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Brasil,Peru,1));
		
		System.out.println("can't do attack with no troops on standby in source");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Brasil,Venezuela,1));
	
		System.out.println("can't attack with more than 3 troops or 0 troops");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,0));
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,4));
		
		System.out.println("verify if target is src's neighbor");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Argentina,Venezuela,1));
		
		System.out.println("valid attack");
		System.out.print("Expects true -> ");
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,1));
	}
	
	public static void testObjectiveValidation (){
		
		testDestroyArmyObjective();
		testConquerTerritoryObjective();
		testConquerContinentObjective();
		
	}
	
	private static void  testDestroyArmyObjective() {
		
		System.out.println("-------------TEST DESTROY ARMY OBJECTIVE--------------");
		
		//setting the stage
		
		Player [] p = new Player[3];
		
		p[0] = new Player("Mario",Color.Vermelho);
		p[1] = new Player("Luigi",Color.Verde);
		p[2] = new Player("Peach",Color.Branco);
		
		
		Objective objs[] = new Objective[3];
		//DestroyArmyObjective(String description, Player target,Player player)
		objs[0] = new DestroyArmyObjective("Destruir totalmente os exércitos do jogador " + p[0].getColor().name(),p[0],null);
		objs[1] = new DestroyArmyObjective("Destruir totalmente os exércitos do jogador " + p[1].getColor().name(),p[1],null);
		objs[2] = new DestroyArmyObjective("Destruir totalmente os exércitos do jogador " + p[2].getColor().name(),p[2],null);
		
		p[0].setObjective(objs[1]);
		p[1].setObjective(objs[2]);
		p[2].setObjective(objs[0]);
		
		Territory [] territories = new Territory[28];
		
		ArrayList<String> mushroom_kingdom_n = new ArrayList<String>(
	    	      Arrays.asList("Beanbean Kingdom","Pillo Kingdom"));
		
		ArrayList<String> beanbean_kingdom_n = new ArrayList<String>(
	    	      Arrays.asList("Pillo Kingdom","Mushroom Kingdom"));
		
		ArrayList<String> pillo_kingdom_n = new ArrayList<String>(
	    	      Arrays.asList("Mushroom Kingdom","Beanbean Kingdom"));
		
		territories[0] 	= new Territory("Mushroom Kingdom"	, mushroom_kingdom_n);
	    territories[1] 	= new Territory("Beanbean Kingdom"	, beanbean_kingdom_n);
	    territories[2]	= new Territory("Pillo Kingdom"		, pillo_kingdom_n	);
		
		
		//add territories to all players
	    
	    System.out.println("Correctly eliminate target player. expects [T,F,F]");
	    
	    p[0].manageTerritory(territories[0],4);
		p[1].manageTerritory(territories[1],3);
		p[2].manageTerritory(territories[2],3);
		
		//destroyArmyObjective holding player will win attack against his target
		
		int [] max_value = {6,6,6};
		
		int [] min_value = {1,1,1};
		
		
		Model.attack(p[0],p[1],territories[0],territories[1], max_value , min_value);
		
		for(int i=0;i<p.length;i++) {
			System.out.println("Objective complete: " + p[i].getObj().ValidateObjective());
		}
		
		for(int i=0;i<p.length;i++) {
			p[i].resetPlayer();
		}
		
		
		System.out.println("Correctly conquer 24 territories after target player is defeated by someone else. expects [T,F,F]");
		
		//lots of stub territories to get red a lot of territories
		
		ArrayList<String> alaska_n = new ArrayList<String>(
	    	      Arrays.asList("Vladvostok","Vancouver","Mackenzie"));
		
		ArrayList<String> california_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Nova York","Ottawa","Vancouver"));
		
		ArrayList<String> groenlandia_n = new ArrayList<String>(
	    	      Arrays.asList("Mackenzie","Labrador","Islandia"));
		
		ArrayList<String> mackenzie_n = new ArrayList<String>(
	    	      Arrays.asList("Alaska","Vancouver","Ottawa","Groenlandia"));
		
		ArrayList<String> labrador_n = new ArrayList<String>(
	    	      Arrays.asList("Groenlandia","Nova York","Ottawa"));
		
		ArrayList<String> mexico_n = new ArrayList<String>(
	    	      Arrays.asList("California","Nova York","Colombia"));
		
		ArrayList<String> nova_york_n = new ArrayList<String>(
	    	      Arrays.asList("Ottawa","Labrador","California","Mexico"));
		
		ArrayList<String> vancouver_n = new ArrayList<String>(
	    	      Arrays.asList("Alaska","Mackenzie","California","Ottawa"));
		
		ArrayList<String> ottawa_n = new ArrayList<String>(
	    	      Arrays.asList("Vancouver","Labrador","Nova York","California","Mackenzie"));
		
		ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Chile","Brasil"));
		
		ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Colombia","Chile","Argentina"));
		
		ArrayList<String> chile_n = new ArrayList<String>(
	    	    Arrays.asList("Argentina","Colombia","Brasil"));
		
	    ArrayList<String> colombia_n = new ArrayList<String>(
	    		Arrays.asList("Mexico","Chile","Brasil"));
	    
	    ArrayList<String> argelia_n = new ArrayList<String>(
	    	      Arrays.asList("Franca","Brasil","Egito","Sudao","Congo"));

	    ArrayList<String> egito_n = new ArrayList<String>(
	    	      Arrays.asList("Polonia","Franca","Oriente Medio","Sudao","Argelia"));
	    
	    ArrayList<String> sudao_n = new ArrayList<String>(
	    	      Arrays.asList("Egito","Argelia","Congo","Madagascar","Africa Do Sul"));
	    
	    ArrayList<String> africa_do_sul_n = new ArrayList<String>(
	    	      Arrays.asList("Congo","Sudao","Madagascar"));
	    
	    ArrayList<String> madagascar_n = new ArrayList<String>(
	    	      Arrays.asList("Sudao","Africa Do Sul"));
	    
	    ArrayList<String> congo_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Sudao","Africa Do Sul"));
	    
	    ArrayList<String> franca_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Egito","Inglaterra","Alemanha","Polonia"));
	    
	    ArrayList<String> polonia_n = new ArrayList<String>(
	    	      Arrays.asList("Moscou","Alemanha","Franca","Egito"));
	    
	    ArrayList<String> inglaterra_n = new ArrayList<String>(
	    	      Arrays.asList("Islandia","Suecia","Alemanha","Franca"));
	    
	    ArrayList<String> alemanha_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra","Franca","Polonia"));
	    
	    ArrayList<String> suecia_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra", "Moscou"));
	    
	    ArrayList<String> islandia_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra","Groenlandia"));
	    
	    ArrayList<String> moscou_n = new ArrayList<String>(
	    	      Arrays.asList("Suecia","Polonia","Omsk","Aral","Oriente Medio"));
	    
	    territories[3] 	= new Territory("Alaska"		, alaska_n);
	    territories[4] 	= new Territory("Mackenzie"		, mackenzie_n);
	    territories[5]	= new Territory("California"	, california_n);
	    territories[6] 	= new Territory("Groenlandia"	, groenlandia_n);
	    territories[7]	= new Territory("Mexico"		, mexico_n);
	    territories[8] 	= new Territory("Nova York"		, nova_york_n);
	    territories[9] 	= new Territory("Labrador"		, labrador_n);
	    territories[10] = new Territory("Ottawa"		, ottawa_n);
	    territories[11] = new Territory("Vancouver"		, vancouver_n);
	    territories[12]	= new Territory("Argentina"		, argentina_n);
	    territories[13] = new Territory("Brasil"		, brasil_n);
	    territories[14] = new Territory("Chile"			, chile_n);
	    territories[15] = new Territory("Colombia"		, colombia_n);
	    territories[16]	= new Territory("Africa Do Sul"	, africa_do_sul_n);
	    territories[17] = new Territory("Sudao"			, sudao_n);
	    territories[18] = new Territory("Argelia"		, argelia_n);
	    territories[19] = new Territory("Egito"			, egito_n);
	    territories[20]	= new Territory("Madagascar"	, madagascar_n);
	    territories[21] = new Territory("Congo"			, congo_n);
	    territories[22]	= new Territory("Islandia"		, islandia_n);
	    territories[23] = new Territory("Franca"		, franca_n);
	    territories[24] = new Territory("Inglaterra"	, inglaterra_n);
	    territories[25]	= new Territory("Polonia"		, polonia_n);
	    territories[26] = new Territory("Suecia"		, suecia_n);
	    territories[27] = new Territory("Moscou"		, moscou_n);
	    
	    for(int i=3;i<territories.length;i++) {
	    	p[0].manageTerritory(territories[i],1);
	    }
		
		
		p[0].manageTerritory(territories[0],4);
		p[1].manageTerritory(territories[1],3);
		p[2].manageTerritory(territories[2],4);
		
		p[0].setObjective(objs[1]);
		p[1].setObjective(objs[2]);
		p[2].setObjective(objs[0]);
		
		Model.attack(p[2],p[1],territories[2],territories[1], max_value , min_value);
		
		
		for(int i=0;i<p.length;i++) {
			System.out.println("Objective complete: " + p[i].getObj().ValidateObjective());
		}
		
	}
	
	private static void  testConquerTerritoryObjective() {
		
		System.out.println("-------------TEST CONQUER TERRITORY OBJECTIVE--------------");
		
		System.out.println("Both P1 and P2 have enough territories, expects [T,T,F]");
		
		Territory territories[] = new Territory[42];
		
		//NA
		
		ArrayList<String> alaska_n = new ArrayList<String>(
	    	      Arrays.asList("Vladvostok","Vancouver","Mackenzie"));
		
		ArrayList<String> california_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Nova York","Ottawa","Vancouver"));
		
		ArrayList<String> groenlandia_n = new ArrayList<String>(
	    	      Arrays.asList("Mackenzie","Labrador","Islandia"));
		
		ArrayList<String> mackenzie_n = new ArrayList<String>(
	    	      Arrays.asList("Alaska","Vancouver","Ottawa","Groenlandia"));
		
		ArrayList<String> labrador_n = new ArrayList<String>(
	    	      Arrays.asList("Groenlandia","Nova York","Ottawa"));
		
		ArrayList<String> mexico_n = new ArrayList<String>(
	    	      Arrays.asList("California","Nova York","Colombia"));
		
		ArrayList<String> nova_york_n = new ArrayList<String>(
	    	      Arrays.asList("Ottawa","Labrador","California","Mexico"));
		
		ArrayList<String> vancouver_n = new ArrayList<String>(
	    	      Arrays.asList("Alaska","Mackenzie","California","Ottawa"));
		
		ArrayList<String> ottawa_n = new ArrayList<String>(
	    	      Arrays.asList("Vancouver","Labrador","Nova York","California","Mackenzie"));
		
		//SA
		
		ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Chile","Brasil"));
		
		ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Colombia","Chile","Argentina"));
		
		ArrayList<String> chile_n = new ArrayList<String>(
	    	    Arrays.asList("Argentina","Colombia","Brasil"));
		
	    ArrayList<String> colombia_n = new ArrayList<String>(
	    		Arrays.asList("Mexico","Chile","Brasil"));
	    
	    
	    //AF
	    
	    ArrayList<String> argelia_n = new ArrayList<String>(
	    	      Arrays.asList("Franca","Brasil","Egito","Sudao","Congo"));

	    ArrayList<String> egito_n = new ArrayList<String>(
	    	      Arrays.asList("Polonia","Franca","Oriente Medio","Sudao","Argelia"));
	    
	    ArrayList<String> sudao_n = new ArrayList<String>(
	    	      Arrays.asList("Egito","Argelia","Congo","Madagascar","Africa Do Sul"));
	    
	    ArrayList<String> africa_do_sul_n = new ArrayList<String>(
	    	      Arrays.asList("Congo","Sudao","Madagascar"));
	    
	    ArrayList<String> madagascar_n = new ArrayList<String>(
	    	      Arrays.asList("Sudao","Africa Do Sul"));
	    
	    ArrayList<String> congo_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Sudao","Africa Do Sul"));
	    
	    
	    //EU
	    
	    ArrayList<String> franca_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Egito","Inglaterra","Alemanha","Polonia"));
	    
	    ArrayList<String> polonia_n = new ArrayList<String>(
	    	      Arrays.asList("Moscou","Alemanha","Franca","Egito"));
	    
	    ArrayList<String> inglaterra_n = new ArrayList<String>(
	    	      Arrays.asList("Islandia","Suecia","Alemanha","Franca"));
	    
	    ArrayList<String> alemanha_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra","Franca","Polonia"));
	    
	    ArrayList<String> suecia_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra", "Moscou"));
	    
	    ArrayList<String> islandia_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra","Groenlandia"));
	    
	    ArrayList<String> moscou_n = new ArrayList<String>(
	    	      Arrays.asList("Suecia","Polonia","Omsk","Aral","Oriente Medio"));
	    
	    //AS
	    
	    ArrayList<String> china_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","Japao","Vietna","India","Aral","Omsk","Tchita"));
	    
	    ArrayList<String> india_n = new ArrayList<String>(
	    	      Arrays.asList("China","Aral","Oriente Medio","Vietna","Sumatra"));
	    
	    ArrayList<String> japao_n = new ArrayList<String>(
	    	      Arrays.asList("China","Vladivostok"));
	    
	    ArrayList<String> vladivostok_n = new ArrayList<String>(
	    	      Arrays.asList("Japao","Tchita","Siberia","China"));
	    
	    ArrayList<String> siberia_n = new ArrayList<String>(
	    	      Arrays.asList("Vladivostok","Tchita","Dudinka"));
	    
	    ArrayList<String> dudinka_n = new ArrayList<String>(
	    	      Arrays.asList("Siberia","Tchita","Mongolia","Omsk"));
	    
	    ArrayList<String> tchita_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","Vladivostok","China","Siberia","Dudinka"));
	    
	    ArrayList<String> omsk_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","China","Aral","Dudinka","Moscou"));
	    
	    ArrayList<String> aral_n = new ArrayList<String>(
	    	      Arrays.asList("Moscou","Omsk","Oriente Medio","China","India"));
	    
	    ArrayList<String> oriente_medio_n = new ArrayList<String>(
	    	      Arrays.asList("Moscou","Aral","India","Egito","Polonia"));
	    
	    ArrayList<String> vietna_n = new ArrayList<String>(
	    	      Arrays.asList("China","India","Borneo"));
	    
	    ArrayList<String> mongolia_n = new ArrayList<String>(
	    	      Arrays.asList("China","Tchita","Dudinka","Omsk"));
	    
	    //OC
	    
	    ArrayList<String> australia_n = new ArrayList<String>(
	    	      Arrays.asList("Sumatra","Nova Guine","Borneo"));
	    
	    ArrayList<String> borneo_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Nova Guine","Vietna"));
	    
	    ArrayList<String> nova_guine_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Borneo"));
	    
	    ArrayList<String> sumatra_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","India"));
		
		territories[0] 	= new Territory("Alaska"		, alaska_n);
	    territories[1] 	= new Territory("Mackenzie"		, mackenzie_n);
	    territories[2]	= new Territory("California"	, california_n);
	    territories[3] 	= new Territory("Groenlandia"	, groenlandia_n);
	    territories[4]	= new Territory("Mexico"		, mexico_n);
	    territories[5] 	= new Territory("Nova York"		, nova_york_n);
	    territories[6] 	= new Territory("Labrador"		, labrador_n);
	    territories[7] 	= new Territory("Ottawa"		, ottawa_n);
	    territories[8] 	= new Territory("Vancouver"		, vancouver_n);
	    territories[9]	= new Territory("Argentina"		, argentina_n);
	    territories[10] = new Territory("Brasil"		, brasil_n);
	    territories[11] = new Territory("Chile"			, chile_n);
	    territories[12] = new Territory("Colombia"		, colombia_n);
	    territories[13]	= new Territory("Africa Do Sul"	, africa_do_sul_n);
	    territories[14] = new Territory("Sudao"			, sudao_n);
	    territories[15] = new Territory("Argelia"		, argelia_n);
	    territories[16] = new Territory("Egito"			, egito_n);
	    territories[17]	= new Territory("Madagascar"	, madagascar_n);
	    territories[18] = new Territory("Congo"			, congo_n);
	    territories[19]	= new Territory("Islandia"		, islandia_n);
	    territories[20] = new Territory("Franca"		, franca_n);
	    territories[21] = new Territory("Inglaterra"	, inglaterra_n);
	    territories[22]	= new Territory("Polonia"		, polonia_n);
	    territories[23] = new Territory("Suecia"		, suecia_n);
	    territories[24] = new Territory("Moscou"		, moscou_n);
	    territories[25] = new Territory("Alemanha"		, alemanha_n);
	    territories[26] = new Territory("China"			, china_n);
	    territories[27] = new Territory("India"			, india_n);
	    territories[28] = new Territory("Japao"			, japao_n);
	    territories[29] = new Territory("Dudinka"		, dudinka_n);
	    territories[30] = new Territory("Aral"			, aral_n);
	    territories[31] = new Territory("Mongolia"		, mongolia_n);
	    territories[32] = new Territory("Oriente Medio"	, oriente_medio_n);
	    territories[33] = new Territory("Omsk"			, omsk_n);
	    territories[34] = new Territory("Siberia"		, siberia_n);
	    territories[35] = new Territory("Tchita"		, tchita_n);
	    territories[36] = new Territory("Vietna"		, vietna_n);
	    territories[37] = new Territory("Vladivostok"	, vladivostok_n);
	    territories[38] = new Territory("Australia"		, australia_n);
	    territories[39] = new Territory("Sumatra"		, sumatra_n);
	    territories[40] = new Territory("Nova Guine"	, nova_guine_n);
	    territories[41] = new Territory("Borneo"		, borneo_n);
	    
	    Player [] p = new Player[3];
		
		p[0] = new Player("Mario",Color.Vermelho);
		p[1] = new Player("Luigi",Color.Verde);
		p[2] = new Player("Peach",Color.Branco);
		
		Objective objs[] = new Objective[3];
		//ConquerTerritoryObjective(String description, int numberOfTerritories, int armyPerTerritory,Player player)
		
		objs[0] = new ConquerTerritoryObjective("Conquistar 18 territórios e ocupar cada um deles com pelo menos 2 exércitos", 18, 2, null);
		objs[1] = new ConquerTerritoryObjective("Conquistar 24 territórios", 24, 1,null);
		objs[2] = new ConquerTerritoryObjective("Conquistar 24 territórios", 24, 1,null);
		
		p[0].setObjective(objs[0]);
		p[1].setObjective(objs[1]);
		p[2].setObjective(objs[2]);
		
		//player 1 will have his objective conquered
		for(int i=0;i<18;i++) {
			p[0].manageTerritory(territories[i],2);
		}
		
		//player 2 will have his objective conquered
		for(int i=18;i<42;i++) {
			p[1].manageTerritory(territories[i],1);
		}
		
		//player 3 will not have territories
		
		
		for(int i=0;i<p.length;i++) {
			System.out.println("Objective complete: " + p[i].getObj().ValidateObjective());
		}
	
		
	}

	private static void  testConquerContinentObjective() {
		
System.out.println("-------------TEST CONQUER CONTINENT OBJECTIVE--------------");
		
		Territory territories[] = new Territory[42];
		
		//NA
		
		ArrayList<String> alaska_n = new ArrayList<String>(
	    	      Arrays.asList("Vladvostok","Vancouver","Mackenzie"));
		
		ArrayList<String> california_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Nova York","Ottawa","Vancouver"));
		
		ArrayList<String> groenlandia_n = new ArrayList<String>(
	    	      Arrays.asList("Mackenzie","Labrador","Islandia"));
		
		ArrayList<String> mackenzie_n = new ArrayList<String>(
	    	      Arrays.asList("Alaska","Vancouver","Ottawa","Groenlandia"));
		
		ArrayList<String> labrador_n = new ArrayList<String>(
	    	      Arrays.asList("Groenlandia","Nova York","Ottawa"));
		
		ArrayList<String> mexico_n = new ArrayList<String>(
	    	      Arrays.asList("California","Nova York","Colombia"));
		
		ArrayList<String> nova_york_n = new ArrayList<String>(
	    	      Arrays.asList("Ottawa","Labrador","California","Mexico"));
		
		ArrayList<String> vancouver_n = new ArrayList<String>(
	    	      Arrays.asList("Alaska","Mackenzie","California","Ottawa"));
		
		ArrayList<String> ottawa_n = new ArrayList<String>(
	    	      Arrays.asList("Vancouver","Labrador","Nova York","California","Mackenzie"));
		
		//SA
		
		ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Chile","Brasil"));
		
		ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Colombia","Chile","Argentina"));
		
		ArrayList<String> chile_n = new ArrayList<String>(
	    	    Arrays.asList("Argentina","Colombia","Brasil"));
		
	    ArrayList<String> colombia_n = new ArrayList<String>(
	    		Arrays.asList("Mexico","Chile","Brasil"));
	    
	    
	    //AF
	    
	    ArrayList<String> argelia_n = new ArrayList<String>(
	    	      Arrays.asList("Franca","Brasil","Egito","Sudao","Congo"));

	    ArrayList<String> egito_n = new ArrayList<String>(
	    	      Arrays.asList("Polonia","Franca","Oriente Medio","Sudao","Argelia"));
	    
	    ArrayList<String> sudao_n = new ArrayList<String>(
	    	      Arrays.asList("Egito","Argelia","Congo","Madagascar","Africa Do Sul"));
	    
	    ArrayList<String> africa_do_sul_n = new ArrayList<String>(
	    	      Arrays.asList("Congo","Sudao","Madagascar"));
	    
	    ArrayList<String> madagascar_n = new ArrayList<String>(
	    	      Arrays.asList("Sudao","Africa Do Sul"));
	    
	    ArrayList<String> congo_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Sudao","Africa Do Sul"));
	    
	    
	    //EU
	    
	    ArrayList<String> franca_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Egito","Inglaterra","Alemanha","Polonia"));
	    
	    ArrayList<String> polonia_n = new ArrayList<String>(
	    	      Arrays.asList("Moscou","Alemanha","Franca","Egito"));
	    
	    ArrayList<String> inglaterra_n = new ArrayList<String>(
	    	      Arrays.asList("Islandia","Suecia","Alemanha","Franca"));
	    
	    ArrayList<String> alemanha_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra","Franca","Polonia"));
	    
	    ArrayList<String> suecia_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra", "Moscou"));
	    
	    ArrayList<String> islandia_n = new ArrayList<String>(
	    	      Arrays.asList("Inglaterra","Groenlandia"));
	    
	    ArrayList<String> moscou_n = new ArrayList<String>(
	    	      Arrays.asList("Suecia","Polonia","Omsk","Aral","Oriente Medio"));
	    
	    //AS
	    
	    ArrayList<String> china_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","Japao","Vietna","India","Aral","Omsk","Tchita"));
	    
	    ArrayList<String> india_n = new ArrayList<String>(
	    	      Arrays.asList("China","Aral","Oriente Medio","Vietna","Sumatra"));
	    
	    ArrayList<String> japao_n = new ArrayList<String>(
	    	      Arrays.asList("China","Vladivostok"));
	    
	    ArrayList<String> vladivostok_n = new ArrayList<String>(
	    	      Arrays.asList("Japao","Tchita","Siberia","China"));
	    
	    ArrayList<String> siberia_n = new ArrayList<String>(
	    	      Arrays.asList("Vladivostok","Tchita","Dudinka"));
	    
	    ArrayList<String> dudinka_n = new ArrayList<String>(
	    	      Arrays.asList("Siberia","Tchita","Mongolia","Omsk"));
	    
	    ArrayList<String> tchita_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","Vladivostok","China","Siberia","Dudinka"));
	    
	    ArrayList<String> omsk_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","China","Aral","Dudinka","Moscou"));
	    
	    ArrayList<String> aral_n = new ArrayList<String>(
	    	      Arrays.asList("Moscou","Omsk","Oriente Medio","China","India"));
	    
	    ArrayList<String> oriente_medio_n = new ArrayList<String>(
	    	      Arrays.asList("Moscou","Aral","India","Egito","Polonia"));
	    
	    ArrayList<String> vietna_n = new ArrayList<String>(
	    	      Arrays.asList("China","India","Borneo"));
	    
	    ArrayList<String> mongolia_n = new ArrayList<String>(
	    	      Arrays.asList("China","Tchita","Dudinka","Omsk"));
	    
	    //OC
	    
	    ArrayList<String> australia_n = new ArrayList<String>(
	    	      Arrays.asList("Sumatra","Nova Guine","Borneo"));
	    
	    ArrayList<String> borneo_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Nova Guine","Vietna"));
	    
	    ArrayList<String> nova_guine_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Borneo"));
	    
	    ArrayList<String> sumatra_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","India"));
	    
	    int NA = 0;
		int SA = 1;
	    int AF = 2;
	    int EU = 3;
		int AS = 4;
	    int OC = 5;
	    
	    Continent continents[] = new Continent[6];
		
	    //NA
	    
	    territories[0] 	= new Territory("Alaska"		, alaska_n);
	    territories[1] 	= new Territory("Mackenzie"		, mackenzie_n);
	    territories[2]	= new Territory("California"	, california_n);
	    territories[3] 	= new Territory("Groenlandia"	, groenlandia_n);
	    territories[4]	= new Territory("Mexico"		, mexico_n);
	    territories[5] 	= new Territory("Nova York"		, nova_york_n);
	    territories[6] 	= new Territory("Labrador"		, labrador_n);
	    territories[7] 	= new Territory("Ottawa"		, ottawa_n);
	    territories[8] 	= new Territory("Vancouver"		, vancouver_n);
	    
	    
	    Territory[] northAmerica = new Territory[9];
	    int cont_all_territories = 0;
	    
	    for(int i = 0; i < 9; i++)
	    {
	    	 northAmerica[i] = territories[cont_all_territories];
	    	 cont_all_territories++;
	    }
	    
	    continents[NA] = new Continent("América do Norte", northAmerica, 5);
	    
		//SA
	    
	    territories[9]	= new Territory("Argentina"		, argentina_n);
	    territories[10] = new Territory("Brasil"		, brasil_n);
	    territories[11] = new Territory("Chile"			, chile_n);
	    territories[12] = new Territory("Colombia"		, colombia_n);
	    
	    Territory[] southAmerica = new Territory[4];
	    
	    for(int i = 0; i < 4; i++)
	    {
	    	 southAmerica[i] = territories[cont_all_territories];
	    	 cont_all_territories++;
	    }
	    
	    continents[SA] = new Continent("América do Sul", southAmerica, 2);
	    
	    //AF
	    
	    territories[13]	= new Territory("Africa Do Sul"	, africa_do_sul_n);
	    territories[14] = new Territory("Sudao"			, sudao_n);
	    territories[15] = new Territory("Argelia"		, argelia_n);
	    territories[16] = new Territory("Egito"			, egito_n);
	    territories[17]	= new Territory("Madagascar"	, madagascar_n);
	    territories[18] = new Territory("Congo"			, congo_n);
	    
	    Territory[] africa = new Territory[6];
	    
	    for(int i = 0; i < 6; i++)
	    {
	    	 africa[i] = territories[cont_all_territories];
	    	 cont_all_territories++;
	    }
	    
	    continents[AF] = new Continent("África", africa, 3);
	    
	    //EU
	    
	    territories[19]	= new Territory("Islandia"		, islandia_n);
	    territories[20] = new Territory("Franca"		, franca_n);
	    territories[21] = new Territory("Inglaterra"	, inglaterra_n);
	    territories[22]	= new Territory("Polonia"		, polonia_n);
	    territories[23] = new Territory("Suecia"		, suecia_n);
	    territories[24] = new Territory("Moscou"		, moscou_n);
	    territories[25] = new Territory("Alemanha"		, alemanha_n);
	    
	    Territory[] europe = new Territory[7];
	    
	    for(int i = 0; i < 7; i++)
	    {
	    	 europe[i] = territories[cont_all_territories];
	    	 cont_all_territories++;
	    }
	    
	    continents[EU] = new Continent("Europa", northAmerica, 5);
	    
	    //AS
	    
	    territories[26] = new Territory("China"			, china_n);
	    territories[27] = new Territory("India"			, india_n);
	    territories[28] = new Territory("Japao"			, japao_n);
	    territories[29] = new Territory("Dudinka"		, dudinka_n);
	    territories[30] = new Territory("Aral"			, aral_n);
	    territories[31] = new Territory("Mongolia"		, mongolia_n);
	    territories[32] = new Territory("Oriente Medio"	, oriente_medio_n);
	    territories[33] = new Territory("Omsk"			, omsk_n);
	    territories[34] = new Territory("Siberia"		, siberia_n);
	    territories[35] = new Territory("Tchita"		, tchita_n);
	    territories[36] = new Territory("Vietna"		, vietna_n);
	    territories[37] = new Territory("Vladivostok"	, vladivostok_n);
	    
	    Territory[] asia = new Territory[12];
	    
	    for(int i = 0; i < 12; i++)
	    {
	    	 asia[i] = territories[cont_all_territories];
	    	 cont_all_territories++;
	    }
	    
	    continents[AS] = new Continent("Asia", asia, 7);
	    
	    //OC
	    
	    territories[38] = new Territory("Australia"		, australia_n);
	    territories[39] = new Territory("Sumatra"		, sumatra_n);
	    territories[40] = new Territory("Nova Guine"	, nova_guine_n);
	    territories[41] = new Territory("Borneo"		, borneo_n);
	    
	    Territory[] oceania = new Territory[4];
	    
	    for(int i = 0; i < 4; i++)
	    {
	    	 oceania[i] = territories[cont_all_territories];
	    	 cont_all_territories++;
	    }
	    
	    continents[OC] = new Continent("Oceania", oceania, 2);
	    
	    
	    Player [] p = new Player[3];
		
		p[0] = new Player("Mario",Color.Vermelho);
		p[1] = new Player("Luigi",Color.Verde);
		p[2] = new Player("Peach",Color.Branco);
		
		Objective objs[] = new Objective[6];
		
		
		
		Continent[] ContinentsEUSA = {continents[EU], continents[SA]};
		
		objs[0] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a América do Sul "
				+ "e mais um continente à sua escolha", ContinentsEUSA, true,null,continents);
		
		Continent[] ContinentsEUOC = {continents[EU],continents[OC]};
		
		objs[1] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a Oceania e "
				+ "mais um continente à sua escolha", ContinentsEUOC, true,null,continents);
		
		Continent[] ContinentsNAOC = {continents[NA],continents[OC]};
		
		objs[2] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a Oceania", ContinentsNAOC, false,null,continents);
		
		Continent[] ContinentsNAAF = {continents[NA],continents[AF]};
		
		objs[3] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a África", ContinentsNAAF, false,null,continents);
		
		
		Continent[] ContinentsASSA = {continents[AS],continents[SA]};
		
		objs[4] = new ConquerContinentObjective("Conquistar na totalidade a América do Sul e a Ásia", ContinentsASSA, false,null,continents);
		
		Continent[] ContinentsASAF = {continents[AS],continents[AF]};
		
		objs[5] = new ConquerContinentObjective("Conquistar na totalidade a Ásia e a África", ContinentsASAF, false,null,continents);
		
		
		System.out.println("P1 conquers NA,SA,EU");
		
		p[0].setObjective(objs[0]);
		
		
		for(int i = 0; i < 13;i++) { //NA and SA
			p[0].manageTerritory(territories[i],1);
			
		}
		
		for(int i = 19;i<26;i++) { //EU
			p[0].manageTerritory(territories[i],1);
		}
		
		System.out.println("Objective complete: " + p[0].getObj().ValidateObjective());
		
		p[0].resetPlayer();
		
		System.out.println("P2 conquers NA,OC");
		
		
		p[2].setObjective(objs[2]);
		
		for(int i = 0; i < 9;i++) { //NA
			p[2].manageTerritory(territories[i],1);
			
		}
		
		for(int i = 38;i < 42;i++) { //OC
			p[2].manageTerritory(territories[i],1);
		}
		
		
		System.out.println("Objective complete: " + p[2].getObj().ValidateObjective());
		
		
	}
	
	}


