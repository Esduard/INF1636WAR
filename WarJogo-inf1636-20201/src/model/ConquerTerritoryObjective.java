package model;

public class ConquerTerritoryObjective extends Objective {

	private int numberOfTerritories;
	private int armyPerTerritory;
	
	@Override
	protected boolean ValidateObjective() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ConquerTerritoryObjective(String description, int numberOfTerritories, int armyPerTerritory)
	{
		this.description = description;
		this.numberOfTerritories = numberOfTerritories;
		this.armyPerTerritory = armyPerTerritory;
	}

}
