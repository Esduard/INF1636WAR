package controller;

import model.*;
import observer.Observable;

import view.GameScreen;

public class GameController extends Observable{

	private GameState currentState = GameState.newGameMenu;
	
	private int currentPlayer;
	
	private static GameController singleton;

	private GameController()
	{
	}
	
	public static GameController getGameController()
	{
		if(singleton == null)
			singleton = new GameController();
		return singleton;
	}
	
	public void nextState()
	{
		switch (currentState) {
		case newGameMenu:
			currentState = GameState.chooseNumberOfPlayersMenu;
			break;
		case chooseNumberOfPlayersMenu:
			currentState = GameState.playerRegisterMenu;
			break;
		case playerRegisterMenu:
			GameExecution.initializeGameComponents();
			currentState = GameState.game;
			break;
		default:
			break;
		}
		
		notifyObservers();
	}
	
	public void nextTurn()
	{
		if(currentState == GameState.game)
		{
			if(currentPlayer == GameExecution.getPlayerCount())
				currentPlayer = 1;
			else
				currentPlayer++;
		}
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}

	@Override
	public Object get(int i) {
		switch(i)
		{
			case 0:
				return currentState;
			default:
				return null;
		}
	}
}
