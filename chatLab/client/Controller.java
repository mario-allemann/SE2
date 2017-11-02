package chatLab.client;

public class Controller {
	protected Model model;
	protected View view;

	protected Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		view.btnConnect.setOnAction((event) -> {
			model.connect(view.tfIPAdr.getText(), Integer.parseInt(view.tfPort.getText()), view.tfName.getText());
			view.btnConnect.setDisable(true);
		});

		view.stage.setOnCloseRequest((event) -> {
			model.disconnect();
		});

		view.btnSend.setOnAction((event) -> {
			model.sendMessage(view.tfMessage.getText());
		});

		model.newestMessage.addListener((o, oldValue, newValue) -> view.chatMessages.appendText("\n" + newValue));

	}

}
