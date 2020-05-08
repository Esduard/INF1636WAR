import java.util.*;

import model.*;

public class TEST {

	
	
	public static void main(String[] args) {
		
		//public Territory(String n, Color c, ArrayList<String> neighbors );
	    ArrayList<String> venezuela_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Peru","Brasil"));
	    
	    ArrayList<String> peru_n = new ArrayList<String>(
	    	      Arrays.asList("Argentina","Venezuela","Brasil"));
	    
	    ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Venezuela","Peru","Argentina"));
	    
	    ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Peru","Brasil"));
		
		Territory Venezuela = new Territory("Venezuela",Color.Red, venezuela_n);
		Territory Peru = new Territory("Peru",Color.Blue, peru_n);
		Territory Argentina = new Territory("Argentina",Color.Blue, argentina_n);
		Territory Brasil = new Territory("Brasil",Color.Blue, brasil_n);
		
		Venezuela.setTroops(1);
		Peru.setTroops(5);
		Argentina.setTroops(2);
		Brasil.setTroops(1);
		
		//public static boolean validateAttack(Color c,Territory src,Territory target,int n_Troops_Attacking)
		
		
		System.out.println("can't attack with enemy troops");
		System.out.println(model.validateAttack(Color.Blue,Venezuela,Peru,1));
		
		System.out.println("can't attack yourself");
		System.out.println(model.validateAttack(Color.Blue,Brasil,Peru,1));
		
		System.out.println("can't do attack with no troops on standby in source");
		System.out.println(model.validateAttack(Color.Blue,Brasil,Venezuela,1));
	
		System.out.println("can't attack with more than 3 troops or 0 troops");
		System.out.println(model.validateAttack(Color.Blue,Peru,Venezuela,0));
		System.out.println(model.validateAttack(Color.Blue,Peru,Venezuela,4));
		
		System.out.println("verify if target is src's neighbor");
		System.out.println(model.validateAttack(Color.Blue,Argentina,Venezuela,1));
		
		
	}
}
