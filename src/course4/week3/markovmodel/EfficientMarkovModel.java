package course4.week3.markovmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel{
	
	private int numOfChars;
	private HashMap<String, ArrayList<String>> followsMap;
	
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
		
		//build a HashMap of all the keys and ArrayLists values 
		followsMap = new HashMap<String, ArrayList<String>>();
		
		//not sure how to pick the keys and there is a way to obtain them not at random like previously done in the MarkovModel
		for(int k=0; k < myText.length()-numOfChars; k+=numOfChars){
			String key = myText.substring(k, k+numOfChars);
			if(!followsMap.containsKey(key)){
				ArrayList<String> follows = getFollows(key);
				if(follows.size() == 0 ){
					ArrayList<String> emptyTemp = new ArrayList<String>();
					followsMap.put(key, emptyTemp);
				}
				followsMap.put(key, follows);
				System.out.println(key + " " + follows);
			}
		}
		System.out.println("The size of all the keys in the HashMap is " + followsMap.size() + " after building the map.");
		printHashMapInfo();
	}
	
	public void printHashMapInfo(){
		
		for (String name: followsMap.keySet()){
            String key = name.toString();
            String value = followsMap.get(name).toString();  
            System.out.println(key + " " + value);  
		}	
	}
	
}