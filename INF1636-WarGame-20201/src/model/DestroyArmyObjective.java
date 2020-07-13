package model;

import java.util.ArrayList;
import java.util.List;

public class DestroyArmyObjective extends Objective {

	private static final long serialVersionUID = 1436822817521491441L;
	private Player target;	
	
	@Override
	protected boolean ValidateObjective() {
		
		
		
		if(target.equals(player)) {
			//if your target is yourself change method
			List<Territory> territories = this.player.getAllTerritories();
			if (territories.size() >= 24) {
				return true;
			}
			else {
				return false;
			}
		}
		
		//get target player's territory count
		if(target.getAllTerritories().isEmpty()) {
			//if count is 0 then assert that you killed him
			ArrayList<GameColor> killList = player.getPlayersKilled();
			
			if(!killList.isEmpty()) {
				
				for(int i=0;i<killList.size();i++) {
					if(killList.get(i).equals(target.getColor())) {
						return true;
					}
				}
			}
			
			//if player was killed by someone else verify if territory count is valid
			List<Territory> territories = this.player.getAllTerritories();
			if (territories.size() >= 24) {
				return true;
			}
			else {
				return false;
			}
			
		
		}
		else {
			return false;
		}
		
		
	}
	
	public DestroyArmyObjective(String code, String description, Player target,Player player)
	{
		this.description = description;
		this.target = target;
		this.player = player;
		this.code = code;
	}
}
