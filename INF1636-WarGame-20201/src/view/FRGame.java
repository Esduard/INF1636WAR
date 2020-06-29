package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.TurnController;
import model.GameExecution;

@SuppressWarnings("serial")
public class FRGame extends JFrame {

	private final static Dimension MAP_SIZE = new Dimension(1024, 768);
	private final static Dimension PANEL_SIZE = new Dimension(1024, 100);
	private final static String NEXT_TURN_IMG_FILE_PATH = "src\\images\\war_btnProxJogada.png";

	private PNTurn turnPanel;

	private int selectedTerritory = -1;

	public FRGame() {
		super("WAR");

		TurnController tC = TurnController.getTurnController();
		GameExecution gE = GameExecution.getGameExecution();
		JPanel p = new PNMap(MAP_SIZE);

		getContentPane().add(p);
		p.setLayout(null);

		p.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int t = gE.getTerritoryIndexByClick(e.getPoint());
				int p = tC.getCurrentPlayer();

				if (t >= 0) {
					switch (tC.getCurrentState()) {
					case 0: // Army Placement
						if (gE.playerHasTerritory(p, t)) {
							int army = Integer.parseInt(
									JOptionPane.showInputDialog("Digite o numero de tropas que deseja posicionar em "
											+ gE.getTerritoryName(t) + ":", 1));
							gE.placeArmy(p, army, t);
							tC.nextState();
						}
						break;
					case 1: // Attack
						if (!gE.playerHasTerritory(p, t) && selectedTerritory == -1) {
							if (gE.playerHasNeighbour(p, t)) {
								int answer = JOptionPane.showConfirmDialog(null,
										"Deseja atacar " + gE.getTerritoryName(t) + "?", "Ataque",
										JOptionPane.YES_NO_OPTION);
								if (answer == 0)
									selectedTerritory = t;
							} else
								JOptionPane.showMessageDialog(null, "Você não possui algum territorio vizinho a este.");
						} else if (selectedTerritory > -1 && gE.playerHasTerritory(p, t)
								&& gE.isNeighbour(selectedTerritory, t)) {
							int answer = JOptionPane
									.showConfirmDialog(null,
											"Deseja atacar " + gE.getTerritoryName(selectedTerritory) + " pel@ "
													+ gE.getTerritoryName(t) + "?",
											"Ataque", JOptionPane.YES_NO_OPTION);
							if (answer == 0) {
								if (gE.getTerritoryArmy(t) > 1) {
									JFrame f = new FRDice(t, selectedTerritory);
									f.setVisible(true);
									selectedTerritory = -1;
								} else
									JOptionPane.showMessageDialog(null, "Tropas insuficientes");
							}
						}
					}
				} else
					return;
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

		//
		// Player turn:
		//
		turnPanel = new PNTurn();
		turnPanel.setPlayer(tC.getCurrentPlayer());
		turnPanel.setState(tC.getCurrentState());
		tC.addObserver(turnPanel);
		gE.addPlayerObserver(tC.getCurrentPlayer(), turnPanel);

		p.add(turnPanel);
		turnPanel.setOpaque(false);
		turnPanel.setBounds(0, -32, PANEL_SIZE.width, PANEL_SIZE.height);

		//
		// Territories Info:
		//
		for (int i = 0; i < gE.getTerritoryCount(); i++) {
			LBTerritory l = new LBTerritory();
			int[] center = gE.getTerritoryCenter(i);

			l.setTerritoryInfo(gE.getTerritoryName(i), gE.getTerritoryColorCode(i), gE.getTerritoryArmy(i));
			p.add(l);
			l.setBounds(center[0] - 20, center[1] - 20, 100, 50);

			gE.addTerritoryObserver(i, l);
		}

		//
		// Show Objective:
		//
		JButton objB = new JButton("Objective");
		objB.addActionListener(new ActionListener() {

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
