package chatLab.messages;

import java.net.Socket;
import com.sun.istack.internal.logging.Logger;

public class Message {
	private static Logger logger = Logger.getLogger("", null);
	protected MessageType type;
	
	public Message(MessageType type) {
		this.type = type;
	}
	
	public void send(Socket socket) {
		logger.info("Sending message");
	}
	
	public static Message receive(Socket socket) {
		logger.info("Receiving Message");
		return null;
	}
	
	public MessageType getType() {
		return this.type;
	}
	
}
