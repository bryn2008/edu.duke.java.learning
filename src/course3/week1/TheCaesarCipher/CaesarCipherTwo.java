package course3.week1.TheCaesarCipher;

public class CaesarCipherTwo {
	
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int mainKey1;
	private int mainKey2;
	
	public CaesarCipherTwo(int key1, int key2){
		
		mainKey1 = key1;
		mainKey2 = key2;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
		
	}
	
	public String encrypt(String input) {

		String stringInput = input;
		StringBuilder encrypted = new StringBuilder(input.toUpperCase());
		for (int i = 0; i < encrypted.length(); i++) {
			char currChar = encrypted.charAt(i);
			int idx = alphabet.indexOf(currChar);
			if (idx != -1) {
				if (i%2 == 0){
					char newChar1 = shiftedAlphabet1.charAt(idx);
					encrypted.setCharAt(i, newChar1);
				}
				else {
					char newChar2 = shiftedAlphabet2.charAt(idx);
					encrypted.setCharAt(i, newChar2);
				}
				
			}
		}
		for (int j = 0; j < encrypted.length(); j++) {
			char originalChar = stringInput.charAt(j);
			char newEncryptedChar = encrypted.charAt(j);
			if (Character.isLowerCase(originalChar) && Character.isUpperCase(newEncryptedChar)) {
				char c = Character.toLowerCase(newEncryptedChar);
				encrypted.setCharAt(j, c);
			}
		}
		return encrypted.toString();
	}
	
	public String decrypt(String input) {

		CaesarCipherTwo ccTwo = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
		String decrypted = ccTwo.encrypt(input);
		return decrypted;
	}

}
