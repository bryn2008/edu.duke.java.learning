package course2.week4;
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
		//myObj.printNames();
		//myObj.printNamesOfNumBornLessThanAHundred();
		//myObj.testTotalBirths();
		//myObj.testUniqueNames();
		myObj.testGetRank();
	}
	
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
	
	public void testUniqueNames () {
		
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
		
		//Assignment test files
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2012short.csv");
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2013short.csv");
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2014short.csv");
		
		uniqueNames(fr);
	}
	
/*************************************************************************************************************************************************/
	
	public void getRank (FileResource fr) {
		
//		int year = 0;
//		String name = null;
//		String gender = null;	//F for female and M for male
//		
//		for(CSVRecord rec : fr.getCSVParser(false)) {
//			
//			
//		}
		
		
		
		
		
//        if (???????? == -1) {
//            //System.out.println("There is not a start codon.");
//            return "";
//        }
		
		
		
		/*int totalBirths = 0;
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
		System.out.println("total boys = " + totalBoys);*/
	}
	
/*************************************************************************************************************************************************/
	
	public void testGetRank () {
		
		//Assignment test files
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2012short.csv");
		
		//getRank(fr);
		
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
			
			//Print all the names and genders
			System.out.print(gender + " ");
			System.out.println(name);
			
			//use this to get the rank of a name 
			
		}
	}
	
/*************************************************************************************************************************************************/

}
