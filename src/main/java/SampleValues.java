package main.java;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SampleValues {
	
	BufferedReader fileBuffer;
	
	public SampleValues(String inputFile){
		try {
			fileBuffer = new BufferedReader(new FileReader(inputFile));
		} catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
	}
	
	public String GetNext() throws IOException {
		return fileBuffer.readLine();
	}
	
	public void Close() {
		try {
			fileBuffer.close();
		} catch (IOException e) {
		}
	}

}
