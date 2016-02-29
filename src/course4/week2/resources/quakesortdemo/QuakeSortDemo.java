package course4.week2.resources.quakesortdemo;

/**
 * Illustrate sorting
 * @author Duke Software 
 * @version 1.0
 */
//import edu.duke.*;
import java.util.*;

public class QuakeSortDemo {
	
	private String filePath = "src/course4/week2/resources/quakesortdemo/";
    
	public QuakeSortDemo(){
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
	}
	
    public static void main(String[] args){
    	QuakeSortDemo myObj = new QuakeSortDemo();
    	myObj.testSort();
    }
	
	public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = filePath + "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
}
