package model;

import java.util.ArrayList;

public class Territory {
	private String name;
	private Color color;
	private int numTroops = 0;
	private ArrayList<String> neighbors;
	
	
	
	public Territory(String n, ArrayList<String> neighbors ) {
		name = n;
		this.neighbors = neighbors;
	}
	
	public Territory(String n, Color c, ArrayList<String> neighbors ) {
		name = n;
		this.color = c;
		this.neighbors = neighbors;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getTroops() {
		
		return numTroops;
	}
	
	public void setTroops(int t) {
		
		if(t < 0) {
			numTroops = 0;
		}
		
		numTroops = t;
	}
	
	//Recieves integer that increase or decrease troops
	public void modifyTroops(int t) {
		numTroops += t;
	}
	
	public ArrayList<String> getNeighbors(){
		return neighbors;
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	public void setArmy(int number)
	{
		numTroops = number;
	}
}
