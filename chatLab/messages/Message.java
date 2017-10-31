package chatLab.messages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import com.sun.istack.internal.logging.Logger;

public class Message implements Serializable{
	private static Logger logger = Logger.getLogger("", null);
	protected MessageType type;
	
	public Message(MessageType type) {
		this.type = type;
	}
	
	public void send(Socket socket) {
		logger.info("Sending message");
		
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(this);
			out.flush();
			socket.shutdownOutput();
			
		} catch(Exception e) {
			logger.warning(e.toString());
		}
	}
	
	public static Message receive(Socket socket) {
		logger.info("Receiving Message");
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			return (Message) in.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.warning(e.toString());
		}
		return null;
	}
	
	public MessageType getType() {
		return this.type;
	}
	
}
