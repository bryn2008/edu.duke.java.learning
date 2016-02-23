package course4.week1.earthquakeclient;

import java.util.*;

public class LargestQuake {
	
	private String filePath = "src/course4/week1/earthquakeclient/";
	//private String url = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
	
	private LargestQuake(){
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk");
		System.setProperty("http.proxyPort", "8080");
	}
	
	public static void main(String[] args){
		LargestQuake lq = new LargestQuake();
		//lq.findLargestQuake();
		lq.findLargestQuakes();
	}
	
	public int indexOfLargest(ArrayList<QuakeEntry> data){
		
		int answer = 0;
		double lagestQuake = 0;
		for (QuakeEntry qe : data) {
			if (qe.getMagnitude() > lagestQuake) {
				System.out.println(qe.getMagnitude());
				lagestQuake = qe.getMagnitude();
				answer = data.indexOf(qe);
			}
		}
		return answer;
	}
	
	public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
		
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		double mag = 0;
		for (QuakeEntry qe : quakeData) {
			if (qe.getMagnitude() > mag) {
				answer.add(qe);
			}
		}
		//get only the top 5
		System.out.println(howMany);
		//sort in order of magnitude
		
		return answer;
	}
	
	public void findLargestQuake(){
		
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = filePath + "data/nov20quakedatasmall.atom";
		// String source = url;
		ArrayList<QuakeEntry> list = parser.read(source);
		/*for (int k = 0; k < list.size(); k++) {
			QuakeEntry entry = list.get(k);
			System.out.println(entry.toString());
		}*/
		System.out.println("read data for " + list.size() + " quakes.");
		int dexOfLargestQuake = indexOfLargest(list);
		System.out.println("the index is " + dexOfLargestQuake + " and the details are " + list.get(dexOfLargestQuake));
		
	}	
		
	public void findLargestQuakes(){	
		
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = filePath + "data/nov20quakedatasmall.atom";
		// String source = url;
		ArrayList<QuakeEntry> list = parser.read(source);
		int howMany = 5;
		ArrayList<QuakeEntry> qe = getLargest(list, howMany);
		for (int k = 0; k < qe.size(); k++) {
			QuakeEntry entry = qe.get(k);
			System.out.println(entry.toString());
		}
		
	}
	
}
