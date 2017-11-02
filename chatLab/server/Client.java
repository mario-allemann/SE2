package chatLab.server;

import java.io.IOException;
import java.net.Socket;

import chatLab.messages.ChatMsg;
import chatLab.messages.JoinMsg;
import chatLab.messages.Message;

public class Client  {
	private Socket socket;
	private String name;
	private Model model;
	
	public Client(Model model,Socket socket) {
		this.socket = socket;
		this.model = model;
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while(true) {
					Message msg = Message.receive(socket);
					if(msg instanceof ChatMsg) {
						System.out.println("In if");
						model.broadcast((ChatMsg) msg);
					} else if (msg instanceof JoinMsg) {
						Client.this.name = ((JoinMsg) msg).getName();
					}
				}
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
	}
	
	public void send(ChatMsg msg) {
		msg.send(socket);
	}
	
	public void stop() {
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return this.name + " : " + socket.toString();
	}

	
	
	
}
