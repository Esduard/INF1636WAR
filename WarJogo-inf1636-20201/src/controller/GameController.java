package controller;

import javax.swing.JFrame;

import model.GameExecution;
import view.*;

public class GameController{

	private static GameController singleton;
	
	private GameState currentState = GameState.newGameMenu;
	private JFrame activeFrame;
	private GameExecution gE = GameExecution.getGameExecution();
	
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
	
	private void changeFrame(JFrame f)
	{
		activeFrame.dispose();
		activeFrame = f;
		activeFrame.setVisible(true);
	}
	
	public void nextState()
	{
		switch (currentState) {
			case newGameMenu:
				changeFrame(new FRChooseNumberOfPlayers());
				currentState = GameState.chooseNumberOfPlayersMenu;
				break;
			case chooseNumberOfPlayersMenu:
				changeFrame(new FRPlayerRegister());
				currentState = GameState.playerRegisterMenu;
				break;
			case playerRegisterMenu:
				gE.initializeGameComponents();
				gE.firstDraw();
				changeFrame(new FRGame());
				currentState = GameState.game;
				break;
			default:
				break;
		}
	}
}
