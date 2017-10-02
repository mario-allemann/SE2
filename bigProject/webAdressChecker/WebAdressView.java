package bigProject.webAdressChecker;

import bigProject.counter.ServiceLocator;
import bigProject.counter.commonClasses.Configuration;
import bigProject.counter.commonClasses.Translator;
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
	ServiceLocator sl = ServiceLocator.getServiceLocator();
	Translator t = sl.getTranslator();
	Configuration c = sl.getConfiguration();
	

	public WebAdressView(Stage stage, WebAdressModel model) {
		this.stage = stage;
		this.model = model;
		stage.setTitle("Web Adress Checker");

		GridPane pane = new GridPane();

		adressLabel = new Label(t.getString("webAdressChecker.webadress"));
		pane.add(adressLabel, 0, 0);

		portLabel = new Label(t.getString("webAdressChecker.port"));
		pane.add(portLabel, 0, 1);

		adress = new TextField();
		pane.add(adress, 1, 0);

		port = new TextField();
		pane.add(port, 1, 1);

		theButton = new Button(t.getString("webAdressChecker.button"));
		theButton.setDisable(true);
		pane.add(theButton, 0, 2);

		//get config values (lastValues)
		adress.setText(c.getOption("LastAdress"));
		port.setText(c.getOption("LastPort"));
		
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
