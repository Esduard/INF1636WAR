package controller;

import java.io.Serializable;

import javax.swing.JOptionPane;

import model.GameExecution;
import observer.IObserver;
import observer.NextStateNotifier;
import observer.NextTurnNotifier;

public class TurnController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static TurnController singleton;

	private int currentPlayer;
	private GameExecution gE;
	private TurnState currentState;
	private NextTurnNotifier nextTurnNotifier = new NextTurnNotifier();
	private NextStateNotifier nextStateNotifier = new NextStateNotifier();

	private TurnController() {
		gE = GameExecution.getGameExecution();
		currentPlayer = 0;
	}

	public static TurnController getTurnController() {
		if (singleton == null)
			singleton = new TurnController();
		return singleton;
	}

	public static void setTurnController(TurnController tC) {
		singleton = tC;
	}
	
	public void start()
	{
		currentState = TurnState.armyPlacement;
		gE.distribuiteArmy(currentPlayer);
	}

	public void nextTurn() {
		switch(currentState)
		{
		case armyMovement:
			nextState();
			break;
		case armyPlacement:
			JOptionPane.showMessageDialog(null, "Posicione todas suas tropas antes de passar o turno");
			break;
		case attack:
			nextState();
			break;
		case cardDraw:
			if(!gE.isPlayerTradeObligatory(currentPlayer))
				nextState();
			else
				JOptionPane.showMessageDialog(null, "Voce possui 5 cartas, precisa troca-las antes de passar de turno");
			break;
		case ended:
			
			if(gE.checkPlayerObjective(currentPlayer))
			{
				GameController.getGameController().nextState(false);
			}
			
			int prevPlayer = currentPlayer;

			if (currentPlayer < gE.getPlayerCount() - 1)
				currentPlayer++;
			else
				currentPlayer = 0;

			gE.distribuiteArmy(currentPlayer);
			nextTurnNotifier.setPlayers(currentPlayer, prevPlayer);
			nextState();
			break;
		default:
			break;
		}
	}

	public void nextState() {

		TurnState s = currentState;

		switch (currentState) {
		case armyPlacement:
			if (gE.getPlayerAvailableArmy(currentPlayer) == 0)
				currentState = TurnState.attack;
			break;
		case attack:
			currentState = TurnState.armyMovement;
			break;
		case armyMovement:
			currentState = TurnState.cardDraw;
			gE.playerDraw(currentPlayer);
			break;
		case cardDraw:
			currentState = TurnState.ended;
			break;
		case ended:
			currentState = TurnState.armyPlacement;
			break;
		default:
			break;
		}

		if (s != currentState)
			nextStateNotifier.setNextState(currentState.ordinal());
	}

	public void loadState()
	{
		nextStateNotifier.setNextState(currentState.ordinal());
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public int getCurrentState() {
		return currentState.ordinal();
	}

	public void addTurnObserver(IObserver o) {
		nextTurnNotifier.addObserver(o);
	}
	
	public void addStateObserver(IObserver o) {
		nextStateNotifier.addObserver(o);
	}

}
