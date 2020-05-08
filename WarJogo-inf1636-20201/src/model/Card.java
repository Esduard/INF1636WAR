package model;

import java.util.ArrayList;

public class Card {
	private Shape shape;
	private Territory territory;
	private ArrayList<Strings> neighbors;


	public Card(Shape s, Territory t) {
		shape = s;
		territory = t;
		
	}
	
	Shape getShape() {
		return shape;
	}
	
	Territory getTerritory(){
		return territory;
	}
}