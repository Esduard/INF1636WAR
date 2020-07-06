package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.TurnController;
import model.GameExecution;
import observer.*;

@SuppressWarnings("serial")
class PNTurn extends JPanel implements IObserver{

	private GameExecution gE;
	private JLabel player;
	private JLabel state;
	private JLabel availableArmy;
	
	private String currentPlayerColor;
	private String currentPlayerName;
	
	private static final String[] stateDescriptions = {
		"Posicione seus novos exércitos",
		"Clique sobre o territorio que deseja atacar, se não passe o turno",
		"Se desejar, movimente suas tropas, se não passe o turno",
		"Clique no botao cartas para visualizar suas cartas",
		"Quando estiver pronto passe o turno"
	};
	
	public PNTurn()
	{
		super();
		
		gE = GameExecution.getGameExecution();
		player = new JLabel();
		state = new JLabel();
		availableArmy = new JLabel();
		
		this.setLayout(new BorderLayout());
		
		this.add(player, BorderLayout.EAST);
		this.add(state, BorderLayout.WEST);
		this.add(availableArmy, BorderLayout.SOUTH);
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
		
		if(i == 0)
		{
			setAvailableArmy(gE.getPlayerAvailableArmy(TurnController.getTurnController().getCurrentPlayer()));
		}
	}
	
	public void setAvailableArmy(int i)
	{
		if(i == 0)
		{
			availableArmy.setText(" ");
		}
		else
		{
			availableArmy.setText("<html><font size=6 color="+ currentPlayerColor +">" + "Faltam " + i + "</font></html>");
			availableArmy.repaint();
		}
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
