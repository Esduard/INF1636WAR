package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.TurnController;
import model.GameExecution;

public class FRGame extends JFrame{
	
	private final static Dimension MAP_SIZE = new Dimension(1024, 768);
	private final static Dimension LABEL_SIZE = new Dimension(300,100);
	
	private GameExecution gE;
	
	private JLabel playerTurn;
	private ArrayList<String> playerNames = new ArrayList<String>();
	private ArrayList<String> playerColors = new ArrayList<String>();
	
	private ArrayList<JLabel> territoriesInfo = new ArrayList<JLabel>();
	
	private JFrame objFrame;
	
	public FRGame()
	{		
		super("WAR");
		
		gE = GameExecution.getGameExecution();
		JPanel p = new PNMap(MAP_SIZE);
		
		getContentPane().add(p);
		
		//
		// 	Player turn:
		//
		playerTurn = new JLabel();
		p.add(playerTurn);
		playerTurn.setBounds(MAP_SIZE.width/2 - LABEL_SIZE.width/2, 0, LABEL_SIZE.width, LABEL_SIZE.height);
		
		for(int i = 0; i < gE.getPlayerCount(); i++)
		{
			playerNames.add(gE.getPlayerName(i));
			playerColors.add(gE.getPlayerColorCode(i));
		}
	
		setTurnLabel(TurnController.getPlayerController().getCurrentPlayer());
		
		//
		//	Territories Info:
		//
		for(int i = 0; i < gE.getTerritoryCount(); i++)
		{
			JLabel l = new JLabel();
			int[] center = gE.getTerritoryCenter(i);
			
			territoriesInfo.add(l);
			setTerritoryLabel(i, gE.getTerritoryName(i), gE.getTerritoryColorCode(i), gE.getTerritoryArmy(i));
			p.add(l);
			l.setBounds(center[0], center[1], 100, 50);
		}
		
		//
		// Show Objective:
		//
		JButton objB = new JButton("Objective");
		objB.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showObjective();
			}
			
		});
		
		p.add(objB);
		Dimension objBSize = objB.getPreferredSize();
		objB.setBounds(0, MAP_SIZE.height - objBSize.height * 2, objBSize.width * 2, objBSize.height * 2);
		
		pack();
		setResizable(false);
	}
	
	public void setTurnLabel(int i)
	{
		playerTurn.setText("<html><font size=18 color="+ playerColors.get(i) +">Turno do "+ playerNames.get(i) + "</font></html>");
		repaint();
	}
	
	public void setTerritoryLabel(int i, String name, String color, int army)
	{
		territoriesInfo.get(i).setText("<html><center><font size=4 color="+ color +">"+ name + "<br>" 
										+ army + "</font></html>");
		repaint();
	}
	
	private void showObjective()
	{
		if(objFrame != null)
			objFrame.dispose();
		
		int i = TurnController.getPlayerController().getCurrentPlayer();
		objFrame = new JFrame();
		JPanel p = new PNObjective(gE.getPlayerObjective(i));

		objFrame.getContentPane().add(p);
		objFrame.pack();
		objFrame.setResizable(false);
		objFrame.setVisible(true);
	}
}
