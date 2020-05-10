package model;

public class ConquerContinentObjective extends Objective {

	private Continent[] continents;
	private boolean extraContinent;
	
	@Override
	protected boolean ValidateObjective() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ConquerContinentObjective(String description, Continent[] continents, boolean extraContinent)
	{
		this.description = description;
		this.continents = continents;
		this.extraContinent = extraContinent;
	}

}
