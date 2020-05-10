package model;
import java.util.*;

public class model {
	
	public static void start(){
		
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
		
		ArrayList<Color> colors = new ArrayList<Color>(
				Arrays.asList(Color.White,Color.Black,Color.Blue,Color.Yellow,Color.Green,Color.Red));
		
		Player [] players = new Player[n_players];
		//public Player(String n,Color c,Objective o)
		
		
		for(i=0;i<6;i++)
		{
			System.out.print("Escolha uma cor para o jogador ");
			System.out.print(i+1);
			System.out.print("\n");
			System.out.println("Indices respectivos: BRANCO, PRETO, AZUL, AMARELO, VERDE, VERMELHO");
			select = scan.nextInt();
			if(colors.get(select) == null)
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
				
				
				players[i] = new Player(name,colors.get(select),null); //maybe define objectives before and give'em out here 
				
				colors.set(select,null);
			}
		}
		
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
	    
	    
	    
	  //initialize territories
		
	  		Territory [] Turfs;
	  		
	  		Turfs = new Territory[51];
	    
	  //public Territory(String n, Color c, ArrayList<String> neighbors );
		
		//NA
	    
	    Turfs[0] 	= new Territory("Alasca"		,null, alasca_n);
	    Turfs[1] 	= new Territory("Calgary"		,null, calgary_n);
	    Turfs[2]	= new Territory("California"	,null, california_n);
	    Turfs[3] 	= new Territory("Groenlandia"	,null, groenlandia_n);
	    Turfs[4]	= new Territory("Mexico"		,null, mexico_n);
	    Turfs[5] 	= new Territory("Nova York"		,null, nova_york_n);
	    Turfs[6] 	= new Territory("Quebec"		,null, quebec_n);
	    Turfs[7] 	= new Territory("Texas"			,null, texas_n);
	    Turfs[8] 	= new Territory("Vancouver"		,null, vancouver_n);
		
		//SA
	    
	    Turfs[9]	= new Territory("Argentina"		,null, argentina_n);
	    Turfs[10] 	= new Territory("Brasil"		,null, brasil_n);
	    Turfs[11] 	= new Territory("Peru"			,null, peru_n);
	    Turfs[12] 	= new Territory("Venezuela"		,null, venezuela_n);
	    
	    //AF
	    
	    Turfs[13]	= new Territory("Africa Do Sul"	,null, africa_do_sul_n);
	    Turfs[14] 	= new Territory("Angola"		,null, angola_n);
	    Turfs[15] 	= new Territory("Argelia"		,null, argelia_n);
	    Turfs[16] 	= new Territory("Egito"			,null, egito_n);
	    Turfs[17]	= new Territory("Nigeria"		,null, nigeria_n);
	    Turfs[18] 	= new Territory("Somalia"		,null, somalia_n);
	    
	    //EU
	    
	    Turfs[19]	= new Territory("Espanha"		,null, espanha_n);
	    Turfs[20] 	= new Territory("Franca"		,null, franca_n);
	    Turfs[21] 	= new Territory("Italia"		,null, italia_n);
	    Turfs[22]	= new Territory("Polonia"		,null, polonia_n);
	    Turfs[23] 	= new Territory("Reino Unido"	,null, reino_unido_n);
	    Turfs[24]	= new Territory("Romenia"		,null, romenia_n);
	    Turfs[25] 	= new Territory("Suecia"		,null, suecia_n);
	    Turfs[26] 	= new Territory("Ucrania"		,null, ucrania_n);
	    
	    //AS
	    
	    Turfs[27] 	= new Territory("Arabia Saudita",null, arabia_saudita_n);
	    Turfs[28]	= new Territory("Bangladesh"	,null, bangladesh_n);
	    Turfs[29] 	= new Territory("Cazaquistao"	,null, cazaquistao_n);
	    Turfs[30] 	= new Territory("China"			,null, china_n);
	    Turfs[31] 	= new Territory("Coreia Do Norte",null, coreia_do_norte_n);
	    Turfs[32] 	= new Territory("Coreia Do Sul"	,null, coreia_do_sul_n);
	    Turfs[33] 	= new Territory("Estonia"		,null, estonia_n);
	    Turfs[34] 	= new Territory("India"			,null, india_n);
	    Turfs[35] 	= new Territory("Ira"			,null, ira_n);
	    Turfs[36] 	= new Territory("Iraque"		,null, iraque_n);
	    Turfs[37] 	= new Territory("Japao"			,null, japao_n);
	    Turfs[38] 	= new Territory("Jordania"		,null, jordania_n);
	    Turfs[39] 	= new Territory("Letonia"		,null, letonia_n);
	    Turfs[40] 	= new Territory("Mongolia"		,null, mongolia_n);
	    Turfs[41] 	= new Territory("Paquistao"		,null, paquistao_n);
	    Turfs[42] 	= new Territory("Russia"		,null, russia_n);
	    Turfs[43] 	= new Territory("Sibeira"		,null, siberia_n);
	    Turfs[44] 	= new Territory("Siria"			,null, siria_n);
	    Turfs[45] 	= new Territory("Tailandia"		,null, tailandia_n);
	    Turfs[46] 	= new Territory("Turquia"		,null, turquia_n);
	    
	    //OC
	    
	    Turfs[47] 	= new Territory("Australia"		,null, australia_n);
	    Turfs[48] 	= new Territory("Indonesia"		,null, indonesia_n);
	    Turfs[49] 	= new Territory("Nova Zelandia"	,null, nova_zelandia_n);
	    Turfs[50] 	= new Territory("Perth"			,null, perth_n);
	    
	    
		//initialize cards
		Card [] cards;
		
		cards = new Card[53];
		
		ArrayList<Objective> objectives;
		
		
		//public Card(Shape s, Territory t);
		
		//NA_Turfs 
		
		cards[0] = new Card(Shape.Triangle	, Turfs[0]);//Alasca
		cards[1] = new Card(Shape.Circle	, Turfs[1]);//Calgary
		cards[2] = new Card(Shape.Square	, Turfs[2]);//California
		cards[3] = new Card(Shape.Circle	, Turfs[3]);//Groenlandia
		cards[4] = new Card(Shape.Square	, Turfs[4]);//Mexico
		cards[5] = new Card(Shape.Square	, Turfs[5]);//Nova_York
		cards[6] = new Card(Shape.Circle	, Turfs[6]);//Quebec
		cards[7] = new Card(Shape.Triangle	, Turfs[7]);//Texas
		cards[8] = new Card(Shape.Triangle	, Turfs[8]);//Vancouver
		
		
		//SA_Turfs 
		
		cards[9] = new Card(Shape.Square	, Turfs[9]);//Argentina
		cards[10] = new Card(Shape.Circle	, Turfs[10]);//Brasil
		cards[11] = new Card(Shape.Triangle	, Turfs[11]);//Peru
		cards[12] = new Card(Shape.Triangle	, Turfs[12]);//Venezuela
		
		//AF_Turfs 
		
		cards[13] = new Card(Shape.Triangle	, Turfs[13]);//Africa_Do_Sul
		cards[14] = new Card(Shape.Square	, Turfs[14]);//Angola
		cards[15] = new Card(Shape.Circle	, Turfs[15]);//Argelia
		cards[16] = new Card(Shape.Triangle	, Turfs[16]);//Egito
		cards[17] = new Card(Shape.Circle	, Turfs[17]);//Nigeria
		cards[18] = new Card(Shape.Square	, Turfs[18]);//Somalia
		
		//EU_Turfs 
		
		cards[19] = new Card(Shape.Circle	, Turfs[19]);//Espanha
		cards[20] = new Card(Shape.Triangle	, Turfs[20]);//Franca
		cards[21] = new Card(Shape.Square	, Turfs[21]);//Italia
		cards[22] = new Card(Shape.Triangle	, Turfs[22]);//Polonia
		cards[23] = new Card(Shape.Circle	, Turfs[23]);//Reino_Unido
		cards[24] = new Card(Shape.Triangle	, Turfs[24]);//Romenia
		cards[25] = new Card(Shape.Square	, Turfs[25]);//Suecia
		cards[26] = new Card(Shape.Circle	, Turfs[26]);//Ucrania
		
		//AS_Turfs 
		
		cards[27] = new Card(Shape.Circle 	, Turfs[27]);//Arabia_Saudita
		cards[28] = new Card(Shape.Circle 	, Turfs[28]);//Bangladesh
		cards[29] = new Card(Shape.Circle 	, Turfs[29]);//Cazaquistao
		cards[30] = new Card(Shape.Square 	, Turfs[30]);//China
		cards[31] = new Card(Shape.Square 	, Turfs[31]);//Coreia_Do_Norte
		cards[32] = new Card(Shape.Triangle , Turfs[32]);//Coreia_Do_Sul
		cards[33] = new Card(Shape.Circle 	, Turfs[33]);//Estonia
		cards[34] = new Card(Shape.Triangle , Turfs[34]);//India
		cards[35] = new Card(Shape.Square 	, Turfs[35]);//Ira
		cards[36] = new Card(Shape.Triangle , Turfs[36]);//Iraque
		cards[37] = new Card(Shape.Circle 	, Turfs[37]);//Japao
		cards[38] = new Card(Shape.Square 	, Turfs[38]);//Jordania
		cards[39] = new Card(Shape.Square 	, Turfs[39]);//Letonia
		cards[40] = new Card(Shape.Triangle , Turfs[40]);//Mongolia
		cards[41] = new Card(Shape.Circle 	, Turfs[41]);//Paquistao
		cards[42] = new Card(Shape.Triangle , Turfs[42]);//Russia
		cards[43] = new Card(Shape.Square 	, Turfs[43]);//Siberia
		cards[44] = new Card(Shape.Square 	, Turfs[44]);//Siria
		cards[45] = new Card(Shape.Triangle , Turfs[45]);//Tailandia
		cards[46] = new Card(Shape.Triangle	, Turfs[46]);//Turquia
		
		//OC_Turfs
		
		cards[47] = new Card(Shape.Triangle	, Turfs[47]);//Australia);
		cards[48] = new Card(Shape.Triangle	, Turfs[48]);//Indonesia);
		cards[49] = new Card(Shape.Square	, Turfs[49]);//Nova_Zelandia);
		cards[50] = new Card(Shape.Circle	, Turfs[50]);//Perth);
		
		//Jokers
		
		cards[51] = new Card(Shape.Joker	, null);
		cards[52] = new Card(Shape.Joker	, null);
		
		
		//Objectives
		
		
		//public Objective(String d)
		
		Objective 
		
		
		objectives = new ArrayList<Objectives>(
	    	      Arrays.asList());
		
		
		
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
