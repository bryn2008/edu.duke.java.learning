package course2.week3;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class ParsingWeatherData {


	public static void main (String [] args){
		
		ParsingWeatherData myObj = new ParsingWeatherData();
		myObj.testHottestInManyDays();
	}
	
/********************************************************************************************************/	
	
	public CSVRecord hottestHourInFile(CSVParser parser) {
		
		//start with largestSoFar as nothing
		CSVRecord largestSoFar = null;
		//For each row (currentRow) in the CSV File
		for(CSVRecord currentRow : parser){
			//If largestSoFar is nothing
			largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
		}
		//The largestSoFar is the answer
		return largestSoFar;
	}
	
/********************************************************************************************************/
	
	public CSVRecord HottestInManyDays () {
		CSVRecord largestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		for (File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			//use method to get largest in file
			CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
			largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
		}
		//The largest so far is the answer
		return largestSoFar;
	}
/********************************************************************************************************/
	
	public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
		if(largestSoFar == null){
			largestSoFar = currentRow;
		}
		//Otherwise
		else{
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				//Check if currentRow's temperature > largestSoFar
				if(currentTemp > largestTemp){
					//If so update largestSoFar to currentRow
					largestSoFar = currentRow; 
				}
		}
		return largestSoFar;
	}
	
/********************************************************************************************************/
	
	public void testHottestInDay () {
		FileResource fr = new FileResource("resources/course2/week3/data/2015/weather-2015-01-02.csv");
		CSVRecord largest = hottestHourInFile(fr.getCSVParser());
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				   " at " + largest.get("TimeEST"));
	}	
/********************************************************************************************************/
	
	public void testHottestInManyDays () {
		CSVRecord largest = HottestInManyDays();
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				   " at " + largest.get("DateUTC"));
	}
		
/********************************************************************************************************/
	
}
