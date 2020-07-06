package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class PNMap extends JPanel {
	
	private final static String MAP_IMG_FILE_PATH = "src\\images\\war_tabuleiro_mapa.png";
	private final static String BG_IMG_FILE_PATH = "src\\images\\war_tabuleiro_fundo.png";
	
	private Dimension size;
	private Image mapImg;
	private Image bgImg;
	
	public PNMap(Dimension size)
	{
		super(null);
		
		setPreferredSize(size);
		this.size = size;
		
		try {
			mapImg = ImageIO.read(new File(MAP_IMG_FILE_PATH)).getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try {
			bgImg = ImageIO.read(new File(BG_IMG_FILE_PATH)).getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(bgImg, 0, 0, size.width, size.height, null);
		g.drawImage(mapImg, 0, 0, size.width, size.height, null);
	}
	
}
