package observer;

public class NextTurnNotifier extends Observable {
	
	private int nextPlayer;
	private int prevPlayer;
	
	public void setPlayers(int next, int prev)
	{
		nextPlayer = next;
		prevPlayer = prev;
		
		notifyObservers();
	}

	@Override
	public Object get(int i) {
		
		switch(i)
		{
		case 0:
			return nextPlayer;
		case 1:
			return prevPlayer;
		}
		
		return null;
	}
}
