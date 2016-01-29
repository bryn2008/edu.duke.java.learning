package course3.week1;

import java.util.Arrays;
import edu.duke.FileResource;

public class WordLengths {

	public static void main (String [] args){
		
		WordLengths myObj = new WordLengths();
		myObj.testCountWordLength();
	}
	
	public void countWordLength (FileResource fr){
		
		String resource = fr.asString();
		System.out.println("resource: " + resource);
		
		String[] words = resource.split("\\s+");
		for (int i = 0; i < words.length; i++) {
		    words[i] = words[i].replaceAll("[+.^:,]","");
		}
		//System.out.println("The 'words' Array contins: "+ Arrays.toString(words));
		
		int [] counts;
		int maxWordLength = 0;
		//System.out.println(" ");
		for(String word : words) {
			//int index = indexOf(words,word);
			//System.out.print(index +"\t");
			//System.out.print(word.length()+"\t");		
			//System.out.println(word);
			if (maxWordLength < word.length()){
				maxWordLength = word.length();
			}
		}
		//System.out.println(" ");
		//System.out.println("The max word length is: "+maxWordLength);
		
		//allocate count to maxWordLength
		
		counts = new int[maxWordLength+1];
		
		for(String word : words) {
			counts[word.length()] += 1;
		}
		//System.out.println(" ");
		//System.out.print("The count is: ");
		//for (int c : counts) {
			//System.out.print(c+", ");
		//}
		//System.out.println(" ");
		//find the max in the counts array 
		//int indexOfMax = indexOfMax(counts); 
		
		//System.out.println(" ");
		//System.out.println("The indexOfMax is: "+indexOfMax);
		
		//System.out.println();
		
		//Target counts and word length/s of the g value
		for (int g=0; g<maxWordLength+1; g++){
			
			if (counts[g] == 0){
				
			}
			else if (counts[g] == 1){
				System.out.print(counts[g] + " word of length "+ g +": ");
				//get words of a certain length
				for(String word : words) {
					int wordLength = letterCount(word);
					//System.out.println("The length of '"+word+"' is " + wordLength);
					
					//could amend this == x
					
					if (wordLength == g){
						System.out.print(" "+word);
					}
				}
				System.out.println();
			}
			else{
				System.out.print(counts[g] + " words of length "+ g +": ");
				//get words of a certain length
				for(String word : words) {
					int wordLength = letterCount(word);
					//System.out.println("The length of '"+word+"' is " + wordLength);
						if (wordLength == g){
							System.out.print(" "+word);
						}
					}
					System.out.println();
			}
		}
	}
		
	public int  indexOfMax(int [ ] counts){ 
		//find the max in the counts array
		//System.out.print("The count is: ");
		int max = 0;
		for (int c : counts) {
			//System.out.print(c+", ");
			if (c > max){
				max = c;
			}
			//System.out.println("max: " + max);
		}
		//System.out.println("The max value in the counts array is: "+max);
		//find the index of the max value in the counts array
		int cIndex = 0;
		for (int i=0; i<counts.length; i++ ) {
			if (counts[i]==max) {
				cIndex=i;
			}
		}
		//System.out.println("The index of value of " + max + " is at " + cIndex);
		return cIndex;
	}
	
	public int getArrayIndex(int[] arr,int value) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
    return k;
	}
	
	public int indexOf(String[] list, String word){
		for (int k=0; k<list.length; k++){
			if (list[k].equals(word)){
				return k;
			}
		}
		return -1;
	}
	
	public int letterCount(String word){
	    int count = 0;
	    for (int i = 0; i < word.length(); i++) {
	        if (word.charAt(i) == ' ') {
	            //System.out.println("count is " + count);
	            count = 0;
	        } else {
	            count++;
	        }
	    }
	    //System.out.println("count is " + count);
	    return count;
	}
	
	public void testCountWordLength (){
		
		//FileResource fr = new FileResource("ProgrammingBreakingCaesarData/smallHamlet.txt");
		FileResource fr = new FileResource("resources/course3/week1/data/hamlet.txt");
		//System.out.println(fr.asString());
		//CALL THE METHOD
		countWordLength(fr);
		
		//created an array
		/*int [] counts = new int[fr.toString().length()+1];
		System.out.println(">>"+(fr.toString().length()+1));
		System.out.println("Length of counts array: " + counts.length);*/
	}
}