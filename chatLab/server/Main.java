package chatLab.server;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ChatLab Server");
		Model model = new Model();
		View view = new View(primaryStage, model);
		Controller controller = new Controller(model, view);
		primaryStage.show();
	}
}