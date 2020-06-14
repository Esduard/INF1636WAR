package controller;

import model.GameExecution;
import observer.Observable;

public class TurnController extends Observable{
	
	private static TurnController singleton;
	
	private int currentPlayer;
	private GameExecution gE = GameExecution.getGameExecution();
	
	private TurnController()
	{
	}
	
	public static TurnController getPlayerController()
	{
		if(singleton == null)
			singleton = new TurnController();
		return singleton;
	}
	
	public void nextTurn()
	{
		if(currentPlayer == gE.getPlayerCount())
			currentPlayer = 1;
		else
			currentPlayer++;
		
		notifyObservers();
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}

	@Override
	public Object get(int i) {
		return null;
	}
}
