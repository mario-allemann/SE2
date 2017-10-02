package logger;

import java.util.logging.Logger;

public class ImplementsLogger {
	
	private  Logger logger;
	
	
	public ImplementsLogger(){
		logger = Logger.getLogger(MasterLogger.LOGGER_NAME);
		
		logger.finest("IL This will only be shown on console");
		logger.severe("This gets written to a file");
	}
	
	
	public static void main(String[] args) {

	}
}
