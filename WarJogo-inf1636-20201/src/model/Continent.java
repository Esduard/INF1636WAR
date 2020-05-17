package model;

class Continent {
	private String name;
	private Territory[] territories;
	private int bonusArmy;
	
	
	public Continent (String n, Territory[] t, int b) {
		
		name = n;
		territories = t;
		bonusArmy = b;
	}
	
	public Territory[] getTerritories()
	{
		return territories;
	}
	
	public String  getName() {
		return name;
	}
	
	public int getBonusArmy() {
		return bonusArmy;
	}
	
}
