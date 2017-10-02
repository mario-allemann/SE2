package logger;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public class MasterLogger {

	public static final String LOGGER_NAME = MasterLogger.class.getSimpleName();
	private Logger logger = null;



	public MasterLogger() {
		logger = Logger.getLogger("LOGGER_NAME");
		logger.setLevel(Level.ALL);

		Handler[] defaultHandler = Logger.getLogger("").getHandlers();
		System.out.println(defaultHandler.length);
		// Console prints out all logs
		defaultHandler[0].setLevel(Level.FINEST);
		
		try {
			FileHandler fl = new FileHandler("%t/" + LOGGER_NAME + "_%u" + "_%g" + ".log", 1000000, 9);
			fl.setLevel(Level.SEVERE);
			logger.addHandler(fl);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void logSomeStuff() {
		logger.severe("Help me");
		logger.finest("Nothing to worry about!");
	}
	
	public static void main(String[] args) {
		MasterLogger ml = new MasterLogger();
		ml.logSomeStuff();
		ImplementsLogger il = new ImplementsLogger();
	}

}
