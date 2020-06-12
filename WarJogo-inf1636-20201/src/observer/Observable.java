package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	
    private List<IObserver> observers = new ArrayList<IObserver>();
 
    public abstract Object get(int i);
    
    public void addObserver(IObserver o) {
        observers.add(o);
    }
 
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }
 
    public void notifyObservers()
    {
    	for(IObserver observer:observers)
    	{
    		observer.update(this);
    	}
    }
}
