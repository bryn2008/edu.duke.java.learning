package course3.week4.resources;

//import java.util.*;
//import edu.duke.*;

public class VigenereBreaker {
    
	public String sliceString(String message, int whichSlice, int totalSlices) {
        
		 StringBuilder sb = new StringBuilder(message);
		 String newMessage = "";
		 int totalSliceInput = totalSlices;
		 for (int i = 0; i < totalSliceInput; i++) {
			System.out.println("11 " + totalSlices +sb.charAt(i));
			
			
			for (int j=0; j<totalSlices; j++){
				char c = message.charAt(totalSlices);
				System.out.println(c+">>>>The Second loop input<<<< " + j + " " + (totalSlices+j) );
				int end = j + totalSlices;
				String newMessage2 = message.substring(j, j+1) + " " +message.substring(end, end+j);
				System.out.println("The output >> " + newMessage2);
				
				
				
			}
			
			if (message.indexOf(i) == totalSlices){
            	char c = sb.charAt(i);
            	newMessage += c;
            }
            
            System.out.println(newMessage);
            totalSlices+=1;
	    }
		
		 
	    /*private String transform(String input, String from, String to){
	        StringBuilder sb = new StringBuilder(input);
	        for (int i = 0; i < sb.length(); i++) {
	            char c = sb.charAt(i);
	            c = transformLetter(c, from, to);
	            sb.setCharAt(i, c);
	        }
	        return sb.toString();
	    }*/
		
		/*int totalSliceInput = totalSlices;
		for (int i=whichSlice; i<totalSliceInput; i++){
			System.out.println(">>>>The First loop input<<<<< " + i + "  " + message + "  " + whichSlice + " " + totalSlices);
				for (int j=0; j<totalSlices; j++){
					char c = message.charAt(totalSlices);
					System.out.println(c+">>>>The Second loop input<<<< " + j + " " + (totalSlices+j) );
					int end = j + totalSlices;
					String newMessage = message.substring(j, j+1) + " " +message.substring(end, end+j);
					System.out.println("The output >> " + newMessage);
					
					
					
				}
				totalSlices+=1;
				
		}	
			
		String newMessage = message.substring(message.indexOf(whichSlice), message.indexOf(i));
		whichSlice += totalSlices;
		System.out.println(">>>>The output<<<< " + newMessage + whichSlice);*/
		
		//REPLACE WITH YOUR CODE
        return "WRITE ME!";
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
}
