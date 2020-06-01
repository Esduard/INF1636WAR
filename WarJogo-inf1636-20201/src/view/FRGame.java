package view;

import java.awt.*;

import javax.swing.*;

public class FRGame extends JFrame{
	
	private final static Dimension DEFAULT_SIZE = new Dimension(1024, 768);
	private JLabel playerTurn;
	
	public FRGame()
	{
		playerTurn = new JLabel("Player 1");
		
		getContentPane().add(new PNMap(DEFAULT_SIZE));

		setSize(DEFAULT_SIZE.width, DEFAULT_SIZE.height + 30);
		setResizable(false);
		setVisible(true);
	}
	
}
