package chatLab.client;

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
	
	
	//Top elements
	HBox top = new HBox();
	
	Label lblIPAdr = new Label("IP Address");
	TextField tfIPAdr = new TextField("127.0.0.1");
	Label lblPort = new Label("Port");
	TextField tfPort = new TextField("8080");
	Label lblName = new Label("Name");
	TextField tfName = new TextField();
	Button btnConnect = new Button("Start");
	
	//Center elements
	TextArea chatMessages = new TextArea();
	
	//Bottom elements
	HBox bottom = new HBox();
	
	TextField tfMessage = new TextField();
	
	Button btnSend = new Button("Send");
	
	protected View(Stage stage, Model model) {
		this.stage = stage;
	
		tfMessage.setMinWidth(800);
	
	BorderPane bp = new BorderPane();
		

		top.getStyleClass().add("hbox");

		
		
		top.getChildren().addAll(lblIPAdr,tfIPAdr, lblPort, tfPort, lblName, tfName, btnConnect);
		bp.setTop(top);
		
		chatMessages.setEditable(false);
		bp.setCenter(chatMessages);
		
		
		
		bottom.getChildren().addAll(tfMessage, btnSend);
		bottom.getStyleClass().add("hbox");
		bp.setBottom(bottom);
		
		Scene scene = new Scene(bp);
		
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		this.stage.setScene(scene);
		this.stage.show();
	}

	

}
