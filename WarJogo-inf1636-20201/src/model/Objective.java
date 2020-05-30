package model;

abstract class Objective {
	
	protected String description;
	protected abstract boolean ValidateObjective();
	protected Player player;
	
	
	public void setPlayer(Player p) {
		player = p;
	}
	
	
	public String getDescription()
	{
		return description;
	}
}
