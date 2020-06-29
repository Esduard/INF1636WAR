package controller;

import model.GameExecution;
import observer.IObserver;
import observer.NextTurnNotifier;

public class TurnController{
	
	private static TurnController singleton;
	
	private int currentPlayer;
	private GameExecution gE;
	private TurnState currentState;
	private NextTurnNotifier nextTurnNotifier = new NextTurnNotifier();
	
	private TurnController()
	{
		gE = GameExecution.getGameExecution();
		currentPlayer = 0;
		currentState = TurnState.armyPlacement;
	}
	
	public static TurnController getTurnController()
	{
		if(singleton == null)
			singleton = new TurnController();
		return singleton;
	}
	
	public static void setTurnController(TurnController tC) {
		singleton = tC;
	}
	
	public void nextTurn()
	{
		if(currentState == TurnState.ended)
		{
			if(currentPlayer < gE.getPlayerCount() - 1)
				currentPlayer++;
			else
				currentPlayer = 0;
			
			nextTurnNotifier.setNextPlayer(currentPlayer);
		}
	}
	
	public void nextState()
	{
		switch(currentState)
		{
		case armyMovement:
			currentState = TurnState.cardDraw;
			break;
		case armyPlacement:
			if(gE.getPlayerAvailableArmy(currentPlayer) == 0)
				currentState = TurnState.attack;
			break;
		case attack:
			currentState = TurnState.armyMovement;
			break;
		case cardDraw:
			currentState = TurnState.ended;
			break;
		case ended:
			break;
		default:
			break;
		}
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void addObserver(IObserver o)
	{
		nextTurnNotifier.addObserver(o);
	}
}
