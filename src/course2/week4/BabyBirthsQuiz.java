package course2.week4;
/**
 * Print out the names for which 100 or fewer babies were born in a chosen CSV file of baby name data.
 * Asignment
 * 
 * 
 * @author Bryn Lloyd
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirthsQuiz {
	
	public static void main (String [] args){
		
		BabyBirthsQuiz myObj = new BabyBirthsQuiz();
		//myObj.printNames();
		//myObj.printNamesOfNumBornLessThanAHundred();
		myObj.testTotalBirths();
	}
	
/**********************************************************************************************************/ 
	
	public void printNames () {
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
			for (CSVRecord rec : fr.getCSVParser(false)) {
					System.out.println("Name " + rec.get(0) +
							" Gender " + rec.get(1) +
							" Num Born " + rec.get(2));
		}
	}
	
/**********************************************************************************************************/
	
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
	
/**********************************************************************************************************/
	
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

/**********************************************************************************************************/
	
	public void testTotalBirths () {
		
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
		//All data for 2014
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_by_year/yob2014.csv");
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_by_year/yob1900.csv");
		
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_by_year/yob1900.csv");
		
		totalBirths(fr);
	}
	
/**********************************************************************************************************/
	
}
