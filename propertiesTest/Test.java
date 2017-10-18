package propertiesTest;

import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("Agent", "1");
		prop.setProperty("Hello", "world");
		prop.setProperty("Agent", "2");
		
		System.out.println(prop.getProperty("Hello"));
	}

}
