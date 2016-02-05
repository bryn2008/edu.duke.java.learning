package course3.week2.randomstory;

import java.util.ArrayList;

import edu.duke.FileResource;

public class WordFrequencies {

	private ArrayList<String> myWords = new ArrayList<String>();
	private ArrayList<Integer> myFraqs = new ArrayList<Integer>();

	public WordFrequencies(String input) {
		
		String[] tempWords = input.split("\\s+");
		for (String tempWord: tempWords) {
			if (! myWords.contains(tempWord)){
				myWords.add(tempWord);
				myFraqs.add(0);
			}
		}
		for (String tempWord: tempWords) {
			int wordDex = myWords.indexOf(tempWord);
			int currVal = myFraqs.get(wordDex);
			currVal++;
			myFraqs.set(wordDex, currVal);
		}
	}
		
	public static void main(String[] args) {
		
		FileResource fr = new FileResource("ProgrammingRandomStoryData/testwordfreqs.txt");
		WordFrequencies myObj = new WordFrequencies(fr.asString());
		myObj.tester();
	}

	public void findUnique() {

		//myFraqs.clear();
		//myWords.clear();

	}

	public int findIndexOfMax() {

		int max = 0;
		for (int c : myFraqs) {
			if (c > max) {
				max = c;
			}
		}
		int cIndex = 0;
		for (int i = 0; i < myFraqs.size(); i++) {
			if (myFraqs.get(i) == max) {
				cIndex = i;
			}
		}
		return cIndex;
	}

	public void tester() {

		findUnique();
		System.out.println("The number of unuiqe words are: "+myWords.size());
		for (int i =0; i<myWords.size();i++){
			System.out.println(myFraqs.get(i)+" "+myWords.get(i));
		}

		int maxDex = findIndexOfMax();
		System.out.println("The word that occurs most offten and its count are: "+myWords.get(maxDex)+" "+maxDex);
	}

}