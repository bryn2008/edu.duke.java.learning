package course3.week3.uniqueipaddresses;

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

}
