package course3.week1.TheCaesarCipher;

import course3.week1.TheCaesarCipher.CaesarCipher;
import edu.duke.FileResource;

public class TestCaesrCipher {
	
	public static void main(String[] args) {

		TestCaesrCipher myObj = new TestCaesrCipher();
		myObj.simpleTests();
	}
	

	public void simpleTests() {

		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/smallHamlet.txt");
		String message = fr.asString();
		System.out.println("The meesage is: " + message);
		
		CaesarCipher cc = new CaesarCipher(17);
		String enncrypted = cc.encrypt(message);
		System.out.println("The enncrypted meesage is: " + enncrypted);
		
		String manDecrypt = breakCaesarCipher(enncrypted);
		System.out.println("\nUsing the breakCaesarCipher method, the decrypted meesage is: " + manDecrypt);
		
		String decrypted = cc.decrypt(enncrypted);
		System.out.println("The decrypted meesage is: " + decrypted);

	}

	public String breakCaesarCipher(String input) {
		
		int[] freqs = countLetters(input);
		int maxDex = maxIndex(freqs);
		int dKey = maxDex - 4;
		if (dKey < 1) {
			dKey *= -1;
		}
		System.out.println("The decrypt key is "+(26 - dKey));
		CaesarCipher cc = new CaesarCipher((26 - dKey));
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