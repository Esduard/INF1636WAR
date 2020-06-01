package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.GameController;
import model.Model;

public class FRPlayerRegister extends JFrame {

	public FRPlayerRegister()
	{
		int pCount = Model.getPlayerCount();
		setLayout(null);
		
		Point pos = new Point(0,0);
		
		int width = 100;
		
		JTextField[] texts = new JTextField[pCount];
		JList[] lists = new JList[pCount];
		
		for(int i = 0; i < pCount; i++)
		{
			JLabel label = new JLabel("Jogador " + i);
			texts[i] = new JTextField("Nome", 16);
			lists[i] = new JList(Model.getColorNames().toArray());
			
			label.setBounds(pos.x, pos.y, width, width/2);
			pos.translate(width, 0);
			
			texts[i].setBounds(pos.x, pos.y, width, width/2);
			pos.translate(width, 0);
			
			lists[i].setBounds(pos.x, pos.y, width, width * 2);
			pos.translate(- 2 * width,  2 * width);
			
			getContentPane().add(label);
			getContentPane().add(texts[i]);
			getContentPane().add(lists[i]);
		}
		
		JButton b = new JButton("Iniciar Jogo");
		
		b.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String[] names = new String[pCount];
				String[] colors = new String[pCount];
				
				for(int i = 0; i < pCount; i++)
				{
					names[i] = texts[i].getText();
					if(lists[i].getSelectedValue() != null)
						colors[i] = lists[i].getSelectedValue().toString();
					else 
					{
						JOptionPane.showMessageDialog(null, "É necessário escolher uma cor para cada jogador.");
						return;
					}
				}
				
				boolean r  = Model.addPlayers(names, colors);
				
				if(!r)
					JOptionPane.showMessageDialog(null, "Jogadores inválidos. Não é permitido repetir cores.");
				else
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
		
		b.setBounds(pos.x + width, pos.y, width, width);
		
		getContentPane().add(b);
		
		setVisible(true);
		
		setResizable(false);
		
		setSize(width * pCount, width * pCount + 5 * width);
	}
	
}
