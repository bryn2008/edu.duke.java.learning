package course3.week4.resources;

import edu.duke.FileResource;

public class Tester {
	
	private int ccKey;
	private FileResource fr1;
	private FileResource fr2;
	private FileResource fr3;
	private String message1;
	private String message2;
	private String message3;
	
	public Tester(){
		
		ccKey = 5;
		fr1 = new FileResource("VigenereTestData/titus-small.txt");
		fr2 = new FileResource("VigenereTestData/titus-small_key5.txt");
		fr3 = new FileResource("VigenereTestData/oslusiadas_key17.txt");
		message1 = fr1.asString();
		message2 = fr2.asString();
		message3 = fr3.asString();
		
	}
		
		public static void main(String[] args){
			
			Tester myObj = new Tester();
			//myObj.testCaesarCipher();
			//myObj.testCaesarCracker();
			//myObj.testCaesarCrackerTwo();
			//myObj.testVigenereCipher();
			myObj.testVigenereBreaker();
			
		}
		
		public void testCaesarCipher(){
			
			CaesarCipher myCipher = new CaesarCipher(ccKey);
			String encryptedMessage = myCipher.encrypt(message1);
			System.out.println(">>>>>The original message<<<<<<<");
			System.out.println(message1);
			System.out.println(">>>>>The encrypted message<<<<<<<");
			System.out.println(encryptedMessage);
			String decryptedMessage = myCipher.decrypt(encryptedMessage);
			System.out.println(">>>>>The decrypted message<<<<<<<");
			System.out.println(decryptedMessage);
			
		}
		
		public void testCaesarCracker(){
			
			CaesarCracker myCracker = new CaesarCracker();
			String encryptedMessage = myCracker.decrypt(message2);
			System.out.println(">>>>>The original encrypted message<<<<<<<");
			System.out.println(message2);
			System.out.println(">>>>>The cracked message<<<<<<<");
			System.out.println(encryptedMessage);
			
		}
		
		public void testCaesarCrackerTwo(){
			
			char mostCommon = 'a';
			CaesarCracker myCracker = new CaesarCracker(mostCommon);
			String encryptedMessage = myCracker.decrypt(message3);
			System.out.println(">>>>>The original encrypted message<<<<<<<");
			System.out.println(message3);
			System.out.println(">>>>>The cracked message<<<<<<<");
			System.out.println(encryptedMessage);
			
		}
		
		public void testVigenereCipher(){
			
			int[] key = {17, 14, 12, 4};
			VigenereCipher newCipher = new VigenereCipher(key);
			FileResource newFR = new FileResource("VigenereTestData/titus-small.txt");
			String newMessage = newFR.asString();
			System.out.println(">>>>>The original message<<<<<<<");
			System.out.println(newMessage);
			String encryptedMessage = newCipher.encrypt(newMessage);
			System.out.println(">>>>>The encrypted message<<<<<<<");
			System.out.println(encryptedMessage);
			String decryptedMethod = newCipher.decrypt(encryptedMessage);
			System.out.println(">>>>>The decrypted message<<<<<<<");
			System.out.println(decryptedMethod);
			
		}
		
		public void testVigenereBreaker(){
			
			int whichSlice = 0;
			int totalSlices = 3;
			String message = "abcdefghijklm";
			VigenereBreaker vBreaker = new VigenereBreaker();
			String newSlice = vBreaker.sliceString(message, whichSlice, totalSlices);
			System.out.println(newSlice);
			
		}
		
}
