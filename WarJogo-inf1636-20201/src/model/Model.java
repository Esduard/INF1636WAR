package model;
import java.util.*;

public class Model {
	
	private static Card [] Cards;
	private static Territory[] Territories;
	private static Continent[] Continents;
	private static Objective[] Objectives;
	private static Stack<Objective> objStack = new Stack<Objective>();
	private static Player[] Players;
	private static Color[] Colors = {Color.Branco,Color.Preto,Color.Azul,Color.Amarelo,Color.Verde,Color.Vermelho};
	private static Color[] remainingColors = Colors.clone();
	
	//change to enum
	private static final int NA = 0;
	private static final int SA = 1;
    private static final int AF = 2;
    private static final int EU = 3;
	private static final int AS = 4;
    private static final int OC = 5;
    
    public static Continent[] getContinents() 
    {
    	return Continents;
    }
	
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
			
		    Territories = new Territory[42];
		    Continents = new Continent[6];
		    
		  //public Territory(String n, Color c, ArrayList<String> neighbors );
			
			//NA
		    
		    Territories[0] 	= new Territory("Alaska"		, alaska_n);
		    Territories[1] 	= new Territory("Mackenzie"		, mackenzie_n);
		    Territories[2]	= new Territory("California"	, california_n);
		    Territories[3] 	= new Territory("Groenlandia"	, groenlandia_n);
		    Territories[4]	= new Territory("Mexico"		, mexico_n);
		    Territories[5] 	= new Territory("Nova York"		, nova_york_n);
		    Territories[6] 	= new Territory("Labrador"		, labrador_n);
		    Territories[7] 	= new Territory("Ottawa"		, ottawa_n);
		    Territories[8] 	= new Territory("Vancouver"		, vancouver_n);
		    
		    
		    Territory[] northAmerica = new Territory[9];
		    int cont_all_territories = 0;
		    
		    for(int i = 0; i < 9; i++)
		    {
		    	 northAmerica[i] = Territories[cont_all_territories];
		    	 cont_all_territories++;
		    }
		    
		    Continents[NA] = new Continent("América do Norte", northAmerica, 5);
		    
			//SA
		    
		    Territories[9]	= new Territory("Argentina"		, argentina_n);
		    Territories[10] = new Territory("Brasil"		, brasil_n);
		    Territories[11] = new Territory("Chile"			, chile_n);
		    Territories[12] = new Territory("Colombia"		, colombia_n);
		    
		    Territory[] southAmerica = new Territory[4];
		    
		    for(int i = 0; i < 4; i++)
		    {
		    	 southAmerica[i] = Territories[cont_all_territories];
		    	 cont_all_territories++;
		    }
		    
		    Continents[SA] = new Continent("América do Sul", southAmerica, 2);
		    
		    //AF
		    
		    Territories[13]	= new Territory("Africa Do Sul"	, africa_do_sul_n);
		    Territories[14] = new Territory("Sudao"			, sudao_n);
		    Territories[15] = new Territory("Argelia"		, argelia_n);
		    Territories[16] = new Territory("Egito"			, egito_n);
		    Territories[17]	= new Territory("Madagascar"	, madagascar_n);
		    Territories[18] = new Territory("Congo"			, congo_n);
		    
		    Territory[] africa = new Territory[6];
		    
		    for(int i = 0; i < 6; i++)
		    {
		    	 africa[i] = Territories[cont_all_territories];
		    	 cont_all_territories++;
		    }
		    
		    Continents[AF] = new Continent("África", africa, 3);
		    
		    //EU
		    
		    Territories[19]	= new Territory("Islandia"		, islandia_n);
		    Territories[20] = new Territory("Franca"		, franca_n);
		    Territories[21] = new Territory("Inglaterra"	, inglaterra_n);
		    Territories[22]	= new Territory("Polonia"		, polonia_n);
		    Territories[23] = new Territory("Suecia"		, suecia_n);
		    Territories[24] = new Territory("Moscou"		, moscou_n);
		    Territories[25] = new Territory("Alemanha"		, alemanha_n);
		    
		    Territory[] europe = new Territory[7];
		    
		    for(int i = 0; i < 7; i++)
		    {
		    	 europe[i] = Territories[cont_all_territories];
		    	 cont_all_territories++;
		    }
		    
		    Continents[EU] = new Continent("Europa", northAmerica, 5);
		    
		    //AS
		    
		    Territories[26] = new Territory("China"			, china_n);
		    Territories[27] = new Territory("India"			, india_n);
		    Territories[28] = new Territory("Japao"			, japao_n);
		    Territories[29] = new Territory("Dudinka"		, dudinka_n);
		    Territories[30] = new Territory("Aral"			, aral_n);
		    Territories[31] = new Territory("Mongolia"		, mongolia_n);
		    Territories[32] = new Territory("Oriente Medio"	, oriente_medio_n);
		    Territories[33] = new Territory("Omsk"			, omsk_n);
		    Territories[34] = new Territory("Siberia"		, siberia_n);
		    Territories[35] = new Territory("Tchita"		, tchita_n);
		    Territories[36] = new Territory("Vietna"		, vietna_n);
		    Territories[37] = new Territory("Vladivostok"	, vladivostok_n);
		    
		    Territory[] asia = new Territory[12];
		    
		    for(int i = 0; i < 12; i++)
		    {
		    	 asia[i] = Territories[cont_all_territories];
		    	 cont_all_territories++;
		    }
		    
		    Continents[AS] = new Continent("Asia", asia, 7);
		    
		    //OC
		    
		    Territories[38] = new Territory("Australia"		, australia_n);
		    Territories[39] = new Territory("Sumatra"		, sumatra_n);
		    Territories[40] = new Territory("Nova Guine"	, nova_guine_n);
		    Territories[41] = new Territory("Borneo"		, borneo_n);
		    
		    Territory[] oceania = new Territory[4];
		    
		    for(int i = 0; i < 4; i++)
		    {
		    	 oceania[i] = Territories[cont_all_territories];
		    	 cont_all_territories++;
		    }
		    
		    Continents[OC] = new Continent("Oceania", oceania, 2);
	}
	
	private static void initializeCards() {
		//initialize cards
			Cards = new Card[44];
			
			//public Card(Shape s, Territory t);
			
			//NA_Territories 
			
			Cards[0]  = new Card(Shape.Triangle	, Territories[0]);
			Cards[1]  = new Card(Shape.Circle	, Territories[1]);
			Cards[2]  = new Card(Shape.Square	, Territories[2]);
			Cards[3]  = new Card(Shape.Circle	, Territories[3]);
			Cards[4]  = new Card(Shape.Square	, Territories[4]);
			Cards[5]  = new Card(Shape.Triangle	, Territories[5]);
			Cards[6]  = new Card(Shape.Square	, Territories[6]);
			Cards[7]  = new Card(Shape.Circle	, Territories[7]);
			Cards[8]  = new Card(Shape.Triangle	, Territories[8]);
			
			
			//SA_Territories 
			
			Cards[9]  = new Card(Shape.Square	, Territories[9]);
			Cards[10] = new Card(Shape.Circle	, Territories[10]);
			Cards[11] = new Card(Shape.Triangle	, Territories[11]);
			Cards[12] = new Card(Shape.Triangle	, Territories[12]);
			
			//AF_Territories 
			
			Cards[13] = new Card(Shape.Triangle	, Territories[13]);
			Cards[14] = new Card(Shape.Square	, Territories[14]);
			Cards[15] = new Card(Shape.Circle	, Territories[15]);
			Cards[16] = new Card(Shape.Triangle	, Territories[16]);
			Cards[17] = new Card(Shape.Circle	, Territories[17]);
			Cards[18] = new Card(Shape.Square	, Territories[18]);
			
			//EU_Territories 
			
			Cards[19] = new Card(Shape.Triangle	, Territories[19]);
			Cards[20] = new Card(Shape.Square	, Territories[20]);
			Cards[21] = new Card(Shape.Circle	, Territories[21]);
			Cards[22] = new Card(Shape.Square	, Territories[22]);
			Cards[23] = new Card(Shape.Circle	, Territories[23]);
			Cards[24] = new Card(Shape.Triangle	, Territories[24]);
			Cards[25] = new Card(Shape.Circle	, Territories[25]);
			
			
			//AS_Territories 
			
			Cards[26] = new Card(Shape.Circle	, Territories[26]);
			Cards[27] = new Card(Shape.Square 	, Territories[27]);
			Cards[28] = new Card(Shape.Square 	, Territories[28]);
			Cards[29] = new Card(Shape.Circle 	, Territories[29]);
			Cards[30] = new Card(Shape.Triangle , Territories[30]);
			Cards[31] = new Card(Shape.Circle 	, Territories[31]);
			Cards[32] = new Card(Shape.Square 	, Territories[32]);
			Cards[33] = new Card(Shape.Square 	, Territories[33]);
			Cards[34] = new Card(Shape.Triangle , Territories[34]);
			Cards[35] = new Card(Shape.Triangle , Territories[35]);
			Cards[36] = new Card(Shape.Triangle , Territories[36]);
			Cards[37] = new Card(Shape.Circle 	, Territories[37]);
			
			
			//OC_Territories
			
			Cards[38] = new Card(Shape.Triangle , Territories[38]);
			Cards[39] = new Card(Shape.Square 	, Territories[39]);
			Cards[40] = new Card(Shape.Circle 	, Territories[40]);
			Cards[41] = new Card(Shape.Square 	, Territories[41]);
			
			//Jokers
			
			Cards[42] = new Card(Shape.Joker	, null);
			Cards[43] = new Card(Shape.Joker	, null);

	}
	
	private static void initializeObjectives()
	{

		Objectives = new Objective[14];
		
		//Conquer territory
		
		int objIndex = 0;
		
		Objectives[objIndex++] = new ConquerTerritoryObjective("Conquistar 18 territórios e ocupar cada um deles com pelo menos 2 exércitos", 18, 2);
		Objectives[objIndex++] = new ConquerTerritoryObjective("Conquistar 24 territórios", 24, 1);
		
		//Destroy army
		
		
		for(int i = 0; i < Color.Count.ordinal(); i++)
		{
			Color c = Color.values()[i];
			Objectives[objIndex++] = new DestroyArmyObjective("Destruir totalmente os exércitos do jogador " + c.name(), c);
		}
		
		
		
		//Conquer continent
		
		Continent[] objContinents = {Continents[EU], Continents[SA]};
		
		Objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a América do Sul "
				+ "e mais um continente à sua escolha", objContinents, true);
		
		objContinents[1] = Continents[OC];
		
		Objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a Oceania e "
				+ "mais um continente à sua escolha", objContinents, true);
		
		objContinents[0] = Continents[NA];
		
		Objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a Oceania", objContinents, false);
		
		objContinents[1] = Continents[AF];
		
		Objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a África", objContinents, false);
		
		objContinents[0] = Continents[AS];
		objContinents[1] = Continents[SA];
		
		Objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a América do Sul e a Ásia", objContinents, false);
		
		objContinents[0] = Continents[AF];
		
		Objectives[objIndex++] = new ConquerContinentObjective("Conquistar na totalidade a Ásia e a África", objContinents, false);
		
	}
	
	public static void initializePlayers()
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
				
				Players = new Player[n_players];
				
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
						
						
						Players[i] = new Player(name, remainingColors[select]); //maybe define objectives before and give'em out here 
						
						remainingColors[select] = null;
					}
				}
				
				scan.close();
	}
	
	public static void firstDraw() {
		//Draw cards and objectives
				//Creating stacks to draw cards and objectives
				objStack.addAll(Arrays.asList(Objectives));
				
				//removing "destroyArmy" type Objectives of non-participating colors
				for(int i = 0; i < remainingColors.length; i++)
				{
					Color c = remainingColors[i];
					if(c != null)
					{
						objStack.remove(Objectives[2+c.ordinal()]);
					}
				}
				
				Collections.shuffle(objStack);
				
				Stack<Card> cardStack = new Stack<Card>();
				cardStack.addAll(Arrays.asList(Cards));
				
				//Remove jokers
				cardStack.remove(43); 
				cardStack.remove(42);
				
				Collections.shuffle(cardStack);
				
				boolean isCardStackEmpty = false;
				
				while(!isCardStackEmpty)
				{
					for(Player p:Players)
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
				cardStack.add(Cards[42]);
				cardStack.add(Cards[43]);
				
				for(Player p:Players)
				{
					Objective o = objStack.pop();
				
					p.setObjective(o);
										
					cardStack.addAll(p.cardToTerritory());
				}
				
				//Shuffle players order
				List<Player> PlayerOrder = Arrays.asList(Players);
				
				Collections.shuffle(PlayerOrder);
				
				PlayerOrder.toArray(Players);
	}
	
	public static void initialize(){
	    
		Model.initializeMap();		
		
		Model.initializeCards();
		
		Model.initializeObjectives();
		
		Model.initializePlayers();
		
		Model.firstDraw();
	}
	
	
	public static void round() {
		
		while(true) //loop condition must be a goal verification method for all players 
		{
			for (Player p:Players) 
			{
				
				Model.recieveAndDistributeArmies(p);
				
			}
			break;
		}
		
		
		
	}
	
	
	
	
	public static void recieveAndDistributeArmies(Player p) {
		
		int bonusArmies = 0;
		int viable = 0;
		
		//trade card method
		
		/*system verifies if trade is viable or non-viable, obligatory or non-obligatory */
		/* method isTradeViable() 
		 * return 0 if non-viable
		 * return 1 if viable
		 * return 2 if obligatory
		 */
		
		viable = p.isTradeViable();
		
		if(viable == 1)
		{
				//ask if player wants to trade
				//yes - change viable to 2
				//no - change viable to 0
		}
		if(viable == 2)
		{
			//call tradeCardsForArmies()
			//recive array of cards to add to pile (and shuffle)
			//each 3 cards count as a bonus
			//bonus increases each trade
		}
		
		
		
		
		//player recieves continental bonus(es)
		bonusArmies += p.ContinentBonus();
		
		
		
		//recive regular armies
		int newArmies = (p.getAllTerritories().size() / 2) + bonusArmies;
		
		
		//select where to put
		//while( )
		//{
			//select turfs to put certain amount
			
			//player confirm choices and program validates amount
			
		//}
		
		/* 
		Recebimento e posicionamento dos exércitos correspondentes ao número de territórios (metade) que o jogador da vez possui.
	 	
	 	Recebimento e posicionamento dos exércitos correspondentes à posse de um continente inteiro.
	 	
	 	Recebimento e posicionamento dos exércitos correspondentes a troca de cartas.
		 */
		
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
		
		//System.out.println(neighbors);
		return neighbors.contains(target.getName());
	}
	
	public static void testMethods()
	{
		initialize();
		
		//Instances log
		
		System.out.println("------------------CARDS---------------------");
		System.out.println();
		for(Card c:Model.Cards)
		{
			if(c.getTerritory() != null)
				System.out.println(c.getShape().name() +", "+ c.getTerritory().getName());
			else
				System.out.println(c.getShape().name());
			System.out.println();
		}
		
		System.out.println("---------------TERRITORIES-----------");
		System.out.println();
		for(Territory t:Model.Territories)
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
		for(Continent c:Model.Continents)
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
		
		System.out.println("------------PLAYER ORDER-------------------");
		System.out.println();
		for(Player p:Players)
		{
			System.out.println(p.getName());
		}
		System.out.print("\n");
		
		System.out.println("------------ALL OBJECTIVES-------------------");
		System.out.println();
		for(Objective o:Model.Objectives)
		{
			System.out.println(o.getDescription());
			System.out.println();
		}

		for(Player p:Players)
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

