package course2.week2;

import edu.duke.*;

//these methods are imported and used to store the hyper links
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Completed :)

public class ReadUrlFile {
    
	public static void main (String [] args){
		
		ReadUrlFile myObj = new ReadUrlFile();
		//myObj.readURL();				//A Working method to show all youtube links
		myObj.testingReadURL();			//A shorter and alternative method to search for a url in a HTML file
	}
	
	/*
	1. 	Read in the url resource via the proxy
	2. 	Check each word in the string for the "youtube.com" address
			a.find the double quotes to the left and right of the address string
				i.this could mean search for the first "\"" char and then the following "\"" and see if it contains the address String
	3. 	In addition to the String method indexOf(x, num), you might want to consider using the String method lastIndexOf(s, num) that 
		can be used with two parameters s and num. The parameter s is the string or character to look for, and num is the last position 
		in the string to look for it. This method returns the last match from the start of the string up to the num position, so it is 
		a good option for finding the opening quotation mark of a string searching backward from the youtube.com part of the URL.
	*/
	
    public void readURL(){
    	
    	//Get the html via Met Office proxy
    	System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        //Convert the html into a string
        String urInput = ur.asString();
        
        //set the site to lower case for the search
        String webSite = urInput.toLowerCase();
        
        //Create an array list to store the html addresses
        ArrayList<String> al = new ArrayList<String>();
         
        //Search the first youtube instance in the html string
        int youTubeAddress = webSite.indexOf("youtube.com");
        //System.out.println("The first youtube array address is: " + youTubeAddress ); 
        
        //check if there is an instance of the youtube address in the html 
        if(youTubeAddress == -1){
         	System.out.println("Youtube video not found"); // not video found
         }
        else //finds all youtube videos in the html
        {	
	        //A for loop, loops through to find all instances of youtube in the html 
	        for (int i = 0; i < webSite.length(); i++){
	         	
	         	//this set the search to start after the last found 
	        	youTubeAddress = webSite.indexOf("youtube.com", (youTubeAddress + i));
	         	//System.out.println("The youtube address is: " + youTubeAddress);	//a check to see the for loop workling
	         	
	             if(youTubeAddress == -1){
	             	//System.out.println("No more Youtube videos not found");
	             }
	             else
	             {
	            	 //System.out.println("The " + i + " char is an array address in the string that contains a youtube address");
	            	 
	            	 //Find the start of the hyper link
	            	 int startOfAddress = webSite.substring(0, youTubeAddress).lastIndexOf("\"");
	            	 
	            	 //find the end of the hyper link
	            	 int endOfAddress = webSite.substring(youTubeAddress).indexOf("\"");
	            	 
	            	 //Concatenates the hyper link from the start to the end of the string
	            	 String answer = webSite.substring(startOfAddress, endOfAddress + webSite.substring(0, youTubeAddress).length() + 1);
	            	 //System.out.println("The first youtube addres is: " + answer);
	            	 
	            	 //Adds the answer or hyper link to the array list al
	            	 al.add(answer);        		
	             }
             
	        }
	        
	        //To check the loop has ended
	        System.out.println("End of the for loop");
	         
	        //There are duplicated hyper links in the array list
	        //System.out.println("The array list of hyperlinks contains: " + al);
	        
	        //Sets the first hyper link in the array list to the String "firstElement"
	        //String firstElement = al.get(0);
	         
	        //this method is used to delete duplicate hyper links
	        Set<String> hs = new HashSet<>();
	        hs.addAll(al);
	        al.clear();
	        al.addAll(hs);
	        
	        //Check the array list has been modifiyed with duplicates deleted
	        //System.out.println("The list of hyperlinks as strings are: " + hs);
	        //System.out.println("The array list of hyperlinks contains: " + al);
	        
	        //Set the array list to have an index
	 		//al.set(0, firstElement);
	 		
     		//Remove the first Hyper Link in the Array 
     		//al.remove(0);
	 		
	 		//A for loop to print all the web address in the html page
	     	for (String value : al) {
	     		
	     		//Hyper link number in the "al" array list
	     		int hyperLinkNo = al.indexOf(value);
	     		
	     		//Print the list of the Hyper Links
	     		System.out.println("Hyperlink no. " + hyperLinkNo + " is " + value);
	     	}
	     	
	     	//Check how many Hyper Links there are
	     	System.out.println("The size of al is: " + al.size());
        }

    }
    
/****************************************************************************************************************************************/    
    
    public void testingReadURL(){			//An shorter and alternative method to search for a url in a HTML file
    	
    	//Get the html via Met Office proxy
    	System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        //Create an array list to store the html addresses
        ArrayList<String> al = new ArrayList<String>();
        
	        //Test method for searching line by line and then adding to an Arraylist
	        for (String lineOfHTML : ur.lines()){
	        	if(lineOfHTML.contains("youtube")){
	        		//System.out.println("Line: " + lineOfHTML);
		        		String result = makeURLaddress(lineOfHTML);
			        		//System.out.println("Returned: " + result);
				        		al.add(result);
					        		//System.out.println("The Array list: " + al);
	        	}
	        	else if (lineOfHTML.contains("YouTube")){
		    		//System.out.println("Line: " + lineOfHTML);
	        			//make line all lower case
	        			lineOfHTML = lineOfHTML.toLowerCase();
	        				String result = makeURLaddress(lineOfHTML);
				    			//System.out.println("Returned: " + result);
					    			al.add(result);
						    			//System.out.println("The Array list: " + al);
	    	}
        }
	        
        //System.out.println("The Array list: " + al);
 		
        //A for loop to print all the web address in the html page
     	for (String value : al) {
     		
     		//Hyper link number in the "al" array list
     		int hyperLinkNo = al.indexOf(value);
     		hyperLinkNo++;
     		//Print the list of the Hyper Links
     		System.out.println("Hyperlink no. " + hyperLinkNo + " is " + value);
     	}
	     
    }

/****************************************************************************************************************************************/    
    
    public String makeURLaddress(String lineOfHTML){
    	int youTubeAddress = lineOfHTML.indexOf("youtube.com");
    	//Find the start of the hyper link
    	int startOfAddress = lineOfHTML.substring(0, youTubeAddress).lastIndexOf("\"");
    	//find the end of the hyper link
    	int endOfAddress = lineOfHTML.substring(youTubeAddress).indexOf("\"");
    	//Concatenates the hyper link from the start to the end of the string
    	String answer = lineOfHTML.substring(startOfAddress, endOfAddress + lineOfHTML.substring(0, youTubeAddress).length() + 1);
    	return answer;
    }
    
 /****************************************************************************************************************************************/
    
//    public String makeURLaddressCaps(String lineOfHTML){
//    	int youTubeAddressCaps = lineOfHTML.indexOf("YouTube.com");
//		//Find the start of the hyper link
//		int startOfAddress2 = lineOfHTML.substring(0, youTubeAddressCaps).lastIndexOf("\"");
//		//find the end of the hyper link
//		int endOfAddress2 = lineOfHTML.substring(youTubeAddressCaps).indexOf("\"");
//		//Concatenates the hyper link from the start to the end of the string
//		String answer2 = lineOfHTML.substring(startOfAddress2, endOfAddress2 + lineOfHTML.substring(0, youTubeAddressCaps).length() + 1);   	
//    	return answer2;
//    }

/****************************************************************************************************************************************/
    
}