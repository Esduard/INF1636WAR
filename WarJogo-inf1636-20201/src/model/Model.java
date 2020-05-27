package model;

import java.lang.reflect.Array;
import java.util.*;

public class Model {
	
	private static Card [] cards;
	private static Territory[] territories;
	private static Continent[] continents;
	private static Objective[] objectives;
	private static Stack<Objective> objStack = new Stack<Objective>();
	private static ArrayList<Player> players;
	private static ArrayList<Color> remainingColors = new ArrayList<Color>(Arrays.asList(Color.Branco,Color.Preto,Color.Azul,Color.Amarelo,Color.Verde,Color.Vermelho));
	
	private static final int NA = 0;
	private static final int SA = 1;
    private static final int AF = 2;
    private static final int EU = 3;
	private static final int AS = 4;
    private static final int OC = 5;

	private static void initializeMap()
	{
	//initialize neighbor lists
	
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
	    
	    
	    
	  //initialize territories and continents
		
	    territories = new Territory[42];
	    continents = new Continent[6];
	    
	  //public Territory(String n, Color c, ArrayList<String> neighbors );
		
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
	}
	
	private static void initializeCards() {
		//initialize cards
			cards = new Card[44];
			
			//public Card(Shape s, Territory t);
			
			//NA_Territories 
			
			cards[0]  = new Card(Shape.Triangle	, territories[0]);
			cards[1]  = new Card(Shape.Circle	, territories[1]);
			cards[2]  = new Card(Shape.Square	, territories[2]);
			cards[3]  = new Card(Shape.Circle	, territories[3]);
			cards[4]  = new Card(Shape.Square	, territories[4]);
			cards[5]  = new Card(Shape.Triangle	, territories[5]);
			cards[6]  = new Card(Shape.Square	, territories[6]);
			cards[7]  = new Card(Shape.Circle	, territories[7]);
			cards[8]  = new Card(Shape.Triangle	, territories[8]);
			
			
			//SA_Territories 
			
			cards[9]  = new Card(Shape.Square	, territories[9]);
			cards[10] = new Card(Shape.Circle	, territories[10]);
			cards[11] = new Card(Shape.Triangle	, territories[11]);
			cards[12] = new Card(Shape.Triangle	, territories[12]);
			
			//AF_Territories 
			
			cards[13] = new Card(Shape.Triangle	, territories[13]);
			cards[14] = new Card(Shape.Square	, territories[14]);
			cards[15] = new Card(Shape.Circle	, territories[15]);
			cards[16] = new Card(Shape.Triangle	, territories[16]);
			cards[17] = new Card(Shape.Circle	, territories[17]);
			cards[18] = new Card(Shape.Square	, territories[18]);
			
			//EU_Territories 
			
			cards[19] = new Card(Shape.Triangle	, territories[19]);
			cards[20] = new Card(Shape.Square	, territories[20]);
			cards[21] = new Card(Shape.Circle	, territories[21]);
			cards[22] = new Card(Shape.Square	, territories[22]);
			cards[23] = new Card(Shape.Circle	, territories[23]);
			cards[24] = new Card(Shape.Triangle	, territories[24]);
			cards[25] = new Card(Shape.Circle	, territories[25]);
			
			
			//AS_Territories 
			
			cards[26] = new Card(Shape.Circle	, territories[26]);
			cards[27] = new Card(Shape.Square 	, territories[27]);
			cards[28] = new Card(Shape.Square 	, territories[28]);
			cards[29] = new Card(Shape.Circle 	, territories[29]);
			cards[30] = new Card(Shape.Triangle , territories[30]);
			cards[31] = new Card(Shape.Circle 	, territories[31]);
			cards[32] = new Card(Shape.Square 	, territories[32]);
			cards[33] = new Card(Shape.Square 	, territories[33]);
			cards[34] = new Card(Shape.Triangle , territories[34]);
			cards[35] = new Card(Shape.Triangle , territories[35]);
			cards[36] = new Card(Shape.Triangle , territories[36]);
			cards[37] = new Card(Shape.Circle 	, territories[37]);
			
			
			//OC_Territories
			
			cards[38] = new Card(Shape.Triangle , territories[38]);
			cards[39] = new Card(Shape.Square 	, territories[39]);
			cards[40] = new Card(Shape.Circle 	, territories[40]);
			cards[41] = new Card(Shape.Square 	, territories[41]);
			
			//Jokers
			
			cards[42] = new Card(Shape.Joker	, null);
			cards[43] = new Card(Shape.Joker	, null);

	}
	
	private static void initializeObjectives()
	{

		objectives = new Objective[14];
		
		//Conquer territory
		
		int objIndex = 0;
		
		objectives[objIndex++] = new ConquerTerritoryObjective("Conquistar 18 territórios e ocupar cada um deles com pelo menos 2 exércitos", 18, 2);
		objectives[objIndex++] = new ConquerTerritoryObjective("Conquistar 24 territórios", 24, 1);
		
		//Destroy army
		
		
		for(int i = 0; i < Color.Count.ordinal(); i++)
		{
			Color c = Color.values()[i];
			objectives[objIndex++] = new DestroyArmyObjective("Destruir totalmente os exércitos do jogador " + c.name(), c);
		}
		
		
		
		//Conquer continent
		
		Continent[] objContinents = {continents[EU], continents[SA]};
		
		objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a América do Sul "
				+ "e mais um continente à sua escolha", objContinents, true);
		
		objContinents[1] = continents[OC];
		
		objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a Oceania e "
				+ "mais um continente à sua escolha", objContinents, true);
		
		objContinents[0] = continents[NA];
		
		objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a Oceania", objContinents, false);
		
		objContinents[1] = continents[AF];
		
		objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a África", objContinents, false);
		
		objContinents[0] = continents[AS];
		objContinents[1] = continents[SA];
		
		objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a América do Sul e a Ásia", objContinents, false);
		
		objContinents[0] = continents[AF];
		
		objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a Ásia e a África", objContinents, false);
		
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
			
			return true;
		}
	}
	
	//Return if the player was added
	public static boolean addPlayer(Player p)
	{
		if(p == null)
		{
			return false;
		}
		
		if(remainingColors.remove(p.getColor()))
		{ 
			if(players.add(p))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/*private static void initializePlayers()
	{
	//initialize players
		Scanner scan = new Scanner(System.in);
		
		int n_players = -1;
		
		while(n_players < 3 || n_players > 6)
		{
			System.out.println("Escolha o numero de jogadores");
			n_players = scan.nextInt();
			if(n_players < 3 || n_players > 6)
			{
				System.out.println("O numero de jogadores deve ser de 3 a 6");
			}
		}
		
		String name;
		
		players = new Player[n_players];
		
		//public Player(String n,Color c,Objective o)
		
		for(int i=0;i < n_players;i++)
		{
			System.out.print("Escolha uma cor para o jogador "+ Integer.toString(i+1));
			System.out.print("\n");
			
			int select = -1;

			while(!(select >= 0 && select <= 5))
			{
				System.out.print("Indices respectivos: \n 0 = BRANCO, \n 1 = PRETO, \n 2 = AZUL, \n 3 = AMARELO, \n 4 = VERDE, \n 5 = VERMELHO\n");
				select = scan.nextInt();
				if(!(select >= 0 && select <= 5))
				{
					System.out.println("Insira um indice valido");
				}
			}
				
			if(remainingColors[select] == null)
			{
				System.out.println("Cor ja escolhida");
				i--;
			}
			else
			{
				System.out.println("Insira um nome para o jogador "+ Integer.toString(i+1));
				System.out.print("\n");
				name = scan.next();
				
				
				players[i] = new Player(name, remainingColors[select]); //maybe define objectives before and give'em out here 
				
				remainingColors[select] = null;
			}
		}
		
		scan.close();
	}*/
	
	public static void firstDraw() {
		
	//Draw cards and objectives
		//Creating stacks to draw cards and objectives
		objStack.addAll(Arrays.asList(objectives));
		
		//removing "destroyArmy" type Objectives of non-participating colors
		for(int i = 0; i < remainingColors.size(); i++)
		{
			Color c = remainingColors.get(i);
			if(c != null)
			{
				objStack.remove(objectives[2+c.ordinal()]);
			}
		}
		
		Collections.shuffle(objStack);
		
		Stack<Card> cardStack = new Stack<Card>();
		cardStack.addAll(Arrays.asList(cards));
		
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
		cardStack.add(cards[42]);
		cardStack.add(cards[43]);
		
		for(Player p:players)
		{
			Objective o = objStack.pop();
		
			p.setObjective(o);
			
			//Place 1 army on each territory and retrieve the cards
			cardStack.addAll(p.cardToTerritory());
		}
		
	//Shuffle players order
		Collections.shuffle(players);
	}
	
	public static void initialize(){
	    
		Model.initializeMap();		
		
		Model.initializeCards();
		
		Model.initializeObjectives();
		
		//Model.initializePlayers();
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
			
			army += p.getContinentBonus(continents);
			army += p.getAllTerritories().size()/2;
			
			p.receiveArmies(army);
		}
	}
	
	public static boolean validateCardTrade(ArrayList<Card> selected)
	{
		if(selected != null && selected.size() == 3){
			
			//sort array by enum so joker is last and enums pairs are grouped
			Collections.sort(selected, (a1, a2) -> a1.getShape().compareTo(a2.getShape()));
			
			if(selected.get(0).getShape() == selected.get(1).getShape())
			{
				if(selected.get(0).getShape() == selected.get(2).getShape()) //all shapes are equal
					return true;
				else{
					if(selected.get(2).getShape() == Shape.Joker) //joker complements trade
						return true;
					else
						return false;
				}
			}
			else {
			
				
				if(selected.get(0).getShape() != selected.get(2).getShape()) { 
					return true; //all shapes are diferent
				}
				else{
					if(selected.get(2).getShape() == Shape.Joker) 
						return true; //joker complements trade
					else
						return false; 
					}	
			}
		}
		return false; //invalid number
				
			
	}
	
	public static boolean validateAttack(Color c,Territory src,Territory target,int n_Troops_Attacking) {
		
		
		if(!(c.equals(src.getColor()))) {
			//can't attack with enemy troops
			return false;
		}
		
		if(c.equals(target.getColor())) {
			//can't attack yourself
			return false;
		}
		
		if((src.getTroops() - n_Troops_Attacking)  < 1)
		{
			//can't do attack with no troops on standby in source
			return false;
		}
		
		if(n_Troops_Attacking > 3 || n_Troops_Attacking == 0){
			//can't attack with more than 3 troops or 0 troops
			return false;
		}
		
		//verify if target is src's neighbor	
		ArrayList<String> neighbors = src.getNeighbors();
		
		return neighbors.contains(target.getName());
	}
	
	public static boolean executeAttack(Territory src , Territory target, int [] attack,int [] defend) {
		
		if(!Model.validateAttack(src.getColor(), src, target, attack.length))
			return false;
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
	
	
	public static void testMethods()
	{
		initialize();
		
		//Instances log
		
		System.out.println("------------------CARDS---------------------");
		System.out.println();
		for(Card c:Model.cards)
		{
			if(c.getTerritory() != null)
				System.out.println(c.getShape().name() +", "+ c.getTerritory().getName());
			else
				System.out.println(c.getShape().name());
			System.out.println();
		}
		
		System.out.println("---------------TERRITORIES-----------");
		System.out.println();
		for(Territory t:Model.territories)
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
		for(Continent c:Model.continents)
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
		
		Model.firstDraw();
		
		System.out.println("------------PLAYER ORDER-------------------");
		System.out.println();
		for(Player p:players)
		{
			System.out.println(p.getName());
		}
		System.out.print("\n");
		
		System.out.println("------------ALL OBJECTIVES-------------------");
		System.out.println();
		for(Objective o:Model.objectives)
		{
			System.out.println(o.getDescription());
			System.out.println();
		}

		for(Player p:players)
		{
			System.out.println("------------------"+ p.getName() + "-" + p.getColor() + "----------------------------");
			System.out.println("\tObjetivo: ");
			System.out.println("\t\t"+p.getObjDescription());
			
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

