package course2.week3;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class ParsingWeatherData {


	public static void main (String [] args){
		
		ParsingWeatherData myObj = new ParsingWeatherData();
		//myObj.testHottestInManyDays();			//Start of assignment
		//myObj.testColdestInDay();					//number 1 in the assignment
		//myObj.testFileWithColdestTemperature();	//number 2 in the assignment
		//myObj.testLowestHumidityInFile();			//number 3 in the assignment
		//myObj.testLowestHumidityInManyFile();		//number 4 in the assignment
		myObj.testAverageTemperatureInFile();		//number 5 in the assignment
	}

/********************************************************************************************************/
	//Number 5 in the assignment
	public void testAverageTemperatureInFile() {
		
		FileResource fr = new FileResource("resources/course2/week3/data/2015/weather-2015-01-01.csv");
		CSVParser parser = fr.getCSVParser();
		CSVRecord lowestTemperature = averageTemperatureInFile(parser);
		System.out.println("Average Temperature in file is " + lowestTemperature.get("TemperatureF"));
	}	
	
/********************************************************************************************************/
	
	public CSVRecord averageTemperatureInFile(CSVParser parser) {
		
		ArrayList <Double> al = new ArrayList();
		
		//start with largestSoFar as nothing
		CSVRecord averageTemperature = null;
		//For each row (currentRow) in the CSV File
		for(CSVRecord currentRow : parser){
			//If largestSoFar is nothing
			
			
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			al.add(currentTemp);
		}
		System.out.println(al);
			
		
		double pi = 3.14159;
		//The average temperature is the returned
		return averageTemperature;
	}
	
/********************************************************************************************************/
	//Number 4 in the assignment
	public void testLowestHumidityInManyFile() {
		
		CSVRecord lowestHumidity = lowestHumidityInManyFiles();
		System.out.println("Lowest Humidity at " + lowestHumidity.get("Humidity") +
				   " at " + lowestHumidity.get("DateUTC"));
	}
	
/********************************************************************************************************/
	
	public CSVRecord lowestHumidityInManyFiles () {
		CSVRecord lowestHumidity = null;
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		for (File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			//use method to get the file with the lowest humidity
			CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
			lowestHumidity = getLowestHumidityOfTwo(currentRow, lowestHumidity);
		}
		//The largest so far is the answer
		return lowestHumidity;
	}
	
/********************************************************************************************************/
	
	public CSVRecord getLowestHumidityOfTwo(CSVRecord currentRow, CSVRecord lowHum) {
		if(lowHum == null){
			lowHum = currentRow;
		}
		//Otherwise
		else{
			double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
			double lowestHumidity = Double.parseDouble(lowHum.get("Humidity"));
				//Check if currentRow's temperature > largestSoFar
				if(currentHumidity < lowestHumidity){
					//If so update largestSoFar to currentRow
					lowHum = currentRow; 
				}
		}
		return lowHum;
	}
	
/********************************************************************************************************/
	
	public CSVRecord lowestHumidityInFile(CSVParser parser) {
		//start with largestSoFar as nothing
		CSVRecord lowestHumidity = null;
		//For each row (currentRow) in the CSV File
		for(CSVRecord currentRow : parser){
			//If largestSoFar is nothing
			lowestHumidity = getLowestOfTwo(currentRow, lowestHumidity);
		}
		//The largestSoFar is the answer
		return lowestHumidity;
	}
	
/********************************************************************************************************/
	
	public CSVRecord getLowestOfTwo(CSVRecord currentRow, CSVRecord lowHum) {
		
		String bug = "N/A";
		//Checks the value of the integer lowHum is not empty
		if(lowHum == null){
			lowHum = currentRow;
		}
		
		//check if the currentRow is a string
		else if(currentRow.get("Humidity") == bug){
			//lowHum = lowHum; //Do nothing
		}
		
		//Otherwise
		else{
			double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
			double lowestHumidity = Double.parseDouble(lowHum.get("Humidity"));
				//Check if currentRow's humidity < lowestHumidity
				if(currentHumidity < lowestHumidity){
					lowHum = currentRow;
			}
		}
		return lowHum;
	}
	
/********************************************************************************************************/
	//Number 3 in the assignment
	public void testLowestHumidityInFile() {
		FileResource fr = new FileResource("resources/course2/week3/data/2014/weather-2014-01-20.csv");
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		
		System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
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
	
	public CSVRecord fileWithColdestTemperature (Path path) {
		
		//set the file resource to the path
		String filePath = path.toString();
		FileResource fr = new FileResource(filePath);
		//String fileName = "the file with the lowest temp!!";
		CSVRecord lowestSoFar = null;
		//use method to get smallest in file
		CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
		lowestSoFar = getSmallestOfTwo(currentRow, lowestSoFar);
		//The largest so far is the answer 
		return lowestSoFar;
	}
	
/********************************************************************************************************/
	
	public String theFileNameWithColdestTemperature() {
		
		String filePath = null;
		CSVRecord lowestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		for (File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			String fileName = f.getName();
			//use method to get smallest in file
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			lowestSoFar = getSmallestOfTwo(currentRow, lowestSoFar);
			//if file contains lowest temperature then set the file name to the file path
			if(currentRow == lowestSoFar){
				filePath = fileName;
			}
		}
		//The largest so far is the answer 
		return filePath;
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

		//Call the method to find the files name with the coldest day
		String filePath = theFileNameWithColdestTemperature();
		
		//The coldest day was in file:
		System.out.println("Coldest day was in file "+filePath);
		
		Path path = Paths.get("resources/course2/week3/nc_weather/2014", filePath);
		
		//Result is "resources\course2\week3\nc_weather\2014\" + filePath
		//System.out.println(path); 
		
		//Return the CSV record
		CSVRecord coldest = fileWithColdestTemperature(path);
		
		//This method works
		System.out.println("Coldest temperature on that day was " + coldest.get("TemperatureF"));
		
		//This method needs the name of the file to print all of the temperatures
		System.out.println("All the Temperatures on the coldest day were: ");
		String theFilePath = path.toString();
		FileResource fr = new FileResource(theFilePath);
		CSVParser parser = fr.getCSVParser();
		for (CSVRecord record : parser){
			System.out.print(record.get("DateUTC") + " ");
			System.out.print(record.get("TimeEST") + " ");
			System.out.println(record.get("TemperatureF"));
		}
		
	}
	
/********************************************************************************************************/
}
