package game;

import gui.*;

public class Game {
	public static final int WIDTH = 600, HEIGHT = 600; 

	private int[][] fields;
	
	public static final int FREE = 0, PLAYER_ONE = 1, PLAYER_TWO = 2;

	private Window window; 
	private GameWindow gameWindow; 
	public Game() {
		window = new Window("TicTacToe plz", WIDTH, HEIGHT);
		gameWindow = new GameWindow();
		fields = new int[3][3];

		window.add(gameWindow);
	}
}
