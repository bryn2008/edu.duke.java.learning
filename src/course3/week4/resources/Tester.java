package course3.week4.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import edu.duke.FileResource;

public class Tester {
		
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
			//myObj.testBreakForLanguage();
			//myObj.testBreakVigenere();
			myObj.testBreakForAllLang();
			
		}
		
		public void testCaesarCipher(){
			
			FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
			String message = fr.asString();
			int ccKey = 5;
			CaesarCipher myCipher = new CaesarCipher(ccKey);
			String encryptedMessage = myCipher.encrypt(message);
			System.out.println(">>>>>The original message<<<<<<<");
			System.out.println(message);
			System.out.println(">>>>>The encrypted message<<<<<<<");
			System.out.println(encryptedMessage);
			String decryptedMessage = myCipher.decrypt(encryptedMessage);
			System.out.println(">>>>>The decrypted message<<<<<<<");
			System.out.println(decryptedMessage);
			
		}
		
		public void testCaesarCracker(){
			
			FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
			String message = fr.asString();
			CaesarCracker myCracker = new CaesarCracker();
			String encryptedMessage = myCracker.decrypt(message);
			System.out.println(">>>>>The original encrypted message<<<<<<<");
			System.out.println(message);
			System.out.println(">>>>>The cracked message<<<<<<<");
			System.out.println(encryptedMessage);
			
		}
		
		public void testCaesarCrackerTwo(){
			
			FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
			String message = fr.asString();
			char mostCommon = 'a';
			CaesarCracker myCracker = new CaesarCracker(mostCommon);
			String encryptedMessage = myCracker.decrypt(message);
			System.out.println(">>>>>The original encrypted message<<<<<<<");
			System.out.println(message);
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
			FileResource message = new FileResource("SecretData/secretmessage2.txt");
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
		
		public void testBreakVigenereForAllLang(){
			
			VigenereBreaker vBreaker = new VigenereBreaker();
			vBreaker.breakVigenere();
			
		}
		
		public void testBreakForAllLang(){
			
			String[] dictionaries = {"Danish", "Dutch", "English", "French", "German", "Italian", "Portuguese", "Spanish"};
			HashMap<String, ArrayList<String>> languages = new HashMap<String, ArrayList<String>>();
			VigenereBreaker vBreaker = new VigenereBreaker();
			//for loop over the selected dictionaries adding the words in each dictionary to an ArrayList 
			for(String lang : dictionaries){
				String dPath = "dictionaries/" + lang ;
				FileResource fr = new FileResource(dPath); 
				HashSet<String> dictionary = vBreaker.readDictionary(fr);
				ArrayList<String> words = new ArrayList<String>(dictionary);
				languages.put(lang, words);
			}
			
			FileResource message = new FileResource("SecretData/secretmessage3.txt");
			String encrypted = message.asString();
			
			vBreaker.breakForAllLang(encrypted, languages);
			
		}
}
