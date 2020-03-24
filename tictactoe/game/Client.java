package game;

import java.net.*;
import java.io.*;

public class Client extends Game {

	private Socket socket;
	private Connection connection;


	@Override
	public void inputReceived(int x, int y){
		try {
			socket = new Socket("localhost", Game.PORT);
			connection = new Connection(this, socket);
		}
		catch (IOException e){
			e.printStackTrace();
		}

	}

	@Override
	public void packetReceived(Object object){
	
	}

	@Override
	public void close(){
		try {
			connection.close();
			socket.close();

		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
