package course4.week3.generatingrandomtext;

import java.util.ArrayList;
import java.util.Random;

public class MarkovThree {
    private String myText;
	private Random myRandom;
	
	public MarkovThree() {
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
		int index = myRandom.nextInt(myText.length()-3);
		String key = myText.substring(index, index+3);
		sb.append(key);
		for(int k=0; k < numChars-3; k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0 ){
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			System.out.println(sb);
			key = next;
		}
		
		return sb.toString();
	}
	
}
