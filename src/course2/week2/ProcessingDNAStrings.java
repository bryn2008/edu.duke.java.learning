package course2.week2;

import edu.duke.*;

public class ProcessingDNAStrings {

	public static void main (String [] args){
		
		ProcessingDNAStrings myObj = new ProcessingDNAStrings();
		//myObj.testFindAllGenes();
		myObj.testStorageFinder();
	}

	
	//How many times does the codon CTG appear in a strand of DNA?
	
	//What is the length of the longest gene in a collection of genes (that is, the longest String in a StorageResource of strings)?
/****************************************************************************************************************************************/	
	/*
		 * 
		 *This is modified program from the last assignment that finds how many times the stop codon CTG appears in a strand of DNA
		 *
		 *This program also returns the longest gene in the collection of genes from the DNA
		 * 
	*/	

/****************************************************************************************************************************************/	
	
	//This method reads in the large string of DNA and calls storeAll to find and store all the genes in this large string of DNA
	
	public void testStorageFinder(){
		FileResource fr = new FileResource(/*"data/dna/brca1line.fa"*/);
		//System.out.println(fr);	//shows the file resource chosen
		String dna = fr.asString();
		//System.out.println(dna);
		//Note: This will print noting out if the line of text is too long
				
		//Change any file input to lower case
		dna = dna.toLowerCase();
		
		//Calls the method to count the genes
		printAllGenes(dna);
		
		//Calls the method to storeALL
		storeAll(dna);
		
	}
	
/****************************************************************************************************************************************/	

	//This method search the dna for dna strings while there is remaining dna to search	
	
	public void printAllGenes(String dna){
		
		int start = 0;
		int countGenes = 0;
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
				//System.out.println(countGenes+" "+dna.substring(tag,end+3));
				start = end+3;
				countGenes +=1;
			}
			else{
				start = start + 3;
			}
		}
		System.out.println("The number of genes in this file is: "+countGenes);	
	}	
		
/****************************************************************************************************************************************/

	//find the number of ctg codons in the dna
		
	private void countCTGgenes(String dna) {
		
		int start = 0;
		int ctgTagCount = 0;
		
		while(true){
			//find the CTG codon index
			int tag = dna.indexOf("ctg", start);
			//There is no CTG codon index or none remaining
			if(tag == -1){
				//System.out.println("Can not find ctg codon");
				break;
			}
			start = tag+1;
			ctgTagCount++;
		}
		System.out.println("The number of CTG codons in: "+ctgTagCount);
	}
	
/****************************************************************************************************************************************/	
	
	//This method creates and returns a StorageResource containing the genes found
	
	public void storeAll(String dna){
		
		StorageResource sr = new StorageResource();
		
		int start = 0;
		//int countGenes = 0;
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
				//System.out.println(countGenes+" "+dna.substring(tag,end+3));
				sr.add(dna.substring(tag,end+3));
				//sr = dna.substring(tag,end+3);
				start = end+3;
				//countGenes +=1;
			}
			else{
				start = start + 3;
			}
		}
		
		//System.out.println(sr);
		//calls the method to test the Storage Resource
		printGenes(sr);
		//Calls the method to find all ctg codons in the DNA
		countCTGgenes(dna);		
		//Calls the method to find the longest Gene
		longestGene(sr);
	}
	
/****************************************************************************************************************************************/
	
	//This method returns the ratio of C's and G's in the DNA as fractions
	
	public float cgRatio(String dna){
		
		int countc = 0;
		int countg = 0;
		int start = 0;
		
		while(true){
			
			
			int pos = dna.indexOf("c", start);
			if(pos == -1){
				break;
			}
			countc +=1;
			start = pos+1;
		}
		//1804 matches
		//System.out.println("The no. of times c appears is: " + countc);
		
		start = 0;
		
		while(true){
			int pos = dna.indexOf("g", start);
			if(pos == -1){
				break;
			}
			countg +=1;
			start = pos+1;
		}
		//1903 matches
		//System.out.println("The no. of times g appears is: " + countg);
		
		int countcg = countc + countg ;
		
		//System.out.println("The total no. of times a and g appears is: " + countcg);
		
		return ((float) countcg/dna.length());

	}
	
/****************************************************************************************************************************************/
	
	//This method prints all the genes in the StorageResource which are over 60 chars in length (and the number) and also those which have a C-G-ratio higher than 0.35 (and the number)
	
	public void printGenes(StorageResource sr){
		int noOfGenes = 0;
		for(String gene : sr.data()){
			if(gene.length() > 60){
				//System.out.println(gene.length()+"\t"+gene);
				noOfGenes++;
			}
		}
		System.out.println("The no of genes above 60 characters in length is: "+noOfGenes);
		
		//reset the number of genes count for the number of genes with a a cgRatio above .035
		noOfGenes = 0;
		for(String gene : sr.data()){
			if(cgRatio(gene)>0.35){
				//System.out.println(cgRatio(gene)+"\t"+gene);
				noOfGenes++;
			}
		}
		System.out.println("The no of genes with a cgRatio above 0.35 is: "+noOfGenes);
		
	}
	
/****************************************************************************************************************************************/
	
	//This method prints the largest Gene found
	
	public void longestGene(StorageResource sr){
		
		int maxLength = 0;
		String longestString = null;
		for (String gene : sr.data()) {
			if (gene.length() > maxLength) {
				maxLength = gene.length();
				longestString = gene;
			}
		}
	    int geneLength = longestString.length();
	    System.out.println("The longest Gene has a length of: "+geneLength);
	    
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
		return Math.min(stop1, Math.min(stop2,stop3));
	}
}
