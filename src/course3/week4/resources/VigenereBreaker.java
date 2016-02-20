package course3.week4.resources;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {

	char mostCommon;
    
    public VigenereBreaker() {
        mostCommon = 'e';
    }
    
    public VigenereBreaker(char c) {
        mostCommon = c;
    }	
	
/*  In the VigenereBreaker class, write the public method mostCommonCharIn, 
 *  which has one parameter—a HashSet of Strings dictionary. 
 *  This method should find out which character, of the letters in the English alphabet, 
 *  appears most often in the words in dictionary. 
 *  It should return this most commonly occurring character. 
 *  Remember that you can iterate over a HashSet of Strings with a for-each style for loop.
*/    
	public void mostCommonCharIn(HashSet<String> dictionaries){
		
		HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
		for (String dictionary: dictionaries){
			for (char character: dictionary.toLowerCase().toCharArray()){
				//Iterates over the chars
				if(!letterCount.containsKey(character)){
					letterCount.put(character, 1);
				}else{
					letterCount.put(character, letterCount.get(character).intValue()+1);
				}				
			}
			char mostCommon = Collections.max(letterCount.entrySet(),(entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).getKey();
			System.out.println("The most common char in the "+ dictionary + " is " +mostCommon);
			
		}
	}
    
    
	public String sliceString(String message, int whichSlice, int totalSlices) {

		String slicedString = "";
		for (int i = whichSlice; i < message.length(); i += totalSlices) {
			char character = message.charAt(i);
			slicedString +=  character;
		}
		return slicedString;
	}

	public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
		
		int[] key = new int[klength];
		CaesarCracker cc = new CaesarCracker();
		for(int i=0; i<key.length; i++){
			String sliced = sliceString(encrypted, i, key.length);
			int tempKey = cc.getKey(sliced);
			key[i] = tempKey;
		}
		return key;
	}
	
	public HashSet<String> readDictionary(FileResource fr){
		
		HashSet<String> dictionary = new HashSet<>();
		for(String word : fr.lines()){
			word = word.toLowerCase();
			if(!dictionary.contains(word)){
				dictionary.add(word);
			}
		}
		return dictionary;
	}
	
	public int countWords(String message, HashSet<String>dictionary){
		
		int count;
		HashSet<String> words = new HashSet<String>();
		for(String word : message.split("\\W")){
			//System.out.println(word);
			if(!words.contains(word)){
				words.add(word);
			}
		}
		//System.out.println(words.size());
		
		ArrayList<String> wordMatch = new ArrayList<>();
		for(String str: words){
			//System.out.println(">>"+str);
			for(String dic: dictionary){
				if(dic.equals(str)){
					//System.out.println("="+str);
					wordMatch.add(str);
				}
			}
		}
		//System.out.println(wordMatch);
		count = wordMatch.size();
		return count;
		
	}
	
	public String breakForLanguage(String encrypted, HashSet<String>dictionary){
		
		int dKey = 0;
		int highestWordCount = 0;
		for (int i =57; i<59; i++){
			int[] key = tryKeyLength(encrypted, i, mostCommon);
			VigenereCipher vc = new VigenereCipher(key);
			String decrypted = vc.decrypt(encrypted);
			int wordCount = countWords(decrypted, dictionary);
			System.out.println(">>current key lengtj is set to "+i);
			System.out.println(">>>>The current key length is test a length of "+i+" and there is a possiable corrrect word count of "+wordCount);
			System.out.println(decrypted.substring(0, 200));
			if (wordCount > highestWordCount){
				highestWordCount=wordCount;
				dKey=i;
			}
		}
		System.out.println("The decrypt key length is "+dKey);
		System.out.println("The highest valid word count found is "+highestWordCount);
		int[] key = tryKeyLength(encrypted, dKey, mostCommon);
		VigenereCipher vc = new VigenereCipher(key);
		String decrypted = vc.decrypt(encrypted);
		return decrypted;
	}
	
	public void breakForAllLang(){
		
		
	}
	
	public void breakVigenere() {
		
		FileResource fr = new FileResource("dictionaries/English"); 
		HashSet<String> dictionary = readDictionary(fr);
		FileResource message = new FileResource("SecretData/secretmessage2.txt");
		String encrypted = message.asString();
		String decrypted = breakForLanguage(encrypted, dictionary);
		int countOfDecrypted = countWords(decrypted, dictionary);
		System.out.println("The count of valid words in the decrypted is "+countOfDecrypted);

	}

}
