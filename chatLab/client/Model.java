package chatLab.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;

public class Model {
	
	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	private Logger logger = Logger.getLogger("");	
	private Socket client;
	
	
	public void connect(String ipAddress, int port, String name) {
		logger.info("Connect");
		try {
			client = new Socket(ipAddress, port);
			
		} catch (UnknownHostException e) {
			logger.warning(e.toString());
		} catch (IOException e) {
			logger.warning(e.toString());
		}
	}

	public void disconnect() {
		logger.info("Disconnect");
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.warning(e.toString());
		}
	}

	public void sendMessage(String message) {
		logger.info("Send message");
	}

	public String receiveMessage() {
		logger.info("Receive message");
		return newestMessage.get();
	}
}
