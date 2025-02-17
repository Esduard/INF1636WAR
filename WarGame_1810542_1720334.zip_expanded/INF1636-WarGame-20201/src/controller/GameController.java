package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.GameExecution;
import view.*;


public class GameController {

	private static GameController singleton;

	private GameState currentState;
	private JFrame activeFrame;

	private GameController() {
		activeFrame = new FRNewGame();
		activeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentState = GameState.newGameMenu;
	}

	public static GameController getGameController() {
		if (singleton == null)
			singleton = new GameController();
		return singleton;
	}

	private void changeFrame(JFrame f) {
		activeFrame.dispose();
		activeFrame = f;
		activeFrame.setVisible(true);
		activeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void nextState(boolean load)
	{
		TurnController tC = TurnController.getTurnController();
		GameExecution gE = GameExecution.getGameExecution();
		
		if(load) {
			changeFrame(new FRGame());
			currentState = GameState.game;
			tC.loadState();
			return;
		}
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
			tC.start();
			changeFrame(new FRGame());
			currentState = GameState.game;
			break;
		case game:
			JOptionPane.showMessageDialog(null, gE.getPlayerName(tC.getCurrentPlayer())
					+ " completou seu objetivo. FIM DE JOGO");
			System.exit(0);
			break;
		case ended:
			break;
		default:
			break;
		}
	}
}
