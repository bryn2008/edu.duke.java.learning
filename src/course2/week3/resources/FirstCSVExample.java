package course2.week3.resources;

/**
 * Reads a chosen CSV file of our preferences and prints each field.
 * 
 * @author Duke Software Team
 */

import edu.duke.*;
import org.apache.commons.csv.*;


public class FirstCSVExample {


	public static void main (String [] args){
		
		FirstCSVExample myObj = new FirstCSVExample();
		myObj.readFood();
	}
	
	public void readFood() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		for (CSVRecord record : parser){
			System.out.print(record.get("Name") + " ");
			System.out.print(record.get("Favorite Color") + " ");
			System.out.println(record.get("Favorite Food"));
		}
		
	}
}
