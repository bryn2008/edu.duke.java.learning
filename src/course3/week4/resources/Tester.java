package course3.week4.resources;

import java.util.HashSet;

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
			//myObj.testSliceString();
			//myObj.testTryKeyLength();
			//myObj.testReadDictionary();
			//myObj.testCountWords();
			myObj.testBreakForLanguage();
			//myObj.testBreakVigenere();
			
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
		
		public void testSliceString(){
			
			int whichSlice = 4;
			int totalSlices = 5;
			String message = "abcdefghijklm";
			VigenereBreaker vBreaker = new VigenereBreaker();
			String newSlice = vBreaker.sliceString(message, whichSlice, totalSlices);
			System.out.println(newSlice);
			
		}
		
		public void testTryKeyLength(){
			
			FileResource fr = new FileResource("SecretData/secretmessage1.txt");
			String encrypted = fr.asString();
			int klength = 4;
			char mostCommon = 'e';
			VigenereBreaker vBreaker = new VigenereBreaker();
			int[] key = vBreaker.tryKeyLength(encrypted, klength, mostCommon);
			for(int i=0; i<key.length; i++){
				System.out.print(key[i]+" ");
			}
						
		}
		
		public void testReadDictionary(){
			
			VigenereBreaker vBreaker = new VigenereBreaker();
			FileResource fr = new FileResource("dictionaries/English"); 
			HashSet<String> dictionary = vBreaker.readDictionary(fr);
			for(String word: dictionary){
				System.out.println(word);
			}
			
		}
		
		public void testCountWords(){
			
			VigenereBreaker vBreaker = new VigenereBreaker();
			FileResource fr = new FileResource("dictionaries/English"); 
			HashSet<String> dictionary = vBreaker.readDictionary(fr);
			//FileResource message = new FileResource("VigenereTestData/athens_keyflute.txt");
			FileResource message = new FileResource("VigenereTestData/titus-small.txt");
			String encrypted = message.asString();
			int count = vBreaker.countWords(encrypted, dictionary);
			System.out.println("The count of real words in the dictionary is "+count+".");
			
		}
		
		public void testBreakForLanguage(){
			
			VigenereBreaker vBreaker = new VigenereBreaker();
			FileResource fr = new FileResource("dictionaries/English"); 
			HashSet<String> dictionary = vBreaker.readDictionary(fr);
			FileResource message = new FileResource("VigenereTestData/athens_keyflute.txt");
			String encrypted = message.asString();
			String decrypted = vBreaker.breakForLanguage(encrypted, dictionary);
			System.out.println(decrypted);
			
		}
		
		public void testBreakVigenere(){
			
			VigenereBreaker vBreaker = new VigenereBreaker();
			vBreaker.breakVigenere();
			
		}
		
}
