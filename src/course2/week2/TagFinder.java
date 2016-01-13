package course2.week2;

import edu.duke.FileResource;

/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */

//Modified to use a file reader to read in the dna

public class TagFinder {

	public static void main (String [] args){
		
		TagFinder myObj = new TagFinder();
		myObj.testStorageFinder();
	}
	
	
	
	
    public String findProtein(String dna) { 
        
        //set letters to upper case
        dna = dna.toUpperCase();
        
        int start = dna.indexOf("ATG");
            
        if (start == -1) {
            //System.out.println("There is not a start codon.");
            return "";
        }
        
        //get the stop codon of either (TAG || TGA || TAA ) after the first start codon
        int stop = -1;
        int stop1 = dna.indexOf("TAG", start + 3 );
        
        if ((stop1 - start) % 3 == 0) {
            stop = stop1;
            //System.out.println("TAG was the stop coden used to find this gene");
        }
        else {
              int stop2 = dna.indexOf("TGA", start + 3 );
              
                  if ((stop2 - start) % 3 == 0) {
                      stop = stop2;
                      //System.out.println("TGA was the stop coden used to find this gene");
                  }
                  else{      
                        int stop3 = dna.indexOf("TAA", start + 3 );
                        
                            if ((stop3 - start) % 3 == 0) {
                                stop = stop3;
                                //System.out.println("TAA was the stop coden used to find this gene");
                            }
                            else{
                                stop = -1;
                            }
                  }
                    
        }
        
        if(stop == -1) {
            return"";
        }
        else{
                return dna.substring(start, stop + 3).toLowerCase(); //.toLowerCase() changes the output back to lowwer case
        }
    }
    
    public void testing(String dnaIn) {

    	//String a = "cccatggggtttaaataataataggagagagagagagagttt";
        //String p = "atggggtttaaataataatag";
        //String a = "AATGCTAGTTTAAATCTGA"; //Should return ATGCTAGTTTAAATCTGA
        //String p = "ATGCTAGTTTAAATCTGA";
        //String a = "ataaactatgttttaaatgt"; // Should return atgttttaa
        //String p = "atgttttaa";
        //String a = "acatgataacctaag"; // Should return nothing
        //String p = "";
        
        //String a = "AAATGCCCTAACTAGATTGAAACC"; // Should return atgttttaa
        String p = "ATGCCCTAACTAGATTGA";
        
    	String a = dnaIn.toLowerCase();
        
        String ap = p.toLowerCase();
        
        String result = findProtein(a);
        if (ap.equals(result)) {
            System.out.println("success for " + ap + " length " + ap.length());
        }
        else {
            System.out.println("mistake for input: " + a);
            System.out.println("got: " + result);
            System.out.println("not: " + ap);
        }
    }
    
        public void stopCodon() {
            //Write a method stopCodon that has one parameter that is a String representing a gene. 
            //This method returns the stop codon of the gene. 
            //It should return the empty string if the parameter is not a gene.
            
            //This method is incorporated
    }
        
    	public void testStorageFinder(){
    		FileResource fr = new FileResource(/*"data/dna/brca1line.fa"*/);
    		System.out.println(fr);	//shows the file resource chosen
    		String dnaIn = fr.asString();
    		System.out.println("The input dna is: "+dnaIn);
    		testing(dnaIn);
    	}
    
}
