package course3.week1;

import edu.duke.*;

public class CaesarBreaker {
    
	public static void main (String [] args){
		
		CaesarBreaker myObj = new CaesarBreaker();
		myObj.testDecrypt();
		
	}
	
	
	public void countLetters(){
		
		//Similar method created in the WordLengths Class
		
		String word = "The input?";
		
	    int count = 0;
	    for (int i = 0; i < word.length(); i++) {
	        if (word.charAt(i) == ' ') {
	            //System.out.println("count is " + count);
	            count = 0;
	        } else {
	            count++;
	        }
	    }
	    System.out.println("count is " + count);
	    
	}

	public void maxIndex(){
		
		//Similar method created in the WordLengths Class
		
//		public int  indexOfMax(int [ ] counts){ 
//		//find the max in the counts array
//		//System.out.print("The count is: ");
//		int max = 0;
//		for (int c : counts) {
//			//System.out.print(c+", ");
//			if (c > max){
//				max = c;
//			}
//			//System.out.println("max: " + max);
//		}
//		//System.out.println("The max value in the counts array is: "+max);
//		//find the index of the max value in the counts array
//		int cIndex = 0;
//		for (int i=0; i<counts.length; i++ ) {
//			if (counts[i]==max) {
//				cIndex=i;
//			}
//		}
//		//System.out.println("The index of value of " + max + " is at " + cIndex);
//		return cIndex;
//		}
		
	}
	
	public void decrypt(){
		
		String input = "Hello"; 
		int key = 15;
		
		//The input must be in upper case
		input = input.toUpperCase();
		
		CaesarCipher cc = new CaesarCipher();
		String message = cc.encrypt(input, key);
		
		System.out.println(message);
		
	}
	
	public void testDecrypt(){
		
		FileResource fr = new FileResource();
		
		
		
		decrypt();
		//Need to figure out how to use the two key decrypt method?
		System.out.println("Print the decrypted string from the file resource "+fr.asString());
		
	}
	
	public void halfOfString(){
		
		//Two perameters String message and int start
		
	}
	
	public void getKey(){
		
		//One perameter String s
		//Method should call countLetters
	
	}
	
	public void decryptTwoKeys(){
		
		//Sting encrypted
		
	}
	
}
