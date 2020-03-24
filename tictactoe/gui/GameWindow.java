package gui;

import game.*;

import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.io.File;
import java.io.IOException;

public class GameWindow extends JPanel {
	public static final long serialVersionUID = -1463491557462486617L;
	
	public static final String RES_PATH = "/home/pi/Documents/network_testing/tictactoe/resources";
	public static final String WOLF_PATH = RES_PATH + "/wolf.jpg";
	public static final String LION_PATH = RES_PATH + "/lion.jpg";
	public static final int LINE_WIDTH = 10;

	private Game game;

	public GameWindow(Game game){
		this.game = game;
		addMouseListener(new Input());
	}

	@Override
	public void paint(Graphics g){
		BufferedImage wolf = null;
		BufferedImage lion = null;

		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(LINE_WIDTH));

		int x1 = Game.WIDTH / 3;
		int x2 = 2 * Game.WIDTH / 3;
		
		int y1 = Game.HEIGHT/ 3; 
		int y2 = 2 * Game.HEIGHT / 3;

		// vertical lines (constant x)
		g2D.drawLine(x1, 0, x1, Game.HEIGHT);
		g2D.drawLine(x2, 0, x2, Game.HEIGHT);

		// horizontal lines (constant y)
		g2D.drawLine(0, y1, Game.WIDTH, y1);
		g2D.drawLine(0, y2, Game.WIDTH, y2);

		// render beasts
		try {
			File plz = new File("fjdksljfkdlsjfkldsshit.plz");

			wolf = ImageIO.read(new File(WOLF_PATH)); 
			lion = ImageIO.read(new File(LION_PATH));
		}
		catch (IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		g2D.drawImage(lion, Game.WIDTH / 3 + LINE_WIDTH / 2, Game.HEIGHT / 3 + LINE_WIDTH / 2,
			      Game.WIDTH / 3 - LINE_WIDTH, Game.HEIGHT / 3 - LINE_WIDTH, null);

				
	}

	class Input extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1){
				game.inputReceived((3 * e.getX() / Game.WIDTH), (3 * e.getY() / Game.HEIGHT));
			}
		}
				
	}
}
