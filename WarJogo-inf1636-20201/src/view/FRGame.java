package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.PlayerController;
import model.GameExecution;

public class FRGame extends JFrame{
	
	private final static Dimension MAP_SIZE = new Dimension(1024, 768);
	private final static Dimension LABEL_SIZE = new Dimension(20,20);
	
	private JLabel playerTurn;
	private ArrayList<String> playerNames = new ArrayList<String>();
	private ArrayList<String> playerColors = new ArrayList<String>();
	
	public FRGame()
	{		
		GameExecution gE = GameExecution.getGameExecution();
		
		playerTurn = new JLabel();
		playerTurn.setSize(LABEL_SIZE);
		
		for(int i = 0; i < gE.getPlayerCount(); i++)
		{
			playerNames.add(gE.getPlayerName(i));
			playerColors.add(gE.getPlayerColorCode(i));
		}
		
		setTurnLabel(PlayerController.getPlayerController().getCurrentPlayer());
		
		setLayout(new BorderLayout());
		
		setContentPane(new PNMap(MAP_SIZE));
		getContentPane().add(playerTurn, BorderLayout.NORTH);
		
		setSize(MAP_SIZE.width, MAP_SIZE.height + 30);
		setResizable(false);
	}
	
	public void setTurnLabel(int i)
	{
		playerTurn.setText("<html><center><font size=18 color="+ playerColors.get(i) +">Turno do "+ playerNames.get(i) + "</font></html>");
		repaint();
	}
}
