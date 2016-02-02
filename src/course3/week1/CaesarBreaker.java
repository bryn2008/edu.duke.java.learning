package course3.week1;

import edu.duke.*;

public class CaesarBreaker {
    
	public static void main (String [] args){
		
		CaesarBreaker myObj = new CaesarBreaker();
		//myObj.testDecrypt();
		//myObj.testHalfOfString();
		//myObj.testcountLetters();
		myObj.testCipherDecrypt();
	}
	
	public void CipherDecrypt(String encrypted){
		CaesarCipher decrypted = new CaesarCipher();
		for(int k=0; k<26; k++){
			String s = decrypted.encrypt(encrypted, k);
			System.out.println(k+"\t"+s);
		}
	}
	
	public void testCipherDecrypt(){
		
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		CipherDecrypt(encrypted);
	}
	
	public int countLetters(String word){
	    int count = 0;
	    for (int i = 0; i < word.length(); i++) {
	        if (word.charAt(i) == ' ') {
	            //System.out.println("count is " + count);
	            //count = 0;
	        } else {
	            count++;
	        }
	    }
	    System.out.println("count is " + count);
	    return count;
	}
	
	public void testcountLetters(){
		
		String word = "Hello can you hear me? There's is a, thunder in the air!";
		int letterCount = countLetters(word);
		System.out.println("The letter count is " + letterCount + ". The original word length is " + word.length() + ". This dose not exclude special char's.");
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
	
	public static String halfOfString(String message, int start){
		
		message = message.substring(start);
		String newString = "";
		for (int i = 0; i < message.length(); i += 2)
			{
				newString += message.charAt(i);
			}
		return newString;
	}
	
	public void getKey(){
		
		//One perameter String s
		//Method should call countLetters
	
	}
	
	public void decryptTwoKeys(){
		
		//Sting encrypted
		
	}
	
/*	public void testHalfOfString(){
		
		String message = "Qbkm Zgis";
		int start = 0;
		String newString = halfOfString(message, start);
		System.out.println("The returned String is: " + newString);
	}*/
	
}
