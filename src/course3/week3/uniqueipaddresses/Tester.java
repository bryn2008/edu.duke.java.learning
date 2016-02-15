package course3.week3.uniqueipaddresses;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester {
	
	public static void main(String[] args){
		
		Tester myObj = new Tester(); 
		//myObj.testLogAnalyzer();
		//myObj.testUniqueIPs();
		myObj.testPrintAllHigherThanNum();
		myObj.testUniqueIPVisitsOnDay();
		myObj.testCountUniqueIPsInRange();
	}
	
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
    	
    	testLogEntry();
    	
    	LogAnalyzer la = new LogAnalyzer();
    	String filename = "ProgrammingWebServerLogs/short-test_log";
    	la.readFile(filename);
    	la.printAll();
    }
    
    public void testUniqueIPs() {
    	
    	LogAnalyzer la = new LogAnalyzer();
    	String filename = "ProgrammingWebServerLogs/short-test_log";
    	la.readFile(filename);
    	int uniqueIPs = la.countUniqueIPs();
    	System.out.println("There are "+uniqueIPs+" unique IPs");
    }
    
    public void testPrintAllHigherThanNum() {
    	
    	LogAnalyzer la = new LogAnalyzer();
    	String filename = "ProgrammingWebServerLogs/weblog1_log";
    	la.readFile(filename);
    	/*int statusCode = 300;
    	System.out.println("All addresses with a status code higher that \""+statusCode+"\" are:");
    	la.printAllHigherThanNum(statusCode);*/
    	
    	int statusCode = 400;
    	System.out.println("All addresses with a status code higher that \""+statusCode+"\" are:");
    	la.printAllHigherThanNum(statusCode);
    }
    
    public void testUniqueIPVisitsOnDay() {
    	
    	LogAnalyzer la = new LogAnalyzer();
    	String filename = "ProgrammingWebServerLogs/weblog1_log";
    	la.readFile(filename);
    	//la.printAll();
    	//String dayOne = "Sep 14";
    	//String dayTwo = "Sep 30";
    	//ArrayList<String> al1 = la.uniqueIPVisitsOnDay(dayOne);
    	//ArrayList<String> al2 = la.uniqueIPVisitsOnDay(dayTwo);
    	//System.out.println("ArrayList 1, two items = "+al1);
    	//System.out.println("Arraylist 2, three items = "+al2);
    	//System.out.println("The number of unique IP visits for "+ dayOne +" is "+al1.size()+".");
    	//System.out.println("The number of unique IP visits for "+ dayTwo +" is "+al2.size()+".");
    	
    	String dayOne = "Mar 24";
    	ArrayList<String> al1 = la.uniqueIPVisitsOnDay(dayOne);
    	System.out.println("The number of unique IP visits for "+ dayOne +" is "+al1.size()+".");
    }
    
    public void testCountUniqueIPsInRange() {
    	
    	LogAnalyzer la = new LogAnalyzer();
    	String filename = "ProgrammingWebServerLogs/weblog1_log";
    	la.readFile(filename);
    	//la.printAll();
    	
    	int low = 200; 
    	int high = 299;
    	int total = la.countUniqueIPsInRange(low, high);
    	System.out.println("The total number of unique IP Addresses with a status code between " + low + " and " + high + " is " + total +"\n");
    	
    	/*int lowTwo = 300; 
    	int highTwo = 399;
    	int totalTwo = la.countUniqueIPsInRange(lowTwo, highTwo);
    	System.out.println("The total number of unique IP Addresses with a status code between " + lowTwo + " and " + highTwo + " is " + totalTwo);*/
    } 

}
