package model;

import java.util.*;

public class ConquerContinentObjective extends Objective {

	private Continent[] continents;
	private boolean extraContinent;
	private ArrayList<Continent> allExtraContinents;
	
	@Override
	protected boolean ValidateObjective() {
		
		List<Territory> territories = this.player.getAllTerritories();
		
		for(int i=0;i<continents.length;i++) {
			
			Territory [] t = continents[i].getTerritories();
			for(int j=0;j<t.length;j++) {
				//System.out.println(t[j].getName() + " parte da " + continents[i].getName());
			}
			
			for(int j=0;j<t.length;j++) {
				
				if(!territories.contains(t[j])){
					//System.out.println("i = " + i);
					//System.out.println("j = " + j);
					//System.out.println("falseou em " + t[j].getName() + " parte da " + continents[i].getName());
					
					return false;
				}
			}
				
		}
		
		if(extraContinent) {
			//System.out.println("extracontinet size: " + allExtraContinents.size());
			for(int cont=0;cont<allExtraContinents.size();cont++)
			{	
				//System.out.println("checking extracontinet: " + allExtraContinents.get(cont).getName());
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
	
	public ConquerContinentObjective(String description, Continent[] continents, boolean extraContinent,Player player, ArrayList<Continent> allExtraContinents)
	{
		this.description = description;
		this.continents = continents;
		this.extraContinent = extraContinent;
		this.player = player;
		
		//exclude obligatory continents of "all continents" list
		this.allExtraContinents = allExtraContinents;
	}
}
