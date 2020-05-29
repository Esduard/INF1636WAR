package model;

public class DestroyArmyObjective extends Objective {

	private Color color;
	
	@Override
	protected boolean ValidateObjective() {
		
		//get target player's territory count
		Player target = Model.getPlayer(color);
		
		//if player color does not exist return null
		if (target == null) {
			return false;
		}
		
		//if count is 0 then true
		if(target.getAllTerritories().isEmpty()) {
			return true;
		}
		
		
		return false;
	}
	
	public DestroyArmyObjective(String description, Color c)
	{
		this.description = description;
		this.color = c;
	}
}
