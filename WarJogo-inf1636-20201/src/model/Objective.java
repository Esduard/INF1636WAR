package model;

public abstract class Objective {
	
	protected String description;
	protected abstract boolean ValidateObjective();
	
	public String getDescription()
	{
		return description;
	}
}
