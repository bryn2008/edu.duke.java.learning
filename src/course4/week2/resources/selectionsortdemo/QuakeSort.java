package course4.week2.resources.selectionsortdemo;

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
	
	
	public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
        QuakeEntry min = quakes.get(0);
        for(QuakeEntry q: quakes) {
            if (q.getMagnitude() < min.getMagnitude()) {
                min = q;
            }
        }
        return min;
    }
    
    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {

        ArrayList<QuakeEntry> out = new ArrayList<>();
        while(!in.isEmpty()){
        	QuakeEntry minElement = getSmallestMagnitude(in);
        	in.remove(minElement);
        	out.add(minElement);
        }
    	return out;
    }
    /* tester method to use in BlueJ */
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = filePath + "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        list = sortByMagnitude(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }

}
