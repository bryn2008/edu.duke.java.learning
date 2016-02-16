package course3.week3.websitevisits;

/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

import edu.duke.*;

public class LogAnalyzer {
	private ArrayList<LogEntry> records;

	public LogAnalyzer() {

		records = new ArrayList<LogEntry>();

	}

	public void readFile(String filename) {

		FileResource fr = new FileResource(filename);
		for (String currentLine : fr.lines()) {
			LogEntry newLogEntry = WebLogParser.parseEntry(currentLine);
			records.add(newLogEntry);
		}

	}

	public int countUniqueIPs() {

		ArrayList<String> UniqueIPs = new ArrayList<String>();
		for (LogEntry le : records) {
			String ipAddress = le.getIpAddress();
			if (!UniqueIPs.contains(ipAddress)) {
				UniqueIPs.add(ipAddress);
			}
		}
		return UniqueIPs.size();
	}
	
	public void printAllHigherThanNum(int num) {
		for (LogEntry le : records) {
			if (le.getStatusCode() > num){
				System.out.println(le);
			}
		}
	}
	
	public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
		
		ArrayList<String> UniqueIPs = new ArrayList<String>();
		ArrayList<String> UniqueIPsOnADay = new ArrayList<String>();
		for (LogEntry le : records) {
			String ipAddress = le.getIpAddress();
			if(le.getAccessTime().toString().substring(4, 10).equals(someday)){
				if (!UniqueIPs.contains(ipAddress)) {
					UniqueIPsOnADay.add(ipAddress);
					UniqueIPs.add(ipAddress);
				}
			}
		}
		return UniqueIPsOnADay;
		
	}
	
	public int countUniqueIPsInRange(int low, int high){
		
		ArrayList<String> UniqueIPsInRange = new ArrayList<String>();
		for (LogEntry le : records) {
			String ipAddress = le.getIpAddress();
			int statusCode =  le.getStatusCode();
			if (!UniqueIPsInRange.contains(ipAddress)) {
				if (statusCode >= low && statusCode <= high){
					//System.out.println(le);
					UniqueIPsInRange.add(ipAddress);
				}
			}
		}
		return UniqueIPsInRange.size();
	}
	
	public void printAll() {
		for (LogEntry le : records) {
			System.out.println(le);
		}
	}
	
	public HashMap<String, Integer> countVisitsPerIP(){
		
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		for (LogEntry le : records) {
			String ipAddress = le.getIpAddress();
			if (!counts.containsKey(ipAddress)) {
					counts.put(ipAddress, 1);
			}else{
				counts.put(ipAddress, counts.get(ipAddress)+1);
			}
		}
		return counts;
	}
	
	public int mostNumberVisitsByIP(HashMap<String, Integer> counts ){
		
		int highestIPCount = Collections.max(counts.values());
		return highestIPCount;
	}
	
	public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
		
		ArrayList<String> iPsWithMostVists = new ArrayList<String>();
		int highestIPCount = mostNumberVisitsByIP(counts);
		//for loop through the array values
		for (String key : counts.keySet()) {
		    int currIPcount = counts.get(key).intValue();
		    if (currIPcount == highestIPCount){
		    	iPsWithMostVists.add(key);
		    }
		}
		return iPsWithMostVists;
	}
	
	public HashMap<String, ArrayList<String>> iPsForDays(){
		
		HashMap<String, ArrayList<String>> iPsOnDays = new HashMap<String, ArrayList<String>>();
		
		for (LogEntry le : records) {
			String day = le.getAccessTime().toString().substring(4, 10);
			ArrayList<String> tempIPList = new ArrayList<String>();
			for (LogEntry logEntries: records){
				String currDay = logEntries.getAccessTime().toString().substring(4, 10);
				String currIpAddress = logEntries.getIpAddress();
				if(day.equals(currDay)){
					tempIPList.add(currIpAddress);
				}
			}
			iPsOnDays.put(day, tempIPList);
		}
		return iPsOnDays;
	}
	
	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> iPsOnDays){
		
		int maxIPVisits = 0;
		String day = null;
		for(String key : iPsOnDays.keySet()) {
			   //System.out.println("The date is " + key + " and the num of ip visits is " + iPsOnDays.get(key).size());
			   if (maxIPVisits < iPsOnDays.get(key).size()){
				   maxIPVisits = iPsOnDays.get(key).size();
				   day = key;
			   }
		}
		return day;
		
	}
	
	public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> iPsOnDays , String day){
		
		HashMap<String, Integer> counts = new HashMap<>();
		for (String ip : iPsOnDays.get(day)){
			if(!counts.containsKey(ip)){
				counts.put(ip, 1);
			}else{
				counts.put(ip, counts.get(ip).intValue()+1);
			}
			
		}
		ArrayList<String>iPsWithMostVists = iPsMostVisits(counts);
		return iPsWithMostVists;
		
	}

}
