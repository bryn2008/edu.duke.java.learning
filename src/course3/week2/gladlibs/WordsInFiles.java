package course3.week2.gladlibs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFiles {
	
	private HashMap<String, ArrayList<String>> myMap;
	
	public WordsInFiles(){
		
		myMap = new HashMap<>();
		
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
		
		int number = 4;
		int totalNumOfWords = 0;
		ArrayList<String> words = wordsInNumFile(number);
		
		System.out.println(" ");
		System.out.print("The words in "+ number +" files  is: ");
		for(int i=0;i<words.size();i++){
			System.out.print(words.get(i)+" ");
			totalNumOfWords++;
		}
		System.out.println(" ");
		System.out.println("The total number of wors that appear in "+number+" of the selected files is "+ totalNumOfWords+". ");
		
		System.out.println(" ");
		String word = "laid";
		System.out.println("The \"printFileIn\" method, for \"" + word + "\"");
		printFileIn(word);
		
		System.out.println(" ");
		String wordTwo = "tree";
		System.out.println("The \"printFileIn\" method, for \"" + wordTwo + "\"");
		printFileIn(wordTwo);
		
		
		System.out.println(" ");
		System.out.print("The words in "+ number +" files  is: ");
		for(int i=0;i<words.size();i++){
			System.out.print(words.get(i)+" ");
		}
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.print("The complete map is:");
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
		
		ArrayList<String> tempArrayList = new ArrayList<>();
		for (String key : myMap.keySet()){
			int currentSize = myMap.get(key).size();
			if (currentSize == number){
				tempArrayList.add(key);
			}
		}
		return tempArrayList;
	}
	
	public void printFileIn(String word){
		
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