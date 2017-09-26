package webAdressPortChecker;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WebAdressView {
	private WebAdressModel model;
	private Stage stage;
	private Label adressLabel;
	private Label portLabel;
	protected TextField adress;
	protected TextField port;
	protected Button theButton;

	protected WebAdressView(Stage stage, WebAdressModel model) {
		this.stage = stage;
		this.model = model;
		stage.setTitle("Web Adress Checker");

		GridPane pane = new GridPane();

		adressLabel = new Label("Webadress");
		pane.add(adressLabel, 0, 0);

		portLabel = new Label("Port");
		pane.add(portLabel, 0, 1);

		adress = new TextField();
		pane.add(adress, 1, 0);

		port = new TextField();
		pane.add(port, 1, 1);

		theButton = new Button("Click");
		theButton.setDisable(true);
		pane.add(theButton, 0, 2);

		Scene scene = new Scene(pane);

		stage.setScene(scene);

	}

	public void start() {
		stage.show();

	}

	public void stop() {
		stage.close();
	}

}
