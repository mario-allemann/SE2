package clientServerPhilip;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.concurrent.Task;

public class Server {
	private int port;

	final Task<Void> serverTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			try {
				// Create serversocket resource
				ServerSocket serverSocket = new ServerSocket(port, 10, null);

				// --- Client 1
				Socket clientSocket1 = serverSocket.accept();
				ObjectOutputStream out1 = new ObjectOutputStream(clientSocket1.getOutputStream());
				ObjectInputStream in1 = new ObjectInputStream(clientSocket1.getInputStream());

				// Receive message
				String client1Msg;
				while ((client1Msg = (String) in1.readObject()) != null && client1Msg.length() != 0) {
					System.out.println("Server -> Nachricht vom Client1: " + client1Msg);
				}

				// Send message
				out1.writeObject("clientConnected");
				out1.writeObject("clientWait");

				// --- Client 2
				Socket clientSocket2 = serverSocket.accept();
				ObjectOutputStream out2 = new ObjectOutputStream(clientSocket2.getOutputStream());
				ObjectInputStream in2 = new ObjectInputStream(clientSocket2.getInputStream());

				// Receive message
				String client2Msg;
				while ((client2Msg = (String) in2.readObject()) != null && client2Msg.length() != 0) {
					System.out.println("Server -> Nachricht vom Client2: " + client2Msg);
				}

				// Send message
				out2.writeObject("clientConnected");
				out2.writeObject("startGame");
				out2.writeObject("");

				out1.writeObject("startGame");
				out1.writeObject("");

				// Close resource streams
				out1.flush();
				out1.close();
				in1.close();
				out2.flush();
				out2.close();
				in2.close();
				clientSocket1.close();
				clientSocket2.close();
				serverSocket.close();
			} catch (Exception e) {
				System.err.println(e);
			}
			return null;
		}
	};
	
	public void serveContent(int port) {
		 this.port = port;
		 new Thread(serverTask).start();
	}
}
