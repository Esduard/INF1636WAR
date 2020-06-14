package view;

import javax.swing.*;

import controller.GameController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FRNewGame extends JFrame{
	
	private final static String IMG_FILE_PATH = "src\\images\\bgconfiguracao.png";
	private final static String BUTTON_ICON_FILE_PATH = "src\\images\\botaoNovoJogo.png";
	
	public FRNewGame()
	{
		JPanel p = new JPanel();
		JLabel l = new JLabel(new ImageIcon(IMG_FILE_PATH));
		JButton b = new JButton( new ImageIcon(BUTTON_ICON_FILE_PATH));
		
		getContentPane().add(p);
		p.setLayout(null);
		
		b.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						GameController.getGameController().nextState();
					}
				});
		
		
		
		Dimension lSize = l.getPreferredSize();
		p.setPreferredSize(lSize);
		
		p.add(l);
		p.add(b);
		
		b.setBounds(16, 50, 191, 50);
		l.setBounds(0,0, lSize.width, lSize.height);
		
		pack();
		setResizable(false);
		setVisible(true);
	}
}
