package controller;

import model.Model;
import model.Player;

public class Controller {
	
public static void round() {
		
		while(true) //loop condition must be a goal verification method for all players 
		{
			for (Player p:Players) 
			{
				
				Model.recieveAndDistributeArmies(p);
				
			}
			break;
		}
		
		
		
	}

}
