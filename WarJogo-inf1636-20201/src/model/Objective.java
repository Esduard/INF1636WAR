package model;

import java.util.ArrayList;

public abstract class Objective {
	protected String description;
	protected abstract boolean ValidateObjective();
	
	
	
	public Objective(String d) {
		description = d;
	}
	
	
	//verification type
	
	
	//eliminate army
	//public boolean EliminateArmy(Color target)
	
	//turf conquer
	//public boolean TurfConquer(int Total, int ArmyPerTurf)
	
	//Continent takeover
	//public boolean Takeover(ArrayList<String> Continents)
	
}
