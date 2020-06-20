package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.TurnController;
import model.GameExecution;

@SuppressWarnings("serial")
public class FRGame extends JFrame{
	
	private final static Dimension MAP_SIZE = new Dimension(1024, 768);
	private final static Dimension LABEL_SIZE = new Dimension(300,100);
	private final static String NEXT_TURN_IMG_FILE_PATH = "src\\images\\war_btnProxJogada.png";
	
	private LBTurn turnLabel;
	
	public FRGame()
	{		
		super("WAR");
		
		TurnController tC = TurnController.getTurnController();
		GameExecution gE = GameExecution.getGameExecution();
		JPanel p = new PNMap(MAP_SIZE);
		
		getContentPane().add(p);
		
		//
		// 	Player turn:
		//
		turnLabel = new LBTurn();
		p.add(turnLabel);
		turnLabel.setBounds(MAP_SIZE.width/2 - LABEL_SIZE.width/2, 0, LABEL_SIZE.width, LABEL_SIZE.height);
		turnLabel.setPlayer(tC.getCurrentPlayer());
		tC.addObserver(turnLabel);
		
		//
		//	Territories Info:
		//
		for(int i = 0; i < gE.getTerritoryCount(); i++)
		{
			LBTerritory l = new LBTerritory();
			int[] center = gE.getTerritoryCenter(i);
			
			l.setTerritoryInfo(gE.getTerritoryName(i), gE.getTerritoryColorCode(i), gE.getTerritoryArmy(i));
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
				FRObjective f = new FRObjective();
				tC.addObserver(f);
			}
			
		});
		
		p.add(objB);
		Dimension objBSize = objB.getPreferredSize();
		objB.setBounds(408 - objBSize.width * 2, 682, objBSize.width * 2, objBSize.height * 2);
		
		//
		// Next Turn:
		//
		JButton nextTurn = new JButton(new ImageIcon(NEXT_TURN_IMG_FILE_PATH));
		nextTurn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				TurnController.getTurnController().nextTurn();
			}
			
		});
		
		p.add(nextTurn);
		Dimension nextTurnSize = nextTurn.getPreferredSize();
		nextTurn.setBounds(615, 682, nextTurnSize.width, nextTurnSize.height);
		nextTurn.setContentAreaFilled(false);
		nextTurn.setFocusPainted(false);
		
		pack();
		setResizable(false);
	}
}
