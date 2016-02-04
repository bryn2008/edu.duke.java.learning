package course3.week1;

import edu.duke.*;

public class CaesarBreaker {

	public static void main(String[] args) {

		CaesarBreaker myObj = new CaesarBreaker();
		//myObj.testDecrypt();
		myObj.testHalfOfString();
		//myObj.testcountLetters();
		//myObj.testEyeballDecrypt();
		//myObj.testMaxIndex();
		//myObj.testgetKey();
	}

	public String decrypt(String encrypted) {

		// call half of string
		//int key = getKey(encrypted);
		//Concatenate the stings back together
		
		CaesarCipher cc = new CaesarCipher();
		int[] freqs = countLetters(encrypted);
		int maxDex = maxIndex(freqs);
		System.out.println("The maxDex is set to: "+maxDex);
		int dKey = maxDex - 4;
		if (maxDex < 4){
			dKey = 26 - (4 -maxDex);
		}
		System.out.println("The decrypt key is set to: "+dKey);
		System.out.println("The key is set to: "+(26 - dKey));
		int key = 26 - dKey;
		
		/*for (int k = 0; k < 26; k++) {
			String s = cc.encrypt(encrypted, k);
			System.out.println(k + "\t" + s);
		}*/
		
		//Key is not quite right and needs further testing
		System.out.println("The key passed is set to: "+key);
		return cc.encrypt(encrypted, key);
	}

	public static String halfOfString(String message, int start) {

		message = message.substring(start);
		String newString = "";
		for (int i = 0; i < message.length(); i += 2) {
			newString += message.charAt(i);
		}
		return newString;
	}
	
	public void testHalfOfString() {
		
		//FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		//String encrypted = fr.asString();
		//Question 8
		//String encrypted = "Top ncmy qkff vi vguv vbg ycpx";
		//Question 9 key1 = 4 key2 = 7 || dKey1 = 22 and dkey2 = 19 
		//String encrypted = "akag tjw Xibhr awoa aoee xakex znxag xwko";
		//Question 10 key1 = 9 key2 = 22 || dKey1 = 11 and dkey2 = 4 
		String encrypted = "Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw yehvv xyi gfqdse iekmfrrpzdrxzse fj xyi jzich sw tsdtlxrxzseec xifqvxic, fjkie xmmie zr xyi trwk, xyek klv nsipu rvfyeh yj zw xyvvi-hzqvrjmfrrp eeh ulijxzsew lfa xymekj zr xymj nsipu iiceki xf vetl sklvv eii melvvvrkpp xifqvximt. Xrov dsmmek e tzees xyvfyxl e hfsi-wvrqv rru gprremek e jcmxlk-gekl xyek rzfmuw gfpcmjmfrj nmkl sklvv ezvgprrvw ej kaf vbrqgpvw. Zx wyslpu klvvvjfvv esk jyitimji xyek tsdtlxzrx gvftvvkmvw esslx xyiji kvsdikvzg xymekj rru klvmi zrkiietxzse rvv tsdqfr-tceti eeh mdtfvkeex. Nlzpv klzw mj jxzpc r mecmu rvxydiex, ni afych pzov ks edieh xyek dsjx sw klv xifqvximt hyvwkmfrj giftci gfrtiir xyidwvpmij nmkl lrzv ks hf nmkl lfa xymekj rvv tservgkiu. Mk zw mdtfvkeex xyek ymxlnepw eii wljwmtmvrkpp jxiezkyx eeh wdsfxy ks wltgsix xyi himmmek sw wejx grvj, flx eesklvv ijwvrkmrp tisgiixp, aymtl av lwlecpp kebi jfv kieexvh, zw xyek ymxlnepw eii gfrkmeyfyj, mehviu tservgkmek E xf S, eeh rfx nlwk rtgvfbzqrxvpp. Xyi gfviijtfrumek wlfwmvpu fj gfqgykekmfrrp kvsdikvp zw swxvr vvjvviiu ks ej tsdtlxrxzseec ksgscsxc. R xsfh tfvkmfr sw fyi vjwsixj dep si gcejwzjziu ks fvpfrx ks xymj jysjzich eeh eii himmie sc egtcmtekmfrj zr e zrvzikc sw fxyii wmvpuw, klv gvvhzgkmfr sw klv jxiytxlvv fj jfpuiu gvfxvmew eeh xyi vvgfrjxiytxzse fj llqrr sikrrj sizrx kaf. Xyi lrpcqrvb fj slv afvb zw jrwk rpxsimkldw xyek zqgpvqvrk deklvqrxzgrp qfhvpj ks swjvv mewzkyxj zrks eeh eewniiw xf jytl ulijxzsew.";
		
		System.out.println(encrypted);
		
		int firstHalf = 0;
		int secondHalf = 1;
		
		String halfone = halfOfString(encrypted, firstHalf);
		String halftwo = halfOfString(encrypted, secondHalf);
		
		//eventually use a for loop and chatAt(i) to concatinate them both
		
		//System.out.println(halfone);
		//System.out.println(halftwo);
		
		//System.out.println("First Decoded half:  "+firstDec);
		//System.out.println("Second Decoded half: "+secondDec);		
		
		CaesarCipher cc = new CaesarCipher();
		
		
		//Metod for when the decrypt works automaticlly
/*		String halfOneDecrpted = decrypt(halfone);
		System.out.println("half one decrypted is "+halfOneDecrpted);
		String halfTwoDecrpted = decrypt(halfone);
		System.out.println("half one decrypted is "+halfTwoDecrpted);
		
		String theDecryptedString = "";
		for (int i = 0; i < (encrypted.length()-halfOneDecrpted.length()); i ++) {
			char tempone = halfOneDecrpted.charAt(i);
			char temptwo = halfTwoDecrpted.charAt(i);
			String temp = "" + tempone + temptwo;
			theDecryptedString += temp; 
		}
		System.out.println("The new Decrypted String is: " + theDecryptedString);*/
		
		
/*		for (int j = 0; j < 26; j++){
			int keyOne = 26 - j;
			for (int i = 0; i < 26; i++){
				int keyTwo = 26 - i;
				
				String firstDec = cc.encrypt(halfone, keyOne);
				String secondDec = cc.encrypt(halftwo, keyTwo);
				
				String newString = "";
				for (int k = 0; k < (encrypted.length()-firstDec.length()); k ++) {
					char tempone = firstDec.charAt(k);
					char temptwo = secondDec.charAt(k);
					String temp = "" + tempone + temptwo;
					newString += temp; 
					
					//newString += secondDec.charAt(i);
				}
			
				
			System.out.println("If key1 is "+keyOne+" and key2 is: "+keyTwo+" . The new string is: " + newString);
			}
			
			
		}*/
		
		//Key1 = 9 || dkey1 = 17
		int[] freqsOne = countLetters(halfone);
		int maxDex = maxIndex(freqsOne);
		int dKeyOne = maxDex-1;
		if (dKeyOne < 1){
			dKeyOne *= -1;
		}
		//System.out.println("The maxDexOne is set to: "+maxDex);
		System.out.println("The decrypt Key1 is "+dKeyOne+". ");
		
		//Key2 = 22 || dkey2 = 4
		int[] freqsTwo = countLetters(halftwo);
		int maxDexTwo = maxIndex(freqsTwo);
		int dKeyTwo = maxDexTwo-1;
		if (dKeyTwo < 1){
			dKeyTwo *= -1;
		}
		//System.out.println("The maxDexTwo is set to: "+maxDexTwo);
		System.out.println("The decrypt Key2 is "+dKeyTwo+". ");
		
		//originaly encrypted with these keys
/*		int keyOne = 26 - dKeyOne;
		System.out.println("The original encrypt for Key1 is "+keyOne+". ");
		int keyTwo = 26 - dKeyTwo;
		System.out.println("The original encrypt for Key2 is "+keyTwo+". ");*/
		
		String firstDec = cc.encrypt(halfone, dKeyOne);
		String secondDec = cc.encrypt(halftwo, dKeyTwo);
		
		String newString = "";
		for (int i = 0; i < (encrypted.length()-firstDec.length()); i ++) {
			char tempone = firstDec.charAt(i);
			char temptwo = secondDec.charAt(i);
			String temp = "" + tempone + temptwo;
			newString += temp; 
			
			//newString += secondDec.charAt(i);
		}
		
		System.out.println("The new string is: " + newString);

	}

	public int getKey(String s) {

		// Call the method countLetters will return an array of the letter
		// frequency for every char in the alphabet
		int[] letterFrequency = countLetters(s);
		// Call the method maxIndex will find the index of the letter with the
		// largest frequency
		int maxDex = maxIndex(letterFrequency);	
		//Set the key to the correct value
		
		int dkey = maxDex - 5;
		if (maxDex < 5){
			dkey = 26 - (5-maxDex);
		}
		System.out.println("The key for e is \"" + (26 - dkey) + "\"");
		//need to some how set the key to 11 if the maxIndex is  
		int key = 26 - dkey;
		return key;
	}

	public void testgetKey() {

		// This should return a key when the most common letter is e
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		int key = getKey(encrypted);
		System.out.println("The key is: " + key);
	}

	public int[] countLetters(String s) {

		// an array of the letter frequency in the sting
		int[] letterFrequency = new int[26];
		String letters = s.toLowerCase();
		// System.out.println(letters);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		// loop trough and see if letter matches alphabet at x and if so add
		// count to index of x in letterFrequency Array
		for (char c : letters.toCharArray()) {
			for (int j = 0; j < letterFrequency.length; j++) {
				if (c == alphabet.charAt(j)) {
					letterFrequency[j]++;
				}
			}
		}
		// all work done by now
		/*for (int j = 0; j < alphabet.length; j++) { 
			System.out.println("count for " + alphabet[j] + " is " + letterFrequency[j]); 
		} */
		return letterFrequency;
	}

	public void testcountLetters() {

		// Should return an array of the letter frequencies
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		int[] letterFrequency = countLetters(encrypted);
		// Show the letter freq in the input string
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int j = 0; j < letterFrequency.length; j++) {
			System.out.println("The letter frequency for " + alphabet[j] + " is " + letterFrequency[j]);
		}
	}

	public int maxIndex(int[] letterFrequency) {

		// find the max in the counts array
		// System.out.print("The count is: ");
		int max = 0;
		for (int c : letterFrequency) {
			// System.out.print(c + ", ");
			if (c > max) {
				max = c;
			}
			// System.out.println("max: " + max);
		}
		// System.out.println("The max value in the counts array is: " + max);
		// find the index of the max value in the counts array
		int cIndex = 0;
		for (int i = 0; i < letterFrequency.length; i++) {
			if (letterFrequency[i] == max) {
				cIndex = i;
			}
		}
		// System.out.println("The index of value of " + max + " is at " +
		// cIndex);
		return cIndex;
	}

	public void testMaxIndex() {

		// Return an array of the letter frequencies
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		int[] letterFrequency = countLetters(encrypted);

		// return the index of the largest letter frequency
		int largestLetterFrequency = maxIndex(letterFrequency);
		System.out.println(
				"The lagest letter freqency index is at index \"" + largestLetterFrequency + "\" in the Array");
	}

	public void testDecrypt() {

		//FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted2.txt");
		String encrypted = fr.asString();
		System.out.println("The encrypted input is: " + encrypted);
		String decrypted = decrypt(encrypted);
		// Need to figure out how to use the two key decrypt method?
		System.out.println("The dycrypted output is: " + decrypted);

		/*
		 * Dear Owen, 
		 * No matter what you may have heard, there is no cake in the
		 * conference room. The cake is a lie. Please keep working on Coursera
		 * videos.
		 * Thanks, Drew
		 * 
		 * 
		 * The key for this is 11
		 * 
		 * the most freq used letter is t when encrypted and it has an index of 20 
		 * 
		 * there are 26 char's in the alphabet
		 * 
		 * index of e in the char alphabet is either 5 or 6 if zero indexed
		 * 
		 */
	}

	public void eyeballDecrypt(String encrypted) {
		CaesarCipher cipher = new CaesarCipher();
		for (int k = 0; k < 26; k++) {
			String s = cipher.encrypt(encrypted, k);
			System.out.println(k + "\t" + s);
		}
	}

	public void testEyeballDecrypt() {
		FileResource fr = new FileResource("ProgrammingBreakingCaesarData/encrypted1.txt");
		String encrypted = fr.asString();
		eyeballDecrypt(encrypted);
	}

	public void decryptTwoKeys() {

		// Sting encrypted

	}

	/*
	 * public void testHalfOfString(){
	 * 
	 * String message = "Qbkm Zgis"; int start = 0; String newString =
	 * halfOfString(message, start); System.out.println(
	 * "The returned String is: " + newString); }
	 */

}
