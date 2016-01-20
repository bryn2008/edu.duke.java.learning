package course2.week4;
import java.io.File;
/**
 * Print out the names for which 100 or fewer babies were born in a chosen CSV file of baby name data.
 * Asignment
 * 
 * 
 * @author Bryn Lloyd
 */
import java.util.HashSet;
import java.util.Set;
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
	
	public static void main (String [] args){
		
		BabyBirths myObj = new BabyBirths();
		//myObj.testReadOneFile();
		//myObj.printNames();
		//myObj.printNamesOfNumBornLessThanAHundred();
		//myObj.testTotalBirths();
		//myObj.testUniqueNames();
		//myObj.testGetRank();
		//myObj.testGetName();
		//myObj.testWhatIsNameInYear();
		myObj.testYearOfHighestRank();
	}
	
	//look back at all the programs created over course 2
		//use the 7 step approach
			//Re-read the assignment and look at the videos again
	
/*************************************************************************************************************************************************/ 
	
	public void printNames () {
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
			for (CSVRecord rec : fr.getCSVParser(false)) {
					System.out.println("Name " + rec.get(0) +
							" Gender " + rec.get(1) +
							" Num Born " + rec.get(2));
		}
	}
	
/*************************************************************************************************************************************************/
	
	public void printNamesOfNumBornLessThanAHundred () {
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
		//FileResource fr = new FileResource();
			for (CSVRecord rec : fr.getCSVParser(false)) {
				int numBorn = Integer.parseInt(rec.get(2));
				if (numBorn <= 100) {
					System.out.println("Name " + rec.get(0) +
							" Gender " + rec.get(1) +
							" Num Born " + rec.get(2));
			}
		}
	}
	
/*************************************************************************************************************************************************/
	
	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if(rec.get(1).equals("M")){
				totalBoys += numBorn;
			}
			else{
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("total girls = " + totalGirls);
		System.out.println("total boys = " + totalBoys);
	}
	
/*************************************************************************************************************************************************/
	
	public void testTotalBirths () {
		
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
		
		//Assignment test files
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2012short.csv");
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2013short.csv");
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2014short.csv");
		
		//All data for 2014
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_by_year/yob2014.csv");
		
		totalBirths(fr);
	}
	
/*************************************************************************************************************************************************/
	//method 1 - was totalBirths
	public void uniqueNames (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		Set<String> boysNames = new HashSet<String>();
		Set<String> girlsNames = new HashSet<String>();
		int totalNumOfNames = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			String numName = rec.get(0);
			totalBirths += numBorn;
			if(rec.get(1).equals("M")){
				totalBoys += numBorn;
				boysNames.add(numName);
			}
			else{
				totalGirls += numBorn;
				girlsNames.add(numName);
			}
		}
		totalNumOfNames = boysNames.size()+girlsNames.size();
		System.out.println("total births = " + totalBirths);
		System.out.println("total girls = " + totalGirls);
		System.out.println("total boys = " + totalBoys);
		System.out.println("total number of unique girls names = " + girlsNames.size());
		System.out.println("the girls names are = " + girlsNames);
		System.out.println("total number of unique boys names = " + boysNames.size());
		System.out.print("the boys names are = ");
		for (String i : boysNames) {
		     System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println("total number of unique names in the file = " + totalNumOfNames);
	}

/*************************************************************************************************************************************************/
	//method 1 - was totalBirths
	public void testUniqueNames () {
		
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
		
		//Assignment test files
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2012short.csv");
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2013short.csv");
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2014short.csv");
		
		uniqueNames(fr);
	}
	
/*************************************************************************************************************************************************/
	//method 2
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
	
	public void testGetRank () {
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2012short.csv");
		String gender = "M";
		String name = "Mason";
		getRank(fr, gender, name);
	}
	
/*************************************************************************************************************************************************/
	//method 3
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
	
	public void testGetName() {
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2012short.csv");
		int rankNumber = 4;
		String gender = "M";
		getName(fr, rankNumber, gender);
	}
	
/*************************************************************************************************************************************************/
	//method 4
	public void whatIsNameInYear(String name, int year, int newYear, String gender) {
		
/*	
 	* What would your name be if you were born in a different year? 
 	* Write the void method named whatIsNameInYear that has four parameters: 
 	* a string name, an integer named year representing the year that name was born, an integer named newYear and a string named gender (F for female and M for male). 
 	* This method determines what name would have been named if they were born in a different year, based on the same popularity. 
 	* That is, you should determine the rank of name in the year they were born, and then print the name born in newYear that is at the same rank and same gender. 
 	* For example, using the files "yob2012short.csv" and "yob2014short.csv", notice that in 2012 Isabella is the third most popular girl's name.
 	* he given gender, where rank 1 is the name with the largest number of births. 
 	* 
*/	
		//System.out.println(name+" "+year+" "+newYear+" "+gender);
		//System.out.println(" ");
		String fname = "resources/course2/week4/us_babynames/us_babynames_test/yob" + year + "short.csv";
		FileResource fr = new FileResource(fname);
		int rankNumber = getRank(fr, gender, name);
		//System.out.println(">>"+rankNumber);
		String newfname = "resources/course2/week4/us_babynames/us_babynames_test/yob" + newYear + "short.csv";
		FileResource newFr = new FileResource(newfname);
		String newName = getName(newFr, rankNumber, gender);
		//System.out.println(">>"+newName);
		System.out.println(name+" born in "+year+" would be "+newName+" in "+newYear);	
	}
	
/*************************************************************************************************************************************************/
	
	public void testWhatIsNameInYear() {
		String name = "Isabella";
		int year = 2012;
		int newYear = 2014;
		String gender = "F";
		whatIsNameInYear(name, year, newYear, gender);
	}	
	
/*************************************************************************************************************************************************/
	//method 5
	public int yearOfHighestRank(String name, String gender) {
		
/*	
 	* Write the method yearOfHighestRank that has two parameters: 
 	* a string name, and a string named gender (F for female and M for male). 
 	* This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. 
 	* If the name and gender are not in any of the selected files, it should return -1. 
 	* For example, calling yearOfHighestRank with name Mason and gender ‘M’ and selecting the three test files above results in returning the year 2012. 
 	* That is because Mason was ranked the 2nd most popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014. 
 	* His highest ranking was in 2012.
 	* 
*/	
		int highestRankingYear = 0;
		
		if (name.equals(null)||gender.equals(null)){
			highestRankingYear = -1;
		}
		else{
			
			
			
			
			
			
		}
		
/*		CSVRecord lowestHumidity = null;
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		for (File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			//use method to get the file with the lowest humidity
			CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
			lowestHumidity = getLowestHumidityOfTwo(currentRow, lowestHumidity);
		}
		//The largest so far is the answer
		return lowestHumidity;*/
		
		
//		String fname = "resources/course2/week4/us_babynames/us_babynames_test/yob" + year + "short.csv";
//		FileResource fr = new FileResource(fname);
//		int rankNumber = getRank(fr, gender, name);
//		//System.out.println(">>"+rankNumber);
//		String newfname = "resources/course2/week4/us_babynames/us_babynames_test/yob" + newYear + "short.csv";
//		FileResource newFr = new FileResource(newfname);
//		String newName = getName(newFr, rankNumber, gender);
//		//System.out.println(">>"+newName);
//		System.out.println(name+" born in "+year+" would be "+newName+" in "+newYear);	
//		
		return highestRankingYear;
	}	
	
/*************************************************************************************************************************************************/
	
	public void testYearOfHighestRank() {
		String name = "Mason";
		String gender = null;
		int highestRankingYear = 0;
		highestRankingYear = yearOfHighestRank(name, gender);
		//should retirn 2012 witht the three test files
		System.out.println(name + " was ranked heighest in "+highestRankingYear);
	}	
	
/*************************************************************************************************************************************************/
	//method 6
	public void getAverageRank() {
		
	}	
	
/*************************************************************************************************************************************************/
	
	public void testGetAverageRank() {
		getAverageRank();
	}	
	
/*************************************************************************************************************************************************/
	//method 7
	public void getTotalBithsRankedHigher() {
		
	}	
	
/*************************************************************************************************************************************************/
	
	public void testGetTotalBithsRankedHigher() {
		getTotalBithsRankedHigher();
	}	
	
/*************************************************************************************************************************************************/
	
	public void testReadOneFile () {
		
		//Assignment test files
		int year = 2012;
		readOneFile (year);
		
	}
	
/*************************************************************************************************************************************************/
	
	public void readOneFile (int year){
		
		String fname = "data/yob" + year + ".csv";
		FileResource fr = new FileResource(fname);
		CSVParser parser = fr.getCSVParser(false);
		for (CSVRecord rec : parser){
			String name = rec.get(0);
			String gender =rec.get(1);
			String getbirths =rec.get(2);
			//2. Use valueOf method of Integer class. This method is static.
			String str = getbirths;
			Integer numOfBirths = Integer.valueOf(str);
			System.out.print(numOfBirths+ " ");
			//Print all the names and genders
			System.out.print(name + " ");
			System.out.print(gender + " ");
			System.out.println(getbirths + " ");
		}
	}
	
/*************************************************************************************************************************************************/

}
