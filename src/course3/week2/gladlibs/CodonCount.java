package course3.week2.gladlibs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import edu.duke.FileResource;

public class CodonCount {
	
	private HashMap<String, Integer> dnaCodons;
	
	public CodonCount(){
		
		dnaCodons = new HashMap<>();
		
	}
	
	public static void main(String[] args){
		
		CodonCount myObj = new CodonCount();
		myObj.tester();
		
	}
	
	/* Write a void method named buildCodonMap that has two parameters, an int named start and a String named dna. 
	 * This method will build a new map of codons mapped to their counts from the string dna with the reading frame with the position start (a value of 0, 1, or 2). 
	 * You will call this method several times, so be sure to make your map is empty before building it.
	*/
	public void buildCodonMap(int start, String dna){
		
		dnaCodons.clear();
		dna = dna.substring(start).toUpperCase().trim();
		for (int i=0; i<=dna.length()-3;i++){
			String newCodon = dna.substring(i, i+3);
			if(dnaCodons.containsKey(newCodon)){
				int count = dnaCodons.get(newCodon).intValue();
				dnaCodons.put(newCodon, count+1);
				i+=2;
			}else{
				dnaCodons.put(newCodon, 0);
				int count = dnaCodons.get(newCodon).intValue();
				dnaCodons.put(newCodon, count+1);
				i+=2;
			}
		}
	}
	
	public String getMostCommonCodon(){
		
		String mostCommonCodon = null;
        int maxValueInMap=(Collections.max(dnaCodons.values()));  // This will return max value in the HashMap
        for (Entry<String, Integer> entry : dnaCodons.entrySet()) {  // Iterate through hashMap
            if (entry.getValue()==maxValueInMap) {
                //System.out.println(entry.getKey());     // Print the key with max value
                mostCommonCodon = entry.getKey();
            }
        }
		return mostCommonCodon;
	}
	
	public void printCodonCounts(int start, int end){
		
		for (String name: dnaCodons.keySet()){
            String key =name.toString();
            int value = dnaCodons.get(name);  
            if (value >= start && value <= end){
            	System.out.println(key + " " + value);
            }
        } 
	}
	
	public void tester(){
		
		FileResource fr = new FileResource("ProgrammingImprovingGladLibsData/smalldna.txt");
		String dna = fr.asString().toUpperCase();
		
		int startFrame = 3;
		
		for(int i=0; i<startFrame;i++){
			buildCodonMap(i, dna);
			System.out.println("Reading frame starting with " + i + " results in " + dnaCodons.size() + " unique codons");
			String mostCommonCodon = getMostCommonCodon();
			System.out.println("  and most common codon is " + mostCommonCodon + " with " + "count " + dnaCodons.get(mostCommonCodon).intValue());
			int start = 1; 
			int end = 5;
			System.out.println("Counts of codons between " + start + " and " + end + " inclusive are:");
			printCodonCounts(start, end);
			System.out.println(" ");
		}
	}
	
}
