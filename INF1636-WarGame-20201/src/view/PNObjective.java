package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
class PNObjective extends JPanel{
	
	private final static Dimension DEFAULT_SIZE = new Dimension(380, 600);
	private final static String OBJECTIVE_IMG_FILE_PATH = "src\\images\\war_carta_objetivo_grande.png";
	private final static Rectangle labelRect = new Rectangle(25, 110, 306, 365);
	private Image objImg;
	
	public PNObjective(String objective)
	{
		JLabel l = new JLabel("<html><font size=5>" + objective + "</font></html>");
		
		setLayout(null);
		
		add(l);
		l.setBounds(labelRect);
		l.setVerticalAlignment(SwingConstants.TOP);
		
		try {
			objImg = ImageIO.read(new File(OBJECTIVE_IMG_FILE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		setPreferredSize(DEFAULT_SIZE);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(objImg, 0, 0, DEFAULT_SIZE.width, DEFAULT_SIZE.height, null);
	}
}
