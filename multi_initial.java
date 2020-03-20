// TO RUN: RUN THIS MAIN, THEN USE `telnet localhost <port #>`


// source: still javaworld

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class multi_initial extends Thread {
	private ServerSocket serverSocket;
	private int port;
	private boolean running = false;

	public multi_initial(int port){
		this.port = port;
	}

	public void startServer(){
		try {
			this.serverSocket = new ServerSocket(port);
			this.start();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public void stopServer(){
		running = false;
		this.interrupt();
	}

	@Override
	public void run(){
		running = true;
		while (running){
			try {
				System.out.println("listening for a connection...");
		
				// call accept() to receive a connection
				Socket socket = serverSocket.accept();

				// pass socket to requesthandler (thread)
				RequestHandler requestHandler = new RequestHandler(socket);
				requestHandler.start();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args){
		if (args.length == 0){
			System.out.println("Usage: multi_initial <port>");
			System.exit(0);
		}
		int port = Integer.parseInt(args[0]);
		System.out.println("Start server on port: " + port);
		
		// initialize server
		multi_initial server = new multi_initial(port);
		server.startServer();

		// shut down automatically in 1 min
		try {
			Thread.sleep(60000);	// guess these are ms
		}
		catch (Exception e){
			e.printStackTrace();
		}

		server.stopServer();
	}
}



class RequestHandler extends Thread {
	private Socket socket;

	RequestHandler(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Received a connection...");
			
			// get input and output streams
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			// write out header to the client
			out.println("plz server 1.0");
			out.flush();

			// *** echo lines back to client until client closes connection or inputs empty line
			String line = in.readLine();
			while ((line != null) && (line.length() > 0)){
				out.println("Echo: " + line);
				out.flush();
				line = in.readLine();
			}

			// close everything
			in.close();
			out.close();
			socket.close(); 

			System.out.println("connection closed.");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}




