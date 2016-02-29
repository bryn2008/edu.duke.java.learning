package course4.week2.sort;

/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class QuakeSortInPlace {
	
	private String filePath = "src/course4/week2/sort/";
	
	public QuakeSortInPlace(){
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
	}
	
	public static void main(String[] args){
		QuakeSortInPlace myObj = new QuakeSortInPlace();
		myObj.testSort();
	}
	
	public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
		
		//simuler to sort by magnitude
		int brokeAt = 0;
		for (int i=0; i< in.size(); i++) {
            if (checkInSortOrder(in) == false){
            	int minIdx = getSmallestMagnitude(in,i);
            	QuakeEntry qi = in.get(i);
            	QuakeEntry qmin = in.get(minIdx);
            	in.set(i,qmin);
            	in.set(minIdx,qi);
            	brokeAt = i + 1;
            }else{
            	break;
            }
        }
		System.out.println("Broke at " + brokeAt + " passes");
	}
	
	public boolean checkInSortOrder(ArrayList<QuakeEntry> quakes){
		//loops through the array checking the number adjacent to see if it is higher and if so, returns false, else if not it returns true as the list is sorted
		for(int i=0; i<quakes.size(); i++){
			if (i == quakes.size()-1){
				return true;
			}
			else{
				if(quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()){
					return false;
				}
			}
		}
		return true;
	}
	
	public void sortByMagnitudeWithBubbleSortCheck(ArrayList<QuakeEntry> in){
		//sorts the array list of quakes into order and checks 
		//if array list .size() then onePassBubble() should be called less that .size()-1
		//this method should call checkInSortOrder() and stop earily if the arraylist is sorted, perhaps a while loop here? or for loop
		int brokeAt = 0;
		for (int i=0; i< in.size(); i++) {
			int minIdx = onePassBubbleSort(in,i);
			if(checkInSortOrder(in) == false){
				QuakeEntry qi = in.get(i);
				QuakeEntry qmin = in.get(minIdx);
				in.set(i,qmin);
				in.set(minIdx,qi);
				brokeAt = i + 1;
			}else{
				break;
			}
        }
		System.out.println("Broke at " + brokeAt + " passes");
	}
	
	public int onePassBubbleSort(ArrayList<QuakeEntry> quakes, int numSorted){
		int minIdx = numSorted;
        for (int i=numSorted+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
	}
	
	public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
		
		for (QuakeEntry qe: in) { 
            System.out.println(qe);
        } 
		for (int i=0; i< in.size(); i++) {
            int minIdx = onePassBubbleSort(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            System.out.println("Printing Quakes after pass" + (i+1));
            for (QuakeEntry qe: in) { 
                System.out.println(qe);
            } 
        }
		System.out.println("Earthquakes in sorted order");
	}
	
	
	public int getLargestDepth(ArrayList<QuakeEntry> quakes, int from ){
		int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getDepth() < quakes.get(minIdx).getDepth()) {
                minIdx = i;
            }
        }
        return minIdx;
	}
	
	public void sortByLargestDepth(ArrayList<QuakeEntry> in){
		
		for (int i=0; i< in.size(); i++) {
            int minIdx = getLargestDepth(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
		
	}
	
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = filePath + "data/nov20quakedatasmall.atom";
        String source = filePath + "data/earthquakeDataSampleSix1 .atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
        
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitudeWithCheck(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        }
        
        /*System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitudeWithBubbleSortCheck(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        }*/
        
        /*System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitudeWithBubbleSort(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        }*/
        
        /*System.out.println("read data for "+list.size()+" quakes");    
        sortByLargestDepth(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } */
        
        /*System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitude(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } */
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = filePath + "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
}
