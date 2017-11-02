package chatLab.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import chatLab.messages.ChatMsg;
import chatLab.messages.JoinMsg;
import chatLab.messages.Message;
import javafx.beans.property.SimpleStringProperty;

public class Model {

	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	private Logger logger = Logger.getLogger("");
	private Socket socket;
	private String name;

	public void connect(String ipAddress, int port, String name) {
		this.name = name;

		logger.info("Connect to " + ipAddress + ":" + port + "with name: " + name);

		try {
			socket = new Socket(ipAddress, port);

			Runnable r = new Runnable() {
				@Override
				public void run() {
					while (true) {
						ChatMsg msg = (ChatMsg) Message.receive(socket);
						newestMessage.set(msg.getName() + ": " + msg.getContent());
					}
				}
			};

			Thread t = new Thread(r);
			t.start();

			// Send JoinMsg to server
			logger.info("nameVar: " + name);
			Message msg = new JoinMsg(name);
			msg.send(socket);

		} catch (UnknownHostException e) {
			logger.warning(e.toString());
		} catch (IOException e) {
			logger.warning(e.toString());
		}
	}

	public void disconnect() {
		logger.info("Disconnect");
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.warning(e.toString());
		}
	}

	public void sendMessage(String message) {
		logger.info("Send message");
		Message msg = new ChatMsg(name, message);
		msg.send(socket);
	}

	public String receiveMessage() {
		logger.info("Receive message");
		return newestMessage.get();
	}
}
