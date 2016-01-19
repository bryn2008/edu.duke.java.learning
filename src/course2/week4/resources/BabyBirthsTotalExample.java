package course2.week4.resources;
/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirthsTotalExample {
	
	public static void main (String [] args){
		
		BabyBirthsTotalExample myObj = new BabyBirthsTotalExample();
		myObj.testTotalBirths();
	}
	
/******************************************************************************************************************************/
	
	public class BabyBirths {
		public void printNames () {
			FileResource fr = new FileResource();
			for (CSVRecord rec : fr.getCSVParser(false)) {
				int numBorn = Integer.parseInt(rec.get(2));
				if (numBorn <= 100) {
					System.out.println("Name " + rec.get(0) +
							   " Gender " + rec.get(1) +
							   " Num Born " + rec.get(2));
				}
			}
		}
	}
	
/******************************************************************************************************************************/
	
	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	}
	
/******************************************************************************************************************************/
	
	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		
		//Example file
		FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/example-small.csv");
		
		//2012 short file
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2012short.csv");
		
		//2013 short file
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2013short.csv");
		
		//2014 short file
		//FileResource fr = new FileResource("resources/course2/week4/us_babynames/us_babynames_test/yob2014short.csv");
		
		totalBirths(fr);
	}
	
	
/******************************************************************************************************************************/	
}