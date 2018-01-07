package pruefung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer{
	
	private ServerSocket serverSocket;
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private volatile boolean finished = false;
	
	public void startServer(int port) {
		try {
			serverSocket = new ServerSocket(port, 10, null);
			
			Runnable r = new Runnable() {
				@Override
				public void run() {
					while(!finished) {
						try {
							System.out.println("Waiting for client");
							client = serverSocket.accept();
							System.out.println("Got message");
							receive();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			};
			
			Thread t = new Thread(r);
			t.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void receive() {
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String original = in.readLine();
			int originalInt = Integer.parseInt(original);
			this.send(originalInt*2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void send(int result) {
		try {
			this.out = new PrintWriter(client.getOutputStream());
			out.write(Integer.toString(result));
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		SimpleServer simpleServer = new SimpleServer();
		simpleServer.startServer(5050);

	}

}
