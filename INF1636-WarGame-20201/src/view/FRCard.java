package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.TurnController;
import model.GameExecution;
import observer.IObserver;
import observer.Observable;

@SuppressWarnings("serial")
class FRCard extends JFrame implements IObserver {

	private static Dimension CARD_IMG_SIZE = new Dimension(132, 218);

	public FRCard() {
		super("Cartas");

		GameExecution gE = GameExecution.getGameExecution();
		TurnController tC = TurnController.getTurnController();
		List<String> cardNames = gE.getPlayerCardNameList(tC.getCurrentPlayer());

		JLabel cardLabel = new JLabel();
		DefaultListModel<String> m = new DefaultListModel<String>();
		m.addAll(cardNames);
		JList<String> l = new JList<String>(m);
		l.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		l.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				String s = l.getSelectedValue();
				
				System.out.print(gE.getCardImgFilePath(s));
				
				if(s != null)
					cardLabel.setIcon(new ImageIcon(gE.getCardImgFilePath(s)));
			}
		});

		JButton tradeBtn = new JButton("Trocar cartas");
		tradeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (l.getSelectedIndices().length < 3)
					JOptionPane.showMessageDialog(null,
							"E necessario selecionar no minimo 3 cartas para realizar uma troca");
				else {
					if (gE.tradeCards(tC.getCurrentPlayer(), l.getSelectedValuesList()))
						JOptionPane.showMessageDialog(null, "Troca realizada");
					else
						JOptionPane.showMessageDialog(null, "Troca falhou");
				}
			}

		});

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(cardLabel, BorderLayout.CENTER);
		getContentPane().add(l, BorderLayout.EAST);
		getContentPane().add(tradeBtn, BorderLayout.SOUTH);
		getContentPane().setPreferredSize(new Dimension(CARD_IMG_SIZE.width + l.getPreferredSize().width,
				CARD_IMG_SIZE.height + tradeBtn.getPreferredSize().height));

		pack();
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void update(Observable o) {
			dispose();
	}
}
