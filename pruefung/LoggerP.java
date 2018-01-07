package pruefung;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerP {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.INFO);
		logger.fine("This won't get logged");
		logger.severe("This will");
		
		Properties p = new Properties();
		
		Locale l = new Locale("de");
	}
}
