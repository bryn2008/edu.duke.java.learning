package course4.week3.markovmodel;

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel {
    private String myText;
	private Random myRandom;
	private int numOfChars;
	
	public MarkovModel(int numIn) {
		numOfChars = numIn;
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public ArrayList<String> getFollows(String key){
		
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0; i<myText.length(); i++){	
			String currentText = myText.substring(i);
			if(currentText.startsWith(key) && currentText.length() > key.length()){
				String regEx = myText.substring(i+key.length(), i+key.length()+1);
				answer.add(regEx);
			}
		}	
		return answer;
	}
	
	public String getRandomText(int numChars){
		
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-numOfChars);
		String key = myText.substring(index, index+numOfChars);
		sb.append(key);
		for(int k=0; k < numChars-numOfChars; k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0 ){
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			System.out.println(sb);
			key = key.substring(1) + next;
		}
		return sb.toString();
	}
	
}