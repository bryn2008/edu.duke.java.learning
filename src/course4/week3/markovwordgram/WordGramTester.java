package course4.week3.markovwordgram;

import java.util.*;

public class WordGramTester {
	
	public static void main(String[] args){
		WordGramTester myObj = new WordGramTester();
		//myObj.testWordGram();
		//myObj.testWordGramEquals();
		//myObj.testWordGramLength();
		myObj.testWordGramShiftAdd();
	}
	
	public void testWordGram(){
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		int size = 6;
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg = new WordGram(words,index,size);
			System.out.println(index+"\t"+wg.length()+"\t"+wg);
		}
	}
	
	public void testWordGramEquals(){
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		ArrayList<WordGram> list = new ArrayList<WordGram>();
		int size = 4;
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg = new WordGram(words,index,size);
			list.add(wg);
		}
		WordGram first = list.get(0);
		System.out.println("checking "+first);
		for(int k=0; k < list.size(); k++){
			if (first.equals(list.get(k))) {
				System.out.println("matched at "+k+" "+list.get(k));
			}
		}
	}
	
	public void testWordGramLength(){
		//test the length method
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		int size = 5;
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg = new WordGram(words,0,size);
			System.out.println(wg.length());
		}
	}
	
	public void testWordGramShiftAdd(){
		//test the shiftAdd method
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		int size = 4;
//		for(int index = 0; index <= words.length - size; index += 1) {
//			WordGram wg = new WordGram(words,index,size);
//			System.out.println(index+"\t"+wg.length()+"\t"+wg);
//			
//		}
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg2 = new WordGram(words,index,size);
			WordGram wg3 = wg2.shiftAdd("Chicken");
			System.out.println(index+"\t"+wg3.length()+"\t"+wg3);
		}
		
		
		
	}
}
