package view;

import observer.IObserver;
import observer.Observable;

import javax.swing.JFrame;
import controller.GameState;

public class GameScreen implements IObserver {
	
	private static GameScreen singleton;	
	private JFrame activeFrame;
	
	private GameScreen()
	{
		activeFrame = new FRNewGame();
	}
	
	public static GameScreen getGameScreen()
	{
		if(singleton == null)
			singleton = new GameScreen();
		return singleton;
	}

	private void changeFrame(JFrame f)
	{
		activeFrame.dispose();
		activeFrame = f;
		activeFrame.setVisible(true);
	}
	
	@Override
	public void update(Observable o) {
		switch ((GameState)o.get(0)) 
		{
			case chooseNumberOfPlayersMenu:
				changeFrame(new FRChooseNumberOfPlayers());
				break;
			case playerRegisterMenu:
				changeFrame(new FRPlayerRegister());
				break;
			case game:
				changeFrame(new FRGame());
			default:
				break;
		}
	}
}
