package course3.week3.webserverlog;

/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
    	 
    	 records = new ArrayList<LogEntry>();
    	 
     }
        
     public void readFile(String filename) {
    	 
    	 FileResource fr = new FileResource(filename);
    	 for (String currentLine: fr.lines()){
    		 LogEntry newLogEntry = WebLogParser.parseEntry(currentLine);
    		 records.add(newLogEntry);
    	 }
    	 
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
}
