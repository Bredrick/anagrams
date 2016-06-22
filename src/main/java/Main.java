package main.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main { 
   public static void main(String[] args) { 
	   PropertiesValues properties = new PropertiesValues();
	   
	   try {
		   properties.loadValues();
		   
		   SampleValues sample = new SampleValues(properties.getFileLocation());
		   ProductCalculations product = new ProductCalculations();
		   HashMap<Long,List<String>> map = new HashMap<>();
		   
		   List<String> wordList;
		   
		   /* Calculate product for each word and add it to HashMap.
		    * Each value will contain list of anagrams. */
		   for (String word; (word = sample.GetNext()) != null;) {
			   long wordProduct = product.Calculate(word);
			   if (wordProduct > 1) {
				   if ((wordList = map.get(wordProduct)) == null) {
					   wordList = new ArrayList<>();
				   }
				   wordList.add(word);
				   map.put(wordProduct, wordList);
			   }
		   }
		   
		   /* Iterate thru HashMap and print each value on separate row. */
		   for (Entry<Long, List<String>> anagram : map.entrySet()){
			   String result = "";
			   for (String word : anagram.getValue()) {
				   result += word + " ";  
			   }
			   System.out.println(result);
		   }
		   
		   sample.Close();
		   
	   } catch (Exception e) {
	   		System.out.println("Exception: " + e);
	   }
   }
}