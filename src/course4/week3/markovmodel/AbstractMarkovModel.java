package course4.week3.markovmodel;

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
	
	protected String myText;
	protected Random myRandom;
	
	public AbstractMarkovModel(){
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraning(String s){
		myText = s.trim();
	}
	
	protected ArrayList<String> getFollows(String key){
		
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
	
	abstract public String getRandomText(int numChars);
	
}