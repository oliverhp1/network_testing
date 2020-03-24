package game;

import gui.*;

public abstract class Game {
	public static final int WIDTH = 600, HEIGHT = 600; 
	public static final int PORT = 7777;

	private int[][] fields;
	
	public static final int FREE = 0, PLAYER_ONE = 1, PLAYER_TWO = 2;

	private Window window; 
	private GameWindow gameWindow; 
	public Game() {
		window = new Window(this, "TicTacToe plz", WIDTH, HEIGHT);
		gameWindow = new GameWindow(this);
		fields = new int[3][3];

		window.add(gameWindow);
	}	

	public abstract void inputReceived(int x, int y);
	public abstract void packetReceived(Object object);

	public abstract void close();

}
