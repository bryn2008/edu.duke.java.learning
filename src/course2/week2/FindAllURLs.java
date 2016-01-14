package course2.week2;

import edu.duke.*;

public class FindAllURLs {
    
	public static void main (String [] args){
		
		FindAllURLs myObj = new FindAllURLs();
		myObj.findURLs();
	}
	
/****************************************************************************************************************************************/
	/*
		 * 1.Print all the URLs
		 * 2.Print the No of URLs found
		 * 3.print the No of https found
		 * 4.print the No of links the have ".com"
		 * 5.print the No of links the end with ".com" or ".com/"
		 * 6.print the total No of "." that appear in all the links
	*/
/****************************************************************************************************************************************/
	
	public void findURLs(){
		
    	//Get the html via Met Office proxy
    	//System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        //System.setProperty("http.proxyPort", "8080");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
		
		//FileResource fr = new FileResource("html/TheNewYorkTimes.html");
        
        //Create an StorageResource to store the URL addresses
        StorageResource sr = new StorageResource();
        
        for (String line : ur.lines()){
        	if(line.contains("href=\"http")){
        		//System.out.println("Line: " + line);
        		String url = makeURLaddress(line);
        		//1.Print all the URLs
        		System.out.println(" >> " + url);
        		sr.add(url);
        	}	
        }
        //System.out.println("The number of URLs found: " + noOflinks);
        processURLs(sr);
	}
	
/****************************************************************************************************************************************/    
	
    public String makeURLaddress(String urlAddress){
    	
    	int urlRef = urlAddress.indexOf("href=\"http")+6;
    	
    	//Find the start of the hyper link
    	int endOfurl = urlAddress.substring(urlRef).indexOf("\"");
    	//System.out.println("End of URL >> "+(urlRef+endOfurl));
    	    	
    	String url = urlAddress.substring(urlRef, (urlRef+endOfurl));
    	
    	//System.out.println(">>"+url);
    	return url;
    	
    }
    
/****************************************************************************************************************************************/   
	
	public void processURLs(StorageResource sr){       
        
		//number of URL in the web site
		//336 is incorrect in the quiz
		System.out.println("The number of URLs found is: "+sr.size());
		
		//The number of secure links found
        int numOfhttps = 0;
        for (String httpsAdres : sr.data()){
        	if(httpsAdres.contains("https"))
        		numOfhttps++;
        		//System.out.println("Line: " + httpsAdres);
        }
        //3 and is also the answer in the quiz
        System.out.println("The number of https address are: " + numOfhttps);
        
        //The number of links that have ".com" in them
        int numOfcoms = 0;
        for (String comAdres : sr.data()){
        	if(comAdres.contains(".com"))
        		numOfcoms++;
        		//System.out.println("Line: " + comAdres);
        }
        //335 is incorrect in the quiz
        System.out.println("The number of addresses containing .com are: " + numOfcoms);
        
        //The number of links that end with ".com" or ".com/"
        int numOfcomsEnds = 0;
        for (String urlAdd : sr.data()){
        	if(urlAdd.endsWith(".com") || urlAdd.endsWith(".com/"))
        		numOfcomsEnds++;
        		//System.out.println("Line: " + comAdres);
        }
        //15 and is also the answer in the quiz
        System.out.println("The number of addresses ending in .com or .com/ are: " + numOfcomsEnds);
                
        //The total number that "." appears in all the links
        int numOfDots = 0;
        char dot = '.';
        for (String dotNum : sr.data()){
        	//System.out.println(" >> " + dotNum);
        	for(int i=0;i<dotNum.length();i++){
        		//System.out.println(" >> " + dotNum.charAt(i));
	        	if(dotNum.charAt(i) == dot){
	        		//System.out.println(" is a dot!!!!!! >> ");
	        		numOfDots++;
	        	}
        	}	
        }
        
        //943 is incorrect in the quiz
        System.out.println("The number of "+"\"."+"\" in total is: " + numOfDots);
        
	}
	
/****************************************************************************************************************************************/  
}