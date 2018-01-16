package pruefung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

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
					while (!finished) {
						try {
							client = serverSocket.accept();
							System.out.println("Connection accepted");
							// Creates a new Thread which handles IO
							createThread(client);
						} catch (IOException e) {
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

	private void createThread(Socket socket) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(socket.getOutputStream());
					System.out.println("Waiting for messages...");
					while (true) {
						String msg = in.readLine();
						out.write(Integer.toString(Integer.parseInt(msg) * 2) + "\r\n");
						out.flush();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread t = new Thread(r);
		t.start();

	}

	public static void main(String[] args) {
		SimpleServer simpleServer = new SimpleServer();
		simpleServer.startServer(5050);

	}

}
