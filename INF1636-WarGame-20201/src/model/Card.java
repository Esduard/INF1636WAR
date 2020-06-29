package model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

class Card implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private Territory territory;

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
		
		List<Card> cards = GameExecution.getGameExecution().getCardList();
		
		for(Card c: cards) {
			if(c.getShape() == Shape.Joker) {
				cArray.add(c);
			}
		}
		return cArray;
	}
	
	public static Card getCard(Territory t) {
		
		List<Card> cards = GameExecution.getGameExecution().getCardList();
		
		for(Card c: cards) {
			if(c.getTerritory().equals(t)) {
				return c;
			}
		}
		return null;
	}
	
	public static ArrayList<Card> initialize()
	{	
		//public Card(Shape s, Territory t);
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		//NA_Territories 
		
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Alasca")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Calgary")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("California")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Groenlandia")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Mexico")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Nova York")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Quebec")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Texas")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Vancouver")));
		
		
		//SA_Territories 
		
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Argentina")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Brasil")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Peru")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Venezuela")));
		
		//AF_Territories 
		
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Africa Do Sul")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Angola")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Argelia")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Egito")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Nigeria")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Somalia")));
		
		//EU_Territories 
		
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Espanha")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Franca")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Italia")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Reino Unido")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Suecia")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Polonia")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Romenia")));
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Ucrania")));
		
		
		//AS_Territories 
		
		cards.add(new Card(Shape.Circle		, GameExecution.getGameExecution().getTerritory("Arabia Saudita")));
		cards.add(new Card(Shape.Circle 	, GameExecution.getGameExecution().getTerritory("Bangladesh")));
		cards.add(new Card(Shape.Circle 	, GameExecution.getGameExecution().getTerritory("Cazaquistao")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("China")));
		cards.add(new Card(Shape.Square 	, GameExecution.getGameExecution().getTerritory("Coreia Do Norte")));
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("Coreia Do Sul")));
		cards.add(new Card(Shape.Circle 	, GameExecution.getGameExecution().getTerritory("Estonia")));
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("India")));
		cards.add(new Card(Shape.Square 	, GameExecution.getGameExecution().getTerritory("Ira")));
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("Iraque")));
		cards.add(new Card(Shape.Circle 	, GameExecution.getGameExecution().getTerritory("Japao")));
		cards.add(new Card(Shape.Square 	, GameExecution.getGameExecution().getTerritory("Jordania")));
		cards.add(new Card(Shape.Square 	, GameExecution.getGameExecution().getTerritory("Letonia")));
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("Mongolia")));
		cards.add(new Card(Shape.Circle 	, GameExecution.getGameExecution().getTerritory("Paquistao")));
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("Russia")));
		cards.add(new Card(Shape.Square 	, GameExecution.getGameExecution().getTerritory("Siberia")));
		cards.add(new Card(Shape.Square 	, GameExecution.getGameExecution().getTerritory("Siria")));
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("Tailandia")));
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("Turquia")));
		
		
		//OC_Territories
		
		cards.add(new Card(Shape.Triangle 	, GameExecution.getGameExecution().getTerritory("Australia")));
		cards.add(new Card(Shape.Triangle	, GameExecution.getGameExecution().getTerritory("Indonesia")));
		cards.add(new Card(Shape.Square		, GameExecution.getGameExecution().getTerritory("Nova Zelandia")));
		cards.add(new Card(Shape.Circle 	, GameExecution.getGameExecution().getTerritory("Perth")));
		
		//Jokers
		
		cards.add(new Card(Shape.Joker	, null));
		cards.add(new Card(Shape.Joker	, null));
		
		return cards;
	}
}