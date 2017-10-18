package clientServerPhilip;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		int port = 1111;
		Server server = new Server();
		server.serveContent(port);
		Client client1 = new Client();
		client1.serveContent(port);
		Client client2 = new Client();
		client2.serveContent(port);
	}
}
