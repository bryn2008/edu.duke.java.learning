package course4.week3.markovwordgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class EfficientMarkovWord implements IMarkovModel {

	private String[] myText;
	private Random myRandom;
	private int myOrder;
	private HashMap<Integer, ArrayList<String[]>> followsMap;

	public EfficientMarkovWord(int myOrderNum) {
		myOrder = myOrderNum;
		myRandom = new Random();
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String text) {
		myText = text.split("\\s+");
		buildMap();
	}

	// "this is a test yes this is really a test yes a test this is wow"
	// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	
	// {"a", "really", "wow"}
	// 2 7 15
	
	private int indexOf(String[] words, WordGram target, int start) {
		
		int wgSize = target.length();
		WordGram buffer = null;
		String[] tempWordGramBuffer = new String[wgSize];
		int i = 0;
		for (int k = start; k < words.length + wgSize; k++) {
			if (i < wgSize && buffer == null) {
				if ( k >= words.length){
					return -1;
				}
				tempWordGramBuffer[i++] = words[k];
			} else if (i == wgSize && buffer == null) {
				buffer = new WordGram(tempWordGramBuffer, 0, wgSize);
				//System.out.println("The buffer = " + buffer);
			} else {
				if (buffer.equals(target)) {
					//System.out.println("Return the index of as " + (k - 1));
					return k - 1;
				} else {
					if (k < words.length) {
						buffer = buffer.shiftAdd(words[k - 1]);
						//System.out.println("Buffer update >>" + buffer);
					} else {
						return -1;
					}
				}
			}
		}
		return -1;
	}
	
	private ArrayList<String[]> getFollows(WordGram kGram) {
		ArrayList<String[]> follows = new ArrayList<String[]>();
		StringBuilder sb = new StringBuilder();
		int pos = 0;
		while (pos < myText.length) {
			int start = indexOf(myText, kGram, pos);
			//System.out.println("Start>> "+start);
			if (start == -1) {
				break;
			}
			if (start > myText.length) {
				break;
			}
			String next = myText[start] + " ";
			//System.out.println("The word to add to the follows array is: " + next + " and " + start + " is the index used");			
			//String next = new String();
			/*for (int i=1; i<myOrder; i++){
				next = next + " " + myText[start + i];
			}
			follows.add(next.split(" "));*/
			sb.append(next);
			pos = start;
			//System.out.println("The SB contains "+sb.toString());
		}
		String[] abc = sb.toString().split(" ");
		follows.add(abc);
		return follows;
	}

	public String getRandomText(int numWords) {
		
		StringBuilder sb = new StringBuilder();
		
		int index = myRandom.nextInt(myText.length - myOrder); 
		WordGram keyWG = new WordGram(myText, index, myOrder);
		sb.append(keyWG);
		sb.append(" ");
		System.out.println(">>"+keyWG);
		for (int k = 0; k < numWords - 1; k++) {
			ArrayList<String[]> follows = followsMap.get(keyWG.hashCode());
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			keyWG = keyWG.shiftAdd(next);
		}
		
		return sb.toString().trim();
		
		/*StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length - myOrder); 
		WordGram keyWG = new WordGram(myText, index, myOrder);
		sb.append(keyWG);
		sb.append(" ");
		System.out.println(">>>>>>>>"+keyWG);
		for (int k = 0; k < numWords - 1; k++) {
			ArrayList<String[]> follows = getFollows(keyWG);
			// use the print statement below to test the getfollows method
			// System.out.println(">> " + keyWG + " " + String.join(" ",
			// follows.get(0)) );
			if (follows.size() == 0) {
				break;
			}
			index = myRandom.nextInt(follows.size());
			WordGram next = new WordGram(follows.get(index), 0, myOrder);
			sb.append(next);
			sb.append(" ");
			keyWG = next;
			;
		}

		return sb.toString().trim();*/
	}

	public String toString() {
		return "Markov Word " + myOrder;
	}

	public void buildMap() {

		followsMap = new HashMap<Integer, ArrayList<String[]>>();
		for (int i = 0; i < myText.length - myOrder + 1; i++) {
			// loop through all words of myOrder in the training text
			WordGram currentWords = new WordGram(myText, i, myOrder);
			// System.out.println(">>"+currentWords);
			int hashKey = currentWords.hashCode();
			// System.out.println(">>"+hashCode);
			if (!followsMap.containsKey(hashKey)) {
				ArrayList<String[]> currentFollowes = getFollows(currentWords);
				// System.out.println("currentFollowes size " +
				// currentFollowes.size());
				if (currentFollowes.size() == 0) {
					// System.out.println("NewEntry creates " + hashKey);
					ArrayList<String[]> alTemp = new ArrayList<String[]>();
					followsMap.put(hashKey, alTemp);
				} else {
					followsMap.put(hashKey, currentFollowes);
					// System.out.println("The word gram is: " + currentWords);
					for (String[] arr : currentFollowes) {
						//System.out.println("This returns the array: " + Arrays.toString(arr));
					}
				}
			}
		}
		//printHashMapInfo();
	}

	public void printHashMapInfo() {

		System.out.println("There is " + followsMap.size() + " keys in the HashMap");
		int heighestValues = 0;
		for (Entry<Integer, ArrayList<String[]>> ee : followsMap.entrySet()) {
			System.out.print("The key is "+ee.getKey() + " ");
			// System.out.println("The VAL is "+ee.getValue());
			for (String[] str : ee.getValue()) {
				System.out.print("The words in the String[] are: ");
				int maxValue = 0;
				for (int i = 0; i < str.length; i++) {
					System.out.print(str[i] + ", ");
					maxValue++;
				}
				System.out.println(" ");
				if (maxValue > heighestValues) {
					heighestValues = maxValue;
				}
			}
		}
		System.out.println("The maximum number of elements following a key is " + heighestValues);
	}

}
