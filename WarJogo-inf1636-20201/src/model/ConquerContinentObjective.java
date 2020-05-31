package model;

import java.util.List;

public class ConquerContinentObjective extends Objective {

	private Continent[] continents;
	private boolean extraContinent;
	private Continent[] allContinents;
	
	@Override
	protected boolean ValidateObjective() {
		
		List<Territory> territories = this.player.getAllTerritories();
		
		for(int i=0;i<continents.length;i++) {
			
			Territory [] t = continents[i].getTerritories();
			
			for(int j=0;j<t.length;j++) {
				
				if(!territories.contains(t[j])){
					//System.out.println("i = " + i);
					System.out.println("falseou em " + t[j].getName() + " parte da " + continents[i].getName());
					return false;
				}
			}
				
		}
		
		if(extraContinent) {
			for(int cont=0;cont<allContinents.length;cont++)
			{
				boolean hasContinent = true;
				Territory []continentTerritories = allContinents[cont].getTerritories();
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
	
	public ConquerContinentObjective(String description, Continent[] continents, boolean extraContinent,Player player,Continent[] allContinents)
	{
		this.description = description;
		this.continents = continents;
		this.extraContinent = extraContinent;
		this.player = player;
		this.allContinents = allContinents;
		
	}

}
