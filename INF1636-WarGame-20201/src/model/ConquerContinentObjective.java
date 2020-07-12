package model;


import java.util.*;

public class ConquerContinentObjective extends Objective{

	private Continent[] continents;
	private boolean extraContinent;
	private ArrayList<Continent> allExtraContinents;
	private static final long serialVersionUID = 1L;
	
	@Override
	protected boolean ValidateObjective() {
		
		List<Territory> territories = this.player.getAllTerritories();
		
		for(int i=0;i<continents.length;i++) {
			
			Territory [] t = continents[i].getTerritories();
			for(int j=0;j<t.length;j++) {
				
				if(!territories.contains(t[j])){
					return false;
				}
			}
				
		}
		
		if(extraContinent) {
			for(int cont=0;cont<allExtraContinents.size();cont++)
			{	
				boolean hasContinent = true;
				Territory []continentTerritories = allExtraContinents.get(cont).getTerritories();
				for(Territory t:continentTerritories){
					if(!(territories.contains(t)))
					{
						hasContinent = false;
						break;
					}
				}
				
				if(hasContinent) {
					return true;
				}
				
			}
			return false;
		}
		
		
		return true;
	}
	
	public ConquerContinentObjective(String code,String description, Continent[] continents, boolean extraContinent,Player player, ArrayList<Continent> allExtraContinents)
	{
		this.description = description;
		this.continents = continents;
		this.extraContinent = extraContinent;
		this.player = player;
		this.code = code;
		
		
		this.allExtraContinents = allExtraContinents;
	}
	
}
