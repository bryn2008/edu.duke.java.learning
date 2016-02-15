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
		myObj.testLogAnalyzer();
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
}
