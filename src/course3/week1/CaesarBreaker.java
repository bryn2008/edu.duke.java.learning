package course3.week1;

import edu.duke.*;

public class CaesarBreaker {

	public static void main(String[] args) {

		CaesarBreaker myObj = new CaesarBreaker();
		// yObj.testDecrypt();
		// myObj.testHalfOfString();
		myObj.testcountLetters();
		// myObj.testEyeballDecrypt();
	}

	public String decrypt(String encrypted) {

		// call half of string

		int key = 19;
		CaesarCipher cc = new CaesarCipher();
		String message = cc.encrypt(encrypted, key);
		return message;
	}

	public static String halfOfString(String message, int start) {

		message = message.substring(start);
		String newString = "";
		for (int i = 0; i < message.length(); i += 2) {
			newString += message.charAt(i);
		}
		return newString;
	}

	public void getKey(String s) {

		// Method should call countLetters
		// this will return an array of the letter frequency

		// Call the method maxIndex
		// This should find the index of the largest letter frequency

	}

	public void testgetKey() {

	}

	public int[] countLetters(String s) {

		// an array of the letter frequency in the sting
		int[] letterFrequency = new int[26];
		String letters = s.toLowerCase();
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		System.out.println(letters);

		// loop trough and see if letter matches alphabet at x and if so add
		// count to index of x in letterFrequency Array
		for (char c : s.toCharArray()) {
			for (int j = 0; j < letterFrequency.length; j++) {
				if (c == alphabet[j]) {
					letterFrequency[j]++;
				}
			}
		}

		// all work done by now
		for (int j = 0; j < alphabet.length; j++) {
			System.out.println("count for " + alphabet[j] + " is " + letterFrequency[j]);
		}
		return letterFrequency;
	}

	public void testcountLetters() {

		// Should return an array of the letter frequencies
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		int[] letterFrequency = countLetters(encrypted);
		//Show the letter freq in the input string
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int j = 0; j < letterFrequency.length; j++) {
			System.out.println("The letter frequency for "+ alphabet[j] +" is " + letterFrequency[j]);
		}
	}

	public void testDecrypt() {

		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		System.out.println("The encrypted input is: " + encrypted);
		String decrypted = decrypt(encrypted);
		// Need to figure out how to use the two key decrypt method?
		System.out.println("The dycrypted output is: " + decrypted);

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

	public void maxIndex() {

		// Similar method created in the WordLengths Class

		// public int indexOfMax(int [ ] counts){
		// //find the max in the counts array
		// //System.out.print("The count is: ");
		// int max = 0;
		// for (int c : counts) {
		// //System.out.print(c+", ");
		// if (c > max){
		// max = c;
		// }
		// //System.out.println("max: " + max);
		// }
		// //System.out.println("The max value in the counts array is: "+max);
		// //find the index of the max value in the counts array
		// int cIndex = 0;
		// for (int i=0; i<counts.length; i++ ) {
		// if (counts[i]==max) {
		// cIndex=i;
		// }
		// }
		// //System.out.println("The index of value of " + max + " is at " +
		// cIndex);
		// return cIndex;
		// }

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
