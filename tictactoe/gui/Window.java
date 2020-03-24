package gui;

import game.*;

import javax.swing.JFrame;
import java.awt.Dimension;

import java.awt.event.*;

public class Window extends JFrame {
	public static final long serialVersionUID = -2767113216806410931L;
	
	private Game game;

	public Window(Game game, String title, int width, int height) {
		super(title);
		this.game = game;
		setResizable(false);
		getContentPane().setPreferredSize(new Dimension(width, height));
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addWindowListener(new Listener());
		setVisible(true);
	}
	
	class Listener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			game.close();
		}
		
	}	
}
