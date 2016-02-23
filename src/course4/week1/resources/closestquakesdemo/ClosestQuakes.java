package course4.week1.resources.closestquakesdemo;

/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class ClosestQuakes {
	
	private String filePath = "src/course4/week1/resources/closestquakesdemo/";
	
	public ClosestQuakes(){
		
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
        
	}
	
	public static void main(String[] args){
		
		ClosestQuakes cq = new ClosestQuakes();
		cq.findClosestQuakes();
		
	}
	
	public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
		ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
		for(int j=0; j < howMany; j++){
			int minIndex = 0;
			for (int k =1; k < copy.size(); k++){
				QuakeEntry quake = copy.get(k);
				Location loc = quake.getLocation();
				if(loc.distanceTo(current) < copy.get(minIndex).getLocation().distanceTo(current)){
					minIndex = k;
				}
			}
			ret.add(copy.get(minIndex));
			copy.remove(minIndex);
		}
		return ret;
	}

	public void findClosestQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = filePath + "data/nov20quakedata.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size());

		Location jakarta = new Location(-6.211, 106.845);

		ArrayList<QuakeEntry> close = getClosest(list, jakarta, 10);
		for (int k = 0; k < close.size(); k++) {
			QuakeEntry entry = close.get(k);
			double distanceInMeters = jakarta.distanceTo(entry.getLocation());
			System.out.printf("%4.2f\t %s\n", distanceInMeters / 1000, entry);
		}
		System.out.println("number found: " + close.size());
	}
}
