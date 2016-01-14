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
    	System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		
		//FileResource fr = new FileResource("html/TheNewYorkTimes.html");
        
        //Create an StorageResource to store the URL addresses
        StorageResource sr = new StorageResource();
        
        int noOflinks = 0;
        for (String urlAddress : ur.lines()){
        	if(urlAddress.contains("href=")){
        		System.out.println("Line: " + urlAddress);
        		String adres = makeURLaddress(urlAddress);
        		//System.out.println("Returned: " + adres);
        		//sr.add(adres);
        		sr.add(urlAddress);
        		noOflinks++;
        	}	
        }
        System.out.println("The number of links found: " + noOflinks);
        //processURLs(sr);
	}
	
/****************************************************************************************************************************************/    
	//First strings
	
	// Start of URL is  13																					 End of URL is 91
	//Line: <li> <a href="http://www.informationweek.com/hardware/desktop/turings-universal-machine-voted-top-brit/240151643">
	
	// Start of URL is  7																 End of URL is 77	
	//Line: 		href="http://online.wsj.com/article/SB10001424053111903480904576512250915629460.html">
	
	// Start of URL is  13																			 End of URL is 88	
	//Line: <li> <a href="http://www.newscientist.com/article/dn20791-robot-mission-impossible-wins-video-prize.html">
	
	
	
	//Line: <li> "IKEA"<a href="https://www.youtube.com/watch?feature=player_embedded&v=MOXQo7nURs0">"ExperienceThePowerOfA-bookbook"
	
    public String makeURLaddress(String urlAddress){
    	
    	int urlRef = urlAddress.indexOf("href=");
    	
    	//Find the start of the hyper link
    	int startOfAddress = urlAddress.substring(0, urlAddress.length()).indexOf("\"");
    	System.out.println("Start of URL >> "+startOfAddress);
    	
    	//find the end of the hyper link
    	int endOfAddress = urlAddress.substring((startOfAddress+urlRef)).indexOf("\"");
    	System.out.println("End of URL >>"+endOfAddress);
    	
    	//Concatenates the hyper link from the start to the end of the string
    	String answer = urlAddress.substring(startOfAddress, endOfAddress + urlAddress.substring(0, urlRef).length() + urlAddress.substring(0, startOfAddress).length() +1);
    	System.out.println("Url Address is >> " + answer);
    	
    	return answer;
    	
    }
    
    //bug	
	
	//Line: <li> "IKEA"<a href="https://www.youtube.com/watch?feature=player_embedded&v=MOXQo7nURs0">"ExperienceThePowerOfA-bookbook"
	//Start of URL >> 5
	//End of URL >>0
	//Url Address is >> "IKEA"<a href="    
    
/****************************************************************************************************************************************/   
	
	public void processURLs(StorageResource sr){       
        
		int noOflinks = sr.size();
        int numOfhttp = 0;
        for (String httpsAdres : sr.data()){
        	if(httpsAdres.contains("http"))
        		numOfhttp++;
        		//System.out.println("Line: " + httpsAdres);
        }
        System.out.println("The number of http address are: " + numOfhttp);
        
        int numOfwww = 0;
        for (String httpsAdres : sr.data()){
        	if(httpsAdres.contains("www."))
        		numOfwww++;
        		//System.out.println("Line: " + httpsAdres);
        }
        System.out.println("The number of www. address are: " + numOfwww);
        
        System.out.println("The number of lines that contain href= >> " + noOflinks);
        
        //The number of links in total
        //System.out.println(" >> " + sr.data());
        System.out.println("The number of url address are: " + sr.size());
        
        //The number of links that are https
        int numOfhttps = 0;
        for (String httpsAdres : sr.data()){
        	if(httpsAdres.contains("https"))
        		numOfhttps++;
        		//System.out.println("Line: " + httpsAdres);
        }
        System.out.println("The number of https address are: " + numOfhttps);
        
        //The number of links that have ".com" in them
        int numOfcoms = 0;
        for (String comAdres : sr.data()){
        	if(comAdres.contains(".com"))
        		numOfcoms++;
        		//System.out.println("Line: " + comAdres);
        }
        System.out.println("The number of addresses containing .com are: " + numOfcoms);
        
        //The number of links that end with ".com" or ".com/"
        
        //int numOfends = 0;
        
        // string.length().subsring(-4) == .com or .com/
        
        
        
        
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
        System.out.println("The number of "+"\"."+"\" in total is: " + numOfDots);
        
	}
	
/****************************************************************************************************************************************/  
}