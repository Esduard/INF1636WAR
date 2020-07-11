package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				if (gE.getTerritoryArmy(src) <= 1) {
					JOptionPane.showMessageDialog(null, "Tropas insuficientes");
					dispose();
					return;
				}
				
				int[] attackDices = gE.throwDices(src, false);
				int[] defenseDices = gE.throwDices(target, true);

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
				switch(ret)
				{
				case 0:
					JOptionPane.showMessageDialog(null, "Ataque invalido");
					dispose();
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Ataque realizado");
					break;
				case 2:
					JOptionPane.showMessageDialog(null, gE.getTerritoryName(target) + " foi conquistad@.");
					dispose();
					break;
				}
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

}
