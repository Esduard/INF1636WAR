package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
	private Shape shape;
	private Territory territory;
	private static ArrayList<Card> cards = new ArrayList<Card>();

	public Card(Shape s, Territory t) {
		shape = s;
		territory = t;
		
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public Territory getTerritory(){
		return territory;
	}
	
	public static Card getCard(Territory t) {
		for(Card c: cards) {
			if(c.getTerritory().equals(t)) {
				return c;
			}
		}
		return null;
	}
	
	public static List<Card> getCardList()
	{
		return Collections.unmodifiableList(cards);
	}
	
	public static void resetCards() {
		cards.clear();
	}
	
	public static void initialize()
	{	
		//public Card(Shape s, Territory t);
		
		resetCards();
		
		List<Territory> territories = Territory.getTerritoriesList();
		
		//NA_Territories 
		
		cards.add(new Card(Shape.Triangle	, territories.get(0)));
		cards.add(new Card(Shape.Circle	, territories.get(1)));
		cards.add(new Card(Shape.Square	, territories.get(2)));
		cards.add(new Card(Shape.Circle	, territories.get(3)));
		cards.add(new Card(Shape.Square	, territories.get(4)));
		cards.add(new Card(Shape.Triangle	, territories.get(5)));
		cards.add(new Card(Shape.Square	, territories.get(6)));
		cards.add(new Card(Shape.Circle	, territories.get(7)));
		cards.add(new Card(Shape.Triangle	, territories.get(8)));
		
		
		//SA_Territories 
		
		cards.add(new Card(Shape.Square	, territories.get(9)));
		cards.add(new Card(Shape.Circle	, territories.get(10)));
		cards.add( new Card(Shape.Triangle	, territories.get(11)));
		cards.add(new Card(Shape.Triangle	, territories.get(12)));
		
		//AF_Territories 
		
		cards.add(new Card(Shape.Triangle	, territories.get(13)));
		cards.add(new Card(Shape.Square	, territories.get(14)));
		cards.add(new Card(Shape.Circle	, territories.get(15)));
		cards.add(new Card(Shape.Triangle	, territories.get(16)));
		cards.add(new Card(Shape.Circle	, territories.get(17)));
		cards.add(new Card(Shape.Square	, territories.get(18)));
		
		//EU_Territories 
		
		cards.add(new Card(Shape.Triangle	, territories.get(19)));
		cards.add(new Card(Shape.Square	, territories.get(20)));
		cards.add(new Card(Shape.Circle	, territories.get(21)));
		cards.add(new Card(Shape.Square	, territories.get(22)));
		cards.add(new Card(Shape.Circle	, territories.get(23)));
		cards.add(new Card(Shape.Triangle	, territories.get(24)));
		cards.add(new Card(Shape.Circle	, territories.get(25)));
		
		
		//AS_Territories 
		
		cards.add(new Card(Shape.Circle	, territories.get(26)));
		cards.add(new Card(Shape.Square 	, territories.get(27)));
		cards.add(new Card(Shape.Square 	, territories.get(28)));
		cards.add(new Card(Shape.Circle 	, territories.get(29)));
		cards.add(new Card(Shape.Triangle , territories.get(30)));
		cards.add(new Card(Shape.Circle 	, territories.get(31)));
		cards.add(new Card(Shape.Square 	, territories.get(32)));
		cards.add(new Card(Shape.Square 	, territories.get(33)));
		cards.add(new Card(Shape.Triangle , territories.get(34)));
		cards.add(new Card(Shape.Triangle , territories.get(35)));
		cards.add(new Card(Shape.Triangle , territories.get(36)));
		cards.add(new Card(Shape.Circle 	, territories.get(37)));
		
		
		//OC_Territories
		
		cards.add(new Card(Shape.Triangle , territories.get(38)));
		cards.add(new Card(Shape.Square 	, territories.get(39)));
		cards.add(new Card(Shape.Circle 	, territories.get(40)));
		cards.add(new Card(Shape.Square 	, territories.get(41)));
		
		//Jokers
		
		cards.add(new Card(Shape.Joker	, null));
		cards.add(new Card(Shape.Joker	, null));
	}
}