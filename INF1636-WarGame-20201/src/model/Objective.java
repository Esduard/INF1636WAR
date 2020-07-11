package model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Objective implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String description;
	protected abstract boolean ValidateObjective();
	protected Player player;
	protected String code;
	
	
	public void setPlayer(Player p) {
		player = p;
	}
	
	
	public String getDescription(){
		return description;
	}
	
	public String getCode() {
		return code;
	}
	
	
	
	
	public static ArrayList<Objective> initialize()
	{
		GameExecution gE = GameExecution.getGameExecution();
		
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		
		List<Continent> continents = GameExecution.getGameExecution().getContinentList();
		
		int EU = Continent.EU;
		int SA = Continent.SA;
		int NA = Continent.NA;
		int AS = Continent.AS;
		int AF = Continent.AF;
		int OC = Continent.OC;
		
		//Conquer territory
		
		/*ID de ConquerTerritory:

			"CT" + 'numerototal' + 'quantidade por territorio'

			ex: conquista de 24 territorios com 1 em cada

			CT241*/
		
		objectives.add(new ConquerTerritoryObjective("CT182","Conquistar 18 territorios e ocupar cada um deles com pelo menos 2 exercitos", 18, 2,null));
		objectives.add(new ConquerTerritoryObjective("CT241","Conquistar 24 territorios", 24, 1,null));
		
		//Destroy army
		
		
		//must have acces to players
		int number_p = gE.getPlayerCount();
		
		/*ID of destroyArmyObjective:

			"DA + 'color enum'

			ex: 

			"DAAzul" to destroy blue armies
		*/
		
		for(int i = 0; i < number_p; i++)
		{
			Player p = gE.getPlayer(i);
			
			objectives.add(new DestroyArmyObjective("DA" + p.getColor(),"Destruir totalmente os exercitos do jogador " + p.getColor() + ". Se for voce mesmo ou o exercito ser destruido por outro jogador conquiste 24 territorios.", p,null));
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
		
		/*ID de ConquerContinent:

			"CC" + "iniciais dos continents obrigatorios + "1 SE TEM CONTINENTE EXTRA" OU "0 SE NAO TEM"

			EX: conquiste a America do norte e oceania

			CCNAOC0 */
		
		objectives.add(new ConquerContinentObjective("CCEUSA1","Conquistar na totalidade a Europa, a America do Sul "
				+ "e mais um continente a sua escolha", ContinentsEUSA, true,null,extraContinentsEUSA));
		
		ArrayList<Continent> extraContinentsEUOC = new ArrayList<Continent>();
		
		for(int i=0;i<continents.size();i++) {
			if(!Arrays.asList(ContinentsEUOC).contains(continents.get(i))) {
				//System.out.println("is extra: " + continents.get(i].getName() );
				extraContinentsEUOC.add(continents.get(i));
			}
				
		}
		
		objectives.add(new ConquerContinentObjective("CCEUOC1","Conquistar na totalidade a Europa, a Oceania "
				+ " mais um continente a sua escolha", ContinentsEUOC, true,null,extraContinentsEUOC));
		
		//Conquer continent objectives without extra continents
		
		objectives.add(new ConquerContinentObjective("CCNAOC0","Conquistar na totalidade a America do Norte e a Oceania", ContinentsNAOC, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("CCNAAF0","Conquistar na totalidade a America do Norte e a Africa", ContinentsNAAF, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("CCSAAS0","Conquistar na totalidade a America do Sul e a Asia", ContinentsASSA, false,null,extraContinentsEUOC));
		
		objectives.add(new ConquerContinentObjective("CCASAF0","Conquistar na totalidade a Asia e a Africa", ContinentsASAF, false,null,extraContinentsEUOC));
		

		return objectives;
	}
}
