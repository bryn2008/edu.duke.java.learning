package course3.week2.gladlibs;

import java.util.HashMap;

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
	
	public void buildCodonMap(int start, String dna){
		
		dnaCodons.clear();
		
		//Build new map of codons mapped to their counts
		
	}
	
	public String getMostCommonCodon(){
		
		String str = "Return a string og the most common codon";
		return str;
	}
	
	public void printCodonCounts(int start, int end){
		
		//prints all the codons in the HashMap if there count is inclusive of the start and end
		
	}
	
	public void tester(){
		
		FileResource fr = new FileResource("ProgrammingImprovingGladLibsData/smalldna.txt");
		String dna = fr.asString().toUpperCase();
		int start = 0;
		buildCodonMap(start, dna);
		
	}
	
}
