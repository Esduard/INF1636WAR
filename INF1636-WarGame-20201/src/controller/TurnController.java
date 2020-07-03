package controller;

import java.io.Serializable;

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
		currentState = TurnState.armyPlacement;
		gE.distribuiteArmy(currentPlayer);
	}

	public static TurnController getTurnController() {
		if (singleton == null)
			singleton = new TurnController();
		return singleton;
	}

	public static void setTurnController(TurnController tC) {
		singleton = tC;
	}

	public void nextTurn() {
		if (currentState == TurnState.ended) {
			int prevPlayer = currentPlayer;

			if (currentPlayer < gE.getPlayerCount() - 1)
				currentPlayer++;
			else
				currentPlayer = 0;

			gE.distribuiteArmy(currentPlayer);
			nextTurnNotifier.setPlayers(currentPlayer, prevPlayer);
			
			if(gE.checkPlayerObjective(currentPlayer))
			{
				GameController.getGameController().nextState(false);
			}
			
		} else if (currentState == TurnState.attack) {
			nextState();
		} else if (currentState == TurnState.armyMovement) {
			nextState();
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
			break;
		default:
			break;
		}

		if (s != currentState)
			nextStateNotifier.setNextState(currentState.ordinal());
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public int getCurrentState() {
		return currentState.ordinal();
	}

	public void addObserver(IObserver o) {
		nextTurnNotifier.addObserver(o);
		nextStateNotifier.addObserver(o);
	}

}
