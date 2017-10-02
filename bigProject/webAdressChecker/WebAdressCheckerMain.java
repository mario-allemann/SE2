package bigProject.webAdressChecker;

import javafx.application.Application;
import javafx.stage.Stage;

public class WebAdressCheckerMain extends Application {
	private WebAdressView view;
	private WebAdressController controller;
	private WebAdressModel model;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		model = new WebAdressModel();
		view = new WebAdressView(primaryStage, model);
		controller = new WebAdressController(view, model);
		view.start();
	}

	@Override
	public void stop() {
		if (view != null)
			view.stop();
	}
}
