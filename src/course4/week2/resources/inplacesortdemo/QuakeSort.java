package course4.week2.resources.inplacesortdemo;

import java.util.*;

public class QuakeSort {
	
	private String filePath = "src/course4/week2/resources/selectionsortdemo/";
	
	public QuakeSort(){
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
	}
	
	public static void main(String[] args){
		QuakeSort qs = new QuakeSort();
		qs.testSort();
	}
	
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i = from +1; i < quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
    	for (int i=0; i<in.size(); i++){
    		int minDex = getSmallestMagnitude(in, i);
    		QuakeEntry qi = in.get(i);
    		QuakeEntry qmin = in.get(minDex);
    		in.set(i, qmin);
    		in.set(minDex, qi);
    	}
    }

    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = filePath + "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        sortByMagnitude(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    
}
