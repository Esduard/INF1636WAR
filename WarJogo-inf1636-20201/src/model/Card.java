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
	
	public static ArrayList<Card> getJokers()
	{
		ArrayList<Card> cArray = new ArrayList<Card>(2);
		
		for(Card c: cards) {
			if(c.getShape() == Shape.Joker) {
				cArray.add(c);
			}
		}
		return cArray;
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
		
		//NA_Territories 
		
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Alasca")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Calgary")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("California")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Groenlandia")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Mexico")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Nova York")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Quebec")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Texas")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Vancouver")));
		
		
		//SA_Territories 
		
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Argentina")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Brasil")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Peru")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Venezuela")));
		
		//AF_Territories 
		
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Africa Do Sul")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Angola")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Argelia")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Egito")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Nigeria")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Somalia")));
		
		//EU_Territories 
		
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Espanha")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Franca")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Italia")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Reino Unido")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Suecia")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Polonia")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Romenia")));
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Ucrania")));
		
		
		//AS_Territories 
		
		cards.add(new Card(Shape.Circle		, Territory.getTerritory("Arabia Saudita")));
		cards.add(new Card(Shape.Circle 	, Territory.getTerritory("Bangladesh")));
		cards.add(new Card(Shape.Circle 	, Territory.getTerritory("Cazaquistao")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("China")));
		cards.add(new Card(Shape.Square 	, Territory.getTerritory("Coreia Do Norte")));
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("Coreia Do Sul")));
		cards.add(new Card(Shape.Circle 	, Territory.getTerritory("Estonia")));
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("India")));
		cards.add(new Card(Shape.Square 	, Territory.getTerritory("Ira")));
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("Iraque")));
		cards.add(new Card(Shape.Circle 	, Territory.getTerritory("Japao")));
		cards.add(new Card(Shape.Square 	, Territory.getTerritory("Jordania")));
		cards.add(new Card(Shape.Square 	, Territory.getTerritory("Letonia")));
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("Mongolia")));
		cards.add(new Card(Shape.Circle 	, Territory.getTerritory("Paquistao")));
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("Russia")));
		cards.add(new Card(Shape.Square 	, Territory.getTerritory("Siberia")));
		cards.add(new Card(Shape.Square 	, Territory.getTerritory("Siria")));
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("Tailandia")));
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("Turquia")));
		
		
		//OC_Territories
		
		cards.add(new Card(Shape.Triangle 	, Territory.getTerritory("Australia")));
		cards.add(new Card(Shape.Triangle	, Territory.getTerritory("Indonesia")));
		cards.add(new Card(Shape.Square		, Territory.getTerritory("Nova Zelandia")));
		cards.add(new Card(Shape.Circle 	, Territory.getTerritory("Perth")));
		
		//Jokers
		
		cards.add(new Card(Shape.Joker	, null));
		cards.add(new Card(Shape.Joker	, null));
		
		
	}
}