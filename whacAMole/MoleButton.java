package whacAMole;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MoleButton extends Button implements Runnable, EventHandler<ActionEvent> {
	private Image empty = new Image(MoleButton.class.getResourceAsStream("empty.gif"));
	private Image mole = new Image(MoleButton.class.getResourceAsStream("mole.gif"));
	
	private Whacamole main;
	
	private ImageView moleImage = new ImageView(mole);
    private ImageView emptyImage = new ImageView(empty);
	
	public MoleButton(Whacamole main) {
		this.main = main;
		this.setGraphic(emptyImage);
		this.setDisable(true);
		this.setOnAction(this);
		Thread t = new Thread(this);
		t.start();
		
		
	}
	
	private boolean finished = false;
	public void run() {
		while (!finished) {
			Platform.runLater(() ->{
				if(Math.random() < 0.5) {
					this.setDisable(true);
					this.setGraphic(emptyImage);
				}
				else {
					this.setDisable(false);
					this.setGraphic(moleImage);
				}
				
				
			});
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	@Override
	public void handle(ActionEvent event) {
		main.whack();
		
		
	}


}
