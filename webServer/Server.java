package webServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.concurrent.Task;

public class Server {
	int port = 8080;

	final Task<Void> serverTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			try {
				ServerSocket listener = new ServerSocket(port, 10, null);

				while (true) {
					Socket client = listener.accept();
					System.out.println("Request from client" + client.getInetAddress().toString() + "for server"
							+ client.getLocalAddress().toString());

					BufferedReader inClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
					PrintWriter outClient = new PrintWriter(client.getOutputStream());
					// Send our reply using HTTP 1.0 - we could also use the "write" method
					outClient.print("HTTP/1.0 200 \n"); // Version and status
					outClient.print("Content-Type: text/plain\n");
					outClient.print("\n");

					// Read request from client and send it straight back
					// An empty string (length 0) is the end of an HTTP request
					StringBuilder received = new StringBuilder();
					String inString;
					while ((inString = inClient.readLine()) != null && inString.length() != 0) {
						received.append(inString + "\n");
					}
					String outString = received.toString();
					outClient.print(outString);

					System.out.println("Request contents:\n" + outString);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	};

	/**
	 * Called by the controller, to start the task, to serve web content
	 */
	public void serveContent(Integer port) {
		this.port = port;
		new Thread(serverTask).start();
	}

	public static void main(String[] args) {
		Server webServer = new Server();
		webServer.serveContent(webServer.port);
	}
}
