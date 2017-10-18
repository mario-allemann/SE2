package clientServerPhilip;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.concurrent.Task;
import javafx.stage.Stage;

public class Client {
	private int port;
	private String ipAddress;
	private StringBuffer messageLog;

	/*
	 * public Client(int port) throws Exception { // Display window clientWindow
	 * = new ClientWindow(); clientWindow.start(new Stage()); messageLog = new
	 * StringBuffer();
	 * 
	 * this.port = port; this.ipAddress = "localhost"; }
	 */

	final Task<Void> serverTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			try {
				// Display window
				messageLog = new StringBuffer();
				// Set up resources
				Socket socket = new Socket(ipAddress, port);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

				// Send message
				out.writeObject("test client");
				out.writeObject("");

				// Receive message
				String serverMsg;
				while ((serverMsg = (String) in.readObject()) != null && serverMsg.length() != 0) {
					switch (serverMsg) {
					case "startGame":
						messageLog.append("Starting game...\r\n");
						System.out.println("Starting game...");
						break;
					case "clientConnected":
						messageLog.append("Connected to server.\r\n");
						System.out.println("Connected to server.");
						break;
					case "clientWait":
						messageLog.append("Please wait for other clients to join...\r\n");
						System.out.println("Please wait for other clients to join...");
						break;
					default:
						messageLog.append("Client -> Message from server: " + serverMsg + "\r\n");
						System.out.println("Client -> Message from server: " + serverMsg);
					}
					System.out.println(messageLog.toString());
				}

				// Close resource streams
				out.flush();
				out.close();
				in.close();
				socket.close();
			} catch (Exception e) {
				System.err.println(e);
			}
			return null;
		}
	};

	public void serveContent(Integer port) {
		this.port = port;
		this.ipAddress = "localhost";
		new Thread(serverTask).start();
	}

	/*
	 * @Override public void run() { try { // Set up resources Socket socket =
	 * new Socket(ipAddress, port); ObjectOutputStream out = new
	 * ObjectOutputStream(socket.getOutputStream()); ObjectInputStream in = new
	 * ObjectInputStream(socket.getInputStream());
	 * 
	 * // Send message out.writeObject("test client"); out.writeObject("");
	 * 
	 * // Receive message String serverMsg; while ((serverMsg = (String)
	 * in.readObject()) != null && serverMsg.length() != 0) { switch (serverMsg)
	 * { case "startGame": messageLog.append("Starting game...\r\n");
	 * System.out.println("Starting game..."); break; case "clientConnected":
	 * messageLog.append("Connected to server.\r\n");
	 * System.out.println("Connected to server."); break; case "clientWait":
	 * messageLog.append("Please wait for other clients to join...\r\n");
	 * System.out.println("Please wait for other clients to join..."); break;
	 * default: messageLog.append("Client -> Message from server: " + serverMsg
	 * + "\r\n"); System.out.println("Client -> Message from server: " +
	 * serverMsg); } clientWindow.textArea.setText(messageLog.toString()); }
	 * 
	 * // Close resource streams out.flush(); out.close(); in.close();
	 * socket.close(); } catch (Exception e) { System.out.println(e.toString());
	 * } }
	 */
}
