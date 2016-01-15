package course2.week3;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class ParsingWeatherData {


	public static void main (String [] args){
		
		ParsingWeatherData myObj = new ParsingWeatherData();
		//myObj.testHottestInManyDays();
		//myObj.testColdestInDay();
		myObj.testFileWithColdestTemperature();
	}
	
/********************************************************************************************************/	
	
	public CSVRecord coldestHourInFile(CSVParser parser) {
		
		//start with largestSoFar as nothing
		CSVRecord lowestSoFar = null;
		//For each row (currentRow) in the CSV File
		for(CSVRecord currentRow : parser){
			//If largestSoFar is nothing
			lowestSoFar = getSmallestOfTwo(currentRow, lowestSoFar);
		}
		//The largestSoFar is the answer
		return lowestSoFar;
	}

/********************************************************************************************************/
	
	public CSVRecord fileWithColdestTemperature () {
		CSVRecord lowestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		for (File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);

			
			//use an if statement to determine the file with the coldest temp
			
			
			//use method to get smallest in file
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			lowestSoFar = getSmallestOfTwo(currentRow, lowestSoFar);
			
			
		} 
		//The largest so far is the answer
		return lowestSoFar;
	}
		
/********************************************************************************************************/
	
	public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar) {
		if(lowestSoFar == null){
			lowestSoFar = currentRow;
		}
		//Otherwise
		else{
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
				//Check if currentRow's temperature > largestSoFar
				if(currentTemp < lowestTemp){
					int bugTemp = -9999;
					if(currentTemp == bugTemp){
						//this stops the bugTemp of -9999 from being counted 
					}
					else{
						//If so update largestSoFar to currentRow
						lowestSoFar = currentRow;
					}
				}
		}
		return lowestSoFar;
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
	//number 1 in the assignment
	public void testColdestInDay () {
		FileResource fr = new FileResource("resources/course2/week3/data/2015/weather-2015-01-01.csv");
		CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
		System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
				   " at " + coldest.get("TimeEST"));
	}
		
/********************************************************************************************************/
	
	//number 2 in the assignment
	public void testFileWithColdestTemperature () {
		CSVRecord coldest = fileWithColdestTemperature();
		System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
				   " at " + coldest.get("DateUTC"));
	}
	
/********************************************************************************************************/
}
