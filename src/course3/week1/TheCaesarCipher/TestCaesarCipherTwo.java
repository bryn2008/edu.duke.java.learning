package course3.week1.TheCaesarCipher;

import edu.duke.FileResource;

public class TestCaesarCipherTwo {

	public static void main(String[] args) {

		TestCaesarCipherTwo myObj = new TestCaesarCipherTwo();
		myObj.simpleTests();
	}

	public void simpleTests() {
		
		//FileResource fr = new FileResource("ProgrammingBreakingCaesarData/smallHamlet.txt");
		//FileResource fr = new FileResource("QuizCryptographyData/errors.txt");
		//FileResource fr = new FileResource("QuizCryptographyData/manywords.txt");
		FileResource fr = new FileResource("QuizCryptographyData/mysteryTwoKeysQuiz.txt");
		
		String message = fr.asString();
		System.out.println("The meesage is: " + message);
		
		CaesarCipherTwo ccTwo = new CaesarCipherTwo(17,3);
		String encrypted = ccTwo.encrypt(message);
		System.out.println("The encrypted meesage is: " + encrypted);
		
		String test = breakCaesarCipher(encrypted);
		System.out.println("\nThe de-encrypted test meesage is: " + test);
		
		String decrypted = ccTwo.decrypt(encrypted);
		System.out.println("The decrypted meesage is: " + decrypted);
	}
	
	public String breakCaesarCipher(String input){
				
		String halfone = halfOfString(input, 0);
		String halftwo = halfOfString(input, 1);
		
		int[] freqsOne = countLetters(halfone);
		int maxDexOne = maxIndex(freqsOne);
		int dKeyOne = maxDexOne - 4;
		if (dKeyOne < 1){
			dKeyOne *= -1;
		}
		dKeyOne = (26 - dKeyOne);
		System.out.println("The decrypt Key1 is "+dKeyOne+". ");
		
		int[] freqsTwo = countLetters(halftwo);
		int maxDexTwo = maxIndex(freqsTwo);
		int dKeyTwo = maxDexTwo - 4;
		if (dKeyTwo < 1){
			dKeyTwo *= -1;
		}
		dKeyTwo = (26 - dKeyTwo);
		System.out.println("The decrypt Key2 is "+dKeyTwo+". ");
		
		CaesarCipherTwo ccTwo = new CaesarCipherTwo(26 - dKeyOne, 26 - dKeyTwo);
		String decrypted = ccTwo.decrypt(input);
		return decrypted;
	}
	
	public static String halfOfString(String message, int start) {

		message = message.substring(start);
		String newString = "";
		for (int i = 0; i < message.length(); i += 2) {
			newString += message.charAt(i);
		}
		return newString;
	}

	public int[] countLetters(String s) {

		int[] letterFrequency = new int[26];
		String letters = s.toLowerCase();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (char c : letters.toCharArray()) {
			for (int j = 0; j < letterFrequency.length; j++) {
				if (c == alphabet.charAt(j)) {
					letterFrequency[j]++;
				}
			}
		}
		return letterFrequency;
	}

	public int maxIndex(int[] letterFrequency) {

		int max = 0;
		for (int c : letterFrequency) {
			if (c > max) {
				max = c;
			}
		}
		int cIndex = 0;
		for (int i = 0; i < letterFrequency.length; i++) {
			if (letterFrequency[i] == max) {
				cIndex = i;
			}
		}
		return cIndex;
	}
}
