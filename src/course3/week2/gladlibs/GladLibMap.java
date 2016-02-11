package course3.week2.gladlibs;

import edu.duke.*;
import java.util.*;

public class GladLibMap {
	
	private HashMap<String, ArrayList<String>> myMap;
	private ArrayList<String> usedWords;
	private ArrayList<String> usedCategories;
	
	private Random myRandom;
	
	//private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "resources/course3/week2/GladLib/data";
	
	public static void main(String[] args){
		
		GladLibMap myObj = new GladLibMap();
		myObj.makeStory();
		
	}
	
	public GladLibMap(){
		myMap = new HashMap<String, ArrayList<String>>();
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
		usedWords = new ArrayList<>();
		usedCategories = new ArrayList<>();
	}
	
	public GladLibMap(String source){
		myMap = new HashMap<String, ArrayList<String>>();
		initializeFromSource(source);
		myRandom = new Random();
		usedWords = new ArrayList<>();
		usedCategories = new ArrayList<>();
	}
	
	private void initializeFromSource(String source) {
		
		String[] lables = {"adjective","noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
		for (String categorie: lables){
			ArrayList<String> list = readIt(source+"/"+categorie+".txt");
			myMap.put(categorie, list);
		}
	}
	
	private String randomFrom(ArrayList<String> source){
		
		int index = 0;
		for (int i=0; i< source.size();i++){
			index = myRandom.nextInt(source.size());
			if(usedWords.contains(source.get(index))){
				source.get(index);
				usedWords.add(source.get(index));
				i++;
			}
			else if (! usedWords.contains(source.get(index))){
				usedWords.add(source.get(index));
				i = source.size();
			}	
		}
		return source.get(index);
	}
	
	private String getSubstitute(String label) {
		
		if (label.equals("number")){
			return ""+myRandom.nextInt(50)+5;
		}
		else if (myMap.containsKey(label)){
			if(!usedCategories.contains(label)){
				usedCategories.add(label);
			}
			return randomFrom(myMap.get(label));
		}else{
			return "**UNKNOWN**";
		}
	}
	
	private String processWord(String w){
		int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if (first == -1 || last == -1){
			return w;
		}
		String prefix = w.substring(0,first);
		String suffix = w.substring(last+1);
		String sub = getSubstitute(w.substring(first+1,last));
		return prefix+sub+suffix;
	}
	
	private int printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
		return charsWritten;
	}
	
	private String fromTemplate(String source){
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	
	public int totalWordsInMap(){
		
		int totalWords = 0;
		for(String key : myMap.keySet()){
			ArrayList<String> temp = myMap.get(key);
			int alTotal = temp.size();
			totalWords += alTotal;
		}
		return totalWords;
	}
	
	public void totalWordsConsidered(){
		
		System.out.print("These categorie were used: ");
		for (String str: usedCategories){
			System.out.print(str+" ");
		}
		System.out.println("\n");
	}
	
	public void makeStory(){
		
		usedWords.clear();
	    System.out.println("\n");
		String story = fromTemplate("resources/course3/week2/GladLib/data/madtemplate2.txt");
		printOut(story, 60);
		System.out.println("");
		System.out.println("");
		
		int totalNumOfWordsInMap = totalWordsInMap();
		System.out.println("Total number of words that could have been used is "+totalNumOfWordsInMap+". ");
		System.out.println("");
		
		
		totalWordsConsidered();
		
		
		System.out.println("Total number of words used is "+usedWords.size()+". ");
		for (int i=0; i<usedWords.size();i++){
			System.out.print(usedWords.get(i)+", ");
		}
	}

}
