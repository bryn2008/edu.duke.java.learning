package course3.week2.gladlibs;

import java.util.HashMap;

import edu.duke.FileResource;

public class CodonCount {
	
	private HashMap dnaCodons;
	
	public CodonCount(){
		
		dnaCodons = new HashMap();
		
	}
	
	public static void main(String[] args){
		
		CodonCount myObj = new CodonCount();
		myObj.tester();
		
	}
	
	public void buildCodonMap(int start, String dna){
		
		//Build new map
		
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
		
	}
	
}
