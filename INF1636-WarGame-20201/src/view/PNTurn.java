package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameExecution;
import observer.*;

class PNTurn extends JPanel implements IObserver{

	private GameExecution gE;
	private JLabel player;
	private JLabel state;
	
	private String currentPlayerColor;
	private String currentPlayerName;
	
	private static final String[] stateDescriptions = {
		"Posicione seus novos exércitos",
		"Clique sobre o territorio que deseja atacar, se não passe o turno",
		"Se desejar, movimente suas tropas, se não passe o turno",
		"Clique no baralho para receber suas cartas",
		"Quando estiver pronto passe o turno"
	};
	
	public PNTurn()
	{
		super();
		
		gE = GameExecution.getGameExecution();
		player = new JLabel();
		state = new JLabel();
		
		this.setLayout(new BorderLayout());
		
		this.add(player, BorderLayout.WEST);
		this.add(state, BorderLayout.EAST);
	}
	
	public void setPlayer(int i)
	{
		currentPlayerColor = gE.getPlayerColorCode(i);
		currentPlayerName = gE.getPlayerName(i);
		player.setText("<html><font size=6 color="+ currentPlayerColor +">"+ currentPlayerName + "</font></html>");
		player.repaint();
	}
	
	public void setState(int i)
	{
		state.setText("<html><font size=6 color="+ currentPlayerColor +">" + stateDescriptions[i] + "</font></html>");
		state.repaint();
	}
	
	public void setAvailableArmy(int i)
	{
		state.setText("<html><font size=6 color="+ currentPlayerColor +">" + "Faltam " + i + "</font></html>");
		state.repaint();
	}
	
	@Override
	public void update(Observable o)
	{
		if(o instanceof NextTurnNotifier) {
			int nextPlayer = (int)o.get(0);
			int prevPlayer = (int)o.get(1);
			setPlayer(nextPlayer);
			gE.addPlayerObserver(nextPlayer, this);
			gE.removePlayerObserver(prevPlayer, this);
		}
		else if(o instanceof NextStateNotifier) {
			int state = (int)o.get(0);
			setState(state);
		}
		else {
			setAvailableArmy((int)o.get(0));
		}
	}
}
