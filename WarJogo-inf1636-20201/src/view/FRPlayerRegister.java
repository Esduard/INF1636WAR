package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.GameController;
import model.GameExecution;

public class FRPlayerRegister extends JFrame {

	public FRPlayerRegister()
	{
		GameExecution gE = GameExecution.getGameExecution();
		
		int pCount = gE.getPlayerCount();
		setLayout(null);
		
		Point pos = new Point(0,0);
		
		int width = 80;
		
		JTextField[] texts = new JTextField[pCount];
		JList[] lists = new JList[pCount];
		
		for(int i = 0; i < pCount; i++)
		{
			JLabel label = new JLabel("Jogador " + (i+1));
			DefaultListModel<String> m = new DefaultListModel<String>();
			
			m.addAll(gE.getColorNames());
			texts[i] = new JTextField("Nome", 16);
			lists[i] = new JList<String>(m);
			
			label.setBounds(pos.x, pos.y, width, width/2);
			pos.translate(width, 0);
			
			texts[i].setBounds(pos.x, pos.y, width, width/2);
			pos.translate(width, 0);
			
			lists[i].setBounds(pos.x, pos.y, width, width * 2);
			if((i+1) % 2 == 0)
				pos.translate(- 5 * width,  2 * width);
			else
				pos.translate(width, 0);
			
			getContentPane().add(label);
			getContentPane().add(texts[i]);
			getContentPane().add(lists[i]);
		}
		
		JButton b = new JButton("Iniciar Jogo");
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				
				boolean r  = gE.addPlayers(names, colors);
				
				if(!r)
					JOptionPane.showMessageDialog(null, "Jogadores inválidos. Não é permitido repetir cores.");
				else
					GameController.getGameController().nextState();
			}
		});
		
		b.setBounds(pos.x, pos.y, width * 2, width);
		
		getContentPane().add(b);
		
		setSize(width * 6, width * (pCount + 2));
		setResizable(false);
	}
	
}
