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
	
	public static Territory getTerritory(int i_turf)
	{
		if(i_turf > -1 && i_turf < territories.size()){
			return territories.get(i_turf);
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
	
	public static void resetTerritories() {
		territories.clear();
	}
	
	public static void initialize()
	{
		//initialize neighbor lists
		Territory.resetTerritories();

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
			
		    List<Territory> territoryList = Territory.getTerritoriesList();
		    
		  //public Territory(String n, Color c, ArrayList<String> neighbors );
			
			//NA
		    
		    territories.add(new Territory("Alasca"			, alasca_n));
		    territories.add(new Territory("Calgary"			, calgary_n));
		    territories.add(new Territory("California"		, california_n));
		    territories.add(new Territory("Groenlandia"		, groenlandia_n));
		    territories.add(new Territory("Mexico"			, mexico_n));
		    territories.add(new Territory("Nova York"		, nova_york_n));
		    territories.add(new Territory("Quebec"			, quebec_n));
		    territories.add(new Territory("Texas"			, texas_n));
		    territories.add(new Territory("Vancouver"		, vancouver_n));
		    
		    
			//SA
		    
		    territories.add(new Territory("Argentina"		, argentina_n));
		    territories.add(new Territory("Brasil"			, brasil_n));
		    territories.add(new Territory("Peru"			, peru_n));
		    territories.add(new Territory("Venezuela"		, venezuela_n));
		    
		    //AF
		    
		    territories.add(new Territory("Africa Do Sul"	, africa_do_sul_n));
		    territories.add(new Territory("Angola"			, angola_n));
		    territories.add(new Territory("Argelia"			, argelia_n));
		    territories.add(new Territory("Egito"			, egito_n));
		    territories.add(new Territory("Nigeria"			, nigeria_n));
		    territories.add(new Territory("Somalia"			, somalia_n));
		    
		    //EU
		    
		    territories.add(new Territory("Espanha"		, espanha_n));
		    territories.add(new Territory("Franca"		, franca_n));
		    territories.add(new Territory("Italia"		, italia_n));
		    territories.add(new Territory("Reino Unido"	, reino_unido_n));
		    territories.add(new Territory("Polonia"		, polonia_n));
		    territories.add(new Territory("Suecia"		, suecia_n));
		    territories.add(new Territory("Romenia"		, romenia_n));
		    territories.add(new Territory("Ucrania"		, ucrania_n));
		    
		    //AS
		    
		    territories.add(new Territory("Arabia Saudita"	, arabia_saudita_n));
		    territories.add(new Territory("Bangladesh"		, bangladesh_n));
		    territories.add(new Territory("Cazaquistao"		, cazaquistao_n));
		    territories.add(new Territory("China"			, china_n));
		    territories.add(new Territory("Coreia Do Norte"	, coreia_do_norte_n));
		    territories.add(new Territory("Coreia Do Sul"	, coreia_do_sul_n));
		    territories.add(new Territory("Estonia"			, estonia_n));
		    territories.add(new Territory("India"			, india_n));
		    territories.add(new Territory("Ira"				, ira_n));
		    territories.add(new Territory("Iraque"			, iraque_n));
		    territories.add(new Territory("Japao"			, japao_n));
		    territories.add(new Territory("Jordania"		, jordania_n));
		    territories.add(new Territory("Letonia"			, letonia_n));
		    territories.add(new Territory("Mongolia"		, mongolia_n));
		    territories.add(new Territory("Paquistao"		, paquistao_n));
		    territories.add(new Territory("Russia"			, russia_n));
		    territories.add(new Territory("Siberia"			, siberia_n));
		    territories.add(new Territory("Siria"			, siria_n));
		    territories.add(new Territory("Tailandia"		, tailandia_n));
		    territories.add(new Territory("Turquia"			, turquia_n));
		    
		    //OC
		    
		    territories.add(new Territory("Australia"		, australia_n));
		    territories.add(new Territory("Indonesia"		, indonesia_n));
		    territories.add(new Territory("Nova Zelandia"	, nova_zelandia_n));
		    territories.add(new Territory("Perth"			, perth_n));
		    
	}
}
