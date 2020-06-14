package controller;

import model.GameExecution;
import observer.Observable;

public class PlayerController extends Observable{
	
	private static PlayerController singleton;
	
	private int currentPlayer;
	private GameExecution gE = GameExecution.getGameExecution();
	
	private PlayerController()
	{
	}
	
	public static PlayerController getPlayerController()
	{
		if(singleton == null)
			singleton = new PlayerController();
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
