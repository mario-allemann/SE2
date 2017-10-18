package webServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String ipAddress = "192.168.1.116";
			int port = 8080;
			Socket s = new Socket(ipAddress, port);
			
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			
			out.writeObject("helloworld");
			
			String serverMessage;
//			while((serverMessage = (String) in.readObject()) != null && serverMessage.length() != 0) {
//				System.out.println("Client");
//				System.out.println(serverMessage);
//			}
			
			
			
			//
			out.flush();
			s.close();
			in.close();
			
			// Set up the reader classes
			
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
