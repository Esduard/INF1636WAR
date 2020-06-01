package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Territory {
	private String name;
	private GameColor color;
	private int numTroops = 0;
	private ArrayList<String> neighbors;
	private static ArrayList<Territory> territories = new ArrayList<Territory>(51);
	
	public Territory(String n, ArrayList<String> neighbors) {
		name = n;
		this.neighbors = neighbors;
	}
	
	public static Territory getTerritory(String name)
	{
		for(Territory t : territories)
		{
			if(t.name == name)
				return t;
		}
		
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public GameColor getColor() {
		return color;
	}
	
	public int getTroops() {
		
		return numTroops;
	}
	
	public void setTroops(int t) {
		
		if(t < 0) {
			numTroops = 0;
		}
		
		numTroops = t;
	}
	
	//Receives integer that increase or decrease troops
	public void modifyTroops(int t) {
		numTroops += t;
	}
	
	public ArrayList<String> getNeighbors(){
		return neighbors;
	}
	
	public void setColor(GameColor c)
	{
		color = c;
	}
	
	public static List<Territory> getTerritoriesList()
	{
		return Collections.unmodifiableList(territories);
	}
	
	public static void initialize()
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
			
		    List<Territory> territoryList = Territory.getTerritoriesList();
		    
		  //public Territory(String n, Color c, ArrayList<String> neighbors );
			
			//NA
		    
		    territories.add(new Territory("Alaska"		, alaska_n));
		    territories.add(new Territory("Mackenzie"		, mackenzie_n));
		    territories.add(new Territory("California"	, california_n));
		    territories.add(new Territory("Groenlandia"	, groenlandia_n));
		    territories.add(new Territory("Mexico"		, mexico_n));
		    territories.add(new Territory("Nova York"		, nova_york_n));
		    territories.add(new Territory("Labrador"		, labrador_n));
		    territories.add(new Territory("Ottawa"		, ottawa_n));
		    territories.add(new Territory("Vancouver"		, vancouver_n));
		    
		    
			//SA
		    
		    territories.add(new Territory("Argentina", argentina_n));
		    territories.add(new Territory("Brasil", brasil_n));
		    territories.add(new Territory("Chile"			, chile_n));
		    territories.add(new Territory("Colombia"		, colombia_n));
		    
		    //AF
		    
		    territories.add(new Territory("Africa Do Sul"	, africa_do_sul_n));
		    territories.add(new Territory("Sudao"			, sudao_n));
		    territories.add(new Territory("Argelia"		, argelia_n));
		    territories.add(new Territory("Egito"			, egito_n));
		    territories.add(new Territory("Madagascar"	, madagascar_n));
		    territories.add(new Territory("Congo"			, congo_n));
		    
		    //EU
		    
		    territories.add(new Territory("Islandia"		, islandia_n));
		    territories.add(new Territory("Franca"		, franca_n));
		    territories.add(new Territory("Inglaterra"	, inglaterra_n));
		    territories.add(new Territory("Polonia"		, polonia_n));
		    territories.add(new Territory("Suecia"		, suecia_n));
		    territories.add(new Territory("Moscou"		, moscou_n));
		    territories.add(new Territory("Alemanha"		, alemanha_n));
		    
		    //AS
		    
		    territories.add(new Territory("China"			, china_n));
		    territories.add(new Territory("India"			, india_n));
		    territories.add(new Territory("Japao"			, japao_n));
		    territories.add(new Territory("Dudinka"		, dudinka_n));
		    territories.add(new Territory("Aral"			, aral_n));
		    territories.add(new Territory("Mongolia"		, mongolia_n));
		    territories.add(new Territory("Oriente Medio"	, oriente_medio_n));
		    territories.add(new Territory("Omsk"			, omsk_n));
		    territories.add(new Territory("Siberia"		, siberia_n));
		    territories.add(new Territory("Tchita"		, tchita_n));
		    territories.add(new Territory("Vietna"		, vietna_n));
		    territories.add(new Territory("Vladivostok"	, vladivostok_n));
		    
		    //OC
		    
		    territories.add(new Territory("Australia"		, australia_n));
		    territories.add(new Territory("Sumatra"		, sumatra_n));
		    territories.add(new Territory("Nova Guine"	, nova_guine_n));
		    territories.add(new Territory("Borneo"		, borneo_n));
		    
	}
}
