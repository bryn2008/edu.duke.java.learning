package course3.week1.caesarcipher;

public class CaesarCipher {

	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;

	public CaesarCipher(int key) {

		mainKey = key;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
	}

	public String encrypt(String input) {

		String stringInput = input;
		StringBuilder encrypted = new StringBuilder(input.toUpperCase());
		for (int i = 0; i < encrypted.length(); i++) {
			char currChar = encrypted.charAt(i);
			int idx = alphabet.indexOf(currChar);
			if (idx != -1) {
				char newChar = shiftedAlphabet.charAt(idx);
				encrypted.setCharAt(i, newChar);
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

		CaesarCipher cc = new CaesarCipher(26 - mainKey);
		String decrypted = cc.encrypt(input);
		return decrypted;
	}
}
