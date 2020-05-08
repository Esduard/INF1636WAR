package model;

public class Territory {
	private String name;
	private Color color;
	private int numTroops = 0;
	
	
	
	public Territory(String n, Color c) {
		
		name = n;
		color = c;
		
	}
	
	String getName() {
		return name;
	}
	
	Color getColor() {
		return color;
	}
	
	int getTroops() {
		
		return numTroops;
	}
	
}
