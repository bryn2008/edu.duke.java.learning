package course4.week3.markovwordgram;

import java.util.ArrayList;
import java.util.Random;

public class MarkovWord implements IMarkovModel {

	private String[] myText;
	private Random myRandom;
	private int myOrder;

	public MarkovWord(int myOrderNum) {
		myOrder = myOrderNum;
		myRandom = new Random();
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String text) {
		myText = text.split("\\s+");
	}

	private int indexOf(String[] words, WordGram target, int start) {

		WordGram buffer = null;
		String[] tempWordGramBuffer = new String[myOrder];
		int i = 0;
		for (int k = start; k < words.length; k++) {
			if (i < myOrder && buffer == null) {
				tempWordGramBuffer[i++] = words[k];
			} else if (i == myOrder && buffer == null) {
				buffer = new WordGram(tempWordGramBuffer, 0, myOrder);
			} else {
				if (buffer.equals(target)) {
					return k + 1;
				} else {
					if (k < words.length - myOrder) {
						buffer = buffer.shiftAdd(words[k + 1]);
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
		int pos = 0;
		while (pos < myText.length) {
			int start = indexOf(myText, kGram, pos);
			if (start == -1) {
				break;
			}
			if (start + kGram.length() >= myText.length - myOrder) {
				break;
			}
			String next = myText[start];
			
			//String next = new String();
			for (int i=1; i<myOrder; i++){
				next = next + " " + myText[start + i];
			}
			follows.add(next.split(" "));
			pos = start + myOrder;
		}
		return follows;
	}
	
	public String getRandomText(int numWords) {
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length - myOrder); // random word to start with
		WordGram keyWG = new WordGram(myText, index, myOrder);
		sb.append(keyWG);
		sb.append(" ");
		//System.out.println(">>>>>>>>"+keyWG);
		for (int k = 0; k < numWords - 1; k++) {
			ArrayList<String[]> follows = getFollows(keyWG);
			// use the print statement below to test the getfollows method
			//System.out.println(">> " + keyWG + " " + String.join(" ", follows.get(0)) );
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

		return sb.toString().trim();
	}

	public String toString() {
		return "Markov Word " + myOrder;
	}

}
