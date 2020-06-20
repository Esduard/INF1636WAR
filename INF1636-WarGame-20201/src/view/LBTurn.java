package view;

import java.util.ArrayList;

import javax.swing.JLabel;

import model.GameExecution;
import observer.*;

class LBTurn extends JLabel implements IObserver{

	private ArrayList<String> playerNames = new ArrayList<String>();
	private ArrayList<String> playerColors = new ArrayList<String>();
	
	public LBTurn()
	{
		super();
		
		GameExecution gE = GameExecution.getGameExecution();
		
		System.out.print(gE.getPlayerCount());
		
		for(int i = 0; i < gE.getPlayerCount(); i++)
		{
			playerNames.add(gE.getPlayerName(i));
			playerColors.add(gE.getPlayerColorCode(i));
		}
	}
	
	public void setPlayer(int i)
	{
		setText("<html><font size=8 color="+ playerColors.get(i) +">Turno do "+ playerNames.get(i) + "</font></html>");
		repaint();
	}
	
	@Override
	public void update(Observable o)
	{
		setPlayer((int)o.get(0));
	}
}
