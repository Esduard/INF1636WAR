package model;

import java.util.ArrayList;

public class Card {
	private Shape shape;
	private Territory territory;


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