package model;

import java.util.ArrayList;
import java.util.Collections;

class GameValidation {
	
	public static boolean validateCardTrade(ArrayList<Card> selected)
	{
		if(selected != null && selected.size() == 3){
			
			//sort array by enum so joker is last and enums pairs are grouped
			Collections.sort(selected, (a1, a2) -> a1.getShape().compareTo(a2.getShape()));
			
			if(selected.get(0).getShape() == selected.get(1).getShape())
			{
				if(selected.get(0).getShape() == selected.get(2).getShape()) //all shapes are equal
					return true;
				else{
					if(selected.get(2).getShape() == Shape.Joker) //joker complements trade
						return true;
					else
						return false;
				}
			}
			else {
			
				
				if(selected.get(0).getShape() != selected.get(2).getShape()) { 
					return true; //all shapes are diferent
				}
				else{
					if(selected.get(2).getShape() == Shape.Joker) 
						return true; //joker complements trade
					else
						return false; 
					}	
			}
		}
		return false; //invalid number
				
			
	}
	
	public static boolean validateAttack(GameColor c,Territory src,Territory target,int n_Troops_Attacking) {
		
		
		if(!(c.equals(src.getColor()))) {
			//can't attack with enemy troops
			return false;
		}
		
		if(c.equals(target.getColor())) {
			//can't attack yourself
			return false;
		}
		
		if((src.getTroops() - n_Troops_Attacking)  < 1)
		{
			//can't do attack with no troops on standby in source
			return false;
		}
		
		if(n_Troops_Attacking > 3 || n_Troops_Attacking == 0){
			//can't attack with more than 3 troops or 0 troops
			return false;
		}
		
		//verify if target is src's neighbor	
		ArrayList<String> neighbors = src.getNeighbors();
		
		return neighbors.contains(target.getName());
	}
	
}
