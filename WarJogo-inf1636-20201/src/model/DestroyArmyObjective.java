package model;

public class DestroyArmyObjective extends Objective {

	private Color color;
	
	@Override
	protected boolean ValidateObjective() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public DestroyArmyObjective(String description, Color c)
	{
		this.description = description;
		this.color = c;
	}
}
