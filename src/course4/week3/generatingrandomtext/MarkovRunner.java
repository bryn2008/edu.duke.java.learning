package course4.week3.generatingrandomtext;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {
	
	private String filePath = "src/course4/week3/generatingrandomtext/data/";
	
	public static void main(String[] args){
		MarkovRunner myObj = new MarkovRunner();
		//myObj.runMarkovZero();
		myObj.runMarkovOne();
	}
    
	public void runMarkovOne() {
		FileResource fr = new FileResource(filePath + "confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setRandom(42);
		markov.setTraining(st);
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(65);
			printOut(text);
		}
	}
	
    public void runMarkovZero() {
		FileResource fr = new FileResource(filePath + "alice.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setRandom(42);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(100);
			printOut(text);
		}
	}
	
	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
