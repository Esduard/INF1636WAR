package observer;

public class NextStateNotifier extends Observable {

	private int nextState;
	
	public void setNextState(int i)
	{
		nextState = i;
		
		notifyObservers();
	}
	
	@Override
	public Object get(int i) {
		
		switch(i)
		{
		case 0:
			return nextState;
		}
		
		return null;
	}

}
