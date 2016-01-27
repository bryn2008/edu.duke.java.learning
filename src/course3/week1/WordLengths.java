package course3.week1;

import java.util.ArrayList;

import edu.duke.FileResource;

public class WordLengths {

	public static void main (String [] args){
		
		WordLengths myObj = new WordLengths();
		myObj.testCountWordLength();
	}
	
	public void countWordLength (FileResource fr, ArrayList<Integer> al){
		
	}
	
	
	
	public void testCountWordLength (){
		
		FileResource fr = new FileResource();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		countWordLength(fr, al);
		
		
	}
	
}