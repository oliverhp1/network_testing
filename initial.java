// source: javaworld

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.net.Socket;



public class initial {
	public static void main(String[] args){
		System.out.println("Hello, plz dear jeff");
		if (args.length < 2){
			System.out.println("Usage: initial <server> <path>");
			System.exit(0);
		}
		String server = args[0];
		String path = args[1];

		System.out.println("loading from URL " + server);

		try {
			// connect to server?!
			Socket socket = new Socket(server, 7777);
			PrintStream outputStream = new PrintStream(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// some http shit
			//outputStream.println("GET " + path + " HTTP/1.0");
			outputStream.println("please echo this");

			//String line = reader.readLine();
			//while (line != null){
			//	System.out.println(line);
			//	line = reader.readLine();
			//}

			// close streams
			reader.close();
			outputStream.close();
			
			// and close socket
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
