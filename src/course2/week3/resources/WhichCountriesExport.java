package course2.week3.resources;

/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
	
	public static void main (String [] args){
	
		WhichCountriesExport myObj = new WhichCountriesExport();
		myObj.whoExportsCoffee();

	}
	
	public void listExporters(CSVParser parser, String exportOfInterest) {
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String exports = record.get("Exports");
			//Check if it contains exportOfInterest
			if (exports.contains(exportOfInterest)){
				//If so, write down the "Country" from that row			
				String country = record.get("Country");
				System.out.println(country);
			}
		}
	}
	
	public void whoExportsCoffee() {
		FileResource fr = new FileResource("resources/course2/week3/exports/exports_small.csv");
		CSVParser parser = fr.getCSVParser();
		listExporters(parser, "coffee");
	}
}
