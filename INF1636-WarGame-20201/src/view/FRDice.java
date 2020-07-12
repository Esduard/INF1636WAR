package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import model.GameExecution;

@SuppressWarnings("serial")
class FRDice extends JFrame {

	private final static String DICE_IMG_PATH = "src\\images\\dado_";

	/**
	 * Creates a window to throw dices for attack and defense.
	 * 
	 * @param attacker
	 * @param defender
	 * @param src      - Attacker's territory
	 * @param target   - Defender's territory
	 */
	public FRDice(int src, int target) {
		super("Dices");

		JPanel p = new JPanel();
		JButton b = new JButton("Rolar dados");
		JLabel[] attackLabels = { new JLabel(), new JLabel(), new JLabel() };
		JLabel[] defenseLabels = { new JLabel(), new JLabel(), new JLabel() };
		GameExecution gE = GameExecution.getGameExecution();

		p.setLayout(new GridLayout(4, 3));

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				throwDices(src, target, gE.throwDices(src, false), gE.throwDices(target, true), attackLabels,
						defenseLabels);
			}
		});
		
		b.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.print("pp");
				if (e.getKeyCode() == KeyEvent.VK_K) {
					int[] attackDices = new int[gE.getDicesAmount(src, false)];
					int[] defenseDices = new int[gE.getDicesAmount(target, true)];
					for (int i = 0; i < attackDices.length; i++) {
						try {
							attackDices[i] = Integer.parseInt(JOptionPane.showInputDialog("Escolha um dado para o ataque"));
						} catch (NumberFormatException exc) {
							return;
						}
					}
					for (int i = 0; i < defenseDices.length; i++) {
						try {
							defenseDices[i] = Integer.parseInt(JOptionPane.showInputDialog("Escolha um dado para a defesa"));
						} catch (NumberFormatException exc) {
							return;
						}
					}
					
					throwDices(src, target, attackDices, defenseDices, attackLabels, defenseLabels);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		getContentPane().add(p);

		for (int i = 0; i < 3; i++) {
			p.add(attackLabels[i]);
			p.add(defenseLabels[i]);
		}
		p.add(b);

		pack();
		setResizable(false);
	}

	public void throwDices(int src, int target, int[] attackDices, int[] defenseDices, JLabel[] attackLabels,
			JLabel[] defenseLabels) {
		GameExecution gE = GameExecution.getGameExecution();

		if (gE.getTerritoryArmy(src) <= 1) {
			JOptionPane.showMessageDialog(null, "Tropas insuficientes");
			dispose();
			return;
		}

		for (int i = 0; i < attackDices.length; i++) {
			BufferedImage dice = null;
			try {
				dice = ImageIO.read(new File(DICE_IMG_PATH + "ataque_" + attackDices[i] + ".png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			attackLabels[i].setIcon(new ImageIcon(dice));
			System.out.print(attackDices[i]);
		}

		for (int i = 0; i < defenseDices.length; i++) {
			BufferedImage dice = null;
			try {
				dice = ImageIO.read(new File(DICE_IMG_PATH + "defesa_" + defenseDices[i] + ".png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			defenseLabels[i].setIcon(new ImageIcon(dice));
			System.out.print(defenseDices[i]);
		}

		int ret = gE.attack(src, target, attackDices, defenseDices);
		switch (ret) {
		case 0:
			JOptionPane.showMessageDialog(null, "Ataque invalido");
			dispose();
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Ataque realizado");
			dispose();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, gE.getTerritoryName(target) + " foi conquistad@.");
			dispose();
			break;
		}
	}
}
