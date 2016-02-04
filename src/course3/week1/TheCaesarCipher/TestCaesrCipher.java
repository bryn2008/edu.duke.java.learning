package course3.week1.TheCaesarCipher;

import course3.week1.TheCaesarCipher.CaesarCipher;
import edu.duke.FileResource;

public class TestCaesrCipher {
	
	public static void main(String[] args) {

		TestCaesrCipher myObj = new TestCaesrCipher();
		myObj.simpleTests();
	}
	
	/*
	 * Write the void method simpleTests that has no parameters. This method
	 * should read in a file as a String, create a CaesarCipher object with key
	 * 18, encrypt the String read in using the CaesarCipher object, print the
	 * encrypted String, and decrypt the encrypted String using the decrypt
	 * method.
	 */
	public void simpleTests() {

		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/smallHamlet.txt");
		String message = fr.asString();
		System.out.println("The meesage is: " + message);
		String encrypt = message;
		
		CaesarCipher cc = new CaesarCipher(18);
		String enncrypted = cc.encrypt(message);
		System.out.println("The enncrypted meesage is: " + enncrypted);

		String decrypted = breakCaesarCipher(encrypt);
		System.out.println("The decrypted meesage is: " + decrypted);
		/*
		 * In the simpleTests method, add a call to breakCaesarCipher on the
		 * encrypted String to decrypt it automatically by determining the key,
		 * and print the decrypted String.
		 */
	}

	/*
	 * This method should figure out which key was used to encrypt this message
	 * (in a similar manner as the previous lesson), then create a CaesarCipher
	 * object with that key and decrypt the message.
	 */
	public String breakCaesarCipher(String input) {

		int[] freqs = countLetters(input);
		int maxDex = maxIndex(freqs);
		int dKey = maxDex - 1;
		if (dKey < 1) {
			dKey *= -1;
		}
		CaesarCipher cc = new CaesarCipher(dKey);
		String decrypted = cc.encrypt(input);
		return decrypted;
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

}