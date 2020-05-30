package model;

import java.util.*;

public class ConquerTerritoryObjective extends Objective {

	private int numberOfTerritories;
	private int armyPerTerritory;
	
	@Override
	protected boolean ValidateObjective() {
		
		//get acces to player territories
		List<Territory> territories = this.player.getAllTerritories();
		//if all terrtories have
		if (territories.size() >= numberOfTerritories) {
			
			for(int i=0;i<territories.size();i++) {
				if(territories.get(i).getTroops() <  armyPerTerritory) {
					return false;
				}
			}
			return true;
		}
		
		
		return false;
	}
	
	public ConquerTerritoryObjective(String description, int numberOfTerritories, int armyPerTerritory,Player player) {
		this.description = description;
		this.numberOfTerritories = numberOfTerritories;
		this.armyPerTerritory = armyPerTerritory;
		this.player = player;
	}

}
