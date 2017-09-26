package webAdressPortChecker;

public class WebAdressController {

	private WebAdressView view;
	private WebAdressModel model;
	private boolean isAdressValid;
	private boolean isPortValid;

	public WebAdressController(WebAdressView view, WebAdressModel model) {
		this.view = view;
		this.model = model;

		// Adds Lambda listener to adress textfield
		view.adress.textProperty().addListener((observable, oldValue, newValue) -> {
			validateAdress(newValue);
		});
		//Adds Lambda listener to port textfield
		view.port.textProperty().addListener((observable, oldValue, newValue) -> {
			validatePort(newValue);
		});

		//Add Lambda EventHandler on Button
		view.theButton.setOnAction((event) -> {
			view.theButton.setText("Clicked");
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
