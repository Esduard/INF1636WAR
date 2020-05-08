package model;
import java.util.ArrayList;

public class Continent {
	private String name;
	private ArrayList<Territory> territories;
	private int bonusArmy;
	
	
	public Continent (String n, ArrayList<Territory> t, int b ) {
		
		name = n;
		territories = t;
		bonusArmy = b;
	}
	
	public String  getName() {
		return name;
	}
	
	public int getBonusArmy() {
		return bonusArmy;
	}
	
}
