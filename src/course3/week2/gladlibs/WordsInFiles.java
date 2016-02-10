package course3.week2.gladlibs;

import java.io.File;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashMap;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFiles {
	
	private HashMap<String, ArrayList<String>> myMap = new HashMap<>();
	//private HashMap<String, Integer> words = new HashMap<>();
	
	public WordsInFiles(){
		
		//ßwords = new HashMap<>();
		
	}
	
	public static void main(String[] args){
		
		WordsInFiles myObj = new WordsInFiles();
		myObj.tester();
	}
	
	private void addWordsFromFile(File f){
		
		FileResource fr = new FileResource(f);
		String file= fr.asString();
		String filename = f.getName().substring(0, (int)(f.getName().length()-4));;
		for(String word : file.split("\\s+")){
			if(myMap.containsKey(word)){
				ArrayList<String> tempArrayList = myMap.get(word);
				tempArrayList.add(filename );
				myMap.put(word, tempArrayList);
			} else {
				ArrayList<String> tempArrayList = new ArrayList<String>();
				tempArrayList.add(filename);
				myMap.put(word, tempArrayList);
			}
		}
	}
	
	public void buildWordFileMap(){
		
		myMap.clear();
		DirectoryResource dr = new DirectoryResource();
		for(File f: dr.selectedFiles()){
			addWordsFromFile(f);
		}
		
		int maxNumberOfFiles = maxNumber();
		System.out.println("The maximum number of files that any word appears in, is: "+maxNumberOfFiles);
		
		int number = 3;
		ArrayList<String> words = wordsInNumFile(number);
		System.out.print("The words in "+ number +" files  is: ");
		for(int i=0;i<words.size();i++){
			System.out.print(words.get(i)+" ");
		}
		
		printFileIn("cats");
		printMap();
	}
	
	public int maxNumber(){
		
		int maxValueInWords = 0;
		for (String key : myMap.keySet()){
			int currentSize = myMap.get(key).size();
			if (currentSize > maxValueInWords){
				maxValueInWords = currentSize;
			}
		}
		return maxValueInWords;
	}
	
	public ArrayList<String> wordsInNumFile(int number){
		
		//this method returns the words that appear in a number of files. 
		// i.e. 3 would return "cats" + "and"
		
		ArrayList<String> tempArrayList = new ArrayList<>();
		for (String key : myMap.keySet()){
			int currentSize = myMap.get(key).size();
			if (currentSize == number){
				tempArrayList.add(key);
			}
		}
		//System.out.print("The temp arraylist is: "+tempArrayList);
		return tempArrayList;
	}
	
	public void printFileIn(String word){
		
		System.out.println("\nThe \"printFileIn\" method, for \"" + word + "\"");
		for (String key: myMap.keySet()) {
			if (key.equals(word)){
				for (String elem: myMap.get(key)){
					System.out.println(elem);
				}
			}
		}
	}
	
	public void printMap(){
		
		System.out.println("");
		for (String key: myMap.keySet()) {
			System.out.print(key + ": ");
			for (String elem: myMap.get(key)){
				System.out.print(elem + ", ");
			}
			System.out.println();
		}
		
	}
	
	public void tester(){
		
		buildWordFileMap();
		
	}

}
