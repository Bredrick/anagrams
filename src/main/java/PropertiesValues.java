package main.java;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesValues {
	String result = "";
	InputStream inputStream;
	
	private String sampleLocation = "";
 
	public String getFileLocation() {
		return sampleLocation;
	}

	/* Load setting from config.properties file.
	 * Currently used just for location of sample text file. */
	public void loadValues() throws IOException {
		try {
			Properties prop = new Properties();
			String propertiesFile = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Configuration file '" + propertiesFile + "' not found.");
			}

			sampleLocation = prop.getProperty("inputFile");
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
}
