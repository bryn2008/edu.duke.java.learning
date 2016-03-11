package course4.week3.markovwordgram;

import java.util.Arrays;
import java.util.HashMap;
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
			} else {
				if (buffer.equals(target)) {
					return k - 1;
				} else {
					if (k < words.length) {
						buffer = buffer.shiftAdd(words[k - 1]);
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
			if (start == -1) {
				break;
			}
			if (start > myText.length) {
				break;
			}
			String next = myText[start] + " ";
			sb.append(next);
			pos = start;
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
		String next = new String();
		int key = keyWG.hashCode();
		for (int k = 0; k < numWords - myOrder; k++) {
			
			String[] follows = followsMap.get(key);
			
			//check the follows string array is populated
			while (follows == null || Arrays.asList(follows).contains("")){
				index = myRandom.nextInt(myText.length); 
				keyWG = keyWG.shiftAdd(myText[index]);
				while(keyWG.contains("")){
					index = myRandom.nextInt(myText.length);
					keyWG = keyWG.shiftAdd(myText[index]);
				}
				key = keyWG.hashCode();
				follows = followsMap.get(key);
			}
			
			//Add the next word to the string builder
			index = myRandom.nextInt(follows.length);
			next = follows[index];
			sb.append(next + " ");
			
			//get the next key 
			keyWG = keyWG.shiftAdd(next);
			while(keyWG.contains("")){
				index = myRandom.nextInt(myText.length);
				keyWG = keyWG.shiftAdd(myText[index]);
			}
			key = keyWG.hashCode();
		}
		return sb.toString().trim();
	}

	public String toString() {
		return "Markov Word " + myOrder;
	}

	public void buildMap() {

		followsMap = new HashMap<Integer, String[]>();
		for (int i = 0; i < myText.length - myOrder + 1; i++) {
			WordGram currentWords = new WordGram(myText, i, myOrder);
			int hashKey = currentWords.hashCode();
			if (!followsMap.containsKey(hashKey)) {
				String[] currentFollowes = getFollows(currentWords);
				if (currentFollowes.length == 0) {
					followsMap.put(hashKey, null);
				} else {
					followsMap.put(hashKey, currentFollowes);
				}
			}
		}
		//printHashMapInfo();
	}

	public void printHashMapInfo() {

		System.out.println("There is " + followsMap.size() + " keys in the HashMap");
		int heighestValues = 0;
		for (Entry<Integer, String[]> ee : followsMap.entrySet()) {
			System.out.print("The key is "+ee.getKey() + " ");
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
