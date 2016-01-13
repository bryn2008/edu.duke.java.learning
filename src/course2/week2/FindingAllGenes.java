package course2.week2;

//import edu.duke.*;

public class FindingAllGenes {
	
	public static void main (String [] args){
		
		FindingAllGenes myObj = new FindingAllGenes();
		myObj.testFinder();	
		
	}
	
/****************************************************************************************************************************************/
	
	//This method finds the next stop index in the dna
	public int findStopIndex(String dna, int startIndex){
		int stop1 = dna.indexOf("tag", startIndex);
		if (stop1 == -1 || (stop1-startIndex) %3 != 0){
			stop1 = dna.length();
		}
		int stop2 = dna.indexOf("tga", startIndex);
		if (stop2 == -1 || (stop2-startIndex) %3 != 0){
			stop2 = dna.length();
		}
		int stop3 = dna.indexOf("taa", startIndex);
		if (stop3 == -1 || (stop3-startIndex) %3 != 0){
			stop3 = dna.length();
		}
		return Math.min(stop1, Math.min(stop2,stop3)+1);
	}

/****************************************************************************************************************************************/	

	//This method search the dna for dna strings while there is remaining dna to search	
	
	public void printAll(String dna){
		int start = 0;
		while(true){
			//find the start codon index
			int tag = dna.indexOf("atg", start);
			//There is no start codon index or none remaining
			if(tag == -1){
				//System.out.println("Can not find a start codon");
				break;
			}
			//find the stop index of the codon 
			int end = findStopIndex(dna, tag+3);
			//if the length of the dna is not equal to the end the print the dna strand
			if(end != dna.length()){
				System.out.println(dna.substring(tag,end+3));
				start = end+3;
			}
			else{
				start = start + 3;
			}
		}
	}
	
/****************************************************************************************************************************************/
	
	public void testFinder(){
		
    	//Test 1
		//String dnaInput = "ATGAAATGAAAA";
        //String answer = "ATGAAATGA";
		
		//Test 2
        //String dnaInput = "ccatgccctaataaatgtctgtaatgtaga";
        //String answer1 = "atgccctaa";
		//String answer2 = "atgtctgtaatgtag";
        
		//Test 3
		String dnaInput = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA"; 
		//String answer1 = "ATGTAA";
		//String answer2 = "ATGAATGACTGATAG";
		//String answer3 = "ATGCTATGA";
		//String answer4 = "ATGTGA";
        
		//convert to lower case
		String dna = dnaInput.toLowerCase();
		
		//Display the String to check it is all in lower case
		//System.out.println("The dna input >> " + dna);
		
		//call the method to look for the start index
		printAll(dna);
		
		//get the above to return an array with the answers so that they can be checked
		
	}

}

