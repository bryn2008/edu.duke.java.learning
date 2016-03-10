package course4.week3.markovwordgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class EfficientMarkovWord implements IMarkovModel {

	private String[] myText;
	private Random myRandom;
	private int myOrder;
	private HashMap<Integer, String[]> followsMap;

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
	
	private String[] getFollows(WordGram kGram) {
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
		String[] words = sb.toString().split(" ");
		return words;
	}

	public String getRandomText(int numWords) {
		
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length - myOrder); 
		WordGram keyWG = new WordGram(myText, index, myOrder);
		sb.append(keyWG);
		sb.append(" ");
		System.out.println(">>"+keyWG);
		String next = new String();
		int key = keyWG.hashCode();
		for (int k = 0; k < numWords - myOrder; k++) {
			//get the HashCode for the new word gram
			System.out.print("The key used is: "+key);
			
			//if(followsMap.containsKey(key)){
				//get the String[] of possible follow words from the HashMap and then set the next random word
				String[] follows = followsMap.get(keyWG.hashCode());
				while (follows == null){
					index = myRandom.nextInt(myText.length - myOrder); 
					keyWG = new WordGram(myText, index, myOrder);
					key = keyWG.hashCode();
					follows = followsMap.get(keyWG.hashCode());
				}
				
				
				System.out.print("\nThe next possiable words are: ");
				for (int i = 0; i < follows.length; i++) {
					System.out.print(follows[i] + ", ");
				}
				
				index = myRandom.nextInt(follows.length);
				next = follows[index];
				System.out.print(" and the next word chosen is: " + next + "\n");
				
				sb.append(next);
				sb.append(" ");
				
				//shiftAdd the new word for the next key in the for loop
				keyWG = keyWG.shiftAdd(next);
				key = keyWG.hashCode();
				
		}
		System.out.println("the sb = "+sb.toString().trim());
		return sb.toString().trim();
	}

	public String toString() {
		return "Markov Word " + myOrder;
	}

	public void buildMap() {

		followsMap = new HashMap<Integer, String[]>();
		for (int i = 0; i < myText.length - myOrder + 1; i++) {
			// loop through all words of myOrder in the training text
			WordGram currentWords = new WordGram(myText, i, myOrder);
			// System.out.println(">>"+currentWords);
			int hashKey = currentWords.hashCode();
			// System.out.println(">>"+hashCode);
			if (!followsMap.containsKey(hashKey)) {
				String[] currentFollowes = getFollows(currentWords);
				// System.out.println("currentFollowes size " +
				// currentFollowes.size());
				if (currentFollowes.length == 0) {
					// System.out.println("NewEntry creates " + hashKey);
					String[] alTemp = new String[0];
					followsMap.put(hashKey, alTemp);
				} else {
					followsMap.put(hashKey, currentFollowes);
					// System.out.println("The word gram is: " + currentWords);
					/*for (String arr : currentFollowes) {
						//System.out.println("This returns the array: " + arr);
					}*/
				}
			}
		}
		printHashMapInfo();
	}

	public void printHashMapInfo() {

		System.out.println("There is " + followsMap.size() + " keys in the HashMap");
		int heighestValues = 0;
		for (Entry<Integer, String[]> ee : followsMap.entrySet()) {
			System.out.print("The key is "+ee.getKey() + " ");
			// System.out.println("The VAL is "+ee.getValue());
			
				System.out.print("The words in the String[] are: ");
				int maxValue = 0;
				for (int i = 0; i < ee.getValue().length; i++) {
					System.out.print(ee.getValue()[i] + ", ");
					maxValue++;
				}
				System.out.println(" ");
				if (maxValue > heighestValues) {
					heighestValues = maxValue;
				}
			
		}
		System.out.println("The maximum number of elements following a key is " + heighestValues);
	}

}
