package view;

import javax.swing.JLabel;

import observer.IObserver;
import observer.Observable;

@SuppressWarnings("serial")
class LBTerritory extends JLabel implements IObserver {

	public LBTerritory()
	{
		super();
	}
	
	public void setTerritoryInfo(String name, String color, int army)
	{
		if(name == "Coreia Do Norte" || name == "Coreia Do Sul")
			setText("<html><center><font size=2 color="+ color +">"+ name + " " + army + "</font></html>");
		else {
			setText("<html><center><font size=2 color="+ color +">"+ name + "<br>" + army + "</font></html>");
		}
		repaint();
	}
	
	@Override
	public void update(Observable o) {
		setTerritoryInfo((String)o.get(0), (String)o.get(1), (int)o.get(2));
	}

}
