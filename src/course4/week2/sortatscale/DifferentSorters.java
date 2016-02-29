package course4.week2.sortatscale;

/**
 * Write a description of class DifferentSorters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class DifferentSorters {
	
	private String filePath = "src/course4/week2/sortatscale/";
	
	public DifferentSorters(){
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
	}
	
	public static void main(String[] args){
		DifferentSorters myObj = new DifferentSorters();
		//myObj.sortWithCompareTo();
		myObj.sortByTitleAndDepth();
	}
	
	public void sortByTitleAndDepth(){
		EarthQuakeParser parser = new EarthQuakeParser();
        String source = filePath + "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //Collections.sort(list, new MagnitudeComparator());
        Collections.sort(list, new TitleAndDepthComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.print(list.get(quakeNumber));
	}
	
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = filePath + "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.print(list.get(quakeNumber));
    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = filePath + "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = filePath + "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
}
