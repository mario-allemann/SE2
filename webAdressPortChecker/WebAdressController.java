package webAdressPortChecker;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class WebAdressController {

	private WebAdressView view;
	private WebAdressModel model;
	private boolean isAdressValid;
	private boolean isPortValid;

	public WebAdressController(WebAdressView view, WebAdressModel model) {
		this.view = view;
		this.model = model;

		// Adds Listener on adressTextfield
		view.adress.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				validateAdress(newValue);
			}
		});
		// Adds Listener on port TextField
		view.port.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				validatePort(newValue);
			}
		});
		
		//Lambda
		view.adress.textProperty().addListener((observable, oldValue, newValue) -> {
			view.adress.setText("");
		});
		
		view.theButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				view.theButton.setText("Clicked");
			}

		});
		
	
		
		//Lambda
		view.theButton.setOnAction((event) -> {
			view.theButton.setText("Lambda");
		});

	}

	// Checks if adress is valid and sets color accordingly. Locks or unlocks the
	// button
	public void validateAdress(String adress) {
		this.isAdressValid = model.isValidAdress(adress);

		if (this.isAdressValid) {
			view.adress.setStyle("-fx-text-inner-color: green;");
			checkButtonUnlock();
		} else {
			view.adress.setStyle("-fx-text-inner-color: red;");
			lockButton();
		}
	}

	// Checks if port is valid and sets color accordingly. Locks or unlocks the
	// button
	public void validatePort(String port) {
		this.isPortValid = model.isValidPort(port);

		if (this.isPortValid) {
			view.port.setStyle("-fx-text-inner-color: green;");
			checkButtonUnlock();
		} else {
			view.port.setStyle("-fx-text-inner-color: red;");
			lockButton();
		}
	}

	// If the adress and the port are valid unlock the button
	private void checkButtonUnlock() {
		if (this.isAdressValid && this.isPortValid) {
			view.theButton.setDisable(false);
		}

	}

	// Locks the button
	private void lockButton() {
		view.theButton.setDisable(true);
		view.theButton.setText("Click");
	}
}
