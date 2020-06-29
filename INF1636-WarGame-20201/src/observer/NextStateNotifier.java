package observer;

import java.io.Serializable;

public class NextStateNotifier extends Observable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
