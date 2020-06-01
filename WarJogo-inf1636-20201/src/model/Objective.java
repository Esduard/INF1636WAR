package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class Objective {
	
	protected String description;
	protected abstract boolean ValidateObjective();
	protected Player player;
	
	private static ArrayList<Objective> objectives = new ArrayList<Objective>(14);
	
	
	public void setPlayer(Player p) {
		player = p;
	}
	
	
	public String getDescription()
	{
		return description;
	}
	
	public static List<Objective> getObjectiveList()
	{
		return Collections.unmodifiableList(objectives);
	}
	
	public static void initialize()
	{
		List<Continent> continents = Continent.getContinentList();
		
		int EU = Continent.EU;
		int SA = Continent.SA;
		int NA = Continent.NA;
		int AS = Continent.AS;
		int AF = Continent.AF;
		int OC = Continent.OC;
		
		//Conquer territory
		
		objectives.add(new ConquerTerritoryObjective("Conquistar 18 territórios e ocupar cada um deles com pelo menos 2 exércitos", 18, 2,null));
		objectives.add(new ConquerTerritoryObjective("Conquistar 24 territórios", 24, 1,null));
		
		//Destroy army
		
		
		for(int i = 0; i < GameColor.Count.ordinal(); i++)
		{
			GameColor c = GameColor.values()[i];
			objectives.add(new DestroyArmyObjective("Destruir totalmente os exércitos do jogador " + c.name(),GameExecution.getPlayer(c),null));
		}
		
		//Conquer continent
		
		ArrayList<Continent> extraContinents = new ArrayList<Continent>();
		
		for(int i=0;i<continents.size();i++) {
			extraContinents.add(continents.get(i));
		}
		
		Continent[] ContinentsEUSA = {continents.get(EU), continents.get(SA)};
		
		Continent[] ContinentsEUOC = {continents.get(EU),continents.get(OC)};
		
		Continent[] ContinentsNAOC = {continents.get(NA),continents.get(OC)};
		
		Continent[] ContinentsNAAF = {continents.get(NA),continents.get(AF)};
		
		Continent[] ContinentsASSA = {continents.get(AS),continents.get(SA)};
		
		Continent[] ContinentsASAF = {continents.get(AS),continents.get(AF)}; 
		
		ArrayList<Continent> extraContinentsEUSA = new ArrayList<Continent>();
		
		for(int i=0;i<continents.size();i++) {
			if(!Arrays.asList(ContinentsEUSA).contains(continents.get(i))) {
				//System.out.println("is extra: " + continents.get(i].getName() );
				extraContinentsEUSA.add(continents.get(i));
			}
				
		}
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Europa, a América do Sul "
				+ "e mais um continente à sua escolha", ContinentsEUSA, true,null,extraContinentsEUSA));
		
		ArrayList<Continent> extraContinentsEUOC = new ArrayList<Continent>();
		
		for(int i=0;i<continents.size();i++) {
			if(!Arrays.asList(ContinentsEUOC).contains(continents.get(i))) {
				//System.out.println("is extra: " + continents.get(i].getName() );
				extraContinentsEUOC.add(continents.get(i));
			}
				
		}
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Europa, a Oceania e "
				+ "mais um continente à sua escolha", ContinentsEUOC, true,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a Oceania", ContinentsNAOC, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a América do Norte e a África", ContinentsNAAF, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a América do Sul e a Ásia", ContinentsASSA, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Ásia e a África", ContinentsASAF, false,null,extraContinentsEUOC));
		

	}
}
