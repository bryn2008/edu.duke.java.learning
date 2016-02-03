package course3.week1;

import edu.duke.*;

public class CaesarBreaker {

	public static void main(String[] args) {

		CaesarBreaker myObj = new CaesarBreaker();
		myObj.testDecrypt();
		// myObj.testHalfOfString();
		// myObj.testcountLetters();
		// myObj.testEyeballDecrypt();
		// myObj.testMaxIndex();
		// myObj.testgetKey();
	}

	public String decrypt(String encrypted) {

		// call half of string
		//int key = getKey(encrypted);
		
		CaesarCipher cc = new CaesarCipher();
		int[] freqs = countLetters(encrypted);
		int maxDex = maxIndex(freqs);
		int dKey = maxDex - 4;
		if (maxDex < 4){
			dKey = 26 - (4-maxDex);
		}
		System.out.println("The decrypt key is set to: "+dKey);
		System.out.println("The key is set to: "+(26 - dKey));
		int key = 26 - dKey;
		
		//Key is not quite right and needs further testing
		
		return cc.encrypt(encrypted, key);
	}

	public static String halfOfString(String message, int start) {

		message = message.substring(start);
		String newString = "";
		for (int i = 0; i < message.length(); i += 2) {
			newString += message.charAt(i);
		}
		return newString;
	}

	public int getKey(String s) {

		// Call the method countLetters will return an array of the letter
		// frequency for every char in the alphabet
		int[] letterFrequency = countLetters(s);
		// Call the method maxIndex will find the index of the letter with the
		// largest frequency
		int maxDex = maxIndex(letterFrequency);	
		//Set the key to the correct value
		
		int dkey = maxDex - 5;
		if (maxDex < 5){
			dkey = 26 - (5-maxDex);
		}
		System.out.println("The key for e is \"" + (26 - dkey) + "\"");
		//need to some how set the key to 11 if the maxIndex is  
		int key = 26 - dkey;
		return key;
	}

	public void testgetKey() {

		// This should return a key when the most common letter is e
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		int key = getKey(encrypted);
		System.out.println("The key is: " + key);
	}

	public int[] countLetters(String s) {

		// an array of the letter frequency in the sting
		int[] letterFrequency = new int[26];
		String letters = s.toLowerCase();
		// System.out.println(letters);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		// loop trough and see if letter matches alphabet at x and if so add
		// count to index of x in letterFrequency Array
		for (char c : letters.toCharArray()) {
			for (int j = 0; j < letterFrequency.length; j++) {
				if (c == alphabet.charAt(j)) {
					letterFrequency[j]++;
				}
			}
		}
		// all work done by now
		/*for (int j = 0; j < alphabet.length; j++) { 
			System.out.println("count for " + alphabet[j] + " is " + letterFrequency[j]); 
		} */
		return letterFrequency;
	}

	public void testcountLetters() {

		// Should return an array of the letter frequencies
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		int[] letterFrequency = countLetters(encrypted);
		// Show the letter freq in the input string
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int j = 0; j < letterFrequency.length; j++) {
			System.out.println("The letter frequency for " + alphabet[j] + " is " + letterFrequency[j]);
		}
	}

	public int maxIndex(int[] letterFrequency) {

		// find the max in the counts array
		// System.out.print("The count is: ");
		int max = 0;
		for (int c : letterFrequency) {
			// System.out.print(c + ", ");
			if (c > max) {
				max = c;
			}
			// System.out.println("max: " + max);
		}
		// System.out.println("The max value in the counts array is: " + max);
		// find the index of the max value in the counts array
		int cIndex = 0;
		for (int i = 0; i < letterFrequency.length; i++) {
			if (letterFrequency[i] == max) {
				cIndex = i;
			}
		}
		// System.out.println("The index of value of " + max + " is at " +
		// cIndex);
		return cIndex;
	}

	public void testMaxIndex() {

		// Return an array of the letter frequencies
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		int[] letterFrequency = countLetters(encrypted);

		// return the index of the largest letter frequency
		int largestLetterFrequency = maxIndex(letterFrequency);
		System.out.println(
				"The lagest letter freqency index is at index \"" + largestLetterFrequency + "\" in the Array");
	}

	public void testDecrypt() {

		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		//FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted2.txt");
		String encrypted = fr.asString();
		System.out.println("The encrypted input is: " + encrypted);
		String decrypted = decrypt(encrypted);
		// Need to figure out how to use the two key decrypt method?
		System.out.println("The dycrypted output is: " + decrypted);

		/*
		 * Dear Owen, 
		 * No matter what you may have heard, there is no cake in the
		 * conference room. The cake is a lie. Please keep working on Coursera
		 * videos.
		 * Thanks, Drew
		 * 
		 * 
		 * The key for this is 11
		 * 
		 * the most freq used letter is t when encrypted and it has an index of 20 
		 * 
		 * there are 26 char's in the alphabet
		 * 
		 * index of e in the char alphabet is either 5 or 6 if zero indexed
		 * 
		 */
	}

	public void eyeballDecrypt(String encrypted) {
		CaesarCipher cipher = new CaesarCipher();
		for (int k = 0; k < 26; k++) {
			String s = cipher.encrypt(encrypted, k);
			System.out.println(k + "\t" + s);
		}
	}

	public void testEyeballDecrypt() {
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		eyeballDecrypt(encrypted);
	}

	public void decryptTwoKeys() {

		// Sting encrypted

	}

	/*
	 * public void testHalfOfString(){
	 * 
	 * String message = "Qbkm Zgis"; int start = 0; String newString =
	 * halfOfString(message, start); System.out.println(
	 * "The returned String is: " + newString); }
	 */

}
