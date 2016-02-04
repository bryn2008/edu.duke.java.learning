package course3.week1.TheCaesarCipher;

public class CaesarCipher {
	
	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;
	
	public CaesarCipher(int key){
		
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + 
						  alphabet.substring(0, key);
	}
	
	public String encrypt(String input){
		
		String stringInput = input;
		StringBuilder encrypted = new StringBuilder(input.toUpperCase()); 
		for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        for (int j = 0; j <  encrypted.length(); j++){	//Revert String case to original format
        	char originalChar = stringInput.charAt(j);
        	char newEncryptedChar = encrypted.charAt(j);
        	if (Character.isLowerCase(originalChar) && Character.isUpperCase(newEncryptedChar)){
        		char c = Character.toLowerCase(newEncryptedChar);
        		encrypted.setCharAt(j, c);
        	}
        }
		return encrypted.toString();
	}
	
	public String decrypt(String input){
		
		CaesarCipher cc = new CaesarCipher(26 - mainKey);
		input = cc.encrypt(input);
		return input;
		/*
		 * Write a decrypt method that has one String parameter named input. 
		 * This method returns a String that is the encrypted String decrypted 
		 * using the key associated with this CaesarCipher object. 
		 * One way to do this is to create another private field mainKey, 
		 * which is initialized to be the value of key. 
		 * Then you can create a CaesarCipher object within 
		 * decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey); and call cc.encrypt(input).
		*/
	}
}