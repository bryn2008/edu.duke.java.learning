package course3.week1;

import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.FileResource;

public class WordLengths {

	public static void main (String [] args){
		
		WordLengths myObj = new WordLengths();
		myObj.testCountWordLength();
	}
	
	public void countWordLength (FileResource fr){
		
		//TO DO CODE
		
		String resource = fr.asString();
		System.out.println("resource: " + resource);
		
		ArrayList<String> counts = new ArrayList<String>();
		ArrayList<Integer> countsOfWords = new ArrayList<Integer>();
		HashMap<Integer, String> wordMap = new HashMap<Integer, String>();
		wordMap.put("foo".hashCode(), "bar");
		
		for(String word : resource.split("\\s")) {
			word = word.replaceAll("[+.^:,]","");
			counts.add(word);
			//System.out.println(word);
		}
		//System.out.println(counts);
		System.out.println("The size of the arraylist is: " + counts.size());
		
		int cw = 0;
		for (int i =0; i < counts.size(); i++){
			String currentWord = counts.get(i);
			cw = currentWord.length();
			System.out.println(currentWord.length() + " " + counts.get(i));
			countsOfWords.add(currentWord.length());
			wordMap.put(cw, currentWord);
		}
		
		System.out.print(countsOfWords);
		System.out.println(counts);
		
		System.out.println(">>" +wordMap);
		
		indexOfMax();
		
	}
	
	public void testCountWordLength (){
		
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/smallHamlet.txt");
		//System.out.println(fr.asString());
		//CALL THE METHOD
		countWordLength(fr);
		
	}
	
	public void indexOfMax (){
		//this method should return 3
		
		
		
		
	}
	
}