package observer;

public class NextTurnNotifier extends Observable {
	
	private int nextPlayer;
	
	public void setNextPlayer(int i)
	{
		nextPlayer = i;
		
		notifyObservers();
	}

	@Override
	public Object get(int i) {
		
		switch(i)
		{
		case 0:
			return nextPlayer;
		}
		
		return null;
	}
}
