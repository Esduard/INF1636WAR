package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.TurnController;
import model.GameExecution;
import savestate.SaveFile;
import savestate.WAR_IO;

import java.io.File;

@SuppressWarnings("serial")
public class FRGame extends JFrame {

	private final static Dimension MAP_SIZE = new Dimension(1024, 768);
	private final static Dimension PANEL_SIZE = new Dimension(1024, 100);
	private final static String NEXT_TURN_IMG_FILE_PATH = "src\\images\\war_btnProxJogada.png";
	private final static String SAVE_IMG_FILE_PATH = "src\\images\\Devices-media-floppy-icon.png";

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
							int army = 0;
							try {
								army = Integer.parseInt(JOptionPane
										.showInputDialog("Digite o numero de tropas que deseja posicionar em "
												+ gE.getTerritoryName(t) + ":", 1));
							} catch (NumberFormatException exc) {
								return;
							}
							gE.placeArmy(p, army, t);
							tC.nextState();
						}
						break;
					case 1: // Attack
						if (!gE.playerHasTerritory(p, t) && selectedTerritory == -1) {
							if (gE.playerCanAttackTerritory(p, t)) {
								int answer = JOptionPane.showConfirmDialog(null,
										"Deseja atacar " + gE.getTerritoryName(t) + "?", "Ataque",
										JOptionPane.YES_NO_OPTION);
								if (answer == 0)
									selectedTerritory = t;
							} else
								JOptionPane.showMessageDialog(null, "Você não pode atacar este territorio pois não possui um vizinho com tropas suficientes.");
						} else if (selectedTerritory > -1 && gE.playerHasTerritory(p, t)
								&& gE.isNeighbor(selectedTerritory, t)) {
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
						break;
					case 2: // Army movement
						if (gE.playerHasTerritory(p, t) && selectedTerritory == -1) {
							if (gE.playerHasNeighbour(p, t)) {
								int answer = JOptionPane.showConfirmDialog(null,
										"Deseja deslocar tropas para " + gE.getTerritoryName(t) + "?",
										"Deslocamento de Tropa", JOptionPane.YES_NO_OPTION);
								if (answer == 0)
									selectedTerritory = t;
							} else
								JOptionPane.showMessageDialog(null, "Você não possui algum territorio vizinho a este.");
						} else if (selectedTerritory > -1 && gE.playerHasTerritory(p, t)
								&& gE.isNeighbor(selectedTerritory, t)) {
							int army = 0;
							try {
								army = Integer.parseInt(JOptionPane.showInputDialog(
										"Digite o numero de tropas que deseja deslocar de " + gE.getTerritoryName(t)
												+ " para " + gE.getTerritoryName(selectedTerritory) + ":",
										1));
							} catch (NumberFormatException exc) {
								return;
							}
							if(!gE.movePlayerTroops(tC.getCurrentPlayer(), t, selectedTerritory, army))
								JOptionPane.showMessageDialog(null, "Quantidade de tropas invalidas");
							selectedTerritory = -1;
						}
						break;

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
		turnPanel.setBounds(0, -16, PANEL_SIZE.width, PANEL_SIZE.height);

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
		JButton objB = new JButton("Objetivo");
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
		// Show Cards:
		//
		JButton cardB = new JButton("Cartas");
		cardB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FRCard f = new FRCard();
				tC.addObserver(f);
			}

		});

		p.add(cardB);
		cardB.setBounds(208 - objBSize.width * 2, 682, objBSize.width * 2, objBSize.height * 2);

		//
		// Save Game
		//

		JButton saveB = new JButton(new ImageIcon(SAVE_IMG_FILE_PATH));
		JFileChooser saveFC = new JFileChooser("Salvar Jogo");
		;
		p.add(saveB);
		Dimension SaveBSize = saveB.getPreferredSize();
		saveB.setBounds(800, 682, SaveBSize.width, SaveBSize.height);

		saveB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int returnValue = saveFC.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = saveFC.getSelectedFile();
					System.out.print(selectedFile.getAbsolutePath());
					SaveFile s = new SaveFile();
					WAR_IO.SalvarJogo(selectedFile.getAbsolutePath(), s);
				}
			}

		});

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
