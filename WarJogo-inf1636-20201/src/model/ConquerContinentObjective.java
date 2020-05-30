package model;

import java.util.List;

public class ConquerContinentObjective extends Objective {

	private Continent[] continents;
	private boolean extraContinent;
	
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
		
		return true;
	}
	
	public ConquerContinentObjective(String description, Continent[] continents, boolean extraContinent,Player player)
	{
		this.description = description;
		this.continents = continents;
		this.extraContinent = extraContinent;
		this.player = player;
	}

}
