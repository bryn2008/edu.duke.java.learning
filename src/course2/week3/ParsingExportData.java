package course2.week3;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class ParsingExportData {


	public static void main (String [] args){
		
		ParsingExportData myObj = new ParsingExportData();
		myObj.tester();
	}
	
/********************************************************************************************************/
	
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
	
/********************************************************************************************************/	
	
	public void countryInfo(CSVParser parser, String exportOfInterest) {
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String exports = record.get("Country");
			//Check if it contains exportOfInterest
			if (exports.contains(exportOfInterest)){
				//If so, write down the "Country" from that row and the "Exports" and the "Value (dollars)"
				String country = record.get("Country");
				String export = record.get("Exports");
				String value = record.get("Value (dollars)");
				System.out.println(country+": "+export+": "+value);
			}
			//Else if there is no "exportOfInterest" just write down the "Country"
			else{
				String country = record.get("Country");
				System.out.println(country + ": Not found");
			}
		}
	}
	
/********************************************************************************************************/	
	
	public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
		
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String exports = record.get("Exports");
			//Check if it contains both of the export items (exportItem1 && exportItem2)
			if (exports.contains(exportItem1) && exports.contains(exportItem2)){
				//If so, write down the "Country" from that row	and its "Exports"		
				String country = record.get("Country");
				String export = record.get("Exports");
				System.out.println(country+": "+export);
			}
		}
	}
	
/********************************************************************************************************/	
	
	public void numberOfExports(CSVParser parser, String exportItem) {
		int numOfCountrys = 0;
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String exports = record.get("Exports");
			//Check if it contains exportItem
			if (exports.contains(exportItem)){
				//If so, add 1 to the count			
				numOfCountrys++;
			}
		}
		System.out.println("The num of cuntries is: " + numOfCountrys);
	}

/********************************************************************************************************/	
	
	public void bigExporters(CSVParser parser, String amount) {
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Value (dollars)" column
			String value = record.get("Value (dollars)");
			//Check if the value is bigger then $999,999,999
			if (value.length() > amount.length()){
				//If so, write down the country and the amount			
				String country = record.get("Country");
				String val = record.get("Value (dollars)");
				System.out.println(country+": "+val);
			}
		}
	}
	
/********************************************************************************************************/	
	
	public void tester() {
		//FileResource fr = new FileResource("resources/course2/week3/exports/exportdata.csv");
		FileResource fr = new FileResource("resources/course2/week3/exports/exports_small.csv");
		CSVParser parser = fr.getCSVParser();
		
		System.out.println("Who imports coffee?");
		listExporters(parser, "coffee");
		
		System.out.println("Info for Germany");
		parser =fr.getCSVParser();	//>> to use the parser with another metod it needs to be reset
		countryInfo(parser, "Germany");
		
		System.out.println("Which countrys export gold and dimonds?");
		parser =fr.getCSVParser();	//>> to use the parser with another metod it needs to be reset
		listExportersTwoProducts(parser, "gold", "diamonds");
		
		System.out.println("How many Countrys export gold?");
		parser =fr.getCSVParser();	//>> to use the parser with another metod it needs to be reset
		numberOfExports(parser, "gold");
		
		System.out.println("Which Countrys are big exporters with export values over $999,999,999");
		parser =fr.getCSVParser();	//>> to use the parser with another metod it needs to be reset
		bigExporters(parser, "$999,999,999");
	}
	
/********************************************************************************************************/
	
}
