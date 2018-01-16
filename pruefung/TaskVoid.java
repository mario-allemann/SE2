package pruefung;

import javafx.concurrent.Task;

public class TaskVoid {

	final Task<Void> serverTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			try {
				while (true) {
					//Thread stuff
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			return null;
		}
	};

	public void serveContent(Integer port) {
		new Thread(serverTask).start();
	}
}
