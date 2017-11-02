package chatLab.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import chatLab.messages.ChatMsg;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	public ObservableList<Client> clients = FXCollections.observableArrayList();
	
	private ServerSocket listener;
	private volatile boolean stop = false;
	private Logger logger = Logger.getLogger("");
	
	
	

	public void startServer(int port) {
		logger.info("Start server");
		
		try {
			listener = new ServerSocket(port, 10 ,null);
			Runnable r = new Runnable() {
				@Override
				public void run() {
					while(!stop) {
						try {
							Socket socket = listener.accept();
							Client client = new Client(Model.this, socket);
							System.out.println(client.toString());
							
							clients.add(client);
						} catch (Exception e) {
							logger.info(e.toString());
						}
					}
				}
			};
			Thread t = new Thread(r, "Server Socket");
			t.start();
			
		} catch (IOException e) {
			logger.info(e.toString());
		}
	}

	public void stopServer() {
		logger.info("Stop all clients");
		for(Client c : clients) {
			c.stop();
		}
		
		logger.info("Stop server");
		this.stop = true;
		if(listener != null) {
			try {
				listener.close();
			} catch(Exception e) {
				logger.info(e.toString());
			}
		}
	}

	public ObservableList<Client> getClientList() {
		logger.info("Get client list");
		return clients;
	}

	public void broadcast(ChatMsg msg) {
		for(Client c : clients) {
			c.send(msg);
		}
		
	}


}
