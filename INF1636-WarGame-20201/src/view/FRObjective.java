package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.TurnController;
import model.GameExecution;
import observer.IObserver;
import observer.Observable;

@SuppressWarnings("serial")
class FRObjective extends JFrame implements IObserver{
	
	public FRObjective()
	{
		super();
		
		int i = TurnController.getTurnController().getCurrentPlayer();
		JPanel p = new PNObjective(GameExecution.getGameExecution().getPlayerObjective(i));

		getContentPane().add(p);
		pack();
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void update(Observable o) {
		dispose();
	}
}
