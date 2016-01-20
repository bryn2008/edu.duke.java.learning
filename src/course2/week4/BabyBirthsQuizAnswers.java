package course2.week4;

/**
 * Print out the names for which 100 or fewer babies were born in a chosen CSV file of baby name data.
 * Asignment
 * 
 * 
 * @author Bryn Lloyd
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirthsQuizAnswers {
	
	public static void main (String [] args){
		
		BabyBirthsQuizAnswers myObj = new BabyBirthsQuizAnswers();
/*		//Question 1
		System.out.println("Question 1");
		myObj.testUniqueNames();
		//Question 2
		System.out.println("Question 2");
		myObj.testUniqueNamesAlt();
		//Question 3
		System.out.println("Question 3");
		myObj.testGetRank();
		//Question 4
		System.out.println("Question 4");
		myObj.testGetRankAlt();
		//Question 5
		System.out.println("Question 5");
		myObj.testGetName();
		//Question 6
		System.out.println("Question 6");
		myObj.testGetNameAlt();
		//Question 7
		System.out.println("Question 7");
		myObj.testWhatIsNameInYear();
		//Question 8
		System.out.println("Question 8");
		myObj.testWhatIsNameInYearAlt();
		//Question 9
		System.out.println("Question 9");
		myObj.testYearOfHighestRank();
		//Question 10
		System.out.println("Question 10");
		myObj.testYearOfHighestRankAlt();
		//Question 11
		System.out.println("Question 11");
		myObj.testGetAverageRank();
		//Question 12
		System.out.println("Question 12");
		myObj.testGetAverageRankAlt();
*/		//Question 13
		System.out.println("Question 13");
		myObj.testGetTotalBithsRankedHigher();
/*		//Question 14
		System.out.println("Question 14");
		myObj.testGetTotalBithsRankedHigherAlt();
*/		
	}
		
/*************************************************************************************************************************************************/
	//method 1
	public void uniqueNames (FileResource fr) {
		//int totalBirths = 0;
		//int totalBoys = 0;
		//int totalGirls = 0;
		Set<String> boysNames = new HashSet<String>();
		Set<String> girlsNames = new HashSet<String>();
		int totalNumOfNames = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			//int numBorn = Integer.parseInt(rec.get(2));
			String numName = rec.get(0);
			//totalBirths += numBorn;
			if(rec.get(1).equals("M")){
				//totalBoys += numBorn;
				boysNames.add(numName);
			}
			else{
				//totalGirls += numBorn;
				girlsNames.add(numName);
			}
		}
		totalNumOfNames = boysNames.size()+girlsNames.size();
		//System.out.println("total births = " + totalBirths);
		//System.out.println("total girls = " + totalGirls);
		//System.out.println("total boys = " + totalBoys);
		//System.out.println("total number of unique girls names = " + girlsNames.size());
		//System.out.println("the girls names are = " + girlsNames);
		//System.out.println("total number of unique boys names = " + boysNames.size());
		//System.out.print("the boys names are = " + boysNames);
		//for (String i : boysNames) {
		//     System.out.print(i+" ");
		//}
		//System.out.println("");
		System.out.println("total number of unique names in the file = " + totalNumOfNames);
	}

/*************************************************************************************************************************************************/
	//Question 1
	public void testUniqueNames () {
		FileResource fr = new FileResource("data/yob1900.csv");
		uniqueNames(fr);
	}
	
/*************************************************************************************************************************************************/
	//method 2
	public void uniqueBoysNames (FileResource fr) {
		Set<String> boysNames = new HashSet<String>();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			//int numBorn = Integer.parseInt(rec.get(2));
			String numName = rec.get(0);
			//totalBirths += numBorn;
			if(rec.get(1).equals("M")){
				//totalBoys += numBorn;
				boysNames.add(numName);
			}
		}
		System.out.println("total number of unique boys names = " + boysNames.size());
	}
	
/*************************************************************************************************************************************************/
	//Question 2
	public void testUniqueNamesAlt () {
		FileResource fr = new FileResource("data/yob1905.csv");
		uniqueBoysNames(fr);
	}
	
/*************************************************************************************************************************************************/
	//method 3
	public int getRank (FileResource fr, String gender,String name) {
		
		int temp = 0;
		int rank = -1;
		
		CSVParser parser = fr.getCSVParser(false);
		for (CSVRecord rec : parser){
			//To improve code, I could calculate the rank via the amount of numBorn
			//int numBorn = Integer.parseInt(rec.get(2));
			//Can call a method here to set the name in the if loop
			String currnetName = rec.get(0);
			String currentGender =rec.get(1);
			if (currentGender.equals(gender)){
				//then for loop through the numBorn for the highest
				temp++;
				if (currnetName.equals(name)){
					rank=temp;
				}
			}
		}
		//System.out.println("The rank of " + name + " is: " + rank);
		return rank;
	}
	
/*************************************************************************************************************************************************/
	//Question 3
	public void testGetRank () {
		FileResource fr = new FileResource("data/yob1960.csv");
		String gender = "F";
		String name = "Emily";
		int rank = getRank(fr, gender, name);
		System.out.println("The rank of " + name + " is: " + rank);
	}
	
/*************************************************************************************************************************************************/
	//Question 4
	public void testGetRankAlt () {
		FileResource fr = new FileResource("data/yob1971.csv");
		String gender = "M";
		String name = "Frank";
		int rank = getRank(fr, gender, name);
		System.out.println("The rank of " + name + " is: " + rank);
	}
	
/*************************************************************************************************************************************************/
	//method 4
	public String getName(FileResource fr, int rankNumber, String gender) {
		
/*	
 	* Write the method named getName that has three parameters: 
 	* an integer named year, an integer named rank, and a string named gender (F for female and M for male). 
 	* This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. 
 	* If the rank does not exist in the file, then “NO NAME” is returned.
*/		
		String name = "NO NAME";
		int currentRank = 0;
		CSVParser parser = fr.getCSVParser(false);
		for (CSVRecord rec : parser){
			String currentGender =rec.get(1);
			String currentName = rec.get(0);
			if (currentGender.equals(gender)){
				//get the rank based on the position of the record in the table
				currentRank++;
				//System.out.println("currentRank: " + currentRank + ". numBorn: "+ numBorn);
					//if "rankNo" or 3rd, the assign the name
					if (currentRank == rankNumber){
						name = currentName;
						//System.out.println("currentName: " + currentName);
					}
			}	
		}
		//System.out.println("");
		//System.out.println("The " + gender + " name at Rank No: " + rankNumber + " is: "+ name);
		return name;
	}
	
/*************************************************************************************************************************************************/	
	//Question 5
	public void testGetName() {
		FileResource fr = new FileResource("data/yob1980.csv");
		int rankNumber = 350;
		String gender = "F";
		String name = getName(fr, rankNumber, gender);
		System.out.println("The female name at Rank No: " + rankNumber + " is: "+ name);
	}
	
/*************************************************************************************************************************************************/	
	//Question 6
	public void testGetNameAlt() {
		FileResource fr = new FileResource("data/yob1982.csv");
		int rankNumber = 450;
		String gender = "M";
		String name = getName(fr, rankNumber, gender);
		System.out.println("The male name at Rank No: " + rankNumber + " is: "+ name);
	}
	
/*************************************************************************************************************************************************/
	//method 5
	public String whatIsNameInYear(String name, int year, int newYear, String gender) {
		
		//System.out.println(name+" "+year+" "+newYear+" "+gender);
		//System.out.println(" ");
		String fname = "data/yob" + year + ".csv";
		FileResource fr = new FileResource(fname);
		int rankNumber = getRank(fr, gender, name);
		//System.out.println(">>"+rankNumber);
		String newfname = "data/yob" + newYear + ".csv";
		FileResource newFr = new FileResource(newfname);
		String newName = getName(newFr, rankNumber, gender);
		//System.out.println(">>"+newName);
		//System.out.println(name+" born in "+year+" would be "+newName+" in "+newYear);
		return newName;
	}
	
/*************************************************************************************************************************************************/
	//Question 7
	public void testWhatIsNameInYear() {
		String name = "Susan";
		int year = 1972;
		int newYear = 2014 ;
		String gender = "F";
		String newName = whatIsNameInYear(name, year, newYear, gender);
		System.out.println(name+" born in "+year+" would be "+newName+" in "+newYear);
	}
	
/*************************************************************************************************************************************************/
	//Question 8
	public void testWhatIsNameInYearAlt() {
		String name = "Owen";
		int year = 1974;
		int newYear = 2014 ;
		String gender = "M";
		String newName = whatIsNameInYear(name, year, newYear, gender);
		System.out.println(name+" born in "+year+" would be "+newName+" in "+newYear);
	}
	
/*************************************************************************************************************************************************/
	//method 6
	public int yearOfHighestRank(String name, String gender) {
		
		//set the highest ranking year to zero
		int highestRankingYear = 0;
		//set the rank -1
		int rank = -1;
		//Use a boolean to check if it is the first pass
		boolean firstPass = true;
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		for (File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			//A check to see if both the name and gender are in the file
			if (name.equals(null) || gender.equals(null)){
				return -1;
			}
			//If both the name and gender are in the file then do this...
			else
			{
				int currentRank = getRank (fr, gender, name);
				//Get the year from the file name and use the substring method to determine the year
				String yearOfFile = f.getName().substring(3, 7);
				//A check to show the rank of the name in each year
				//System.out.println("The current rank for "+ name + " is " + currentRank + " in " + yearOfFile);
				//A check to make sure there is a value in the rank when checking the first file
				if (firstPass) {
					rank = currentRank;
					firstPass = false;
				}
				//Compares the two ranks to see if the current rank is higher than the previously set rank
				if (currentRank <= rank ){
					rank = currentRank;
					int currentYearOfFile = Integer.parseInt(yearOfFile);
					highestRankingYear = currentYearOfFile;
					
				}
			}
		}
		//Returns the year with the highest rank
		return highestRankingYear;
	}	
	
/*************************************************************************************************************************************************/
	//Question 9
	public void testYearOfHighestRank() {
		String name = "Genevieve";
		String gender = "F";
		int highestRankingYear = yearOfHighestRank(name, gender);
		System.out.println(name + " was ranked heighest in "+highestRankingYear+".");
	}
	
/*************************************************************************************************************************************************/
	//Question 10
	public void testYearOfHighestRankAlt() {
		String name = "Mich";
		String gender = "m";
		int highestRankingYear = yearOfHighestRank(name, gender);
		System.out.println(name + " was ranked heighest in "+highestRankingYear+".");
	}	
	
/*************************************************************************************************************************************************/
	//method 7
	public double getAverageRank(String name, String gender) {
		
		//set the highest ranking year to zero
		double averageRank = 0;
		//set the rank -1
		//int rank = -1;
		//Use a boolean to check if it is the first pass
		boolean firstPass = true;
		//Use an Array List for the average
		ArrayList<Double> al = new ArrayList<Double>();
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		for (File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			//A check to see if both the name and gender are in the file
			if (name.equals(null) || gender.equals(null)){
				return -1.0;
			}
			//If both the name and gender are in the file then do this...
			else
			{
				int currentRank = getRank (fr, gender, name);
				//Get the year from the file name and use the substring method to determine the year
				//String yearOfFile = f.getName().substring(3, 7);
				//A check to show the rank of the name in each year
				//System.out.println("The current rank for "+ name + " is " + currentRank + " in " + yearOfFile);
				//A check to make sure there is a value in the rank when checking the first file
				//System.out.println(">>"+ rank+ " "+ currentRank );
				//Set the rank to a double
				double currentRankDouble = currentRank;
				//add the current rank to the array list
				al.add(currentRankDouble);
				//if first pass
				if (firstPass) {
					//rank = currentRank;
					firstPass = false;
				}
				//System.out.println(">>"+ rank);
			}
		}
		//Get the average rank from the array list
		//System.out.println(">>"+ al+al.size());
		int sum = 0;
		for (Double i : al){
		    sum += i;
		}
		//Average number in the array list
		averageRank = sum/al.size();
		//Returns the year with the highest rank
		return averageRank;
	}		
	
/*************************************************************************************************************************************************/
	//Question 11
	public void testGetAverageRank() {
		String name = "Susan";
		String gender = "F";
		Double averageRank = getAverageRank(name, gender);
		//should return 2012 with the three test files selected under the test conditions
		System.out.println(name + " has an average rank of "+averageRank+".");
	}
	
/*************************************************************************************************************************************************/
	//Question 12
	public void testGetAverageRankAlt() {
		String name = "Robert";
		String gender = "M";
		Double averageRank = getAverageRank(name, gender);
		//should return 2012 with the three test files selected under the test conditions
		System.out.println(name + " has an average rank of "+averageRank+".");
	}	
	
/*************************************************************************************************************************************************/
	//method 8
	public float getTotalBithsRankedHigher(int year, String name, String gender) {
		
		String fname = "data/yob" + year + ".csv";
		FileResource fr = new FileResource(fname);
		float numOfBirthsTotal = 0;
		//Get the rank of the input name
		int rankOfName = getRank (fr, gender, name);
		//System.out.println(" >> "+ rankOfName);
		CSVParser parser = fr.getCSVParser(false);
		for (CSVRecord rec : parser){
			//System.out.println(rec.getRecordNumber());
			String currentName =rec.get(0);
			String currentGender =rec.get(1);
			int currentNumOfBirths = Integer.parseInt(rec.get(2));
			int currentRank = getRank (fr, currentGender, currentName);
			if (currentGender.equals(gender)){
				//get the details of all the current names
				//System.out.println(" current name:  "+ currentName+" current num of births:  "+ currentNumOfBirths+" current gender "+ currentGender+" current rank:  "+ currentRank);	
				if (currentRank < rankOfName){
					//System.out.println("The current rank is: "+ currentRank);
					numOfBirthsTotal += currentNumOfBirths; 
				}
			}
		}
	//System.out.println(" >> "+ numOfBirthsTotal);
	return numOfBirthsTotal;
	}	
	
/*************************************************************************************************************************************************/
	//Question 13
	public void testGetTotalBithsRankedHigher() {
		//This method takes a long time to calculate!!!
		int year = 1990;
		String name = "Emily";
		String gender = "F";
		float totalNumOfBirths = getTotalBithsRankedHigher(year, name, gender);
		System.out.println("The total number of births ranked higher than "+name+" is "+ totalNumOfBirths +".");
	}	
	
/*************************************************************************************************************************************************/
	//Question 14
	public void testGetTotalBithsRankedHigherAlt() {
		//This method takes a long time to calculate!!!
		int year = 1990;
		String name = "Drew";
		String gender = "M";
		float totalNumOfBirths = getTotalBithsRankedHigher(year, name, gender);
		System.out.println("The total number of births ranked higher than "+name+" is "+ totalNumOfBirths +".");
	}	
	
/*************************************************************************************************************************************************/

}
