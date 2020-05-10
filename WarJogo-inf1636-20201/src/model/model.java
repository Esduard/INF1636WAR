package model;
import java.util.*;

public class model {
	
	public static Card [] Cards;
	public static Territory[] Territories;
	public static Continent[] Continents;
	public static Objective[] Objectives;
	public static Player[] Players;
	public static Color[] Colors = {Color.White,Color.Black,Color.Blue,Color.Yellow,Color.Green,Color.Red};
	
	public static void start(){
		
		//initialize neighbor lists
		
		//NA
		
		ArrayList<String> alasca_n = new ArrayList<String>(
	    	      Arrays.asList("Siberia","Vancouver","Calgary"));
		
		ArrayList<String> calgary_n = new ArrayList<String>(
	    	      Arrays.asList("Alasca","Vancouver","Groenlandia"));
		
		ArrayList<String> california_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Texas","Vancouver"));
		
		ArrayList<String> groenlandia_n = new ArrayList<String>(
	    	      Arrays.asList("Calgary","Quebec","Reino Unido"));
		
		ArrayList<String> mexico_n = new ArrayList<String>(
	    	      Arrays.asList("California","Texas","Venezuela"));
		
		ArrayList<String> nova_york_n = new ArrayList<String>(
	    	      Arrays.asList("Quebec","Texas"));
		
		ArrayList<String> quebec_n = new ArrayList<String>(
	    	      Arrays.asList("Groenlandia","Nova York"));
		
		ArrayList<String> texas_n = new ArrayList<String>(
	    	      Arrays.asList("California","Quebec","Mexico","Nova York","Vancouver"));
		
		ArrayList<String> vancouver_n = new ArrayList<String>(
	    	      Arrays.asList("Alasca","Calgary","California","Quebec","Texas"));
		
		//SA
		
		ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Peru","Brasil"));
		
		ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Venezuela","Peru","Argentina"));
		
		ArrayList<String> peru_n = new ArrayList<String>(
	    	    Arrays.asList("Argentina","Venezuela","Brasil"));
		
	    ArrayList<String> venezuela_n = new ArrayList<String>(
	    		Arrays.asList("Mexico","Peru","Brasil"));
	    
	    
	    //AF
	    
	    ArrayList<String> argelia_n = new ArrayList<String>(
	    	      Arrays.asList("Espanha","Nigeria","Egito","Italia"));

	    ArrayList<String> egito_n = new ArrayList<String>(
	    	      Arrays.asList("Romenia","Jordania","Somalia","Nigeria","Argelia"));
	    
	    ArrayList<String> nigeria_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Egito","Brasil","Somalia","Angola"));
	    
	    ArrayList<String> somalia_n = new ArrayList<String>(
	    	      Arrays.asList("Arabia Saudita","Egito","Nigeria","Angola","Africa Do Sul"));
	    
	    ArrayList<String> angola_n = new ArrayList<String>(
	    	      Arrays.asList("Africa Do Sul","Somalia","Nigeria"));
	    
	    ArrayList<String> africa_do_sul_n = new ArrayList<String>(
	    	      Arrays.asList("Angola","Somalia"));
	    
	    
	    //EU
	    
	    ArrayList<String> espanha_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Franca"));
	    
	    ArrayList<String> franca_n = new ArrayList<String>(
	    	      Arrays.asList("Espanha","Italia","Reino Unido"));
	    
	    ArrayList<String> italia_n = new ArrayList<String>(
	    	      Arrays.asList("Romenia","Polonia","Suecia","Franca","Argelia"));
	    
	    ArrayList<String> polonia_n = new ArrayList<String>(
	    	      Arrays.asList("Letonia","Ucrania","Romenia","Italia"));
	    
	    ArrayList<String> reino_unido_n = new ArrayList<String>(
	    	      Arrays.asList("Groenlandia","Franca"));
	    
	    ArrayList<String> romenia_n = new ArrayList<String>(
	    	      Arrays.asList("Ucrania","Polonia","Italia","Egito"));
	    
	    ArrayList<String> suecia_n = new ArrayList<String>(
	    	      Arrays.asList("Estonia", "Letonia" ,"Italia","Franca"));
	    
	    ArrayList<String> ucrania_n = new ArrayList<String>(
	    	      Arrays.asList("Turquia","Letonia","Polonia","Romenia"));
	    
	    
	    //AS
	    
	    ArrayList<String> arabia_saudita_n = new ArrayList<String>(
	    	      Arrays.asList("Somalia","Iraque","Jordania"));
	    
	    ArrayList<String> bangladesh_n = new ArrayList<String>(
	    	      Arrays.asList("India","Coreia Do Sul","Tailandia","Indonesia"));
	    
	    ArrayList<String> cazaquistao_n = new ArrayList<String>(
	    	      Arrays.asList("Siberia","Russia","Letonia","Turquia","China","Mongolia","Japao"));
	    
	    ArrayList<String> china_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","Cazaquistao","Turquia","Paquistao","India","Coreia Do Sul","Coreia Do Norte"));
	    
	    ArrayList<String> coreia_do_norte_n = new ArrayList<String>(
	    	      Arrays.asList("Japao","China","Coreia Do Sul"));
	    
	    ArrayList<String> coreia_do_sul_n = new ArrayList<String>(
	    	      Arrays.asList("Coreia Do Norte","China","India","Bangladesh","Tailandia"));
	    
	    ArrayList<String> estonia_n = new ArrayList<String>(
	    	      Arrays.asList("Letonia","Suecia","Russia"));
	    
	    ArrayList<String> india_n = new ArrayList<String>(
	    	      Arrays.asList("Coreia Do Sul","China","Paquistao","Indonesia","Bangladesh"));
	    
	    ArrayList<String> ira_n = new ArrayList<String>(
	    	      Arrays.asList("Paquistao","Siria","Iraque"));
	    
	    ArrayList<String> iraque_n = new ArrayList<String>(
	    	      Arrays.asList("Ira","Siria","Jordania","Arabia Saudita"));
	    
	    ArrayList<String> japao_n = new ArrayList<String>(
	    	      Arrays.asList("Cazaquistao","Mongolia","Coreia Do Norte"));
	    
	    ArrayList<String> jordania_n = new ArrayList<String>(
	    	      Arrays.asList("Arabia Saudita","Iraque","Siria","Egito"));
	    
	    ArrayList<String> letonia_n = new ArrayList<String>(
	    	      Arrays.asList("Estonia","Russia","Cazaquistao","Turquia","Ucrania","Polonia","Suecia"));
	    
	    ArrayList<String> mongolia_n = new ArrayList<String>(
	    	      Arrays.asList("Japao","Cazaquistao","China"));
	    
	    ArrayList<String> paquistao_n = new ArrayList<String>(
	    	      Arrays.asList("China","India","Ira","Siria","Turquia"));
	    
	    ArrayList<String> russia_n = new ArrayList<String>(
	    	      Arrays.asList("Estonia","Siberia","Cazaquistao","Letonia"));
	    
	    ArrayList<String> siberia_n = new ArrayList<String>(
	    	      Arrays.asList("Russia","Cazaquistao","Alasca"));
	    
	    ArrayList<String> siria_n = new ArrayList<String>(
	    	      Arrays.asList("Turquia","Paquistao","Ira","Iraque","Jordania"));
	    
	    ArrayList<String> tailandia_n = new ArrayList<String>(
	    	      Arrays.asList("Coreia Do Sul","Bangladesh"));
	    
	    ArrayList<String> turquia_n = new ArrayList<String>(
	    	      Arrays.asList("Letonia","Ucrania","Siria","Paquistao","China","Cazaquistao"));
	    
	    
	    //OC
	    
	    ArrayList<String> australia_n = new ArrayList<String>(
	    	      Arrays.asList("Perth","Nova Zelandia","Indonesia"));
	    
	    ArrayList<String> indonesia_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Nova Zelandia","Bangladesh","India"));
	    
	    ArrayList<String> nova_zelandia_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Indonesia"));
	    
	    ArrayList<String> perth_n = new ArrayList<String>(
	    	      Arrays.asList("Australia"));
	    
	    
	    
	  //initialize territories and continents
		
	    Territories = new Territory[51];
	    Continents = new Continent[6];
	    
	  //public Territory(String n, Color c, ArrayList<String> neighbors );
		
		//NA
	    
	    Territories[0] 	= new Territory("Alasca"		,null, alasca_n);
	    Territories[1] 	= new Territory("Calgary"		,null, calgary_n);
	    Territories[2]	= new Territory("California"	,null, california_n);
	    Territories[3] 	= new Territory("Groenlandia"	,null, groenlandia_n);
	    Territories[4]	= new Territory("Mexico"		,null, mexico_n);
	    Territories[5] 	= new Territory("Nova York"		,null, nova_york_n);
	    Territories[6] 	= new Territory("Quebec"		,null, quebec_n);
	    Territories[7] 	= new Territory("Texas"			,null, texas_n);
	    Territories[8] 	= new Territory("Vancouver"		,null, vancouver_n);
	    
	    Territory[] northAmerica = new Territory[8];
	    
	    for(int i = 0; i < 8; i++)
	    {
	    	 northAmerica[i] = Territories[i];
	    }
	    
	    Continents[0] = new Continent("América do Norte", northAmerica, 0);
	    
		//SA
	    
	    Territories[9]	= new Territory("Argentina"		,null, argentina_n);
	    Territories[10] 	= new Territory("Brasil"		,null, brasil_n);
	    Territories[11] 	= new Territory("Peru"			,null, peru_n);
	    Territories[12] 	= new Territory("Venezuela"		,null, venezuela_n);
	    
	    Territory[] southAmerica = new Territory[4];
	    
	    for(int i = 0; i < 4; i++)
	    {
	    	 southAmerica[i] = Territories[i+8];
	    }
	    
	    Continents[1] = new Continent("América do Sul", southAmerica, 0);
	    
	    //AF
	    
	    Territories[13]	= new Territory("Africa Do Sul"	,null, africa_do_sul_n);
	    Territories[14] 	= new Territory("Angola"		,null, angola_n);
	    Territories[15] 	= new Territory("Argelia"		,null, argelia_n);
	    Territories[16] 	= new Territory("Egito"			,null, egito_n);
	    Territories[17]	= new Territory("Nigeria"		,null, nigeria_n);
	    Territories[18] 	= new Territory("Somalia"		,null, somalia_n);
	    
	    Territory[] africa = new Territory[6];
	    
	    for(int i = 0; i < 6; i++)
	    {
	    	 africa[i] = Territories[i+12];
	    }
	    
	    Continents[2] = new Continent("África", africa, 0);
	    
	    //EU
	    
	    Territories[19]	= new Territory("Espanha"		,null, espanha_n);
	    Territories[20] 	= new Territory("Franca"		,null, franca_n);
	    Territories[21] 	= new Territory("Italia"		,null, italia_n);
	    Territories[22]	= new Territory("Polonia"		,null, polonia_n);
	    Territories[23] 	= new Territory("Reino Unido"	,null, reino_unido_n);
	    Territories[24]	= new Territory("Romenia"		,null, romenia_n);
	    Territories[25] 	= new Territory("Suecia"		,null, suecia_n);
	    Territories[26] 	= new Territory("Ucrania"		,null, ucrania_n);
	    
	    Territory[] europe = new Territory[8];
	    
	    for(int i = 0; i < 8; i++)
	    {
	    	 europe[i] = Territories[i+18];
	    }
	    
	    Continents[3] = new Continent("Europa", northAmerica, 0);
	    
	    //AS
	    
	    Territories[27] 	= new Territory("Arabia Saudita",null, arabia_saudita_n);
	    Territories[28]	= new Territory("Bangladesh"	,null, bangladesh_n);
	    Territories[29] 	= new Territory("Cazaquistao"	,null, cazaquistao_n);
	    Territories[30] 	= new Territory("China"			,null, china_n);
	    Territories[31] 	= new Territory("Coreia Do Norte",null, coreia_do_norte_n);
	    Territories[32] 	= new Territory("Coreia Do Sul"	,null, coreia_do_sul_n);
	    Territories[33] 	= new Territory("Estonia"		,null, estonia_n);
	    Territories[34] 	= new Territory("India"			,null, india_n);
	    Territories[35] 	= new Territory("Ira"			,null, ira_n);
	    Territories[36] 	= new Territory("Iraque"		,null, iraque_n);
	    Territories[37] 	= new Territory("Japao"			,null, japao_n);
	    Territories[38] 	= new Territory("Jordania"		,null, jordania_n);
	    Territories[39] 	= new Territory("Letonia"		,null, letonia_n);
	    Territories[40] 	= new Territory("Mongolia"		,null, mongolia_n);
	    Territories[41] 	= new Territory("Paquistao"		,null, paquistao_n);
	    Territories[42] 	= new Territory("Russia"		,null, russia_n);
	    Territories[43] 	= new Territory("Sibeira"		,null, siberia_n);
	    Territories[44] 	= new Territory("Siria"			,null, siria_n);
	    Territories[45] 	= new Territory("Tailandia"		,null, tailandia_n);
	    Territories[46] 	= new Territory("Turquia"		,null, turquia_n);
	    
	    Territory[] asia = new Territory[19];
	    
	    for(int i = 0; i < 19; i++)
	    {
	    	 asia[i] = Territories[i+26];
	    }
	    
	    Continents[4] = new Continent("Asia", asia, 0);
	    
	    //OC
	    
	    Territories[47] 	= new Territory("Australia"		,null, australia_n);
	    Territories[48] 	= new Territory("Indonesia"		,null, indonesia_n);
	    Territories[49] 	= new Territory("Nova Zelandia"	,null, nova_zelandia_n);
	    Territories[50] 	= new Territory("Perth"			,null, perth_n);
	    
	    Territory[] oceania = new Territory[4];
	    
	    for(int i = 0; i < 4; i++)
	    {
	    	 oceania[i] = Territories[i+46];
	    }
	    
	    Continents[5] = new Continent("Oceania", oceania, 0);
	    
		//initialize cards
		Cards = new Card[53];
		
		//public Card(Shape s, Territory t);
		
		//NA_Territories 
		
		Cards[0] = new Card(Shape.Triangle	, Territories[0]);//Alasca
		Cards[1] = new Card(Shape.Circle	, Territories[1]);//Calgary
		Cards[2] = new Card(Shape.Square	, Territories[2]);//California
		Cards[3] = new Card(Shape.Circle	, Territories[3]);//Groenlandia
		Cards[4] = new Card(Shape.Square	, Territories[4]);//Mexico
		Cards[5] = new Card(Shape.Square	, Territories[5]);//Nova_York
		Cards[6] = new Card(Shape.Circle	, Territories[6]);//Quebec
		Cards[7] = new Card(Shape.Triangle	, Territories[7]);//Texas
		Cards[8] = new Card(Shape.Triangle	, Territories[8]);//Vancouver
		
		
		//SA_Territories 
		
		Cards[9] = new Card(Shape.Square	, Territories[9]);//Argentina
		Cards[10] = new Card(Shape.Circle	, Territories[10]);//Brasil
		Cards[11] = new Card(Shape.Triangle	, Territories[11]);//Peru
		Cards[12] = new Card(Shape.Triangle	, Territories[12]);//Venezuela
		
		//AF_Territories 
		
		Cards[13] = new Card(Shape.Triangle	, Territories[13]);//Africa_Do_Sul
		Cards[14] = new Card(Shape.Square	, Territories[14]);//Angola
		Cards[15] = new Card(Shape.Circle	, Territories[15]);//Argelia
		Cards[16] = new Card(Shape.Triangle	, Territories[16]);//Egito
		Cards[17] = new Card(Shape.Circle	, Territories[17]);//Nigeria
		Cards[18] = new Card(Shape.Square	, Territories[18]);//Somalia
		
		//EU_Territories 
		
		Cards[19] = new Card(Shape.Circle	, Territories[19]);//Espanha
		Cards[20] = new Card(Shape.Triangle	, Territories[20]);//Franca
		Cards[21] = new Card(Shape.Square	, Territories[21]);//Italia
		Cards[22] = new Card(Shape.Triangle	, Territories[22]);//Polonia
		Cards[23] = new Card(Shape.Circle	, Territories[23]);//Reino_Unido
		Cards[24] = new Card(Shape.Triangle	, Territories[24]);//Romenia
		Cards[25] = new Card(Shape.Square	, Territories[25]);//Suecia
		Cards[26] = new Card(Shape.Circle	, Territories[26]);//Ucrania
		
		//AS_Territories 
		
		Cards[27] = new Card(Shape.Circle 	, Territories[27]);//Arabia_Saudita
		Cards[28] = new Card(Shape.Circle 	, Territories[28]);//Bangladesh
		Cards[29] = new Card(Shape.Circle 	, Territories[29]);//Cazaquistao
		Cards[30] = new Card(Shape.Square 	, Territories[30]);//China
		Cards[31] = new Card(Shape.Square 	, Territories[31]);//Coreia_Do_Norte
		Cards[32] = new Card(Shape.Triangle , Territories[32]);//Coreia_Do_Sul
		Cards[33] = new Card(Shape.Circle 	, Territories[33]);//Estonia
		Cards[34] = new Card(Shape.Triangle , Territories[34]);//India
		Cards[35] = new Card(Shape.Square 	, Territories[35]);//Ira
		Cards[36] = new Card(Shape.Triangle , Territories[36]);//Iraque
		Cards[37] = new Card(Shape.Circle 	, Territories[37]);//Japao
		Cards[38] = new Card(Shape.Square 	, Territories[38]);//Jordania
		Cards[39] = new Card(Shape.Square 	, Territories[39]);//Letonia
		Cards[40] = new Card(Shape.Triangle , Territories[40]);//Mongolia
		Cards[41] = new Card(Shape.Circle 	, Territories[41]);//Paquistao
		Cards[42] = new Card(Shape.Triangle , Territories[42]);//Russia
		Cards[43] = new Card(Shape.Square 	, Territories[43]);//Siberia
		Cards[44] = new Card(Shape.Square 	, Territories[44]);//Siria
		Cards[45] = new Card(Shape.Triangle , Territories[45]);//Tailandia
		Cards[46] = new Card(Shape.Triangle	, Territories[46]);//Turquia
		
		//OC_Territories
		
		Cards[47] = new Card(Shape.Triangle	, Territories[47]);//Australia);
		Cards[48] = new Card(Shape.Triangle	, Territories[48]);//Indonesia);
		Cards[49] = new Card(Shape.Square	, Territories[49]);//Nova_Zelandia);
		Cards[50] = new Card(Shape.Circle	, Territories[50]);//Perth);
		
		//Jokers
		
		Cards[51] = new Card(Shape.Joker	, null);
		Cards[52] = new Card(Shape.Joker	, null);
		
		
		//initialize 
		
		Objectives = new Objective[14];
		
		//Conquer territory
		
		Objectives[0] = new ConquerTerritoryObjective("Conquistar 18 territórios e ocupar cada um deles com pelo menos 2 exércitos", 18, 2);
		Objectives[1] = new ConquerTerritoryObjective("Conquistar 24 territórios", 24, 1);
		
		//Destroy army
		
		for(int i = 0; i < Color.Count.ordinal(); i++)
		{
			Color c = Color.values()[i];
			Objectives[2+i] = new DestroyArmyObjective("Destruir totalmente os exércitos do jogador " + c.name(), c);
		}
		
		//Conquer continent
		
		Continent[] objContinents = {Continents[3], Continents[1]};
		
		Objectives[8] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a América do Sul "
				+ "e mais um continente à sua escolha", objContinents, true);
		
		objContinents[1] = Continents[5];
		
		Objectives[9] = new ConquerContinentObjective("Conquistar na totalidade a Europa, a Oceania e "
				+ "mais um continente à sua escolha", objContinents, true);
		
		objContinents[0] = Continents[0];
		
		Objectives[10] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a Oceania", objContinents, false);
		
		objContinents[1] = Continents[2];
		
		Objectives[11] = new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a África", objContinents, false);
		
		objContinents[0] = Continents[4];
		objContinents[1] = Continents[1];
		
		Objectives[12] = new ConquerContinentObjective("Conquistar na totalidade a América do Sul e a Ásia", objContinents, false);
		
		objContinents[0] = Continents[2];
		
		Objectives[13] = new ConquerContinentObjective("Conquistar na totalidade a Ásia e a África", objContinents, false);
		
		System.out.println("------------------CARDS---------------------");
		System.out.println();
		for(Card c:Cards)
		{
			if(c.getTerritory() != null)
				System.out.println(c.getShape().name() +", "+ c.getTerritory().getName());
			else
				System.out.println(c.getShape().name());
			System.out.println();
		}
		
		System.out.println("---------------TERRITORIES-----------");
		System.out.println();
		for(Territory t:Territories)
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
		for(Continent c:Continents)
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
		
		System.out.println("------------OBJECTIVES-------------------");
		System.out.println();
		for(Objective o:Objectives)
		{
			System.out.println(o.description);
			System.out.println();
		}
		
		//initialize players
		
		Scanner scan = new Scanner(System.in);
		
		int n_players = -1;
		
		while(n_players <= 0 || n_players > 6)
		{
			System.out.println("Escolha o numero de jogadores");
			n_players = scan.nextInt();
			if(n_players <= 0 || n_players > 6)
			{
				System.out.println("O numero de jogadores deve ser de 1 a 6");
			}
		}
		
		
		int i;
		int select;
		String name;
		
		Players = new Player[n_players];
		
		//public Player(String n,Color c,Objective o)
		
		Color[] remainingColors = Colors;
		
		for(i=0;i<6;i++)
		{
			System.out.print("Escolha uma cor para o jogador ");
			System.out.print(i+1);
			System.out.print("\n");
			System.out.print("Indices respectivos: \n 0 = BRANCO, \n 1 = PRETO, \n 2 = AZUL, \n 3 = AMARELO, \n 4 = VERDE, \n 5 = VERMELHO\n");
			select = scan.nextInt();
			if(Colors[i] == null)
			{
				System.out.println("Cor ja escolhida");
				i--;
			}
			else
			{
				System.out.println("Insira um noma para o jogador");
				System.out.print(i+1);
				System.out.print("\n");
				name = scan.nextLine();
				
				
				Players[i] = new Player(name,remainingColors[select],null); //maybe define objectives before and give'em out here 
				
				remainingColors[select] = null;
			}
		}
		
		scan.close();
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
}
