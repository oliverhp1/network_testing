package game;

import java.net.*;
import java.io.*;

public class Server extends Game {

	private ServerSocket serverSocket;
	private Socket socket;

	private Connection connection;

	public Server() {
		try {
			serverSocket = new ServerSocket(Game.PORT);
			socket = serverSocket.accept();
			connection = new Connection(this, socket);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void inputReceived(int x, int y){
		System.out.println(x + " " + y);
	}
	
	@Override
	public void packetReceived(Object object){

	}

	@Override
	public void close() {
		try {
			connection.close();
			serverSocket.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}

