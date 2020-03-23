package gui;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Window extends JFrame {
	public static final long serialVersionUID = -2767113216806410931L;

	public Window(String title, int width, int height) {
		super(title);
		setResizable(false);
		getContentPane().setPreferredSize(new Dimension(width, height));
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
