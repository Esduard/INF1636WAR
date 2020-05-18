package model;

import java.util.*;

public class TEST {
	
	
	private static void testValidateCardTrade()
	{
		System.out.println("-------------TEST CARD TRADE--------------");
		
		//public static boolean validateCardTrade(ArrayList<Card> selected)
		Card []cards = new Card[9];
		
		cards[0]  = new Card(Shape.Triangle	, null);
		cards[1]  = new Card(Shape.Circle	, null);
		cards[2]  = new Card(Shape.Square	, null);
		cards[3]  = new Card(Shape.Circle	, null);
		cards[4]  = new Card(Shape.Square	, null);
		cards[5]  = new Card(Shape.Triangle	, null);
		cards[6]  = new Card(Shape.Square	, null);
		cards[7]  = new Card(Shape.Circle	, null);
		cards[8]  = new Card(Shape.Triangle	, null);
		
		System.out.println(" ");
		
	}
	
	public static void testCreatePlayerList()
	{
		System.out.println("----------------TEST CREATE PLAYER LIST----------------");
		
		System.out.println("With 2 players: " + Model.createPlayerList(2));
		System.out.println("With 3 players: " + Model.createPlayerList(3));
		System.out.println("With 6 players: " + Model.createPlayerList(6));
		System.out.println("With 7 players: " + Model.createPlayerList(7));
	}
	
	public static void testAddPlayer()
	{
		System.out.println("----------------TEST ADD PLAYER----------------");
		
		Model.createPlayerList(3);
		System.out.println("3 players: ");
		
		System.out.println("Adding null: " + Model.addPlayer(null));
		System.out.println("Adding first player: " + Model.addPlayer(new Player("Gabriel", Color.Azul)));
		System.out.println("Adding second player: " + Model.addPlayer(new Player("Eduardo", Color.Vermelho)));
		System.out.println("Adding third player and repeating color: " + Model.addPlayer(new Player("Ivan", Color.Vermelho)));
		System.out.println("Adding third player: " + Model.addPlayer(new Player("Ivan", Color.Preto)));
		System.out.println("Adding forth player: " + Model.addPlayer(new Player("Intruso", Color.Azul)));
	}
	
	private static void testValidateAttack()
	{
		System.out.println("-------------TEST VALIDATE ATTACK--------------");
		//public Territory(String n, Color c, ArrayList<String> neighbors );
	    ArrayList<String> venezuela_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Peru","Brasil"));
	    
	    ArrayList<String> peru_n = new ArrayList<String>(
	    	      Arrays.asList("Argentina","Venezuela","Brasil"));
	    
	    ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Venezuela","Peru","Argentina"));
	    
	    ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Peru","Brasil"));
		
		Territory Venezuela = new Territory("Venezuela",Color.Vermelho, venezuela_n);
		Territory Peru = new Territory("Peru",Color.Azul, peru_n);
		Territory Argentina = new Territory("Argentina",Color.Azul, argentina_n);
		Territory Brasil = new Territory("Brasil",Color.Azul, brasil_n);
		
		Venezuela.setTroops(1);
		Peru.setTroops(5);
		Argentina.setTroops(2);
		Brasil.setTroops(1);
		
		//public static boolean validateAttack(Color c,Territory src,Territory target,int n_Troops_Attacking)
		
		
		System.out.println("can't attack with enemy troops");
		System.out.println(Model.validateAttack(Color.Azul,Venezuela,Peru,1));
		
		System.out.println("can't attack yourself");
		System.out.println(Model.validateAttack(Color.Azul,Brasil,Peru,1));
		
		System.out.println("can't do attack with no troops on standby in source");
		System.out.println(Model.validateAttack(Color.Azul,Brasil,Venezuela,1));
	
		System.out.println("can't attack with more than 3 troops or 0 troops");
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,0));
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,4));
		
		System.out.println("verify if target is src's neighbor");
		System.out.println(Model.validateAttack(Color.Azul,Argentina,Venezuela,1));
	}

}
