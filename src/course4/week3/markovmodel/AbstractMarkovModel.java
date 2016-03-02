package course4.week3.markovmodel;

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
	protected String myText;
	protected Random myRandom;
	
	public AbstractMarkovModel(){
		myRandom = new Random();
	}
	
	public void setTraning(String s){
		myText = s.trim();
	}
	
	abstract public String getRandomText(int numChars);
	
}
