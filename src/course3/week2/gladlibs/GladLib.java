package course3.week2.gladlibs;

import edu.duke.*;
import java.util.*;

public class GladLib {
	
	private ArrayList<String> adjectiveList;
	private ArrayList<String> nounList;
	private ArrayList<String> colorList;
	private ArrayList<String> countryList;
	private ArrayList<String> nameList;
	private ArrayList<String> animalList;
	private ArrayList<String> timeList;
	private ArrayList<String> verb;
	private ArrayList<String> fruit;
	private ArrayList<String> usedWords;
	
	private Random myRandom;
	
	//private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "resources/course3/week2/GladLib/data";
	
	public static void main(String[] args){
		
		GladLib myObj = new GladLib();
		myObj.makeStory();
		
	}
	
	public GladLib(){
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
		usedWords = new ArrayList<>();
	}
	
	public GladLib(String source){
		initializeFromSource(source);
		myRandom = new Random();
		usedWords = new ArrayList<>();
	}
	
	private void initializeFromSource(String source) {
		adjectiveList= readIt(source+"/adjective.txt");	
		nounList = readIt(source+"/noun.txt");
		colorList = readIt(source+"/color.txt");
		countryList = readIt(source+"/country.txt");
		nameList = readIt(source+"/name.txt");		
		animalList = readIt(source+"/animal.txt");
		timeList = readIt(source+"/timeframe.txt");
		verb = readIt(source+"/verb.txt");
		fruit = readIt(source+"/fruit.txt");
	}
	
	private String randomFrom(ArrayList<String> source){
		
		//this is where the word is selected
		//loop through to pick a new word every time
		int index = 0;
		for (int i=0; i< source.size();i++){
			
			index = myRandom.nextInt(source.size());
			//System.out.println(" >> "+source.get(index));
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
		if (label.equals("country")) {
			return randomFrom(countryList);
		}
		if (label.equals("color")){
			return randomFrom(colorList);
		}
		if (label.equals("noun")){
			return randomFrom(nounList);
		}
		if (label.equals("name")){
			return randomFrom(nameList);
		}
		if (label.equals("adjective")){
			return randomFrom(adjectiveList);
		}
		if (label.equals("animal")){
			return randomFrom(animalList);
		}
		if (label.equals("timeframe")){
			return randomFrom(timeList);
		}
		if (label.equals("verb")){
			return randomFrom(verb);
		}
		if (label.equals("fruit")){
			return randomFrom(fruit);
		}
		if (label.equals("number")){
			return ""+myRandom.nextInt(50)+5;
		}
		return "**UNKNOWN**";
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
		//System.out.println(" ");
		//System.out.println(sub);
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
	
	public void makeStory(){
		//should make sure array list is cleared out before each run in make story
		usedWords.clear();
	    System.out.println("\n");
		String story = fromTemplate("resources/course3/week2/GladLib/data/madtemplate2.txt");
		printOut(story, 60);
		System.out.println("");
		System.out.println("");
		System.out.println("Total number of words used is "+usedWords.size()+". ");
		for (int i=0; i<usedWords.size();i++){
			System.out.print(usedWords.get(i)+", ");
		}
	}
	


}
