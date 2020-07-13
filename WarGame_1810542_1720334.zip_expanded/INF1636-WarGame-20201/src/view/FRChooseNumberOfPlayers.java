package view;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.GameController;
import model.*;

public class FRChooseNumberOfPlayers extends JFrame{

	public FRChooseNumberOfPlayers()
	{
		setLayout(new FlowLayout());
		
		JLabel l = new JLabel("Número de jogadores: ");
		JTextField t = new JTextField(1);
		
		t.addKeyListener(new KeyListener()
			{
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					int numberOfPlayers = 0;
					
					try {
						numberOfPlayers = Integer.parseInt(t.getText());
					}catch (Exception exc){
						JOptionPane.showMessageDialog(null, "Digite um número.");
						return;
					}
					
					boolean r = GameExecution.getGameExecution().createPlayerList(numberOfPlayers);
					
					if(!r)
						JOptionPane.showMessageDialog(null, "Número inválido de jogadores. Escolha um número de 3 a 6.");
					else
						GameController.getGameController().nextState(false);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			});
		
		getContentPane().add(l);
		getContentPane().add(t);
		
		setSize(200,100);
		setResizable(false);
	}
}
