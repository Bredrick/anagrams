package main.java;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesValues {
	
	private String sampleLocation = "";
 
	public String getFileLocation() {
		return sampleLocation;
	}

	/* Load setting from config.properties file.
	 * Currently used just for location of sample text file. */
	public void loadValues() throws IOException {
		FileInputStream inputStream = null;
		try {
			Properties prop = new Properties();
			String propertiesFile = "./config.properties";
 
			inputStream = new FileInputStream(propertiesFile);
 
			prop.load(inputStream);

			sampleLocation = prop.getProperty("inputFile");
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
}
