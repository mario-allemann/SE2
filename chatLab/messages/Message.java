package chatLab.messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Logger;

public class Message implements Serializable {
	private static Logger logger = Logger.getLogger("");
	protected MessageType type;

	public Message(MessageType type) {
		this.type = type;
	}

	public void send(Socket socket) {
		logger.info("Sending message");
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Message receive(Socket socket) {
		logger.info("Receiving message");
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			return (Message) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public MessageType getType() {
		return this.type;
	}

}
