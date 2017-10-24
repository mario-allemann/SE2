package chatLab.server;

import javafx.collections.ListChangeListener;

public class Controller{
	private Model model;
	private View view;
	protected Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		view.btnStart.setOnAction((event) -> {
			model.startServer(Integer.parseInt(view.tfPort.getText()));
		});
		

		view.stage.setOnCloseRequest(event -> model.stopServer());

		model.clients.addListener((ListChangeListener) (event -> view.updateClients()));
		
	}

}
