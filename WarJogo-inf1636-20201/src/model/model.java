package model;
import java.util.ArrayList;

public class model {
	
	public void start(){
		
		//create players
		int index;
		
		
		//returns true if everthing goes right, false otherwise
		public boolean start( ArrayList<Player> p ) {
			
			
			
		}
		
		
	}
	
	
	public boolean validateAttack(Color c,Territory target, Territory src) {
		
		if(src.getTroops() <= 1)
		{
			return false;
		}
		if(c.equals(target.getColor())) {
			return false;
		}
		
		//verify if its neigbor
		
		return true;
		
	}
}
