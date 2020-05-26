package model;
import java.util.*;

public class TEST {
	
	
	public static void testValidateCardTrade()
	{
		System.out.println("-------------TEST CARD TRADE--------------");
		
		
		
		Card []cards = new Card[8];
		
		ArrayList<Card> test_subject = new ArrayList<Card>();
		
		cards[0]  = new Card(Shape.Triangle	, null);
		cards[1]  = new Card(Shape.Circle	, null);
		cards[2]  = new Card(Shape.Square	, null);
		cards[3]  = new Card(Shape.Circle	, null);
		cards[4]  = new Card(Shape.Triangle	, null);
		cards[5]  = new Card(Shape.Triangle	, null);
		cards[6]  = new Card(Shape.Joker	, null);
		cards[7]  = new Card(Shape.Joker	, null);
		
		
		
		System.out.println("correctly use 3 cards of same shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[4]);
		test_subject.add(cards[5]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		
		System.out.println("correctly use 3 cards of different shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 4 cards for trade");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		test_subject.add(cards[3]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 0 cards for trade");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 2 cards of same shape and other of different-nonjoker shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[1]);
		test_subject.add(cards[5]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use 2 cards of different shape and other of repeated-nonjoker shape");
		test_subject.add(cards[0]);
		test_subject.add(cards[3]);
		test_subject.add(cards[4]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("incorrectly use first card with different shape of second and second card with equal shape of third");
		test_subject.add(cards[1]);
		test_subject.add(cards[4]);
		test_subject.add(cards[5]);
		System.out.print("Expects false -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("correctly deal 2 equal cards with 1 joker");
		test_subject.add(cards[1]);
		test_subject.add(cards[3]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		
		System.out.println("correctly deal 2 diferent cards with  1 joker");
		test_subject.add(cards[1]);
		test_subject.add(cards[2]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
		System.out.println("correctly deal trade with 2 jokers and 1 extra card");
		test_subject.add(cards[1]);
		test_subject.add(cards[7]);
		test_subject.add(cards[6]);
		System.out.print("Expects true -> ");
		System.out.println(Model.validateCardTrade(test_subject));
		test_subject.removeAll(test_subject);
		
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
		System.out.println("Adding first player: " + Model.addPlayer(new Player("Hashirama", Color.Azul)));
		System.out.println("Adding second player: " + Model.addPlayer(new Player("Tobirama", Color.Vermelho)));
		System.out.println("Adding third player and repeating color: " + Model.addPlayer(new Player("Madara", Color.Vermelho)));
		System.out.println("Adding third player: " + Model.addPlayer(new Player("Hiruzen", Color.Preto)));
		System.out.println("Adding forth player: " + Model.addPlayer(new Player("Minato", Color.Branco)));
		System.out.println("Adding fifth player: " + Model.addPlayer(new Player("Tsunade", Color.Amarelo)));
		System.out.println("Adding sixth player: " + Model.addPlayer(new Player("Kakashi", Color.Verde)));
		System.out.println("Adding seventh player: " + Model.addPlayer(new Player("Naruto", Color.Branco)));
	}
	
	public static void testValidateAttack()
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
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Venezuela,Peru,1));
		
		System.out.println("can't attack yourself");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Brasil,Peru,1));
		
		System.out.println("can't do attack with no troops on standby in source");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Brasil,Venezuela,1));
	
		System.out.println("can't attack with more than 3 troops or 0 troops");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,0));
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,4));
		
		System.out.println("verify if target is src's neighbor");
		System.out.print("Expects false -> ");
		System.out.println(Model.validateAttack(Color.Azul,Argentina,Venezuela,1));
		
		System.out.println("valid attack");
		System.out.print("Expects true -> ");
		System.out.println(Model.validateAttack(Color.Azul,Peru,Venezuela,1));
	}

}
