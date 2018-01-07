package pruefung;

import javafx.beans.property.SimpleStringProperty;

public class PropertyListeners {

	public static void main(String[] args) {
		SimpleStringProperty ssp = new SimpleStringProperty("HelloWorld");
		ssp.addListener((observable, oldValue, newValue) -> {

		});

	}
}
