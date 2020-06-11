package view;

import javax.swing.*;

import controller.GameController;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class FRNewGame extends JFrame{
	
	private final static String IMG_FILE_PATH = "src\\images\\bgconfiguracao.png";
	private final static String BUTTON_ICON_FILE_PATH = "src\\images\\botaoNovoJogo.png";
	
	public FRNewGame()
	{
		setLayout(null);
		
		JLabel l = new JLabel(new ImageIcon(IMG_FILE_PATH));
		
		JButton b = new JButton( new ImageIcon(BUTTON_ICON_FILE_PATH));
		b.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent e) {
						GameController.getGameController().nextState();
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
			
				});
		
		
		Dimension size = new Dimension(l.getIcon().getIconWidth(), l.getIcon().getIconHeight());
		
		b.setBounds(16, 50, 191, 50);
		
		l.setBounds(0, 0, size.width, size.height);
		
		getContentPane().add(l);
		
		getContentPane().add(b);
		
		setResizable(false);
		setSize(size.width, size.height + 30);
		setVisible(true);
	}
}
