package pruefung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleClient {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String name;
	int result = 0;

	public void connect(String ipAddress, int Port, String name) {
		this.name = name;
		try {
			// First connection to server
			socket = new Socket(ipAddress, Port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			// Create thread to read incoming messages
			Runnable r = new Runnable() {
				@Override
				public void run() {
					// Read incoming messages
					while (true) {
						String incoming;
						try {
							incoming = in.readLine();
							System.out.println(incoming);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			};
			Thread t = new Thread(r);
			t.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(int number) {
		out.write(Integer.toString(number) + "\r\n");
		out.flush();
	}

	public static void main(String[] args) {
		SimpleClient sc = new SimpleClient();
		sc.connect("127.0.0.1", 5050, "one");
		sc.send(20);
		sc.send(100);
	}

}
