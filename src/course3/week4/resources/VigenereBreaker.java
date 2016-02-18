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
		for (int i =1; i<100; i++){
			int[] key = tryKeyLength(encrypted, i, mostCommon);
			VigenereCipher vc = new VigenereCipher(key);
			String decrypted = vc.decrypt(encrypted);
			int wordCount = countWords(decrypted, dictionary);
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
	
	public void breakVigenere() {
		
		FileResource fr = new FileResource("dictionaries/English"); 
		HashSet<String> dictionary = readDictionary(fr);
		FileResource message = new FileResource("SecretData/secretmessage2.txt");
		String encrypted = message.asString();
		String decrypted = breakForLanguage(encrypted, dictionary);
		System.out.println(decrypted);

	}

}
