package course3.week2.randomstory;

import java.util.ArrayList;

import edu.duke.FileResource;

public class WordFrequencies {

	private ArrayList<String> myWords;
	private ArrayList<Integer> myFraqs;

	public WordFrequencies() {
		
		myWords = new ArrayList<String>();
		myFraqs = new ArrayList<Integer>();
		
	}
		
	public static void main(String[] args) {
		
		WordFrequencies myObj = new WordFrequencies();
		myObj.tester();
	}

	public void findUnique() {

		myFraqs.clear();
		myWords.clear();
		
		FileResource fr = new FileResource("QuizGladLibsData/errors.txt");
		String input = fr.asString().toLowerCase();
		
		String[] tempWords = input.toLowerCase().split("\\s+");
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

	public int findIndexOfMax() {

		int maxCount = 0;
		for (int c : myFraqs) {
			if (c > maxCount) {
				maxCount = c;
			}
		}
		int maxDex = 0;
		for (int i = 0; i < myFraqs.size(); i++) {
			int tempDex = maxDex;
			if (myFraqs.get(i) == maxCount) {
				maxDex = i;
				if (!(maxCount > myFraqs.get(i))){
					maxCount = tempDex;
				}
			}
		}
		return maxDex;
	}

	public void tester() {

		findUnique();
		System.out.println("The number of unuiqe words are: "+myWords.size());
		for (int i =0; i<myWords.size();i++){
			System.out.println(myFraqs.get(i)+" "+myWords.get(i));
		}
		
		//first word should be "a"
		int maxDex = findIndexOfMax();
		System.out.println("The word that occurs most offten and its count are: "+myWords.get(maxDex)+" "+myFraqs.get(maxDex));
	}

}