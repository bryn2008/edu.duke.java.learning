package course4.week3.markovmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel{
	
	private int numOfChars;
	private HashMap<String, ArrayList<String>> followsMap = new HashMap<String, ArrayList<String>>();
	
	public EfficientMarkovModel(int numIn){
		numOfChars = numIn;
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		buildMap();
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-numOfChars);
		String key = myText.substring(index, index+numOfChars);
		sb.append(key);
		for(int k=0; k < numChars-numOfChars; k++){
				ArrayList<String> follows = followsMap.get(key);
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
	
	@Override
	public String toString(){
		return "MarkovModel of order "+ numOfChars;
	}
	
	public void buildMap(){
		
		for(int k=0; k < myText.length(); k+=numOfChars){
			String key = myText.substring(k, k+numOfChars);
			if(!followsMap.containsKey(key)){
				ArrayList<String> follows = getFollows(key);
				if(follows.size() == 0 ){
					ArrayList<String> emptyTemp = new ArrayList<String>();
					followsMap.put(key, emptyTemp);
				}
				followsMap.put(key, follows);
			}
		}
		printHashMap();
	}
	
	public void printHashMap(){
		for (String name: followsMap.keySet()){
            String key = name.toString();
            String value = followsMap.get(name).toString();  
            System.out.println(key + " " + value);  
		} 	
	}
	
}