package clientServerPhilip;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ClientWindow extends Application{
	public TextArea textArea;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(500);
		textArea = new TextArea();
		Scene scene = new Scene(textArea);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
