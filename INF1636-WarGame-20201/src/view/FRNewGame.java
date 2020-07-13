package view;

import javax.swing.*;


import controller.GameController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;

import savestate.WAR_IO;

@SuppressWarnings("serial")
public class FRNewGame extends JFrame{
	
	private final static String IMG_FILE_PATH = "src\\images\\bgconfiguracao.png";
	private final static String BUTTON_ICON_FILE_PATH = "src\\images\\botaoNovoJogo.png";
	
	public FRNewGame()
	{
		JPanel p = new JPanel();
		JLabel l = new JLabel(new ImageIcon(IMG_FILE_PATH));
		JButton b = new JButton( new ImageIcon(BUTTON_ICON_FILE_PATH));
		
		JButton bload = new JButton("Carregar Jogo");
		
		JFileChooser loadGame = new JFileChooser("Carregar Jogo");
		
		getContentPane().add(p);
		p.setLayout(null);
		
		b.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						GameController.getGameController().nextState(false);
					}
				});
		
		bload.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnValue = loadGame.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = loadGame.getSelectedFile();
					WAR_IO.CarregarJogo(selectedFile);
					GameController.getGameController().nextState(true);
				}
            }
		});
		
		
		
		Dimension lSize = l.getPreferredSize();
		p.setPreferredSize(lSize);
		
		p.add(l);
		p.add(b);
		p.add(bload);
		p.add(loadGame);
		
		b.setBounds(16, 50, 191, 50);
		bload.setBounds(16, 110, 191, 50);
		
		l.setBounds(0,0, lSize.width, lSize.height);
		
		pack();
		setResizable(false);
		setVisible(true);
	}
}
