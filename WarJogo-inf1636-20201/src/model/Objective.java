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
	
	public static Objective getObjective(int i) {
		return objectives.get(i);
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
		
		objectives.add(new ConquerTerritoryObjective("Conquistar 18 territ�rios e ocupar cada um deles com pelo menos 2 ex�rcitos", 18, 2,null));
		objectives.add(new ConquerTerritoryObjective("Conquistar 24 territ�rios", 24, 1,null));
		
		//Destroy army
		
		
		//must have acces to players
		int number_p = GameExecution.getPlayerCount();
		
		for(int i = 0; i < number_p; i++)
		{
			objectives.add(new DestroyArmyObjective("Destruir totalmente os ex�rcitos do jogador " + GameExecution.getPlayer(i).getColor(),GameExecution.getPlayer(i),null));
		}
		
		//Conquer continent
		
		//Conquer continent objectives with extra continents
		
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
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Europa, a Am�rica do Sul "
				+ "e mais um continente � sua escolha", ContinentsEUSA, true,null,extraContinentsEUSA));
		
		ArrayList<Continent> extraContinentsEUOC = new ArrayList<Continent>();
		
		for(int i=0;i<continents.size();i++) {
			if(!Arrays.asList(ContinentsEUOC).contains(continents.get(i))) {
				//System.out.println("is extra: " + continents.get(i].getName() );
				extraContinentsEUOC.add(continents.get(i));
			}
				
		}
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Europa, a Oceania "
				+ " mais um continente � sua escolha", ContinentsEUOC, true,null,extraContinentsEUOC));
		
		//Conquer continent objectives without extra continents
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Am�rica do Norte e a Oceania", ContinentsNAOC, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Am�rica do Norte e a �frica", ContinentsNAAF, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a Am�rica do Sul e a �sia", ContinentsASSA, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("Conquistar na totalidade a �sia e a �frica", ContinentsASAF, false,null,extraContinentsEUOC));
		

	}
}
