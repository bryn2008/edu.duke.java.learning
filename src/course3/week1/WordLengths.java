package course3.week1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.jws.Oneway;

import edu.duke.FileResource;

public class WordLengths {

	public static void main (String [] args){
		
		WordLengths myObj = new WordLengths();
		myObj.testCountWordLength();
	}
	
	public void countWordLength (FileResource fr){
		
		//TO DO CODE
		
		String resource = fr.asString();
		System.out.println("resource: " + resource);
		
		String[] words = resource.split("\\s+");
		for (int i = 0; i < words.length; i++) {
		    words[i] = words[i].replaceAll("[+.^:,]","");
		}
		System.out.println("The word Array contins: "+ Arrays.toString(words));
		
		int [] counts;
		int maxWordLength = 0;
		System.out.println(" ");
		System.out.println("The words are: ");
		for(String word : words) {
			System.out.print(word.length()+"\t");		
			System.out.println(word);
			if (maxWordLength < word.length()){
				maxWordLength = word.length();
			}
		}
		
		System.out.println("The max word length is: "+maxWordLength);
		System.out.println(" ");
		//allocate count to maxWordLength
		
		counts = new int[maxWordLength+1];
		
		for(String word : words) {
			counts[word.length()] += 1;
		}
		System.out.println(" ");
		System.out.print("The count is: ");
		for (int c : counts) {
			System.out.print(c+", ");
		}
		System.out.println(" ");
		//find the max in the counts array 
		int indexOfMax = indexOfMax(counts); 
		
		System.out.println(" ");
		System.out.println("The indexOfMax is: "+indexOfMax);
		
		//get the index of max in counts
		
		
		//Arrays.asList(words).indexOf(indexOfMax)
		
		System.out.println("The  is: "+ Arrays.asList(words).indexOf(indexOfMax));
		System.out.println(" ");
		
		//int indexNum = getArrayIndex(counts,indexOfMax);
		
		//System.out.println("The array of words are is: "+ Arrays.asList(words));
		
		for (int c : counts) {
			int indexNum = getArrayIndex(counts,c);
			//System.out.println(indexNum);
			
			//show only the relevant counts
			if (indexNum > 0){
				// this narrows it down to only the array indexs that contain values
				//show these values 
				System.out.print(c+ " words of length " );
				//next show the length of the words at "c" words
				
				
				
			}
			System.out.println(">>");
		}
		
		
		
		
		/*for(String word : words) {
			
			System.out.print(">>"+word );
			
			if(word.length() == indexNum)
				
				System.out.print(word+" ");
				
//				int lengthOfCurrentWord;
//				lengthOfCurrentWord = words[c].length();
//				System.out.println(c+ " words of length " + lengthOfCurrentWord);
		}
		System.out.println(" ");*/
		
		
		
		
		
		//and then look at the words with the .length() == mostFreqLength
		
	}
	
	public void testCountWordLength (){
		
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/smallHamlet.txt");
		//System.out.println(fr.asString());
		//CALL THE METHOD
		countWordLength(fr);
		
		//created an array
		/*int [] counts = new int[fr.toString().length()+1];
		System.out.println(">>"+(fr.toString().length()+1));
		System.out.println("Length of counts array: " + counts.length);*/
	}
	
	public int  indexOfMax(int [ ] counts){ 
		//find the max in the counts array
		//System.out.print("The count is: ");
		int max = 0;
		for (int c : counts) {
			//System.out.print(c+", ");
			if (c > max){
				max = c;
			}
			//System.out.println("max: " + max);
		}
		System.out.println("The max value in the counts array is: "+max);
		//find the index of the max value in the counts array
		int cIndex = 0;
		for (int i=0; i<counts.length; i++ ) {
			if (counts[i]==max) {
				cIndex=i;
			}
		}
		System.out.println("The index of value of " + max + " is at " + cIndex);
		return cIndex;
	}
	
	public int getArrayIndex(int[] arr,int value) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
    return k;
	}
	
}