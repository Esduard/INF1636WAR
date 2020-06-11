package view;

import java.awt.*;

import javax.swing.*;

class FRGame extends JFrame{
	
	private final static Dimension MAP_SIZE = new Dimension(1024, 768);
	private final static Dimension LABEL_SIZE = new Dimension(20,20);
	private JLabel playerTurn;
	
	public FRGame()
	{
		playerTurn = new JLabel("Turno do Player 1", SwingConstants.CENTER);
		playerTurn.setSize(LABEL_SIZE);
		
		setLayout(new BorderLayout());
		
		getContentPane().add(new PNMap(MAP_SIZE), BorderLayout.CENTER);
		getContentPane().add(playerTurn, BorderLayout.NORTH);
		
		setSize(MAP_SIZE.width + LABEL_SIZE.width, MAP_SIZE.height + LABEL_SIZE.height + 30);
		setResizable(false);
	}
	
	
}
