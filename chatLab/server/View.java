package chatLab.server;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class View {
	protected Stage stage;
	private Model model;
	
	HBox top = new HBox();
	
	protected Label lblPort = new Label("Port");
	protected TextField tfPort = new TextField();
	protected Button btnStart = new Button("Start");
	

	
	TextArea conClients = new TextArea();
	

	
	
	
	
	protected View(Stage stage, Model model) {
		this.stage = stage;
		this.model = model;
		
		
		BorderPane bp = new BorderPane();
		top.getStyleClass().add("hbox");
		
		Scene scene = new Scene(bp);
		
		top.getChildren().addAll(lblPort, tfPort, btnStart);
		
		bp.setTop(top);
		
		bp.setCenter(conClients);
		
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		stage.setScene(scene);
		stage.show();
	}



	public void updateClients() {
		StringBuffer sb = new StringBuffer();
		for(Client c : model.clients) {
			sb.append(c.toString());
			sb.append("\n");
		}
		this.conClients.appendText(sb.toString());
	}



}
