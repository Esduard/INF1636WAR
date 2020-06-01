package controller;

import javax.swing.*;

import model.*;
import view.*;

public class GameController {

	private GameState currentState = GameState.newGameMenu;
	private JFrame activeFrame;
	private JFrame turnFrame;
	
	private static GameController singleton;
	
	private GameController()
	{
		activeFrame = new FRNewGame();
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
			activeFrame.dispose();
			activeFrame = new FRChooseNumberOfPlayers();
			currentState = GameState.chooseNumberOfPlayersMenu;
			break;
		case chooseNumberOfPlayersMenu:
			activeFrame.dispose();
			activeFrame = new FRPlayerRegister();
			currentState = GameState.playerRegisterMenu;
			break;
		case playerRegisterMenu:
			activeFrame.dispose();
			activeFrame = new FRGame();
			GameExecution.initializeGameComponents();
			currentState = GameState.p1Turn;
			break;
		case p1Turn:
			//turnFrame = new FRPlayerTurn();
		}
	}
}
